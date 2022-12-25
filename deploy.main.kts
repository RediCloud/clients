@file:Repository("https://repo.maven.apache.org/maven2/")
@file:DependsOn("com.jcraft:jsch:0.1.55")

import com.jcraft.jsch.ChannelExec
import com.jcraft.jsch.ChannelSftp
import com.jcraft.jsch.JSch

val jsch = JSch()
jsch.addIdentity("node01-ssh-key", System.getenv("NODE01_SSH_KEY").toByteArray(), null, null)
val session = jsch.getSession("root", "node01.hosting.suqatri.net", 22).apply {
    setConfig("StrictHostKeyChecking", "no")
    connect()
}
val sftp = session.openChannel("sftp").apply {
    connect()
} as ChannelSftp

fun deploy(from: String, to: String) =
    sftp.put(from, to, ChannelSftp.OVERWRITE)

fun runCommandSync(it: String): String {
    (session.openChannel("exec") as ChannelExec).apply {
        setCommand(it)
        connect()
        while (!isClosed) {
            Thread.sleep(100)
        }
        if (exitStatus != 0) {
            throw RuntimeException(
                "Failed to run command \"${it}\": ${
                    inputStream.readAllBytes().decodeToString()
                }"
            )
        }
        return inputStream.readAllBytes().decodeToString()
    }
}

val services = listOf("minestom" to "lobby")

services.forEach { (type, name) ->
    deploy(
        "service-impl/$type/$name/build/libs/$name.jar",
        "/home/cloudnet/local/templates/${name.replaceFirstChar { it.uppercaseChar() }}/default/${
            if (type == "minestom") "extensions" else "plugins"
        }/$name.jar".also {
            runCommandSync("mkdir -p ${it.substringBeforeLast("/")}")
        }
    )
    runCommandSync("screen -S CloudNet -X stuff \"service restart ${name.replaceFirstChar { it.uppercaseChar() }}\"")
}

sftp.disconnect()
session.disconnect()
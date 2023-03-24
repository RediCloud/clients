@file:Repository("https://repo.maven.apache.org/maven2/")
@file:DependsOn("com.jcraft:jsch:0.1.55")

import com.jcraft.jsch.ChannelExec
import com.jcraft.jsch.ChannelSftp
import com.jcraft.jsch.JSch

val jsch = JSch()
jsch.addIdentity("node01-ssh-key", System.getenv("NODE01_SSH_KEY").toByteArray(), null, null)
val session = jsch.getSession(
    System.getenv("NODE_01_USER").toString(),
    System.getenv("NODE_01_HOSTNAME").toString(),
    System.getenv("NODE_01_PORT").toInt()
).apply {
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
val apis = listOf("paper", "velocity")

apis.forEach { name ->
    deploy(
        "api/$name/build/libs/$name.jar",
        "/home/cloudnet/local/templates/Core/$name/plugins/clients.jar"
    )
}

deploy(
    "api/minestom/build/libs/minestom.jar",
    "/home/cloudnet/local/templates/Core/minestom/application.jar"
)

val services = listOf("minestom" to "lobby")

services.forEach { (type, name) ->
    deploy(
        "service-impl/$type/$name/build/libs/$name.jar",
        "/home/cloudnet/local/templates/${name.replaceFirstChar { it.uppercaseChar() }}/default/${
            if (type == "minestom") "extensions" else "plugins"
        }/$name.jar"
    )
    //runCommandSync("screen -S CloudNet -X stuff \"service restart ${name.replaceFirstChar { it.uppercaseChar() }}\"")
}

sftp.disconnect()
session.disconnect()
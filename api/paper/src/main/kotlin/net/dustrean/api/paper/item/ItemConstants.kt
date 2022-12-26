package net.dustrean.api.paper.item

import com.destroystokyo.paper.profile.ProfileProperty
import com.google.gson.JsonParser
import net.dustrean.api.item.ItemStack
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import java.io.InputStreamReader
import java.net.URL
import java.nio.ByteBuffer
import java.util.*
import org.bukkit.inventory.ItemStack as BukkitItemStack

object ItemConstants {
    val KEY = NamespacedKey("dustrean", "item_api")

    class UUIDTagType : PersistentDataType<ByteArray, UUID> {
        override fun getPrimitiveType(): Class<ByteArray> {
            return ByteArray::class.java
        }

        override fun getComplexType(): Class<UUID> {
            return UUID::class.java
        }

        override fun fromPrimitive(primitive: ByteArray, context: PersistentDataAdapterContext): UUID {
            val buffer = ByteBuffer.wrap(primitive)
            val first = buffer.long
            val second = buffer.long
            return UUID(first, second)
        }

        override fun toPrimitive(complex: UUID, context: PersistentDataAdapterContext): ByteArray {
            val buffer = ByteBuffer.wrap(ByteArray(16))
            buffer.putLong(complex.mostSignificantBits)
            buffer.putLong(complex.leastSignificantBits)
            return buffer.array()
        }

    }

    fun ItemStack.paper(): BukkitItemStack =
        BukkitItemStack(
            Material.getMaterial(
                material.name
            )!!, amount
        ).editMetaInstance {
            if (this is Damageable) damage = this@paper.damage
            displayName(this@paper.name)
            lore(this@paper.lore)
            isUnbreakable = this@paper.unbreakable
            persistentDataContainer.set(
                KEY, UUIDTagType(), identifier
            )
            if (this is SkullMeta) {
                val offlinePlayer = Bukkit.getOfflinePlayer(skullOwner!!)
                if (!offlinePlayer.hasPlayedBefore())
                    playerProfile = Bukkit.createProfile(skullOwner!!).also {
                        it.properties.removeIf { property -> property.name == "textures" }
                        it.properties.add(
                            ProfileProperty(
                                "textures",
                                skullTexture ?: JsonParser().parse(
                                    InputStreamReader(
                                        URL("https://sessionserver.mojang.com/session/minecraft/profile/$skullOwner").openConnection()
                                            .getInputStream()
                                    )
                                ).asJsonObject.get("properties").asJsonArray[0].asJsonObject.get("value").asString
                            )
                        )
                    }
                else owningPlayer = offlinePlayer
            }
        }


    inline fun BukkitItemStack.editMetaInstance(crossinline block: ItemMeta.() -> Unit): BukkitItemStack {
        itemMeta = itemMeta.apply(block)
        return this
    }
}

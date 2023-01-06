package net.dustrean.api.paper.item

import com.destroystokyo.paper.profile.ProfileProperty
import kotlinx.coroutines.runBlocking
import net.dustrean.api.ICoreAPI
import net.dustrean.api.item.ItemStack
import net.dustrean.api.language.component.item.ItemComponentProvider
import net.dustrean.api.language.placeholder.PlaceholderProvider
import net.dustrean.api.utils.fetcher.TextureFetcher
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.Damageable
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import java.nio.ByteBuffer
import java.util.*
import org.bukkit.inventory.ItemStack as BukkitItemStack

object ItemConstants {

    private val languageManager = ICoreAPI.INSTANCE.getLanguageManager()
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

    suspend fun ItemStack.paper(): BukkitItemStack {
        val provider = ItemComponentProvider().apply(languageProvider)
        val placeholderProvider = PlaceholderProvider().apply(provider.placeholderProvider)
        val player = ICoreAPI.INSTANCE.getPlayerManager().getPlayerByUUID(playerUniqueId)!!
        val languageId = languageManager.getLanguage(player.languageId)?.id ?: languageManager.getDefaultLanguage().id
        val component = languageManager.getItem(languageId, provider)

        val displayName = languageManager.deserialize(
            component.rawName, component.serializerType, placeholderProvider.parse(component.rawName)
        )
        val lore = component.rawLore.map {
            languageManager.deserialize(
                it, component.serializerType, placeholderProvider.parse(it)
            )
        }

        val itemStack = BukkitItemStack(
            Material.getMaterial(material.getName())!!, amount
        ).editMetaInstance {
            if (this is Damageable) damage = this@paper.damage
            displayName(displayName)
            lore(lore)
            isUnbreakable = this@paper.unbreakable
            persistentDataContainer.set(
                KEY, UUIDTagType(), identifier
            )
            if (this is SkullMeta) {
                val offlinePlayer = Bukkit.getOfflinePlayer(skullOwner!!)
                if (!offlinePlayer.hasPlayedBefore()) {
                    val textureUrl = runBlocking { TextureFetcher.fetchTexture(skullOwner!!) }
                    playerProfile = Bukkit.createProfile(skullOwner!!).also {
                        it.properties.removeIf { property -> property.name == "textures" }
                        it.properties.add(
                            ProfileProperty("textures", textureUrl)
                        )
                    }
                } else owningPlayer = offlinePlayer
            }
        }
        return itemStack
    }

    inline fun BukkitItemStack.editMetaInstance(crossinline block: ItemMeta.() -> Unit): BukkitItemStack {
        itemMeta = itemMeta.apply(block)
        return this
    }
}

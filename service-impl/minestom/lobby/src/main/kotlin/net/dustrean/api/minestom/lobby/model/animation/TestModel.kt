package net.dustrean.api.minestom.lobby.model.animation

import net.minestom.server.coordinate.Pos
import net.minestom.server.entity.LivingEntity
import net.minestom.server.instance.Instance
import net.worldseed.multipart.GenericModelImpl
import net.worldseed.multipart.ModelConfig

class TestModel : GenericModelImpl() {
    override fun getId(): String {
        return "test.bbmodel"
    }


    override fun init(instance: Instance?, position: Pos, config: ModelConfig?, masterEntity: LivingEntity?) {
        super.init(instance, position, config, masterEntity)
    }
}
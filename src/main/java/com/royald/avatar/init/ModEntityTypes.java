package com.royald.avatar.init;

import com.royald.avatar.AvatarAnimal;
import com.royald.avatar.entities.LemurEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

   public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, AvatarAnimal.MOD_ID);

   // Entity Types
   public static final RegistryObject<EntityType<LemurEntity>> LEMUR = ENTITY_TYPES.register("lemur", () -> EntityType.Builder.create(LemurEntity::new, EntityClassification.CREATURE)
      .size(0.5f, 1.0f)
      .build(new ResourceLocation(AvatarAnimal.MOD_ID, "lemur").toString()));
}

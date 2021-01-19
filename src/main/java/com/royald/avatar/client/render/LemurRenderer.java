package com.royald.avatar.client.render;

import com.royald.avatar.AvatarAnimal;
import com.royald.avatar.entities.LemurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import com.royald.avatar.client.model.LemurModel;
import net.minecraft.util.ResourceLocation;

public class LemurRenderer extends MobRenderer<LemurEntity, LemurModel<LemurEntity>>{

   protected static final ResourceLocation TEXTURE = new ResourceLocation(AvatarAnimal.MOD_ID, "textures/entity/lemur.png");

   public LemurRenderer(EntityRendererManager renderManagerIn) {
      super(renderManagerIn, new LemurModel<>(), 0.5F);
   }

   @Override
   public ResourceLocation getEntityTexture(LemurEntity entity) {
      return TEXTURE;
   }
}

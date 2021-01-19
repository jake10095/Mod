package com.royald.avatar.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.royald.avatar.entities.LemurEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class LemurModel<T extends LemurEntity> extends EntityModel<T> {
   private final ModelRenderer head;
   private final ModelRenderer bone;
   private final ModelRenderer RightEar;
   private final ModelRenderer left;
   private final ModelRenderer leftArm;
   private final ModelRenderer right;
   private final ModelRenderer rightArm;
   private final ModelRenderer tail;
   private final ModelRenderer Torso;

   public LemurModel() {
      textureWidth = 32;
      textureHeight = 32;

      head = new ModelRenderer(this);
      head.setRotationPoint(0.0F, 16.0F, -0.5F);
      head.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -1.5F, 4.0F, 5.0F, 3.0F, 0.0F, false);

      bone = new ModelRenderer(this);
      bone.setRotationPoint(0.0F, 8.0F, 0.5F);
      head.addChild(bone);
      bone.setTextureOffset(0, 8).addBox(0.0F, -14.0F, -2.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
      bone.setTextureOffset(0, 15).addBox(1.0F, -15.0F, -1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
      bone.setTextureOffset(6, 19).addBox(1.0F, -17.0F, -1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
      bone.setTextureOffset(18, 12).addBox(1.0F, -18.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

      RightEar = new ModelRenderer(this);
      RightEar.setRotationPoint(0.0F, 0.0F, 0.0F);
      head.addChild(RightEar);
      RightEar.setTextureOffset(9, 12).addBox(-3.0F, -6.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
      RightEar.setTextureOffset(0, 19).addBox(-3.0F, -9.0F, -0.5F, 2.0F, 3.0F, 1.0F, 0.0F, false);
      RightEar.setTextureOffset(12, 8).addBox(-4.0F, -7.0F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);
      RightEar.setTextureOffset(20, 20).addBox(-2.0F, -10.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

      left = new ModelRenderer(this);
      left.setRotationPoint(1.5F, 22.0F, -0.5F);
      left.setTextureOffset(21, 10).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

      leftArm = new ModelRenderer(this);
      leftArm.setRotationPoint(-2.0F, 17.0F, -0.5F);
      leftArm.setTextureOffset(16, 19).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

      right = new ModelRenderer(this);
      right.setRotationPoint(-1.5F, 22.0F, -0.5F);
      right.setTextureOffset(20, 7).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

      rightArm = new ModelRenderer(this);
      rightArm.setRotationPoint(2.0F, 17.0F, -0.5F);
      rightArm.setTextureOffset(12, 19).addBox(0.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

      tail = new ModelRenderer(this);
      tail.setRotationPoint(0.0F, 24.0F, 0.0F);


      Torso = new ModelRenderer(this);
      Torso.setRotationPoint(0.0F, 24.0F, 0.0F);
      Torso.setTextureOffset(14, 0).addBox(-2.0F, -8.0F, -1.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
   }

   @Override
   public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
      this.head.rotateAngleX = headPitch * ((float) Math.PI / 270F);
      this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
      this.right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
      this.left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
      this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
      this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
   }

   @Override
   public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
      head.render(matrixStack, buffer, packedLight, packedOverlay);
      left.render(matrixStack, buffer, packedLight, packedOverlay);
      leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
      right.render(matrixStack, buffer, packedLight, packedOverlay);
      rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
      tail.render(matrixStack, buffer, packedLight, packedOverlay);
      Torso.render(matrixStack, buffer, packedLight, packedOverlay);
   }

   public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
      modelRenderer.rotateAngleX = x;
      modelRenderer.rotateAngleY = y;
      modelRenderer.rotateAngleZ = z;
   }
}

package com.royald.avatar.entities;

import com.royald.avatar.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class LemurEntity extends AnimalEntity {

   public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.APPLE);

   public LemurEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
      super(type, worldIn);
   }

   // func_23666_p_() ---> registerAttributes()
   public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
      return MobEntity.func_233666_p_()
            .createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
            .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35D)
            .createMutableAttribute(Attributes.FLYING_SPEED, 0.5D);
   }

   // The "brain"
   @Override
   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(0, new SwimGoal(this));
      this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
      this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
      this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, TEMPTATION_ITEMS, false));
      this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
      this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
      this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
      this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
   }

   @Nullable
   @Override
   protected SoundEvent getAmbientSound() {
      return SoundEvents.ENTITY_BAT_AMBIENT;
   }

   @Nullable
   @Override
   protected SoundEvent getDeathSound() {
      return SoundEvents.ENTITY_BAT_DEATH;
   }

   @Nullable
   @Override
   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundEvents.ENTITY_BAT_HURT;
   }

   @Override
   protected void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
   }

   public AgeableEntity createChild(AgeableEntity ageable) {
      return ModEntityTypes.LEMUR.get().create(this.world);
   }

   @Nullable
   @Override
   public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
      return ModEntityTypes.LEMUR.get().create(this.world);
   }
}

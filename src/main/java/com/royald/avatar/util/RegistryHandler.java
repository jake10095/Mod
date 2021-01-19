package com.royald.avatar.util;

import com.royald.avatar.AvatarAnimal;
import com.royald.avatar.items.ItemBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
   public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AvatarAnimal.MOD_ID);

   public static void init() {
      ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
   }

   // Items Only
   //                                                             Name of item in code, use underscore
   public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);
}

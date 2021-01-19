package com.royald.avatar.util;


import com.royald.avatar.AvatarAnimal;
import com.royald.avatar.client.render.LemurRenderer;
import com.royald.avatar.init.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AvatarAnimal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LEMUR.get(), LemurRenderer::new);
   }
}

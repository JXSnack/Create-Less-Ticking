package net.dadamalda.create.less_ticking.forge;

import net.dadamalda.create.less_ticking.CLTConfig;
import net.dadamalda.create.less_ticking.CLTMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(CLTMod.MOD_ID)
public class CLTModForge {
    public CLTModForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        CLTMod.init();
    }

    @SubscribeEvent
    public void onServerStarting(FMLCommonSetupEvent event) {
        CLTMod.config = new CLTConfig(FMLPaths.CONFIGDIR.get().toAbsolutePath() + "/create_less_ticks.json");
    }
}

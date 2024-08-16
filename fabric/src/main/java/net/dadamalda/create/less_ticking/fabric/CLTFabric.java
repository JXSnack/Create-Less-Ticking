package net.dadamalda.create.less_ticking.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.dadamalda.create.less_ticking.CLTConfig;
import net.dadamalda.create.less_ticking.CLTMod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class CLTFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CLTMod.init();
        CLTMod.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CLTMod.NAME);

        CLTMod.config = new CLTConfig(FabricLoader.getInstance().getConfigDir().toAbsolutePath() + "/create_less_ticks.json");
    }
}

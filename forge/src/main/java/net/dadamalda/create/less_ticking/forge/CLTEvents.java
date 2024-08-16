package net.dadamalda.create.less_ticking.forge;

import net.dadamalda.create.less_ticking.CLTMod;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CLTMod.MOD_ID)
public class CLTEvents {
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        CLTMod.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }
}

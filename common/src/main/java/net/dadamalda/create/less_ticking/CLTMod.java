package net.dadamalda.create.less_ticking;

import com.mojang.brigadier.CommandDispatcher;
import com.simibubi.create.Create;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CLTMod {
    public static final String MOD_ID = "create_lt";
    public static final String NAME = "Create: Less Ticking";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static CLTConfig config;


    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, CLTExpectPlatform.platformName());
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher,
                                        CommandBuildContext ctx,
                                        Commands.CommandSelection selection) {
        dispatcher.register(Commands.literal("createlt")
                .then(Commands.literal("reload")
                        .executes((source) -> {
                            source.getSource().sendSystemMessage(Component.literal("Config reloaded!").withStyle(ChatFormatting.GREEN));
                            return 1;
                        })
                )
        );
    }
}

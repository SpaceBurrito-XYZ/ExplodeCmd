package xyz.spaceburrito.mc.explodecmd;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.jetbrains.annotations.NotNull;
import org.apache.logging.log4j.Logger;
import xyz.spaceburrito.mc.explodecmd.common.Reference;
import xyz.spaceburrito.mc.explodecmd.common.command.ExplodeCommand;



@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION
)
public class ExplodeCmd {
    @SuppressWarnings("null")
    @Mod.Instance(Reference.MOD_ID)
    public static @NotNull ExplodeCmd INSTANCE;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
     //proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLServerStartingEvent event) {
        logger.info("Initializing FMLServerStartingEvent :" + Reference.MOD_NAME);
        event.registerServerCommand(new ExplodeCommand());
    }
}

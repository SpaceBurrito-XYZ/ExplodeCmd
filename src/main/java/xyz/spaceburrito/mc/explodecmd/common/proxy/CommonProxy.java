package xyz.spaceburrito.mc.explodecmd.common.proxy;
import xyz.spaceburrito.mc.explodecmd.common.handlers.ExplosionHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CommonProxy {

    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ExplosionHandler());
    }
}

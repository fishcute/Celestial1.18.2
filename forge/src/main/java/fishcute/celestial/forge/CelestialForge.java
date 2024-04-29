package fishcute.celestial.forge;

import dev.architectury.platform.forge.EventBuses;
import fishcute.celestial.Celestial;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Celestial.MOD_ID)
public class CelestialForge {
    public CelestialForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Celestial.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Celestial.init();
    }
}
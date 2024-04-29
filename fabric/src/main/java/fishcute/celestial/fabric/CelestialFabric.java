package fishcute.celestial.fabric;

import fishcute.celestial.Celestial;
import net.fabricmc.api.ModInitializer;

public class CelestialFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Celestial.init();
    }
}
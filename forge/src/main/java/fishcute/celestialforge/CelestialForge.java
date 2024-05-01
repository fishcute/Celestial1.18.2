package fishcute.celestialforge;

import com.mojang.blaze3d.platform.InputConstants;
import fishcute.celestial.Celestial;
import fishcute.celestialmain.util.ClientTick;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Celestial.MOD_ID)
public class CelestialForge {
    private static KeyMapping reloadSky = new KeyMapping(
            "key.reload_sky",
            InputConstants.KEY_F10,
            "key.categories.misc"
    );

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            while (reloadSky.consumeClick()) {
                ClientTick.onReloadKey();
            }
        }
    }

    public CelestialForge() {
        Celestial.init();
        MinecraftForge.EVENT_BUS.register(CelestialForge.class);
        ClientRegistry.registerKeyBinding(reloadSky);
    }
}
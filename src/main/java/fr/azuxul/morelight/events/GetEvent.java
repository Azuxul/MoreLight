package fr.azuxul.morelight.events;

import fr.azuxul.morelight.MoreLight;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class GetEvent {

    @SubscribeEvent
    public void getPhosphoreDustEvent(PlayerEvent.ItemPickupEvent event) {
        if (event.pickedUp.getEntityItem().getItem().equals(MoreLight.PhosphoreDust)) {
            event.player.addStat(MoreLight.GetPhosphoreDust, 1);
        }
    }

}


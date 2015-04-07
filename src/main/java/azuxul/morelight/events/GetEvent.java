package azuxul.morelight.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import azuxul.morelight.MoreLight;

public class GetEvent {
	
	@SubscribeEvent
	public void GetPhosphoreDustEvent(PlayerEvent.ItemPickupEvent event){
		if(event.pickedUp.getEntityItem().getItem().equals(MoreLight.PhosphoreDust)){
			event.player.addStat(MoreLight.GetPhosphoreDust, 1);
		}
	}
		
}
	

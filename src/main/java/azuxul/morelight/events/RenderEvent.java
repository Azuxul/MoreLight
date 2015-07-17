package azuxul.morelight.events;

import azuxul.morelight.client.Cape;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEvent {

	@SubscribeEvent
	public void renderPlayer(RenderLivingEvent.Specials.Pre event){

		if(event.entity instanceof EntityPlayer) {

			if(event.entity.getName().equals("Azuxul") || event.entity.getUniqueID().toString().equals("c091f5f0-7505-4188-a070-02c76cb22bba")){
				
				Cape layer = new Cape((RenderPlayer) event.renderer);
				layer.doRenderLayer(event.entity, event.entity.getPosition().getX(), event.entity.getPosition().getY(), event.entity.getPosition().getZ(), 0, 0, 0, 0);
				
			}
		}
      
    }
}

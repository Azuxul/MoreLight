package azuxul.morelight.events;

import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import azuxul.morelight.client.Cape;

public class RenderEvent {

	@SubscribeEvent
	public void renderPlayer(RenderLivingEvent.Specials.Pre event){
		
		if(event.entity instanceof EntityPlayer) {	
						
			if(event.entity.getName().equals("Azuxul") || event.entity.getUniqueID().toString().equals("c091f5f0-7505-4188-a070-02c76cb22bba")){
				
				Cape layer = new Cape((RenderPlayer) event.renderer);
				layer.doRenderLayer(event.entity, 0, 0, 9.0F, 0, 0, 0, 0);
				
			}
		}
      
    }
}

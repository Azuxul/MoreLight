package azuxul.morelight.events;

import azuxul.morelight.MoreLight;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CraftingEvent {

	@SubscribeEvent
	public void CraftingBlockEvent(PlayerEvent.ItemCraftedEvent event){
		if(Block.getBlockFromItem(event.crafting.getItem()) == MoreLight.PhosphoreBlock){
			event.player.addStat(MoreLight.CraftingPhosphoreBlock, 1);
		}
		if(Block.getBlockFromItem(event.crafting.getItem()) == MoreLight.LightBlueLampBlock){
			event.player.addStat(MoreLight.CraftingLightBlueLampBlock, 1);
		}
		if(Block.getBlockFromItem(event.crafting.getItem()) == MoreLight.GreenLampBlock){
			event.player.addStat(MoreLight.CraftingGreenLampBlock, 1);
		}
		if(Block.getBlockFromItem(event.crafting.getItem()) == MoreLight.NyanLamp){
			event.player.addStat(MoreLight.CraftingNyanLamp, 1);
		}
		if(Block.getBlockFromItem(event.crafting.getItem()) == MoreLight.RandomLamp){
			event.player.addStat(MoreLight.CraftingRandomLamp, 1);
		}
		//System.out.println("Craft block");
	}
}

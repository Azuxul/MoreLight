package azuxul.morelight.events;

import net.minecraft.block.Block;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import azuxul.morelight.MoreLight;

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
	
	@SubscribeEvent
	public void CraftingItemEvent(PlayerEvent.ItemCraftedEvent event){		
		if(event.crafting.getItem() == MoreLight.LD_Pickaxe){
			event.player.addStat(AchievementList.buildPickaxe, 1);
			event.player.addStat(AchievementList.buildBetterPickaxe, 1);
			event.player.addStat(MoreLight.CraftingLD_Pickaxe, 1);
		}
		if(event.crafting.getItem() == MoreLight.LD_Hoe){
			event.player.addStat(AchievementList.buildHoe, 1);
		}
		if(event.crafting.getItem() == MoreLight.LD_Sword){
			event.player.addStat(AchievementList.buildSword, 1);
			event.player.addStat(MoreLight.CraftingLD_Sword, 1);
		}
	}
}

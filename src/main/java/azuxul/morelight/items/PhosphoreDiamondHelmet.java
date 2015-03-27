package azuxul.morelight.items;

import java.util.List;

import azuxul.morelight.Material;
import azuxul.morelight.MoreLight;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class PhosphoreDiamondHelmet extends ItemArmor {
	
	public PhosphoreDiamondHelmet(){
		
		super(Material.diamondPhosphore, 0, 0);
		this.setUnlocalizedName("phosphorediamondhelmet");
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack item){
		
		if(MoreLight.NightVision){
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 400, 0, true, false));
			
		}
		if(MoreLight.ResetNightVision){
			player.removePotionEffect(Potion.nightVision.id);
			MoreLight.ResetNightVision = false;
			
		}

	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List text, boolean advenced) {
		
		text.add("Active NightVision with N (Default key) key");
	}
}
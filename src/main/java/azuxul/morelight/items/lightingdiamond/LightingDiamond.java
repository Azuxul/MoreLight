package azuxul.morelight.items.lightingdiamond;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LightingDiamond extends Item {
	
	public LightingDiamond() {
		
		this.setUnlocalizedName("lightingdiamond");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}

}

package azuxul.morelight.items.lightingdiamond;

import azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class LD_Axe extends ItemAxe {

	public LD_Axe() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondaxe");
	}
	
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}
}

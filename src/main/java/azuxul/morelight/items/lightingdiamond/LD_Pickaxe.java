package azuxul.morelight.items.lightingdiamond;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import azuxul.morelight.Material;

public class LD_Pickaxe extends ItemPickaxe {

	public LD_Pickaxe() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondpickaxe");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}

}

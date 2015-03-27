package azuxul.morelight.items.lightingdiamond;

import azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class LD_Shovel extends ItemSpade {

	public LD_Shovel() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondshovel");
	}
	
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}

}

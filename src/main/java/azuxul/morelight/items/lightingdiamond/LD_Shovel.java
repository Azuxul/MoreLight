package azuxul.morelight.items.lightingdiamond;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import azuxul.morelight.Material;

public class LD_Shovel extends ItemSpade {

	public LD_Shovel() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondshovel");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}

}

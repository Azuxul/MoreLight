package azuxul.morelight.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NyanCoreItem extends Item {
	public NyanCoreItem(){
		this.setUnlocalizedName("nyancoreitem");
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
}

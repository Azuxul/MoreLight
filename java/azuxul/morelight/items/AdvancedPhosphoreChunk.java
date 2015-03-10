package azuxul.morelight.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdvancedPhosphoreChunk extends Item {

	public AdvancedPhosphoreChunk(){
		
		this.setUnlocalizedName("advancedphosphorechunk");
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){

        return true;
    }
}

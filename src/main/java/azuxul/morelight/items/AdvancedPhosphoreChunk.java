package azuxul.morelight.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdvancedPhosphoreChunk extends ItemFood {

	public AdvancedPhosphoreChunk(){
		
		super(7, 15.62F, false);
		this.setUnlocalizedName("advancedphosphorechunk");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setPotionEffect(Potion.nightVision.id, 660, 0, 100);
		this.setAlwaysEdible();
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){

        return true;
    }
    
}

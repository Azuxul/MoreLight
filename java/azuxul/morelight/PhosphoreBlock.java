package azuxul.morelight;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PhosphoreBlock extends Block {

	public PhosphoreBlock(){
		
		super(Material.ground);
		this.setUnlocalizedName("phosphoreblock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(1.0F);
		this.setHardness(0.15F);

	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.TRANSLUCENT;
		
	}
}

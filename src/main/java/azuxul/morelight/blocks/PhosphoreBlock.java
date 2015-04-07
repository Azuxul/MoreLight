package azuxul.morelight.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PhosphoreBlock extends Block {

	public PhosphoreBlock(){
		
		super(new Material(MapColor.goldColor));
		this.setUnlocalizedName("phosphoreblock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(1.0F);
		this.setHardness(0.15F);
		this.setResistance(1.0F);

	}
	
	@Override
	public boolean isOpaqueCube(){	
		
		return false;
	}

	@Override
	public boolean isFullCube(){
		
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer(){
		
		return EnumWorldBlockLayer.TRANSLUCENT;	
	}
}

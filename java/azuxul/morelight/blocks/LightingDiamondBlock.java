package azuxul.morelight.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class LightingDiamondBlock extends Block {

	public LightingDiamondBlock(){
		
		super(Material.iron);
		this.setUnlocalizedName("lightingdiamondblock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(0.5F);
	}
	
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon){
		
		return true;
	}
	
}

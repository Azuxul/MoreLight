package azuxul.morelight.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LightingDiamondBlock extends Block {
	
	public LightingDiamondBlock(){
		
		super(Material.iron);
		this.setUnlocalizedName("lightingdiamondblock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);
		this.setResistance(1.5F);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon){
		
		return true;
	}
	
	public boolean isOpaqueCube(){	
		
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer(){
		return EnumWorldBlockLayer.TRANSLUCENT;
		
	}
	
}

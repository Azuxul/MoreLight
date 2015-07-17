package azuxul.morelight.items;

import azuxul.morelight.MoreLight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class AdvancedLightingDust extends Item {

	public AdvancedLightingDust(){
		
		this.setUnlocalizedName("advancedlightingdust");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		
		player.addStat(MoreLight.SpawnLightningBolt, 1);
		
		if(world.getBlockState(pos).getBlock().equals(Blocks.diamond_block)){
			
			for(int i = 1; i <= 5; i++){
				
				world.spawnEntityInWorld(new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ()));
			}
			world.setBlockState(pos, MoreLight.LightingDiamondBlock.getDefaultState());
			
			player.addStat(MoreLight.GetLightingDiamondBlock, 1);
		}
		else{
			
			for(int i = 1; i <= 3; i++){
				
				Random r = new Random();
				double x = pos.getX() + r.nextInt(5);
				double y = pos.getY();
				double z = pos.getZ() + r.nextInt(5);
				
				world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));
			}

		}
		
		stack.stackSize --;
		
		return true;	
	}
	
    @Override
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){

        return true;
    }
    
	@Override
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.EPIC;
	}
}

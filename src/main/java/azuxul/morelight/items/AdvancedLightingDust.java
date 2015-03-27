package azuxul.morelight.items;

import java.util.Random;

import azuxul.morelight.MoreLight;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AdvancedLightingDust extends Item {

	public AdvancedLightingDust(){
		
		this.setUnlocalizedName("advancedlightingdust");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
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
			
			Random r = new Random();
			if(r.nextInt(50) == 30){
				
				world.setRainStrength(1.0F);
			}
		}
		
		stack.stackSize --;
		
		return true;	
	}
	
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack){

        return true;
    }
}

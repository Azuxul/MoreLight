package azuxul.morelight.items;

import java.util.Random;

import azuxul.morelight.MoreLight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class AdvancedLightingDust extends Item {

	public AdvancedLightingDust(){
		
		this.setUnlocalizedName("advancedlightingdust");
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(16);
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ){
		
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
		
		stack.stackSize --;
		player.addStat(MoreLight.SpawnLightningBolt, 1);
		
		return true;
		
	}
}

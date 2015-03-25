package azuxul.morelight.items.lightingdiamond;

import java.util.Random;

import azuxul.morelight.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class LD_Sword extends ItemSword {

	public LD_Sword() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondsword");
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		
		Random r = new Random();
		if(r.nextInt(100) <= 20){
			
			for(int i = 1; i <= 2; i++){
				
				entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY - 0.5, entity.posZ));			
			}			
		}
		
		return false;
	}
}

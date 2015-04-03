package azuxul.morelight.items.lightingdiamond;

import java.util.List;
import java.util.Random;

import azuxul.morelight.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;

public class LD_Sword extends ItemSword {

	public LD_Sword() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondsword");
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		
		Random r = new Random();
		
		if(entity instanceof EntityEnderman == false && entity instanceof EntityMinecart == false && entity instanceof EntityArmorStand == false){
			
			if(r.nextInt(100) <= 20){
				
				for(int i = 1; i <= 2; i++){
					
					entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY - 0.5, entity.posZ));			
				}			
			}
		}
		
		if(entity instanceof EntityLiving){
			
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 30 + r.nextInt(30), 9));
		}
		
		return false;
	}
	
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}
}

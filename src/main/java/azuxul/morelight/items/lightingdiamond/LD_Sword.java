package azuxul.morelight.items.lightingdiamond;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import azuxul.morelight.Material;

public class LD_Sword extends ItemSword {

	public LD_Sword() {
		
		super(Material.lightingDiamond);
		this.setUnlocalizedName("lightingdiamondsword");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		
		Random r = new Random();
		
		if(entity instanceof EntityEnderman == false && entity instanceof EntityMinecart == false && entity instanceof EntityArmorStand == false && entity instanceof EntityItemFrame == false && entity instanceof EntityLeashKnot == false && entity instanceof EntityPainting == false && entity instanceof EntityBoat == false && entity instanceof EntityTNTPrimed == false && entity instanceof EntityFallingBlock == false){
			
			if(r.nextInt(100) <= 20){
				
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 55 + r.nextInt(10), 1, true, false));
				
				for(int i = 1; i <= 2; i++){
					
					entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY - 0.5, entity.posZ));
					player.addPotionEffect(new PotionEffect(Potion.heal.id, 3, 1, true, false));
				}		
			}
		}
		
		if(entity instanceof EntityLiving){
			
			((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 30 + r.nextInt(30), 9));
		}
		
		return false;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack){
		
		return EnumRarity.RARE;
	}
}

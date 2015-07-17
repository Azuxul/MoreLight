package azuxul.morelight.enchantment;

import azuxul.morelight.MoreLight;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class LightningRain extends Enchantment{

	public LightningRain() {
		
		super(MoreLight.Enchantment_LightningRainID, new ResourceLocation("lightningrain"), 1, EnumEnchantmentType.WEAPON);	
		this.setName("lightningrain");
		Enchantment.addToBookList(this);
	}
	
	@Override
	public int getMaxLevel() {
		
		return 5;
	}
	
	@Override
	public float calcDamageByCreature(int level, EnumCreatureAttribute mob){
		
		return 0;
	}
	
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity entity, int level) {
		
		if(!(entity instanceof EntityEnderman) && !(entity instanceof EntityMinecart) && !(entity instanceof EntityArmorStand) && !(entity instanceof EntityItemFrame) && !(entity instanceof EntityLeashKnot) && !(entity instanceof EntityPainting) && !(entity instanceof EntityBoat) && !(entity instanceof EntityTNTPrimed) && !(entity instanceof EntityFallingBlock)){
			
			Random r = new Random();
			int random = r.nextInt(100);
			
			if(level >= 10)
				level = 10;
			
			int chance = 10 + 5 * level;
			
			if(random <= chance){
				
				if(random == chance)
					level ++;
				
				for(int i = 1; i <= level; i++)
				entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY, entity.posZ));
			}
		}
		
		if(user instanceof EntityPlayer)
			((EntityPlayer) user).addStat(MoreLight.UseEnchantment, 1);
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		
		return true;
	}

}

package azuxul.morelight.enchantment;

import java.util.Random;

import azuxul.morelight.MoreLight;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.ResourceLocation;

public class LightningRain extends Enchantment{

	public LightningRain() {
		
		super(MoreLight.Enchantment_LightningRainID, new ResourceLocation("lightningrain"), 1, EnumEnchantmentType.WEAPON);	
		this.setName("lightningrain");
		this.addToBookList(this);
	}
	
	public int getMaxLevel() {
		
		return 5;
	}
	
	public float calcDamageByCreature(int level, EnumCreatureAttribute mob){
		
		return 0;
	}
	
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		
		Random r = new Random();
		int random = r.nextInt(100);
		
		if(level >= 10)
			level = 10;
		
		int chance = 10 + 5 * level;
		
		if(random <= chance){
			
			if(random == chance)
				level ++;
			
			for(int i = 1; i <= level; i++)
			target.worldObj.spawnEntityInWorld(new EntityLightningBolt(target.worldObj, target.posX, target.posY, target.posZ));
		}
	}
	
	public boolean isAllowedOnBooks() {
		
		return true;
	}

}

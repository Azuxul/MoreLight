package fr.azuxul.morelight.items.lightingdiamond;

import fr.azuxul.morelight.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import java.util.Random;

public class LD_Sword extends ItemSword {

    public LD_Sword() {

        super(Material.lightingDiamond);
        this.setUnlocalizedName("lightingdiamondsword");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {

        Random r = new Random();

        if (!(entity instanceof EntityEnderman) && !(entity instanceof EntityMinecart) && !(entity instanceof EntityArmorStand) && !(entity instanceof EntityItemFrame) && !(entity instanceof EntityLeashKnot) && !(entity instanceof EntityPainting) && !(entity instanceof EntityBoat) && !(entity instanceof EntityTNTPrimed) && !(entity instanceof EntityFallingBlock)) {

            if (r.nextInt(100) <= 20) {

                player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 55 + r.nextInt(10), 1, true, false));

                for (int i = 1; i <= 2; i++) {

                    entity.worldObj.spawnEntityInWorld(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY - 0.5, entity.posZ));
                    player.addPotionEffect(new PotionEffect(Potion.heal.id, 3, 1, true, false));
                }
            }
        }

        if (entity instanceof EntityLiving) {

            ((EntityLiving) entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 30 + r.nextInt(30), 9));
        }

        return false;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }
}

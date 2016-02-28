package fr.azuxul.morelight.items;

import fr.azuxul.morelight.MoreLight;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.Random;

public class LightingDust extends Item {

    public LightingDust() {

        this.setUnlocalizedName("lightingdust");
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setMaxStackSize(16);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {

        Random r = new Random();
        double x = pos.getX() + r.nextInt(5);
        double y = pos.getY();
        double z = pos.getZ() + r.nextInt(5);

        world.spawnEntityInWorld(new EntityLightningBolt(world, x, y, z));

        stack.stackSize--;
        player.addStat(MoreLight.SpawnLightningBolt, 1);

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }
}

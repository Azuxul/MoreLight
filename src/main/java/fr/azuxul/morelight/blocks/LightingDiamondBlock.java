package fr.azuxul.morelight.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LightingDiamondBlock extends Block {

    public LightingDiamondBlock() {

        super(Material.iron);
        this.setUnlocalizedName("lightingdiamondblock");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightLevel(0.5F);
        this.setHardness(4.0F);
        this.setResistance(1.5F);
        this.setHarvestLevel("pickaxe", 3);
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {

        return true;
    }

    @Override
    public boolean isOpaqueCube() {

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.TRANSLUCENT;

    }

}

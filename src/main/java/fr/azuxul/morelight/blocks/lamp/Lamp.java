package fr.azuxul.morelight.blocks.lamp;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Lamp extends net.minecraft.block.Block {

    public Lamp() {
        super(Material.ground);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setStepSound(Block.soundTypeGlass);
        this.setLightLevel(1.0F);
        this.setHardness(0.15F);
    }

}

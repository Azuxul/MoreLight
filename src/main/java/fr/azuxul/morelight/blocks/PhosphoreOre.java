package fr.azuxul.morelight.blocks;

import fr.azuxul.morelight.MoreLight;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;

import java.util.Random;

public class PhosphoreOre extends Ore {

    public PhosphoreOre() {

        this.setUnlocalizedName("phosphoreore");
        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 1);

    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return MoreLight.PhosphoreDust;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }

    @Override
    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }

    @Override
    public int getExpDrop(net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
        if (this.getItemDropped(world.getBlockState(pos), RANDOM, fortune) != Item.getItemFromBlock(this)) {
            return 1 + RANDOM.nextInt(2);
        }
        return 0;
    }

}

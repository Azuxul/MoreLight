package azuxul.morelight.blocks;

import java.util.Random;

import azuxul.morelight.MoreLight;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class PhosphoreOre extends Ore {

	public PhosphoreOre(){
		
		this.setUnlocalizedName("phosphoreore");
		this.setHardness(2.5F);
		this.setHarvestLevel("pickaxe", 1);	
	}
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return MoreLight.PhosphoreDust;
    }
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        return this.quantityDropped(random) + random.nextInt(fortune + 1);
    }
    public int quantityDropped(Random random)
    {
        return 2 + random.nextInt(3);
    }
}

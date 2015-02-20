package azuxul.morelight;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Ore extends Block{
	
	public Ore(){
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypePiston);
	}
}

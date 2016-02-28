package fr.azuxul.morelight.items.lightingdiamond;

import fr.azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class LD_Hoe extends ItemHoe {

    public LD_Hoe() {

        super(Material.lightingDiamond);
        this.setUnlocalizedName("lightingdiamondhoe");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }

}

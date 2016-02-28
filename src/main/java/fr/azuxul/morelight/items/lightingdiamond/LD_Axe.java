package fr.azuxul.morelight.items.lightingdiamond;

import fr.azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class LD_Axe extends ItemAxe {

    public LD_Axe() {

        super(Material.lightingDiamond);
        this.setUnlocalizedName("lightingdiamondaxe");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }
}

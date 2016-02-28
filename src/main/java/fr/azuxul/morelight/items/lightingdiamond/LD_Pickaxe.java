package fr.azuxul.morelight.items.lightingdiamond;

import fr.azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class LD_Pickaxe extends ItemPickaxe {

    public LD_Pickaxe() {

        super(Material.lightingDiamond);
        this.setUnlocalizedName("lightingdiamondpickaxe");
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }

}

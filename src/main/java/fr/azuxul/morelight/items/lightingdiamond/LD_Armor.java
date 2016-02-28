package fr.azuxul.morelight.items.lightingdiamond;

import fr.azuxul.morelight.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class LD_Armor extends ItemArmor {

    public LD_Armor(int armorType) {

        super(Material.lightingDiamondArmor, armorType, armorType);

        String type = null;

        switch (armorType) {

            case 0:
                type = "helmet";
                break;
            case 1:
                type = "chestplate";
                break;
            case 2:
                type = "leggings";
                break;
            case 3:
                type = "boots";
                break;
        }

        this.setUnlocalizedName("lightingdiamond" + type);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return EnumRarity.RARE;
    }

}

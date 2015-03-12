package azuxul.morelight;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
	
	public static ArmorMaterial ironPhosphore = EnumHelper.addArmorMaterial("ironPhosphore", MoreLight.MODID + ":ironPhosphore", 15, new int[]{2, 0, 0, 0}, 9);
	public static ArmorMaterial diamondPhosphore = EnumHelper.addArmorMaterial("diamondPhosphore", MoreLight.MODID + ":diamondPhosphore", 33, new int[]{3, 0, 0, 0}, 10);
	
}

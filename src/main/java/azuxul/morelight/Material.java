package azuxul.morelight;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
	
	//Armor materials
	public static final ArmorMaterial ironPhosphore = EnumHelper.addArmorMaterial("ironPhosphore", MoreLight.MODID + ":ironPhosphore", 15, new int[]{2, 0, 0, 0}, 9);
	public static final ArmorMaterial diamondPhosphore = EnumHelper.addArmorMaterial("diamondPhosphore", MoreLight.MODID + ":diamondPhosphore", 33, new int[]{3, 0, 0, 0}, 10);
	
	//Tools materials
	public static final ToolMaterial lightingDiamond = EnumHelper.addToolMaterial("lightingDiamond", 4, 2237, 11.6F, 7.75F, 14);
}

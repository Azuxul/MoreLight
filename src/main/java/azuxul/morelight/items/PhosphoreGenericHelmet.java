package azuxul.morelight.items;

import java.awt.event.KeyEvent;
import java.util.List;

import akka.util.Helpers;
import azuxul.morelight.Material;
import azuxul.morelight.MoreLight;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class PhosphoreGenericHelmet extends ItemArmor {
	
	private int i = 0;
	private EnumRarity r;
	
	public PhosphoreGenericHelmet(ArmorMaterial material, String name, EnumRarity rarity){

		super(material, 0, 0);
		this.setUnlocalizedName(name);
		this.r = rarity;
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		
		if((MoreLight.NightVision) || (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active"))){
			
			i = 0;
			
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 400, 0, true, false));
			
			//setTag to active
			NBTTagCompound tag = new NBTTagCompound();
			tag.setBoolean("active", true);
			stack.setTagCompound(tag);
			
		}
		
		if(MoreLight.ResetNightVision && i <= 3) {
			
			i++;
			player.removePotionEffect(Potion.nightVision.id);
			
			NBTTagCompound tag = new NBTTagCompound();
			tag.setBoolean("active", false);
			stack.setTagCompound(tag);
			
			if(i == 3)
				MoreLight.ResetNightVision = false;
			
		}

	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean advenced) {
		
		info.add(StatCollector.translateToLocal("info.phosphoreHelmet.key"));
		
		if(stack.hasTagCompound() && stack.getTagCompound().getBoolean("active")){
			
			info.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("info.phosphoreHelmet.enable"));
		}
		else{
			
			info.add(EnumChatFormatting.RED + StatCollector.translateToLocal("info.phosphoreHelmet.disable"));
		}
	}
	
	public boolean getShareTag() {
		
		return true;
	}
	
	public EnumRarity getRarity(ItemStack stack){
		
		return r;
	}
}

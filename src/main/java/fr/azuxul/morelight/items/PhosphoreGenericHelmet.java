package fr.azuxul.morelight.items;

import fr.azuxul.morelight.MoreLight;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class PhosphoreGenericHelmet extends ItemArmor {

    private final EnumRarity r;
    private int i = 0;
    private boolean sendActivetedMsg = true;

    public PhosphoreGenericHelmet(ArmorMaterial material, String name, EnumRarity rarity) {

        super(material, 0, 0);
        this.setUnlocalizedName(name);
        this.r = rarity;
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {

        if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active")) {

            sendActivetedMsg = false;
        }

        if ((MoreLight.NightVision) || (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active"))) {

            i = 0;

            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 400, 0, true, false));

            if (player.isInWater()) {

                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 3, 0, true, false));
            }
            //setTag to active
            NBTTagCompound tag = new NBTTagCompound();
            tag.setBoolean("active", true);
            stack.setTagCompound(tag);

            if (sendActivetedMsg) {

                player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + StatCollector.translateToLocal("info.phosphoreHelmet.enable")));
                sendActivetedMsg = false;
            }

        }

        if (MoreLight.ResetNightVision && i <= 3) {

            i++;
            player.removePotionEffect(Potion.nightVision.id);

            NBTTagCompound tag = new NBTTagCompound();
            tag.setBoolean("active", false);
            stack.setTagCompound(tag);

            if (i == 3) {

                MoreLight.ResetNightVision = false;
                sendActivetedMsg = true;

                player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + StatCollector.translateToLocal("info.phosphoreHelmet.disable")));
            }

        }

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> info, boolean advenced) {

        info.add(StatCollector.translateToLocal("info.phosphoreHelmet.key"));

        if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("active")) {

            info.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("info.phosphoreHelmet.enable"));
        } else {

            info.add(EnumChatFormatting.RED + StatCollector.translateToLocal("info.phosphoreHelmet.disable"));
        }
    }

    @Override
    public boolean getShareTag() {

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {

        return r;
    }
}

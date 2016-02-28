package fr.azuxul.morelight;

import fr.azuxul.morelight.blocks.LightingDiamondBlock;
import fr.azuxul.morelight.blocks.PhosphoreBlock;
import fr.azuxul.morelight.blocks.PhosphoreOre;
import fr.azuxul.morelight.blocks.lamp.GreenLampBlock;
import fr.azuxul.morelight.blocks.lamp.LightBlueLampBlock;
import fr.azuxul.morelight.blocks.lamp.NyanLamp;
import fr.azuxul.morelight.blocks.lamp.RandomLamp;
import fr.azuxul.morelight.enchantment.LightningRain;
import fr.azuxul.morelight.events.CraftingEvent;
import fr.azuxul.morelight.events.GetEvent;
import fr.azuxul.morelight.events.KeyEvent;
import fr.azuxul.morelight.items.AdvancedLightingDust;
import fr.azuxul.morelight.items.AdvancedPhosphoreChunk;
import fr.azuxul.morelight.items.LightingDust;
import fr.azuxul.morelight.items.PhosphoreGenericHelmet;
import fr.azuxul.morelight.items.lightingdiamond.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.StatCollector;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = MoreLight.MODID, version = MoreLight.VERSION, name = MoreLight.NAME)

public class MoreLight {

    public static final String MODID = "morelight";
    public static final String VERSION = "1.5.1";
    public static final String NAME = "MoreLight";
    public static final Logger log = LogManager.getLogger(MoreLight.NAME);
    public static KeyBinding ActiveNightVision;
    public static Block PhosphoreOre;
    public static Block PhosphoreBlock;
    public static Block LightBlueLampBlock;
    public static Block GreenLampBlock;
    public static Block RandomLamp;
    public static Block NyanLamp;
    public static Block LightingDiamondBlock;
    public static Item PhosphoreDust;
    public static Item NyanCoreItem;
    public static Item PhosphoreChunk;
    public static Item AdvancedPhosphoreChunk;
    public static Item PhosphoreIronHelmet;
    public static Item PhosphoreDiamondHelmet;
    public static Item LightingDust;
    public static Item AdvancedLightingDust;
    public static Item LightingDiamond;
    public static Item LD_Pickaxe;
    public static Item LD_Sword;
    public static Item LD_Hoe;
    public static Item LD_Axe;
    public static Item LD_Shovel;
    public static Item LD_Helmet;
    public static Item LD_Chestplate;
    public static Item LD_Leggings;
    public static Item LD_Boots;
    public static Item LD_PhosphoreHelmet;
    public static Item NetherStick;
    public static Item NetherCrystal;
    public static Achievement GetPhosphoreDust;
    public static Achievement CraftingPhosphoreBlock;
    public static Achievement CraftingLightBlueLampBlock;
    public static Achievement CraftingGreenLampBlock;
    public static Achievement CraftingRandomLamp;
    public static Achievement CraftingNyanLamp;
    public static Achievement SpawnLightningBolt;
    public static Achievement GetLightingDiamondBlock;
    public static Achievement UseEnchantment;
    public static Achievement CraftingLD_Sword;
    public static Achievement CraftingLD_Pickaxe;
    public static int Enchantment_LightningRainID;
    public static boolean NightVision = false;
    public static boolean ResetNightVision = false;
    private static boolean OreGeneration;
    private static boolean Hard;
    private static boolean Cape;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        OreGeneration = config.getBoolean("WorldOreGen", Configuration.CATEGORY_GENERAL, true, "PhosphoreOre generation");
        Hard = config.getBoolean("HardMode", Configuration.CATEGORY_GENERAL, false, "Hard recipes");
        Cape = config.getBoolean("ActiveCape", Configuration.CATEGORY_GENERAL, false, "Cape is for mod devlopers (only for client and in beta testing)");
        Enchantment_LightningRainID = config.getInt("LightningRain", "Enchantments", 74, 63, 256, "Enchantment ID");

        config.save();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        PhosphoreOre = new PhosphoreOre();
        PhosphoreBlock = new PhosphoreBlock();
        LightBlueLampBlock = new LightBlueLampBlock();
        GreenLampBlock = new GreenLampBlock();
        RandomLamp = new RandomLamp();
        NyanLamp = new NyanLamp();
        LightingDiamondBlock = new LightingDiamondBlock();

        PhosphoreDust = new Item().setUnlocalizedName("phosphoredust").setCreativeTab(CreativeTabs.tabMaterials);
        NyanCoreItem = new Item().setUnlocalizedName("nyancoreitem").setCreativeTab(CreativeTabs.tabMisc);
        PhosphoreChunk = new Item().setUnlocalizedName("phosphorechunk").setCreativeTab(CreativeTabs.tabMaterials);
        AdvancedPhosphoreChunk = new AdvancedPhosphoreChunk();
        PhosphoreIronHelmet = new PhosphoreGenericHelmet(Material.ironPhosphore, "phosphoreironhelmet", EnumRarity.UNCOMMON);
        PhosphoreDiamondHelmet = new PhosphoreGenericHelmet(Material.diamondPhosphore, "phosphorediamondhelmet", EnumRarity.UNCOMMON);
        LightingDust = new LightingDust();
        AdvancedLightingDust = new AdvancedLightingDust();
        LightingDiamond = new Item().setUnlocalizedName("lightingdiamond").setCreativeTab(CreativeTabs.tabMaterials);
        LD_Pickaxe = new LD_Pickaxe();
        LD_Sword = new LD_Sword();
        LD_Hoe = new LD_Hoe();
        LD_Axe = new LD_Axe();
        LD_Shovel = new LD_Shovel();
        LD_Helmet = new LD_Armor(0);
        LD_Chestplate = new LD_Armor(1);
        LD_Leggings = new LD_Armor(2);
        LD_Boots = new LD_Armor(3);
        LD_PhosphoreHelmet = new PhosphoreGenericHelmet(Material.lightingDiamondPhosphore, "phosphorelightingdiamondhelmet", EnumRarity.RARE);
        NetherStick = new Item().setUnlocalizedName("netherstick").setCreativeTab(CreativeTabs.tabMaterials);
        NetherCrystal = new Item().setUnlocalizedName("nethercrystal").setCreativeTab(CreativeTabs.tabMaterials);

        //Registry blocks
        GameRegistry.registerBlock(PhosphoreOre, "phosphoreore");
        GameRegistry.registerBlock(PhosphoreBlock, "phosphoreblock");
        GameRegistry.registerBlock(LightBlueLampBlock, "lightbluelampblock");
        GameRegistry.registerBlock(GreenLampBlock, "greenlampblock");
        GameRegistry.registerBlock(RandomLamp, "randomlamp");
        GameRegistry.registerBlock(NyanLamp, "nyanlamp");
        GameRegistry.registerBlock(LightingDiamondBlock, "lightingdiamondblock");

        OreDictionary.registerOre("phosphoreore", PhosphoreOre);

        //Registry items
        GameRegistry.registerItem(PhosphoreDust, "phosphoredust");
        GameRegistry.registerItem(NyanCoreItem, "nyancoreitem");
        GameRegistry.registerItem(PhosphoreChunk, "phosphorechunk");
        GameRegistry.registerItem(AdvancedPhosphoreChunk, "advancedphosphorechunk");
        GameRegistry.registerItem(PhosphoreIronHelmet, "phosphoreironhelmet");
        GameRegistry.registerItem(PhosphoreDiamondHelmet, "phosphorediamondhelmet");
        GameRegistry.registerItem(LightingDust, "lightingdust");
        GameRegistry.registerItem(AdvancedLightingDust, "advancedlightingdust");
        GameRegistry.registerItem(LightingDiamond, "lightingdiamond");
        GameRegistry.registerItem(LD_Pickaxe, "lightingdiamondpickaxe");
        GameRegistry.registerItem(LD_Sword, "lightingdiamondsword");
        GameRegistry.registerItem(LD_Hoe, "lightingdiamondhoe");
        GameRegistry.registerItem(LD_Axe, "lightingdiamondaxe");
        GameRegistry.registerItem(LD_Shovel, "lightingdiamondshovel");
        GameRegistry.registerItem(LD_Helmet, "lightingdiamondhelmet");
        GameRegistry.registerItem(LD_Chestplate, "lightingdiamondchestplate");
        GameRegistry.registerItem(LD_Leggings, "lightingdiamondleggings");
        GameRegistry.registerItem(LD_Boots, "lightingdiamondboots");
        GameRegistry.registerItem(LD_PhosphoreHelmet, "phosphorelightingdiamondhelmet");
        GameRegistry.registerItem(NetherStick, "netherstick");
        GameRegistry.registerItem(NetherCrystal, "nethercrystal");

        OreDictionary.registerOre("phosphoredust", PhosphoreDust);

        Enchantment LightningRain = new LightningRain();

        //Registry crafting recipe
        GameRegistry.addShapedRecipe(new ItemStack(PhosphoreBlock), "AA", "AA", 'A', new ItemStack(PhosphoreDust));
        GameRegistry.addShapedRecipe(new ItemStack(LightBlueLampBlock), "AAA", "ABA", "ACA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 3), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(Blocks.redstone_torch));
        GameRegistry.addShapedRecipe(new ItemStack(GreenLampBlock), "AAA", "ABA", "ACA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 13), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(Blocks.redstone_torch));
        GameRegistry.addShapedRecipe(new ItemStack(RandomLamp), "ABC", "DXE", "FGH", 'A', new ItemStack(Items.dye, 1, 0), 'B', new ItemStack(Items.dye, 1, 1), 'C', new ItemStack(Items.dye, 1, 2), 'D', new ItemStack(Items.dye, 1, 4), 'E', new ItemStack(Items.dye, 1, 5), 'F', new ItemStack(Items.dye, 1, 11), 'G', new ItemStack(Items.dye, 1, 15), 'H', new ItemStack(Items.dye, 1, 13), 'X', new ItemStack(PhosphoreBlock));
        GameRegistry.addShapedRecipe(new ItemStack(NyanLamp), "ABA", "ACA", "ABA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 0), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(NyanCoreItem));
        GameRegistry.addShapedRecipe(new ItemStack(NyanCoreItem), "AAB", "AAB", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 6), 'B', new ItemStack(Blocks.stained_glass_pane, 1, 7));
        GameRegistry.addShapedRecipe(new ItemStack(PhosphoreChunk), "AAA", "AAA", "AAA", 'A', new ItemStack(PhosphoreDust));
        GameRegistry.addShapedRecipe(new ItemStack(AdvancedPhosphoreChunk), "AAA", "ABA", "AAA", 'A', new ItemStack(PhosphoreChunk), 'B', new ItemStack(Items.potionitem, 1, 8262));
        GameRegistry.addShapedRecipe(new ItemStack(PhosphoreIronHelmet), "A", "B", 'A', new ItemStack(Items.iron_helmet), 'B', new ItemStack(AdvancedPhosphoreChunk));
        GameRegistry.addShapedRecipe(new ItemStack(PhosphoreDiamondHelmet), "A", "B", 'A', new ItemStack(Items.diamond_helmet), 'B', new ItemStack(AdvancedPhosphoreChunk));
        GameRegistry.addShapedRecipe(new ItemStack(LightingDiamond, 9), "A", 'A', new ItemStack(LightingDiamondBlock));
        GameRegistry.addShapedRecipe(new ItemStack(LightingDiamondBlock), "AAA", "AAA", "AAA", 'A', new ItemStack(LightingDiamond));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Sword), "A", "A", "B", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Hoe), "AA ", " B ", " B ", 'A', LightingDiamond, 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Hoe), " AA", " B ", " B ", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Axe), "AA ", "AB ", " B ", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Axe), " AA", " BA", " B ", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Pickaxe), "AAA", " B ", " B ", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Shovel), "A", "B", "B", 'A', new ItemStack(LightingDiamond), 'B', new ItemStack(NetherStick));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Helmet), "AAA", "A A", 'A', new ItemStack(LightingDiamond));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Chestplate), "A A", "AAA", "AAA", 'A', new ItemStack(LightingDiamond));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Leggings), "AAA", "A A", "A A", 'A', new ItemStack(LightingDiamond));
        GameRegistry.addShapedRecipe(new ItemStack(LD_Boots), "A A", "A A", 'A', new ItemStack(LightingDiamond));
        GameRegistry.addShapedRecipe(new ItemStack(LD_PhosphoreHelmet), "A", "B", 'A', new ItemStack(LD_Helmet), 'B', new ItemStack(AdvancedPhosphoreChunk));
        GameRegistry.addShapedRecipe(new ItemStack(NetherStick, 1), "A", "A", 'A', new ItemStack(Items.netherbrick));
        GameRegistry.addShapedRecipe(new ItemStack(NetherCrystal), "ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Blocks.glass_pane, 'C', Blocks.obsidian);

        if (Hard) {

            GameRegistry.addShapedRecipe(new ItemStack(LightingDust), "ABA", "BCB", "ABA", 'A', new ItemStack(PhosphoreDust), 'B', new ItemStack(Items.dye, 1, 15), 'C', new ItemStack(Items.nether_star));
            GameRegistry.addShapedRecipe(new ItemStack(AdvancedLightingDust), "AAA", "ABA", "AAA", 'A', new ItemStack(Blocks.diamond_block), 'B', new ItemStack(LightingDust));
        } else {

            GameRegistry.addShapedRecipe(new ItemStack(LightingDust), "ABA", "BCB", "ABA", 'A', new ItemStack(PhosphoreDust), 'B', new ItemStack(Items.dye, 1, 15), 'C', new ItemStack(Items.skull, 1, 1));
            GameRegistry.addShapedRecipe(new ItemStack(AdvancedLightingDust), "AAA", "ABA", "AAA", 'A', new ItemStack(Items.diamond), 'B', new ItemStack(LightingDust));
        }

        ItemStack book;

        book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(LightningRain, 1);
        GameRegistry.addShapedRecipe(book, "AB", 'A', new ItemStack(Items.book), 'B', new ItemStack(LightingDust));

        book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(LightningRain, 2);
        GameRegistry.addShapedRecipe(book, "AB", "B ", 'A', new ItemStack(Items.book), 'B', new ItemStack(LightingDust));

        book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(LightningRain, 3);
        GameRegistry.addShapedRecipe(book, "ABB", "BB ", 'A', new ItemStack(Items.book), 'B', new ItemStack(LightingDust));

        book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(LightningRain, 4);
        GameRegistry.addShapedRecipe(book, "ABB", "BBB", 'A', new ItemStack(Items.book), 'B', new ItemStack(LightingDust));

        book = new ItemStack(Items.enchanted_book);
        book.addEnchantment(LightningRain, 5);
        GameRegistry.addShapedRecipe(book, "ABB", "BBB", "BB ", 'A', new ItemStack(Items.book), 'B', new ItemStack(LightingDust));

        //Registry smelling recipe
        GameRegistry.addSmelting(PhosphoreOre, new ItemStack(PhosphoreDust), 0.1F);

        //Chest generation
        ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(LightingDiamond, 0, 4, 8, 3));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(LD_Pickaxe, 0, 4, 7, 1));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(LightingDust, 0, 3, 5, 5));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(PhosphoreIronHelmet, 0, 2, 6, 2));
        ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(LD_Chestplate, 0, 3, 8, 3));
        ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(LightingDust, 0, 3, 5, 5));
        ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(LightingDiamond, 0, 3, 8, 3));

        if (OreGeneration) {

            //Registry ore
            GameRegistry.registerWorldGenerator(new OreGeneration(PhosphoreOre), 0);
        } else
            log.warn(StatCollector.translateToLocal("log.warn.morelightOreGen"));

        if (event.getSide().isClient()) {

            ActiveNightVision = new KeyBinding("key.ActiveNightVision", Keyboard.KEY_N, "key.categories.gameplay");

            ClientRegistry.registerKeyBinding(ActiveNightVision);

            //Rendering blocks
            RegistryRenderBlock("phosphoreore", PhosphoreOre);
            RegistryRenderBlock("phosphoreblock", PhosphoreBlock);
            RegistryRenderBlock("lightbluelampblock", LightBlueLampBlock);
            RegistryRenderBlock("greenlampblock", GreenLampBlock);
            RegistryRenderBlock("randomlamp", RandomLamp);
            RegistryRenderBlock("nyanlamp", NyanLamp);
            RegistryRenderBlock("lightingdiamondblock", LightingDiamondBlock);

            //Rendering items
            RegistryRenderItem("phosphoredust", PhosphoreDust);
            RegistryRenderItem("nyancoreitem", NyanCoreItem);
            RegistryRenderItem("phosphorechunk", PhosphoreChunk);
            RegistryRenderItem("advancedphosphorechunk", AdvancedPhosphoreChunk);
            RegistryRenderItem("phosphoreironhelmet", PhosphoreIronHelmet);
            RegistryRenderItem("phosphorediamondhelmet", PhosphoreDiamondHelmet);
            RegistryRenderItem("lightingdust", LightingDust);
            RegistryRenderItem("advancedlightingdust", AdvancedLightingDust);
            RegistryRenderItem("lightingdiamond", LightingDiamond);
            RegistryRenderItem("lightingdiamondsword", LD_Sword);
            RegistryRenderItem("lightingdiamondhoe", LD_Hoe);
            RegistryRenderItem("lightingdiamondaxe", LD_Axe);
            RegistryRenderItem("lightingdiamondpickaxe", LD_Pickaxe);
            RegistryRenderItem("lightingdiamondshovel", LD_Shovel);
            RegistryRenderItem("lightingdiamondhelmet", LD_Helmet);
            RegistryRenderItem("lightingdiamondchestplate", LD_Chestplate);
            RegistryRenderItem("lightingdiamondleggings", LD_Leggings);
            RegistryRenderItem("lightingdiamondboots", LD_Boots);
            RegistryRenderItem("phosphorelightingdiamondhelmet", LD_PhosphoreHelmet);
            RegistryRenderItem("netherstick", NetherStick);
            RegistryRenderItem("nethercrystal", NetherCrystal);

        }

        //Registry events
        FMLCommonHandler.instance().bus().register(new GetEvent());
        FMLCommonHandler.instance().bus().register(new CraftingEvent());
        FMLCommonHandler.instance().bus().register(new KeyEvent());

        //Add achievement
        GetPhosphoreDust = new Achievement("Achievement.GetPhosphoreDust", "GetPhosphoreDust", 0, 0, new ItemStack(PhosphoreDust), null).registerStat().initIndependentStat();
        CraftingPhosphoreBlock = new Achievement("Achievement.CraftingPhosphoreBlock", "CraftingPhosphoreBlock", 3, 0, PhosphoreBlock, GetPhosphoreDust).registerStat();
        CraftingLightBlueLampBlock = new Achievement("Achievement.CraftingLightBlueLampBlock", "CraftingLightBlueLampBlock", 2, 2, LightBlueLampBlock, CraftingPhosphoreBlock).registerStat();
        CraftingGreenLampBlock = new Achievement("Achievement.CraftingGreenLampBlock", "CraftingGreenLampBlock", 3, 2, GreenLampBlock, CraftingPhosphoreBlock).registerStat();
        CraftingRandomLamp = new Achievement("Achievement.CraftingRandomLamp", "CraftingRandomLamp", 4, 2, RandomLamp, CraftingPhosphoreBlock).registerStat();
        CraftingNyanLamp = new Achievement("Achievement.CraftingNyanLamp", "CraftingNyanLamp", 6, 0, NyanLamp, CraftingPhosphoreBlock).setSpecial().registerStat();
        SpawnLightningBolt = new Achievement("Achievement.SpawnLightningBolt", "SpawnLightningBolt", 0, 2, LightingDust, GetPhosphoreDust).setSpecial().registerStat();
        GetLightingDiamondBlock = new Achievement("Achievement.GetLightingDiamondBlock", "GetLightingDiamondBlock", 0, 4, LightingDiamondBlock, SpawnLightningBolt).setSpecial().registerStat();
        UseEnchantment = new Achievement("Achievement.UseEnchantment", "UseEnchantment", 0, -2, Items.enchanted_book, null).registerStat().initIndependentStat();
        CraftingLD_Sword = new Achievement("Achievement.CraftingLD_Sword", "CraftingLD_Sword", -1, 6, LD_Sword, GetLightingDiamondBlock).registerStat();
        CraftingLD_Pickaxe = new Achievement("Achievement.CraftingLD_Pickaxe", "CraftingLD_Pickaxe", 1, 6, LD_Pickaxe, GetLightingDiamondBlock).registerStat();


        AchievementPage.registerAchievementPage(new AchievementPage("MoreLight", GetPhosphoreDust, CraftingPhosphoreBlock, CraftingLightBlueLampBlock, CraftingGreenLampBlock, CraftingNyanLamp, CraftingRandomLamp, SpawnLightningBolt, GetLightingDiamondBlock, UseEnchantment, CraftingLD_Sword, CraftingLD_Pickaxe));

        //Check updates whit VersionChecker
        FMLInterModComms.sendRuntimeMessage(MoreLight.MODID, "VersionChecker", "addVersionCheck", "https://raw.githubusercontent.com/Azuxul/MoreLight/master/version.json");

    }

    private void RegistryRenderBlock(String blockName, Block block) {

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MoreLight.MODID + ":" + blockName, "inventory"));

    }

    private void RegistryRenderItem(String itemName, Item item) {

        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MoreLight.MODID + ":" + itemName, "inventory"));

    }
}
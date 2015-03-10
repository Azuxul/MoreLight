package azuxul.morelight;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import azuxul.morelight.blocks.*;
import azuxul.morelight.blocks.lamp.*;
import azuxul.morelight.events.*;
import azuxul.morelight.items.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = MoreLight.MODID, version = MoreLight.VERSION, name = MoreLight.NAME)

public class MoreLight {
	
	public static final String MODID = "morelight";
	public static final String VERSION = "1.3_DEV";
	public static final String NAME = "MoreLight";
	
	public static KeyBinding ActiveNightVision;
	
	public static Block PhosphoreOre;
	public static Block PhosphoreBlock;
	public static Block LightBlueLampBlock;
	public static Block GreenLampBlock;
	public static Block RandomLamp;
	public static Block NyanLamp;
	
	public static Item PhosphoreDust;
	public static Item NyanCoreItem;
	public static Item PhosphoreChunk;
	public static Item AdvancedPhosphoreChunk;
	public static Item PhosphoreIronHelmet;
	public static Item PhosphoreDiamondHelmet;
	
	public static Achievement GetPhosphoreDust;
	public static Achievement CraftingPhosphoreBlock;
	public static Achievement CraftingLightBlueLampBlock;
	public static Achievement CraftingGreenLampBlock;
	public static Achievement CraftingRandomLamp;
	public static Achievement CraftingNyanLamp;
	
	public static boolean OreGeneration;
	
	public static boolean NightVision = false;
	public static boolean ResetNightVision = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		OreGeneration = config.getBoolean("WorldOreGen", Configuration.CATEGORY_GENERAL, true, "PhosphoreOre generation");
		
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
				
		PhosphoreOre = new PhosphoreOre();
		PhosphoreBlock = new PhosphoreBlock();
		LightBlueLampBlock = new LightBlueLampBlock();
		GreenLampBlock = new GreenLampBlock();
		RandomLamp = new RandomLamp();
		NyanLamp = new NyanLamp();
		
		PhosphoreDust = new PhosphoreDust();
		NyanCoreItem = new NyanCoreItem();
		PhosphoreChunk = new PhosphoreChunk();
		AdvancedPhosphoreChunk = new AdvancedPhosphoreChunk();
		PhosphoreIronHelmet = new PhosphoreIronHelmet();
		PhosphoreDiamondHelmet = new PhosphoreDiamondHelmet();

		//Registry blocks
		GameRegistry.registerBlock(PhosphoreOre, "phosphoreore");
		GameRegistry.registerBlock(PhosphoreBlock, "phosphoreblock");
		GameRegistry.registerBlock(LightBlueLampBlock, "lightbluelampblock");
		GameRegistry.registerBlock(GreenLampBlock, "greenlampblock");
		GameRegistry.registerBlock(RandomLamp, "randomlamp");
		GameRegistry.registerBlock(NyanLamp, "nyanlamp");
		
		OreDictionary.registerOre("phosphoreore", PhosphoreOre);
		
		//Registry items
		GameRegistry.registerItem(PhosphoreDust, "phosphoredust");
		GameRegistry.registerItem(NyanCoreItem, "nyancoreitem");
		GameRegistry.registerItem(PhosphoreChunk, "phosphorechunk");
		GameRegistry.registerItem(AdvancedPhosphoreChunk, "advancedphosphorechunk");
		GameRegistry.registerItem(PhosphoreIronHelmet, "phosphoreironhelmet");
		GameRegistry.registerItem(PhosphoreDiamondHelmet, "phosphorediamondhelmet");
		
		OreDictionary.registerOre("phosphoredust", PhosphoreDust);
		
		//Registry crafting recipe
		GameRegistry.addShapedRecipe(new ItemStack(PhosphoreBlock),"XX","XX",'X', new ItemStack(PhosphoreDust));
		GameRegistry.addShapedRecipe(new ItemStack(LightBlueLampBlock), "AAA", "ABA", "ACA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 3), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(Blocks.redstone_torch));
		GameRegistry.addShapedRecipe(new ItemStack(GreenLampBlock), "AAA", "ABA", "ACA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 13), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(Blocks.redstone_torch));
		GameRegistry.addShapedRecipe(new ItemStack(RandomLamp), "ABC", "DXE", "FGH", 'A', new ItemStack(Items.dye, 1, 0), 'B', new ItemStack(Items.dye, 1, 1), 'C', new ItemStack(Items.dye, 1, 2), 'D', new ItemStack(Items.dye, 1, 4), 'E', new ItemStack(Items.dye, 1, 5), 'F', new ItemStack(Items.dye, 1, 11), 'G', new ItemStack(Items.dye, 1, 15), 'H', new ItemStack(Items.dye, 1, 13), 'X', new ItemStack(PhosphoreBlock));
		GameRegistry.addShapedRecipe(new ItemStack(NyanLamp), "ABA", "ACA", "ABA", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 0), 'B', new ItemStack(PhosphoreBlock), 'C', new ItemStack(NyanCoreItem));
		GameRegistry.addShapedRecipe(new ItemStack(NyanCoreItem), "AAB", "AAB", 'A', new ItemStack(Blocks.stained_glass_pane, 1, 6), 'B', new ItemStack(Blocks.stained_glass_pane, 1, 7));
		GameRegistry.addShapedRecipe(new ItemStack(PhosphoreChunk), "AAA", "AAA", "AAA", 'A', new ItemStack(PhosphoreDust));
		GameRegistry.addShapedRecipe(new ItemStack(AdvancedPhosphoreChunk), "AAA", "ABA", "AAA", 'A', new ItemStack(PhosphoreChunk), 'B', new ItemStack(Items.potionitem, 0, 8262));
		GameRegistry.addShapedRecipe(new ItemStack(PhosphoreIronHelmet), "A", "B", 'A', new ItemStack(Items.iron_helmet), 'B', new ItemStack(AdvancedPhosphoreChunk));
		GameRegistry.addShapedRecipe(new ItemStack(PhosphoreDiamondHelmet), "A", "B", 'A', new ItemStack(Items.diamond_helmet), 'B', new ItemStack(AdvancedPhosphoreChunk));
		
		//Registry smelling recipe
		GameRegistry.addSmelting(PhosphoreOre, new ItemStack(PhosphoreDust), 0.1F);
				
	if(OreGeneration){
		
		//Registry ore
		GameRegistry.registerWorldGenerator(new OreGeneration(PhosphoreOre, 2, 50, 4, 9), 0);
	}
	else
		System.out.println("MoreLight ore generation is disable !");
		
	if(event.getSide().isClient()){
		
		ActiveNightVision = new KeyBinding("key.ActiveNightVision", Keyboard.KEY_N, "key.categories.gameplay");
		
		ClientRegistry.registerKeyBinding(ActiveNightVision);
		
		System.out.println("Initialization render");
		
		//Rendering blocks
		RegistryRenderBlock("phosphoreore", PhosphoreOre);
		RegistryRenderBlock("phosphoreblock", PhosphoreBlock);
		RegistryRenderBlock("lightbluelampblock", LightBlueLampBlock);
		RegistryRenderBlock("greenlampblock", GreenLampBlock);
		RegistryRenderBlock("randomlamp", RandomLamp);
		RegistryRenderBlock("nyanlamp", NyanLamp);
		
		//Rendering items
		RegistryRenderItem("phosphoredust", PhosphoreDust);
		RegistryRenderItem("nyancoreitem", NyanCoreItem);
	}
	
		//Add events
		FMLCommonHandler.instance().bus().register(new GetEvent());
		FMLCommonHandler.instance().bus().register(new CraftingEvent());
		FMLCommonHandler.instance().bus().register(new KeyEvent());
		
		//Add achievement
		GetPhosphoreDust = (Achievement) new Achievement("Achievement.GetPhosphoreDust", "GetPhosphoreDust", 0, 0, new ItemStack(PhosphoreDust), null).registerStat().initIndependentStat();
		CraftingPhosphoreBlock = (Achievement) new Achievement("Achievement.CraftingPhosphoreBlock", "CraftingPhosphoreBlock", 3, 0, PhosphoreBlock, GetPhosphoreDust).registerStat();
		CraftingLightBlueLampBlock = (Achievement) new Achievement("Achievement.CraftingLightBlueLampBlock", "CraftingLightBlueLampBlock", 2, 2, LightBlueLampBlock, CraftingPhosphoreBlock).registerStat();
		CraftingGreenLampBlock = (Achievement) new Achievement("Achievement.CraftingGreenLampBlock", "CraftingGreenLampBlock", 3, 2, GreenLampBlock, CraftingPhosphoreBlock).registerStat();
		CraftingRandomLamp = (Achievement) new Achievement("Achievement.CraftingRandomLamp", "CraftingRandomLamp", 4, 2, RandomLamp, CraftingPhosphoreBlock).registerStat();
		CraftingNyanLamp = (Achievement) new Achievement("Achievement.CraftingNyanLamp", "CraftingNyanLamp", 6, 0, NyanLamp, CraftingPhosphoreBlock).setSpecial().registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("MoreLight", new Achievement[]{GetPhosphoreDust, CraftingPhosphoreBlock, CraftingLightBlueLampBlock, CraftingGreenLampBlock, CraftingNyanLamp, CraftingRandomLamp}));
		
		//Check updates whit VersionChecker
		FMLInterModComms.sendRuntimeMessage(MoreLight.MODID, "VersionChecker", "addVersionCheck", "https://raw.githubusercontent.com/Azuxul/MoreLight/master/version.json");
		
	}
	private void RegistryRenderBlock(String blockName, Block block){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(MoreLight.MODID+":"+blockName, "inventory"));
		
	}
	
	private void RegistryRenderItem(String itemName, Item item){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MoreLight.MODID+ ":" +itemName, "inventory"));
		
	}
	
}
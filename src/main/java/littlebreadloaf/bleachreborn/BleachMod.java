package littlebreadloaf.bleachreborn;

import littlebreadloaf.bleachreborn.proxies.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import net.minecraft.potion.*;
import cpw.mods.fml.common.network.*;
import cpw.mods.fml.relauncher.*;
import littlebreadloaf.bleachreborn.network.*;
import littlebreadloaf.bleachreborn.items.*;
import littlebreadloaf.bleachreborn.blocks.*;
import cpw.mods.fml.common.registry.*;
import littlebreadloaf.bleachreborn.world.biomes.*;
import littlebreadloaf.bleachreborn.world.gen.NewOreGen;
import littlebreadloaf.bleachreborn.world.*;
import littlebreadloaf.bleachreborn.entities.*;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.gui.*;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.*;
import littlebreadloaf.bleachreborn.extras.*;
import net.minecraftforge.common.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.tiles.*;
import cpw.mods.fml.common.event.*;
import net.minecraft.server.*;
import littlebreadloaf.bleachreborn.commands.*;
import net.minecraft.client.Minecraft;
import net.minecraft.command.*;
import java.lang.reflect.*;

@Mod(modid = "bleachreborn", name = "Bleach Mod", version = "2.0.7")
public class BleachMod
{
    @SidedProxy(clientSide = "littlebreadloaf.bleachreborn.proxies.ClientProxy", serverSide = "littlebreadloaf.bleachreborn.proxies.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance("bleachreborn")
    public static BleachMod instance;
    public static SimpleNetworkWrapper network;
    private static int spiritpressurePotionID;
    public static Potion spiritpressure;
    public static int bleedingPotionID;
    public static Potion bleeding;
    
    public static int defenseRejectPotionID;
    public static Potion defenseReject;
    
    public static int soulDisconnectPotionID;
    public static Potion soulDisconnect;
    
    public static IWorldGenerator gen = new NewOreGen();
    
    @Mod.EventHandler
    public static void preInit(final FMLPreInitializationEvent event) {
        expandPotionTypesArray();
        BleachMod.network = NetworkRegistry.INSTANCE.newSimpleChannel("BleachChannel");
        BleachMod.proxy.loadMessages();
        PacketDispatcher.registerPackets();
        BleachItems.init();
        BleachItems.registerItems();
        BleachBlocks.init();
        BleachBlocks.registerBlocks();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        BleachMod.proxy.initRenderers();
        GameRegistry.registerWorldGenerator((IWorldGenerator)new BleachWorldGen(), 0);
        new BleachBiomes();
        DimensionManager.registerProviderType(BleachIds.worldHuecoMundoID, (Class)HuecoMundoWorldProvider.class, false);
        DimensionManager.registerDimension(BleachIds.worldHuecoMundoID, BleachIds.worldHuecoMundoID);
        DimensionManager.registerProviderType(BleachIds.worldSoulSocietyID, (Class)SoulSocietyWorldProvider.class, false);
        DimensionManager.registerDimension(BleachIds.worldSoulSocietyID, BleachIds.worldSoulSocietyID);
        BleachMod.spiritpressure = new PotionMagicEffect(BleachMod.spiritpressurePotionID, false, 16723714, 0).setPotionName("potion.spiritpressure");
        BleachMod.bleeding = new PotionMagicEffect(BleachMod.bleedingPotionID, false, 16723714, 1).setPotionName("potion.bleeding");
        BleachMod.soulDisconnect = new PotionMagicEffect(BleachMod.soulDisconnectPotionID, false, 16723714, 1).setPotionName("potion.soulDisconnect");
        BleachMod.defenseReject = new PotionMagicEffect(BleachMod.defenseRejectPotionID, false, 16723714, 1).setPotionName("potion.defenseReject");

    }
    
    @Mod.EventHandler
    public static void init(final FMLInitializationEvent event) {
        Entities.init();
        Armor.init();
        Armor.registerItems();
        new GuiHandler();
        FMLCommonHandler.instance().bus().register((Object)new BleachPlayerTickHandler());
        Recipes.init();
        GameRegistry.registerWorldGenerator((IWorldGenerator)new OreGenerator(), 0);
        MinecraftForge.EVENT_BUS.register((Object)new BleachEvents());
        BleachMod.proxy.loadKeys();
        GameRegistry.registerTileEntity((Class)TileSphereLamp.class, "TileSphereLamp");
        GameRegistry.registerTileEntity((Class)TileLantern.class, "TileLantern");
        GameRegistry.registerTileEntity((Class)TileSeeleSchneider.class, "TileSeeleschneider");
        BleachMod.proxy.initZanpakutoRenderers();
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            final Minecraft mc = FMLClientHandler.instance().getClient();
            MinecraftForge.EVENT_BUS.register((Object)new HealthHud(mc));
        }
        FMLCommonHandler.instance().bus().register((Object)new BleachTicks());
        GameRegistry.registerWorldGenerator(gen, 1);
    }
    
    @Mod.EventHandler
    public static void postInit(final FMLPostInitializationEvent event) {
        BleachMod.proxy.loadGUI();
    }
    
    @Mod.EventHandler
    public void serverStart(final FMLServerStartingEvent event) {
        final MinecraftServer server = MinecraftServer.getServer();
        final ICommandManager command = server.getCommandManager();
        final ServerCommandManager serverCommand = (ServerCommandManager)command;
        serverCommand.registerCommand((ICommand)new CommandAddSpirit());
        serverCommand.registerCommand((ICommand)new CommandResetSpirit());
        serverCommand.registerCommand((ICommand)new CommandResetType());
        serverCommand.registerCommand((ICommand)new CommandExpRate());
        serverCommand.registerCommand(new CommandAddSubPoints());
        serverCommand.registerCommand(new CommandAddKidoPoints());
        serverCommand.registerCommand((ICommand)new CommandSetSpirit());
        serverCommand.registerCommand((ICommand)new CommandSetType());
        serverCommand.registerCommand((ICommand)new CommandSpirit());
        serverCommand.registerCommand((ICommand)new CommandSetFaction());
        serverCommand.registerCommand((ICommand)new CommandToggle3D());
        serverCommand.registerCommand((ICommand)new CommandResetHollow());
        serverCommand.registerCommand(new CommandToggleHollow());
        serverCommand.registerCommand((ICommand)new CommandSetHollowKills());
        serverCommand.registerCommand(new CommandCheckSpirit());
        serverCommand.registerCommand(new CommandUnlockBankai());
        serverCommand.registerCommand(new CommandUnlockCap());
    }
    
    private static void expandPotionTypesArray() {
        Potion[] potionTypes = null;
        for (final Field f : Potion.class.getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
                    final Field modfield = Field.class.getDeclaredField("modifiers");
                    modfield.setAccessible(true);
                    modfield.setInt(f, f.getModifiers() & 0xFFFFFFEF);
                    potionTypes = (Potion[])f.get(null);
                    final Potion[] newPotionTypes = new Potion[63];
                    System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
                    f.set(null, newPotionTypes);
                }
            }
            catch (Exception e) {
                System.err.println("Something went very wrong! Error while expanding potion types array:");
                e.printStackTrace();
            }
        }
    }
    
    static {
        BleachMod.spiritpressurePotionID = 53;
        BleachMod.bleedingPotionID = 54;
        BleachMod.soulDisconnectPotionID = 55;
        BleachMod.defenseRejectPotionID = 56;
    }
}

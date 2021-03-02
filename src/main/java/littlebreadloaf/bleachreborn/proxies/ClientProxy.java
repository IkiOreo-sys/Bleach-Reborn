package littlebreadloaf.bleachreborn.proxies;

import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.render.models.armor.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.client.renderer.entity.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.player.*;
import littlebreadloaf.bleachreborn.render.entity.*;
import net.minecraftforge.common.*;
import net.minecraft.client.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraftforge.client.*;
import net.minecraft.client.renderer.tileentity.*;
import littlebreadloaf.bleachreborn.tiles.*;
import littlebreadloaf.bleachreborn.render.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.*;
import littlebreadloaf.bleachreborn.events.*;
import littlebreadloaf.bleachreborn.gui.*;
import littlebreadloaf.bleachreborn.extras.*;
import cpw.mods.fml.common.network.simpleimpl.*;

public class ClientProxy extends CommonProxy
{
    private static final ModelSoulChain chain;
    private static final ModelBiped robes;
    private static final ModelGolemMask golem;
    private static final ModelSnakeMask snake;
    private static final ModelWolfMask wolf;
    private static final ModelStalkerMask stalker;
    private static final ModelSkirt skirt;
    
    @Override
    public void initRenderers() {
        BleachIds.sphereLampRenderID = RenderingRegistry.getNextAvailableRenderId();
        BleachIds.lanternRenderingID = RenderingRegistry.getNextAvailableRenderId();
        BleachIds.seeleSchneiderRenderingID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityEnergyArrow.class, (Render)new RenderEnergyArrow());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntitySanreiArrow.class, (Render)new RenderSanreiArrow());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityHCArrow.class, (Render)new RenderHCArrow());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntitySeeleArrow.class, (Render)new RenderSeeleArrow());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityGetsuga.class, (Render)new RenderGetsuga());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityBlock.class, (Render)new RenderBlock());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityCero.class, (Render)new RenderCero());
        RenderingRegistry.registerEntityRenderingHandler((Class)EntityGlob.class, (Render)new RenderGlob(Items.slime_ball, 0));
        if(ConfigHandler.renderHollow)
            RenderingRegistry.registerEntityRenderingHandler((Class)EntityPlayer.class, (Render)new HollowRenderer());
        //RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderPH());
        Renders.renderEntities();
        MinecraftForge.EVENT_BUS.register((Object)new BleachSounds());
        MinecraftForge.EVENT_BUS.register((Object)new OverlaySpiritPressure(Minecraft.getMinecraft()));
    }
    
    @Override
    public void initZanpakutoRenderers() {
        MinecraftForgeClient.registerItemRenderer(BleachItems.zanpakuto, (IItemRenderer)new ZanpakutoRenderer());
        MinecraftForgeClient.registerItemRenderer(BleachItems.seele, (IItemRenderer)new SeeleSchneiderRenderer());
        MinecraftForgeClient.registerItemRenderer(BleachItems.hogyoku, (IItemRenderer)new RenderHogyoku());
        MinecraftForgeClient.registerItemRenderer(BleachItems.diablo, (IItemRenderer)new DiabloRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileSphereLamp.class, (TileEntitySpecialRenderer)new RenderSphereLamp());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileLantern.class, (TileEntitySpecialRenderer)new RenderLantern());
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileSeeleSchneider.class, (TileEntitySpecialRenderer)new SeeleSchneiderBlockRenderer());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderSphereLamp());
        RenderingRegistry.registerBlockHandler((ISimpleBlockRenderingHandler)new RenderLantern());
    }
    
    @Override
    public void loadParts() {
        FMLCommonHandler.instance().bus().register((Object)new BleachPlayerTickHandler());
    }
    
    @Override
    public int addArmor(final String string) {
        return RenderingRegistry.addNewArmourRendererPrefix(string);
    }
    
    @Override
    public void loadGUI() {
        MinecraftForge.EVENT_BUS.register((Object)new GuiSoulBar(Minecraft.getMinecraft()));
    }
    
    @Override
    public void loadKeys() {
        FMLCommonHandler.instance().bus().register((Object)new BleachKeyHandler());
    }
    
    @Override
    public ModelBiped getArmorModel(final int id) {
        switch (id) {
            case 0: {
                return ClientProxy.robes;
            }
            case 1: {
                return ClientProxy.golem;
            }
            case 2: {
                return ClientProxy.snake;
            }
            case 3: {
                return ClientProxy.wolf;
            }
            case 4: {
                return ClientProxy.stalker;
            }
            case 5: {
                return ClientProxy.skirt;
            }
            case 21: {
                return ClientProxy.chain;
            }
            default: {
                return ClientProxy.chain;
            }
        }
    }
    
    @Override
    public EntityPlayer getPlayerFromMessage(final MessageContext ctx) {
        return (EntityPlayer)Minecraft.getMinecraft().thePlayer;
    }
    
    static {
        chain = new ModelSoulChain(1.0f);
        robes = new ModelBiped(0.05f);
        golem = new ModelGolemMask(1.0f);
        snake = new ModelSnakeMask(1.0f);
        wolf = new ModelWolfMask(1.0f);
        stalker = new ModelStalkerMask(0.0f);
        skirt = new ModelSkirt(1.0f);
    }
}

package littlebreadloaf.bleachreborn.blocks;

import net.minecraft.block.*;
import littlebreadloaf.bleachreborn.*;
import net.minecraft.block.material.*;
import cpw.mods.fml.common.registry.*;

public class BleachBlocks
{
    public static Block reiatsuBlock;
    public static Block hollowBait;
    public static Block hollowBait2;
    public static Block regenBlock;
    public static Block maskOre;
    public static Block purpleGoo;
    public static Block reiatsuOre;
    public static Block sekkiseki;
    public static Block soulQuartzOre;
    public static Block soulQuartzBlock;
    public static Block soulQuartzLamp;
    public static Block whitesand;
    public static Block paperwall;
    public static Block paperdoor;
    public static Block hollowdiamond;
    public static Block hollowemerald;
    public static Block hollowgold;
    public static Block paperLamp;
    public static Block seeleSchneiderBlock;
    public static Block shikaiIceBlock;
    public static Block poisonShroom;
    public static Block adminBait;
    public static Block arrancarEssenceOre;
    
    public static void init() {
        BleachBlocks.reiatsuBlock = new BlockReiatsu().setBlockTextureName("bleachreiatsu_block");
        BleachBlocks.hollowBait = new BlockHollowBait().setBlockTextureName("bleachhollow_bait");
        BleachBlocks.hollowBait2 = new BlockHollowBait2().setBlockTextureName("bleachhollow_bait2");
        BleachBlocks.adminBait = new BlockAdminBait().setBlockTextureName("bleachadmin_bait");
        BleachBlocks.maskOre = new BlockMaskOre().setBlockTextureName("bleachmask_ore");
        BleachBlocks.purpleGoo = new BlockPurpleGoo().setBlockTextureName("bleachpurple_goo");
        BleachBlocks.reiatsuOre = new BlockReiatsuOre().setBlockTextureName("bleachreiatsu_ore");
        BleachBlocks.sekkiseki = new BlockSekkiseki(BleachIds.sekkisekiID).setBlockTextureName("bleachsekkiseki");
        BleachBlocks.soulQuartzOre = new BlockSoulQuartzOre().setBlockTextureName("bleachsoul_quartz_ore");
        BleachBlocks.soulQuartzBlock = new BlockSoulQuartzBlock().setBlockTextureName("bleachsoul_quartz_block");
        BleachBlocks.soulQuartzLamp = new BlockSoulQuartzLamp().setBlockTextureName("bleachsoul_quartz_lamp");
        BleachBlocks.whitesand = new BlockWhiteSand().setBlockTextureName("bleachwhite_sand");
        BleachBlocks.paperwall = new BlockPaperWall("paper_wall", "paper_wall", Material.wood, true).setHardness(5.0f).setResistance(10.0f).setBlockName("paper_wall").setBlockTextureName("bleachpaper_wall");
        BleachBlocks.hollowdiamond = new BlockHollowDiamond().setBlockTextureName("bleachhollow_diamond");
        BleachBlocks.hollowemerald = new BlockHollowEmerald().setBlockTextureName("bleachhollow_emerald");
        BleachBlocks.hollowgold = new BlockHollowGold().setBlockTextureName("bleachhollow_gold");
        BleachBlocks.paperLamp = new BlockLantern(Material.glass).setBlockTextureName("bleachlantern");
        BleachBlocks.seeleSchneiderBlock = new BlockSeeleSchneider(Material.iron);
        BleachBlocks.shikaiIceBlock = (Block)new BlockShikaiIce();
        BleachBlocks.poisonShroom = new BlockPoisonShroom();
        BleachBlocks.regenBlock = new BlockSpiritRegen().setBlockTextureName("bleachregen_block");
        BleachBlocks.arrancarEssenceOre = new BlockArrancarOre().setBlockName("arrancarOre").setBlockTextureName("bleachreborn" + ":arrancarore");
    }
    
    public static void registerBlocks() {
        GameRegistry.registerBlock(BleachBlocks.reiatsuBlock, "Reiatsu Block");
        GameRegistry.registerBlock(BleachBlocks.hollowBait, "Hollow Bait");
        GameRegistry.registerBlock(BleachBlocks.hollowBait2, "Hollow Bait 2");
        GameRegistry.registerBlock(BleachBlocks.adminBait, "Admin Bait");
        GameRegistry.registerBlock(BleachBlocks.maskOre, "Mask Ore");
        GameRegistry.registerBlock(BleachBlocks.purpleGoo, "Precipice Plasma");
        GameRegistry.registerBlock(BleachBlocks.reiatsuOre, "Reiatsu Ore");
        GameRegistry.registerBlock(BleachBlocks.sekkiseki, "Sekkiseki");
        GameRegistry.registerBlock(BleachBlocks.soulQuartzOre, "Soul Quartz Ore");
        GameRegistry.registerBlock(BleachBlocks.soulQuartzBlock, "Soul Quartz Block");
        GameRegistry.registerBlock(BleachBlocks.soulQuartzLamp, "Soul Quartz Lamp");
        GameRegistry.registerBlock(BleachBlocks.whitesand, "White Sand");
        GameRegistry.registerBlock(BleachBlocks.paperwall, "Paper Wall");
        GameRegistry.registerBlock(BleachBlocks.hollowdiamond, "Diamond Hollow Block");
        GameRegistry.registerBlock(BleachBlocks.hollowemerald, "Emerald Hollow Block");
        GameRegistry.registerBlock(BleachBlocks.hollowgold, "Gold Hollow Block");
        GameRegistry.registerBlock(BleachBlocks.paperLamp, "Paper Lantern");
        GameRegistry.registerBlock(BleachBlocks.seeleSchneiderBlock, "Seeleschneider Block");
        GameRegistry.registerBlock(BleachBlocks.shikaiIceBlock, "Temporary Ice Block");
        GameRegistry.registerBlock(BleachBlocks.poisonShroom, "Poison Mushroom");
        GameRegistry.registerBlock(BleachBlocks.regenBlock, "Spirit Regen Block");
        GameRegistry.registerBlock(BleachBlocks.arrancarEssenceOre, "Arrancar Essence Ore");
    }
}

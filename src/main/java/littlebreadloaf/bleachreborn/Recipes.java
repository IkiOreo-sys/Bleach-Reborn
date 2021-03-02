package littlebreadloaf.bleachreborn;

import littlebreadloaf.bleachreborn.blocks.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.items.*;
import cpw.mods.fml.common.registry.*;
import littlebreadloaf.bleachreborn.armor.*;
import net.minecraft.init.*;

public class Recipes
{
    public static void init() {
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.reiatsuBlock, 1), new Object[] { "***", "***", "***", '*', BleachItems.reiatsu });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu, 9), new Object[] { "*", '*', BleachBlocks.reiatsuBlock });
        GameRegistry.addRecipe(new ItemStack(BleachItems.shinai, 1), new Object[] { "*", "*", "#", '*', Items.reeds, '#', Items.stick });
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.hollowBait, 1), new Object[] { " * ", "*#*", " * ", '*', BleachBlocks.reiatsuBlock, '#', BleachItems.maskshard });
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.paperwall, 8), new Object[] { "*#*", "###", "*#*", '*', BleachItems.soulcloth, '#', Items.stick });
        GameRegistry.addRecipe(new ItemStack(BleachItems.soulcloth, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.reiatsu, '#', BleachBlocks.reiatsuBlock });
        GameRegistry.addRecipe(new ItemStack(BleachItems.zanpakuto, 1), new Object[] { "*", "*", "#", '*', BleachBlocks.reiatsuBlock, '#', BleachItems.soulsteel });
        GameRegistry.addRecipe(new ItemStack(BleachItems.seele, 1), new Object[] { "*", "#", "#", '*', BleachBlocks.reiatsuBlock, '#', BleachItems.soulsteel });
        GameRegistry.addRecipe(new ItemStack(Armor.HollowHelmet, 1), new Object[] { "***", "***", "***", '*', BleachItems.maskshard });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.BatHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.SpiderHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.BlazeHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.SnakeHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.GolemHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.WaspHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.StalkerHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 2), new Object[] { "*", '*', BleachItems.oremask });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', Armor.WolfHelmet });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 1), new Object[] { "*", '*', BleachItems.fishermask });
        GameRegistry.addRecipe(new ItemStack(BleachItems.maskshard, 3), new Object[] { "*", '*', BleachItems.menosmask });
        GameRegistry.addRecipe(new ItemStack(BleachItems.soulsteel, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.reiatsu, '#', Items.iron_ingot });
        GameRegistry.addRecipe(new ItemStack(BleachItems.quincypendant, 1, 0), new Object[] { " * ", "*#*", " * ", '*', BleachItems.soulsteel, '#', BleachBlocks.reiatsuBlock });
        final ItemStack quincyPendant = new ItemStack(BleachItems.quincypendant, 1, 0);
        GameRegistry.addRecipe(new ItemStack(BleachItems.quincypendant, 1, 1), new Object[] { "* *", " # ", "* *", '*', BleachItems.soulsteel, '#', quincyPendant.getItem() });
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.paperLamp, 2), new Object[] { "***", "&#&", "***", '&', BleachItems.soulcloth, '#', Blocks.torch, '*', Items.paper });
        GameRegistry.addShapelessRecipe(new ItemStack(BleachItems.hollowbook, 1), new Object[] { new ItemStack(BleachItems.maskshard), new ItemStack(Items.book) });
        GameRegistry.addRecipe(new ItemStack(Armor.ShiniRobe, 1), new Object[] { "* *", "***", "***", '*', BleachItems.soulcloth });
        GameRegistry.addRecipe(new ItemStack(Armor.ShiniPants, 1), new Object[] { "***", "* *", "* *", '*', BleachItems.soulcloth });
        GameRegistry.addRecipe(new ItemStack(Armor.Sandals, 1), new Object[] { "* *", "* *", '*', BleachItems.soulcloth });
        GameRegistry.addRecipe(new ItemStack(Armor.QuincyRobe, 1), new Object[] { "* *", "*#*", "*#*", '*', BleachItems.soulcloth, '#', Blocks.lapis_block });
        GameRegistry.addRecipe(new ItemStack(Armor.QuincyPants, 1), new Object[] { "###", "* *", "* *", '*', BleachItems.soulcloth, '#', Blocks.lapis_block });
        GameRegistry.addRecipe(new ItemStack(Armor.QuincyShoes, 1), new Object[] { "# #", "* *", '*', BleachItems.soulcloth, '#', Blocks.lapis_block });
        GameRegistry.addRecipe(new ItemStack(Armor.ArrancarJacket, 1), new Object[] { "* *", "*#*", "# #", '*', BleachItems.soulcloth, '#', BleachBlocks.soulQuartzBlock });
        GameRegistry.addRecipe(new ItemStack(Armor.ArrancarPants, 1), new Object[] { "###", "* *", "* *", '*', BleachItems.soulcloth, '#', BleachBlocks.soulQuartzBlock });
        GameRegistry.addRecipe(new ItemStack(Armor.ArrancarShoes, 1), new Object[] { "# #", "* *", '#', BleachItems.soulcloth, '*', BleachBlocks.soulQuartzBlock });
        GameRegistry.addRecipe(new ItemStack(BleachItems.refined_reiatsu, 1), new Object[] { "***", "*#*", "***", '*', BleachBlocks.reiatsuBlock, '#', Items.nether_star});
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill, 1), new Object[] { "*#%", "#^#", "%#*", '*', new ItemStack(Items.dye, 1, 4), '#', BleachItems.reiatsu, '^', BleachBlocks.reiatsuBlock, '%', Blocks.lapis_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill1, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.redstone, '#', BleachItems.reiatsu_pill, '^', BleachBlocks.reiatsuBlock, '%', Blocks.redstone_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill2, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.iron_ingot, '#', BleachItems.reiatsu_pill1, '^', BleachBlocks.reiatsuBlock, '%', Blocks.iron_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill3, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.gold_ingot, '#', BleachItems.reiatsu_pill2, '^', BleachBlocks.reiatsuBlock, '%', Blocks.gold_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill4, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.diamond, '#', BleachItems.reiatsu_pill3, '^', BleachBlocks.reiatsuBlock, '%', Blocks.diamond_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill5, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.emerald, '#', BleachItems.reiatsu_pill4, '^', BleachBlocks.reiatsuBlock, '%', Blocks.emerald_block });
        GameRegistry.addRecipe(new ItemStack(BleachItems.reiatsu_pill6, 1), new Object[] { "*#%", "#^#", "%#*", '*', Items.nether_star, '#', BleachItems.reiatsu_pill5, '^', BleachBlocks.reiatsuBlock, '%', BleachItems.refined_reiatsu });
        GameRegistry.addRecipe(new ItemStack(Armor.SoulChain, 1), new Object[] { "###", "#A#", " A ", '#', BleachItems.soulsteel, 'A', Blocks.iron_bars });
        GameRegistry.addRecipe(new ItemStack(BleachItems.hogyoku, 1), new Object[] { "###", "#%#", "###", '#', BleachItems.refined_reiatsu, '%', BleachItems.reiatsu_pill6});
        GameRegistry.addRecipe(new ItemStack(BleachItems.sanrei, 1), new Object[] { "#^#", "#%#", "###", '#', BleachItems.soulcloth, '^', BleachItems.refined_reiatsu, '%', new ItemStack(BleachItems.quincypendant, 1, 1)});
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.hollowBait2, 1), new Object[] { "*%*", "*#*", "***", '*', BleachItems.maskshard, '#', BleachBlocks.hollowBait, '%', BleachItems.refined_reiatsu});
        GameRegistry.addRecipe(new ItemStack(Armor.eyepatch, 1), new Object[] { "#**", "#%*", "*##", '#', BleachItems.soulcloth, '*', BleachBlocks.reiatsuBlock, '%', Items.ender_eye });
        GameRegistry.addRecipe(new ItemStack(BleachBlocks.regenBlock, 1), new Object[] { "*%*", "*#*", "***", '*', BleachBlocks.reiatsuBlock, '%', BleachItems.refined_reiatsu, '#', BleachItems.reiatsu_pill2 });
        GameRegistry.addRecipe(new ItemStack(Armor.HogyokuJacket, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.arrancaressence, '#', Armor.ShiniRobe });
        GameRegistry.addRecipe(new ItemStack(Armor.HogyokuPants, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.arrancaressence, '#', Armor.ShiniPants });
        GameRegistry.addRecipe(new ItemStack(Armor.HogyokuShoes, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.arrancaressence, '#', Armor.Sandals });
        GameRegistry.addRecipe(new ItemStack(Armor.HogyokuMask, 1), new Object[] { "***", "*#*", "***", '*', BleachItems.arrancaressence, '#', Armor.HollowHelmet  });
    }
}

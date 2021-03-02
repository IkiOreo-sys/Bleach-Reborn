package littlebreadloaf.bleachreborn.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import littlebreadloaf.bleachreborn.BleachMod;
import littlebreadloaf.bleachreborn.api.Tools;
import net.minecraft.item.Item;

public class Armor
{
    public static Item HollowHelmet;
    public static Item HogyokuMask;
    public static Item eyepatch;
    public static Item BatHelmet;
    public static Item SpiderHelmet;
    public static Item BlazeHelmet;
    public static Item SnakeHelmet;
    public static Item GolemHelmet;
    public static Item WaspHelmet;
    public static Item StalkerHelmet;
    public static Item WolfHelmet;
    public static Item ShiniRobe;
    public static Item ShiniPants;
    public static Item Sandals;
    public static Item QuincyRobe;
    public static Item QuincyPants;
    public static Item QuincyShoes;
    public static Item ArrancarJacket;
    public static Item ArrancarPants;
    public static Item ArrancarShoes;
    public static Item MaleAcademyTop;
    public static Item MaleAcademyBottom;
    public static Item FemaleAcademyTop;
    public static Item FemaleAcademyBottom;
    public static Item MaleSchoolTop;
    public static Item MaleSchoolBottom;
    public static Item FemaleSchoolTop;
    public static Item FemaleSchoolBottom;
    public static Item SoulChain;
    public static Item HogyokuJacket;
    public static Item HogyokuPants;
    public static Item HogyokuShoes;
    
    public static void init() {
        Armor.HollowHelmet = (Item)new ItemHollowHelmet(Tools.MASK, BleachMod.proxy.addArmor("hollow_helmet"), 0);
        Armor.HogyokuMask = new ItemHogyokuHelmet(Tools.MASK, BleachMod.proxy.addArmor("hogyoku_mask"), 0);
        Armor.BatHelmet = (Item)new ItemBatHelmet(Tools.MASK, BleachMod.proxy.addArmor("bat_helmet"), 0);
        Armor.SpiderHelmet = (Item)new ItemSpiderHelmet(Tools.MASK, BleachMod.proxy.addArmor("spider_helmet"), 0);
        Armor.BlazeHelmet = (Item)new ItemBlazeHelmet(Tools.MASK, BleachMod.proxy.addArmor("blaze_helmet"), 0);
        Armor.SnakeHelmet = (Item)new ItemSnakeHelmet(Tools.MASK, BleachMod.proxy.addArmor("snake_helmet"), 0);
        Armor.GolemHelmet = (Item)new ItemGolemHelmet(Tools.MASK, BleachMod.proxy.addArmor("golem_helmet"), 0);
        Armor.WaspHelmet = (Item)new ItemWaspHelmet(Tools.MASK, BleachMod.proxy.addArmor("wasp_helmet"), 0);
        Armor.StalkerHelmet = (Item)new ItemStalkerHelmet(Tools.MASK, BleachMod.proxy.addArmor("stalker_helmet"), 0);
        Armor.WolfHelmet = (Item)new ItemWolfHelmet(Tools.MASK, BleachMod.proxy.addArmor("wolf_helmet"), 0);
        Armor.ShiniRobe = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 1).setUnlocalizedName("shinirobe");
        Armor.ShiniPants = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 2).setUnlocalizedName("shinipants");
        Armor.Sandals = new ItemShinigamiRobes(Tools.SOULS, BleachMod.proxy.addArmor("shinigami"), 3).setUnlocalizedName("sandals");
        Armor.QuincyRobe = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 1).setUnlocalizedName("quincytop");
        Armor.QuincyPants = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 2).setUnlocalizedName("quincyslacks");
        Armor.QuincyShoes = new ItemQuincyRobes(Tools.SOULS, BleachMod.proxy.addArmor("quincy"), 3).setUnlocalizedName("quincyshoes");
        Armor.HogyokuJacket = new ItemHogyokuArmor(Tools.SOULS, BleachMod.proxy.addArmor("hogyoku"), 1).setUnlocalizedName("hogyokujacket");
        Armor.HogyokuPants = new ItemHogyokuArmor(Tools.SOULS, BleachMod.proxy.addArmor("hogyoku"), 2).setUnlocalizedName("hogyokupants");
        Armor.HogyokuShoes = new ItemHogyokuArmor(Tools.SOULS, BleachMod.proxy.addArmor("hogyoku"), 3).setUnlocalizedName("hogyokushoes");
        Armor.ArrancarJacket = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 1).setUnlocalizedName("arrancar_top");
        Armor.ArrancarPants = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 2).setUnlocalizedName("arrancar_pants");
        Armor.ArrancarShoes = new ItemArrancarArmor(Tools.SOULS, BleachMod.proxy.addArmor("arrancar"), 3).setUnlocalizedName("arrancar_shoes");
        Armor.MaleAcademyTop = new ItemMAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy"), 1).setUnlocalizedName("macademy_top");
        Armor.MaleAcademyBottom = new ItemMAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy"), 2).setUnlocalizedName("macademy_bottom");
        Armor.FemaleAcademyTop = new ItemFAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy2"), 1).setUnlocalizedName("facademy_top");
        Armor.FemaleAcademyBottom = new ItemFAcademyRobes(Tools.MASK, BleachMod.proxy.addArmor("academy2"), 2).setUnlocalizedName("facademy_bottom");
        Armor.MaleSchoolTop = new ItemMSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school"), 1).setUnlocalizedName("mschool_top");
        Armor.MaleSchoolBottom = new ItemMSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school"), 2).setUnlocalizedName("mschool_bottom");
        Armor.FemaleSchoolTop = new ItemFSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school2"), 1).setUnlocalizedName("fschool_top");
        Armor.FemaleSchoolBottom = new ItemFSchoolUniform(Tools.MASK, BleachMod.proxy.addArmor("school2"), 2).setUnlocalizedName("fschool_bottom");
        Armor.SoulChain = new ItemSoulChain(Tools.MASK, BleachMod.proxy.addArmor("chain"), 1).setUnlocalizedName("soul_chain");
        Armor.eyepatch = new ItemEyePatch(Tools.MASK, BleachMod.proxy.addArmor("eyepatch"), 0);
    }
    
    public static void registerItems() {
        GameRegistry.registerItem(Armor.HollowHelmet, "Hollow Mask");
        GameRegistry.registerItem(Armor.BatHelmet, "Bat Hollow Mask");
        GameRegistry.registerItem(Armor.SpiderHelmet, "Spider Hollow Mask");
        GameRegistry.registerItem(Armor.BlazeHelmet, "Blaze Hollow Mask");
        GameRegistry.registerItem(Armor.SnakeHelmet, "Snake Hollow Mask");
        GameRegistry.registerItem(Armor.GolemHelmet, "Golem Hollow Mask");
        GameRegistry.registerItem(Armor.WaspHelmet, "Wasp Hollow Mask");
        GameRegistry.registerItem(Armor.StalkerHelmet, "Stalker Hollow Mask");
        GameRegistry.registerItem(Armor.WolfHelmet, "Wolf Hollow Mask");
        GameRegistry.registerItem(Armor.ShiniRobe, "Shihakusho Top");
        GameRegistry.registerItem(Armor.ShiniPants, "Shihakusho Bottom");
        GameRegistry.registerItem(Armor.Sandals, "Sandals");
        GameRegistry.registerItem(Armor.QuincyRobe, "Quincy Tunic");
        GameRegistry.registerItem(Armor.QuincyPants, "Quincy Slacks");
        GameRegistry.registerItem(Armor.QuincyShoes, "Quincy Shoes");
        GameRegistry.registerItem(Armor.ArrancarJacket, "Arrancar Jacket");
        GameRegistry.registerItem(Armor.ArrancarPants, "Arrancar Pants");
        GameRegistry.registerItem(Armor.ArrancarShoes, "Arrancar Shoes");
        GameRegistry.registerItem(Armor.MaleAcademyTop, "Male Academy Top");
        GameRegistry.registerItem(Armor.MaleAcademyBottom, "Male Academy Bottom");
        GameRegistry.registerItem(Armor.FemaleAcademyTop, "Female Academy Top");
        GameRegistry.registerItem(Armor.FemaleAcademyBottom, "Female Academy Bottom");
        GameRegistry.registerItem(Armor.MaleSchoolTop, "Male School Top");
        GameRegistry.registerItem(Armor.MaleSchoolBottom, "Male School Bottom");
        GameRegistry.registerItem(Armor.FemaleSchoolTop, "Female School Top");
        GameRegistry.registerItem(Armor.FemaleSchoolBottom, "Female School Bottom");
        GameRegistry.registerItem(Armor.SoulChain, "Soul Chain");
        GameRegistry.registerItem(Armor.HogyokuMask, "Hogyoku Mask");
        GameRegistry.registerItem(Armor.HogyokuJacket, "Hogyoku Jacket");
        GameRegistry.registerItem(Armor.HogyokuPants, "Hogyoku Pants");
        GameRegistry.registerItem(Armor.HogyokuShoes, "Hogyoku Shoes");
        GameRegistry.registerItem(Armor.eyepatch, "Eyepatch");
    }
}

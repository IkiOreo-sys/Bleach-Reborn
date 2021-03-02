package littlebreadloaf.bleachreborn.api;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraftforge.common.util.*;

public class Tools
{
    public static Item.ToolMaterial SOUL;
    public static Item.ToolMaterial SHIKAI;
    public static Item.ToolMaterial BANKAI;
    public static Item.ToolMaterial SHINAI;
    public static ItemArmor.ArmorMaterial MASK;
    public static ItemArmor.ArmorMaterial SOULS;
    public static ItemArmor.ArmorMaterial QUINCY;
    public static EnumCreatureAttribute SPIRIT;
    
    static {
        Tools.SOUL = EnumHelper.addToolMaterial("Soul", 1, -1, 6.0f, 0.0f, 14);
        Tools.SHIKAI = EnumHelper.addToolMaterial("Shikai", 1, -1, 7.0f, 7.0f, 14);
        Tools.BANKAI = EnumHelper.addToolMaterial("Bankai", 1, -1, 7.0f, 12.0f, 14);
        Tools.SHINAI = EnumHelper.addToolMaterial("Shinai", 1, -1, 2.0f, 1.0f, 14);
        Tools.MASK = EnumHelper.addArmorMaterial("Mask", -1, new int[] { 0, 0, 0, 0 }, 0);
        Tools.SOULS = EnumHelper.addArmorMaterial("Souls", -1, new int[] { 0, 4, 2, 1 }, 0);
        Tools.QUINCY = EnumHelper.addArmorMaterial("Quincy", -1, new int[] { 0, 3, 1, 1 }, 0);
        Tools.SPIRIT = EnumHelper.addCreatureAttribute("Spirit");
    }
}

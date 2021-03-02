package littlebreadloaf.bleachreborn.items;

import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;

public class ItemBleachRecord extends ItemRecord
{
    IIcon[] icons;
    private static String[] ICON;
    
    public ItemBleachRecord(final String discName) {
        super(discName);
        this.setCreativeTab((CreativeTabs)null);
        this.maxStackSize = 1;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(final int par1) {
        return this.icons[par1];
    }
    
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal() {
        return StatCollector.translateToLocal("item.record." + this.recordName + ".desc");
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister icon) {
        this.icons = new IIcon[ItemBleachRecord.ICON.length];
        for (int i = 0; i < this.icons.length; ++i) {
            this.icons[i] = icon.registerIcon("bleachreborn".toLowerCase() + ItemBleachRecord.ICON[i]);
        }
    }
    
    public ResourceLocation getRecordResource(final String name) {
        return new ResourceLocation(name);
    }
    
    static {
        ItemBleachRecord.ICON = new String[] { ":asterisk", ":NumberOne", "Escalon" };
    }
}

package littlebreadloaf.bleachreborn.gui.hollow;

import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.client.entity.*;
import cpw.mods.fml.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.common.network.internal.*;

public class GuiHollowSelect extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 171;
    EntityPlayer thePlayer;
    ExtendedPlayer props;
    private int id;
    EntityClientPlayerMP player;
    
    public GuiHollowSelect(final EntityPlayer player) {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/hollow_select_gui.png");
        this.id = -1;
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.thePlayer = player;
        this.props = ExtendedPlayer.get(player);
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        final ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int var6 = var5.getScaledWidth();
        final int var7 = var5.getScaledHeight();
        final FontRenderer var8 = this.mc.fontRenderer;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 171) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, 256, 171);
        final String var9 = "Free Points: " + (this.player.capabilities.isCreativeMode ? "Inf." : Integer.valueOf(this.props.getCurrentHPoints()));
        final String var10 = "Hollow Evolution";
        var8.drawString(var9, (var6 - var8.getStringWidth(var9)) / 2, var7 / 2 + 70, 0);
        var8.drawString("Hollow Evolution", (var6 - var8.getStringWidth(var9)) / 2 + 1, var7 / 2 - 70, 0);
        var8.drawString("Hollow Evolution", (var6 - var8.getStringWidth(var9)) / 2 - 1, var7 / 2 - 70, 0);
        var8.drawString("Hollow Evolution", (var6 - var8.getStringWidth(var9)) / 2, var7 / 2 - 69, 0);
        var8.drawString("Hollow Evolution", (var6 - var8.getStringWidth(var9)) / 2, var7 / 2 - 71, 0);
        var8.drawString("Hollow Evolution", (var6 - var8.getStringWidth(var9)) / 2, var7 / 2 - 70, 1953999);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 171) / 2;
        if (this.props.getHead() == 0 || this.player.capabilities.isCreativeMode) {
            this.buttonList.add(new GuiButton(0, posX + 190, posY + 5, 50, 20, "Head"));
        }
        if (this.props.getBack() == 0 || this.player.capabilities.isCreativeMode) {
            this.buttonList.add(new GuiButton(1, posX + 15, posY + 15, 50, 20, "Torso"));
        }
        if (this.props.getArms() == 0 || this.player.capabilities.isCreativeMode) {
            this.buttonList.add(new GuiButton(2, posX + 200, posY + 55, 50, 20, "Arms"));
        }
        if (this.props.getTail() == 0 || this.player.capabilities.isCreativeMode) {
            this.buttonList.add(new GuiButton(3, posX + 10, posY + 60, 50, 20, "Tail"));
        }
        if (this.props.getLegs() == 0 || this.player.capabilities.isCreativeMode) {
            this.buttonList.add(new GuiButton(4, posX + 15, posY + 125, 50, 20, "Legs"));
        }
        this.buttonList.add(new GuiButton(5, posX + 190, posY + 130, 50, 20, "Color"));
    }
    
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 0: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 4, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
            case 1: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 5, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
            case 2: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 10, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
            case 3: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 7, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
            case 4: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 8, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
            case 5: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 9, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
}

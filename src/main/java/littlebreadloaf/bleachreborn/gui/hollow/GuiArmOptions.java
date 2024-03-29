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
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.common.network.internal.*;

public class GuiArmOptions extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 171;
    EntityPlayer thePlayer;
    ExtendedPlayer props;
    private int id;
    private int choice;
    String line1;
    String line2;
    String line3;
    int points;
    EntityClientPlayerMP player;
    
    public GuiArmOptions(final EntityPlayer player) {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/arm_select_gui.png");
        this.id = -1;
        this.choice = 1;
        this.points = 0;
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
        this.drawTexturedModalRect(posX + 140, posY + 10, 86 * (this.choice - 1) + 1, 172, 83, 83);
        final String var9 = "Costs 1 Point";
        if (this.choice == 1) {
            this.line1 = "Gives the player some";
            this.line2 = " buff arms. Increases";
            this.line3 = "  player knockback";
            this.points = 1;
        }
        if (this.choice == 2) {
            this.line1 = " Gives the player claw";
            this.line2 = "hands. Increases attack";
            this.line3 = "damage with empty hand.";
            this.points = 1;
        }
        if (this.choice == 3) {
            this.line1 = "  Gives the player 4";
            this.line2 = " arms, and a haste buff.";
            this.line3 = "Not fully implemented yet...";
            this.points = 1;
        }
        final String var10 = "Free Points: " + this.props.getCurrentHPoints();
        var8.drawString(var10, var6 / 2 - 117, var7 / 2 + 70, 0);
        var8.drawString(this.line1, var6 / 2 - 30, var7 / 2 + 15, 0);
        var8.drawString(this.line2, var6 / 2 - 30, var7 / 2 + 25, 0);
        var8.drawString(this.line3, var6 / 2 - 30, var7 / 2 + 35, 0);
        var8.drawString("Costs 1 Point", (this.width - 256) / 2 + 107, (this.height - 171) / 2 + 135, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 171) / 2;
        this.buttonList.add(new GuiButton(0, posX + 5, posY + 20, 80, 20, "Golem Arms"));
        this.buttonList.add(new GuiButton(1, posX + 5, posY + 70, 80, 20, "Claw Arms"));
        this.buttonList.add(new GuiButton(2, posX + 5, posY + 120, 80, 20, "Insect Arms"));
        this.buttonList.add(new GuiButton(3, posX + 110, posY + 145, 50, 20, "Accept"));
        this.buttonList.add(new GuiButton(4, posX + 200, posY + 145, 50, 20, "Cancel"));
    }
    
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 0: {
                this.choice = 1;
                break;
            }
            case 1: {
                this.choice = 2;
                break;
            }
            case 2: {
                this.choice = 3;
                break;
            }
            case 3: {
                if (ExtendedPlayer.get((EntityPlayer)this.player).getCurrentHPoints() >= this.points || this.player.capabilities.isCreativeMode) {
                    PacketDispatcher.sendToServer((IMessage)new HollowPieceMessage(2, this.choice, 1));
                    ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setArms(this.choice);
                }
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 4: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 3, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
}

package littlebreadloaf.bleachreborn.gui.hollow;

import java.util.*;
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

public class GuiColorSelect extends GuiScreen
{
    Random rand;
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 171;
    EntityPlayer thePlayer;
    ExtendedPlayer props;
    private int id;
    private int choice;
    private int choice2;
    String line1;
    String line2;
    String line3;
    public static final float[][] colorTable;
    EntityClientPlayerMP player;
    
    public GuiColorSelect(final EntityPlayer player) {
        this.rand = new Random();
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/color_select_gui.png");
        this.id = -1;
        this.choice = this.rand.nextInt(16);
        this.choice2 = this.rand.nextInt(16);
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.thePlayer = player;
        this.props = ExtendedPlayer.get(player);
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor3f(GuiColorSelect.colorTable[this.choice][0], GuiColorSelect.colorTable[this.choice][1], GuiColorSelect.colorTable[this.choice][2]);
        final ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
        final int var6 = var5.getScaledWidth();
        final int var7 = var5.getScaledHeight();
        final FontRenderer var8 = this.mc.fontRenderer;
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 171) / 2;
        this.drawTexturedModalRect(posX, posY, 0, 0, 256, 171);
        this.drawTexturedModalRect(posX + 140, posY + 10, 86 * (this.choice - 1) + 1, 172, 83, 83);
        String var9 = "";
        this.line1 = "Background color is your";
        this.line2 = "  Hollow's base color.";
        this.line3 = "Click Randomize to change.";
        var9 = "Costs 1 Point";
        final String var10 = "Free Points: " + this.props.getCurrentHPoints();
        var8.drawString(var10, var6 / 2 - 117, var7 / 2 + 70, 0);
        var8.drawString(this.line1, var6 / 2 - 20, var7 / 2 - 45, 0);
        var8.drawString(this.line2, var6 / 2 - 20, var7 / 2 - 35, 0);
        var8.drawString(this.line3, var6 / 2 - 20, var7 / 2 - 25, 0);
        var8.drawString(var9, (this.width - 256) / 2 + 107, (this.height - 171) / 2 + 135, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 171) / 2;
        this.buttonList.add(new GuiButton(0, posX + 5, posY + 60, 80, 20, "Randomize"));
        this.buttonList.add(new GuiButton(1, posX + 110, posY + 145, 50, 20, "Accept"));
        this.buttonList.add(new GuiButton(2, posX + 200, posY + 145, 50, 20, "Cancel"));
    }
    
    public void actionPerformed(final GuiButton button) {
        switch (button.id) {
            case 0: {
                this.choice = this.rand.nextInt(16);
                break;
            }
            case 1: {
                if (ExtendedPlayer.get((EntityPlayer)this.player).getCurrentHPoints() >= 1 || this.player.capabilities.isCreativeMode) {
                    PacketDispatcher.sendToServer((IMessage)new HollowPieceMessage(5, this.choice, 1));
                    ((ExtendedPlayer)this.thePlayer.getExtendedProperties("BleachPlayer")).setHColor(this.choice);
                }
                this.mc.displayGuiScreen((GuiScreen)null);
                break;
            }
            case 2: {
                this.mc.displayGuiScreen((GuiScreen)null);
                FMLNetworkHandler.openGui((EntityPlayer)this.player, (Object)BleachMod.instance, 3, this.player.worldObj, (int)this.player.posX, (int)this.player.posY, (int)this.player.posZ);
                break;
            }
        }
    }
    
    public boolean doesGuiPauseGame() {
        return true;
    }
    
    static {
        colorTable = new float[][] { { 1.0f, 1.0f, 1.0f }, { 0.85f, 0.5f, 0.2f }, { 0.7f, 0.3f, 0.85f }, { 0.4f, 0.6f, 0.85f }, { 0.9f, 0.9f, 0.2f }, { 0.5f, 0.8f, 0.1f }, { 0.95f, 0.5f, 0.65f }, { 0.3f, 0.3f, 0.3f }, { 0.6f, 0.6f, 0.6f }, { 0.3f, 0.5f, 0.6f }, { 0.5f, 0.25f, 0.7f }, { 0.2f, 0.3f, 0.7f }, { 0.4f, 0.3f, 0.2f }, { 0.4f, 0.5f, 0.2f }, { 0.6f, 0.2f, 0.2f }, { 0.1f, 0.1f, 0.1f } };
    }
}

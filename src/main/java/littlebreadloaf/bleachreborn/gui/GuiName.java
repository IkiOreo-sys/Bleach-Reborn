package littlebreadloaf.bleachreborn.gui;

import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import cpw.mods.fml.client.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.events.ExtendedPlayer;
import net.minecraft.util.*;

public class GuiName extends GuiScreen
{
    ResourceLocation texture;
    public final int xSizeOfTexture = 256;
    public final int ySizeOfTexture = 256;
    EntityPlayer thePlayer;
    private int id;
    private GuiTextField text;
    private String Code1;
    EntityClientPlayerMP player;
    
    public GuiName() {
        this.texture = new ResourceLocation("bleachreborn".toLowerCase(), "textures/guis/back.png");
        this.id = -1;
        this.player = FMLClientHandler.instance().getClient().thePlayer;
    }
    
    public void drawScreen(final int x, final int y, final float f) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.drawTexturedModalRect(posX, posY + 50, 0, 0, 256, 256);
        this.text.drawTextBox();
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        this.fontRendererObj.drawString(EnumChatFormatting.RED + "Name Your Zanpakuto", posX + 65, posY + 62, 0);
        super.drawScreen(x, y, f);
    }
    
    public void initGui() {
        final int posX = (this.width - 256) / 2;
        final int posY = (this.height - 256) / 2;
        this.buttonList.add(new GuiButton(0, posX + 100, posY + 150, 40, 20, "Submit"));
        (this.text = new GuiTextField(this.fontRendererObj, this.width / 2 - 76, this.height / 2 - 20, 137, 20)).setMaxStringLength(23);
        this.text.setText("");
        this.text.setFocused(true);
    }
    
    protected void keyTyped(final char par1, final int par2) {
        this.text.textboxKeyTyped(par1, par2);
        if (par2 != 18 || !this.text.isFocused()) {
            super.keyTyped(par1, par2);
        }
    }
    
    public void updateScreen() {
        super.updateScreen();
        this.text.updateCursorCounter();
    }
    
    protected void mouseClicked(final int x, final int y, final int btn) {
        super.mouseClicked(x, y, btn);
        this.text.mouseClicked(x, y, btn);
    }
    
    public void actionPerformed(final GuiButton button) {
        final ExtendedPlayer props = (ExtendedPlayer)this.mc.thePlayer.getExtendedProperties("BleachPlayer");
        switch (button.id) {
            case 0: {
                if ((player.getHeldItem().getDisplayName().equals("Zanpakuto"))) {
                	if (!this.text.getText().equals("")) {
                		player.getHeldItem().setStackDisplayName(this.text.getText());
                		player.inventoryContainer.detectAndSendChanges();
                        this.mc.displayGuiScreen((GuiScreen)null);
                		break;
                	}
                }
                this.player.addChatComponentMessage((IChatComponent)new ChatComponentText("Error: Your zanpakuto is already named."));
                break;
            }
        }
        super.actionPerformed(button);
    }
    
    public boolean doesGuiPauseGame() {
        return false;
    }
}

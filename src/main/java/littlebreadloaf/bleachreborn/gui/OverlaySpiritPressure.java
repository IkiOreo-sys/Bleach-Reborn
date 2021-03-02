package littlebreadloaf.bleachreborn.gui;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.event.*;
import cpw.mods.fml.common.eventhandler.*;

@SideOnly(Side.CLIENT)
public class OverlaySpiritPressure extends GuiScreen
{
    private Minecraft mc;
    
    public OverlaySpiritPressure(final Minecraft mc) {
        this.mc = mc;
    }
    
    public void renderFirstHud() {
        final int guiWidth = 256;
        final int guiHeight = 256;
        int guiLeft = 0;
        int guiTop = 0;
        final ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth);
        final int backX = sr.getScaledWidth();
        final int backY = sr.getScaledHeight();
        guiLeft = (backX - 256) / 2;
        guiTop = (backY - 256) / 2;
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)this.mc.thePlayer);
        if (props == null) {
            return;
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("bleachreborn", "textures/guis/pressure.png"));
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glPushMatrix();
        GL11.glScalef(70.0f, 70.0f, 70.0f);
        if (props.getAffected()) {
            this.drawTexturedModalRect(guiLeft - 500, guiTop - 400, 0, 0, 256, 256);
            this.drawTexturedModalRect(guiLeft - 300, guiTop - 300, 0, 0, 256, 256);
        }
        GL11.glPopMatrix();
        GL11.glDisable(3042);
    }
    
    @SubscribeEvent(receiveCanceled = true)
    public void onEvent(final RenderGameOverlayEvent.Pre event) {
        switch (event.type) {
            case HOTBAR: {
                this.renderFirstHud();
                break;
            }
        }
    }
}

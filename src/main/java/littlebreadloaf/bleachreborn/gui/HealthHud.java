package littlebreadloaf.bleachreborn.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraftforge.client.event.*;
import net.minecraft.block.material.*;
import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraftforge.client.*;
import net.minecraft.potion.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;

public class HealthHud extends Gui
{
    private Minecraft mc;
    protected final Random rand;
    
    public HealthHud(final Minecraft mc) {
        this.rand = new Random();
        this.mc = Minecraft.getMinecraft();
    }
    
    private void bind(final ResourceLocation res) {
        this.mc.getTextureManager().bindTexture(res);
    }
    
    @SubscribeEvent
    public void modifyAirHUD(final RenderGameOverlayEvent.Pre event) {
        if (event == null) {
            return;
        }
        if (event.type == null) {
            return;
        }
        if (event.type.equals((Object)RenderGameOverlayEvent.ElementType.AIR)) {
            event.setCanceled(true);
            this.mc.mcProfiler.startSection("air");
            final ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int width = res.getScaledWidth();
            final int height = res.getScaledHeight();
            final int left = width / 2 + 91;
            int top = height - 49;
            if (this.mc.thePlayer.isInsideOfMaterial(Material.water)) {
                final int level = ForgeHooks.getTotalArmorValue((EntityPlayer)this.mc.thePlayer);
                if (level > 0) {
                    top -= 9;
                }
                final int air = this.mc.thePlayer.getAir();
                for (int full = MathHelper.ceiling_double_int((air - 2) * 10.0 / 300.0), partial = MathHelper.ceiling_double_int(air * 10.0 / 300.0) - full, i = 0; i < full + partial; ++i) {
                    this.drawTexturedModalRect(left - i * 8 - 9, top, (i < full) ? 16 : 25, 18, 9, 9);
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    @SubscribeEvent
    public void modifyArmorHUD(final RenderGameOverlayEvent.Pre event) {
        if (event == null) {
            return;
        }
        if (event.type == null) {
            return;
        }
        if (event.type.equals((Object)RenderGameOverlayEvent.ElementType.ARMOR)) {
            GuiIngameForge.left_height += 10;
        }
    }
    
    @SubscribeEvent
    public void modifyHealthHUD(final RenderGameOverlayEvent.Pre evt) {
        if (evt == null) {
            return;
        }
        if (evt.type == null) {
            return;
        }
        if (evt.type.equals((Object)RenderGameOverlayEvent.ElementType.HEALTH)) {
            evt.setCanceled(true);
            this.mc.mcProfiler.startSection("health");
            boolean highlight = this.mc.thePlayer.hurtResistantTime / 3 % 2 == 1;
            if (this.mc.thePlayer.hurtResistantTime < 10) {
                highlight = false;
            }
            final ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
            final int width = res.getScaledWidth();
            final int height = res.getScaledHeight();
            final int health = MathHelper.ceiling_float_int(this.mc.thePlayer.getHealth());
            final int healthLast = MathHelper.ceiling_float_int(this.mc.thePlayer.prevHealth);
            final int left = width / 2 - 91;
            final int top = height - 39;
            final int colorX = left - 7;
            final int colorY = top + 1;
            int regen = -1;
            if (this.mc.thePlayer.isPotionActive(Potion.regeneration)) {
                regen = this.mc.ingameGUI.getUpdateCounter() % 25;
            }
            for (int row = (health - 1) / 20, i = row * 10; i < row * 10 + 10; ++i) {
                if ((i + 1) * 2 <= this.mc.thePlayer.getMaxHealth()) {
                    final int idx = i * 2 + 1;
                    int iconX = 16;
                    if (this.mc.thePlayer.isPotionActive(Potion.poison)) {
                        iconX += 36;
                    }
                    else if (this.mc.thePlayer.isPotionActive(Potion.wither)) {
                        iconX += 72;
                    }
                    final int x = left + i * 8 - 80 * row;
                    int y = top;
                    if (health <= 4) {
                        y = top + this.rand.nextInt(2);
                    }
                    if (i == regen) {
                        y -= 2;
                    }
                    byte iconY = 0;
                    if (this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled()) {
                        iconY = 5;
                    }
                    this.drawTexturedModalRect(x, y, 16 + (highlight ? 9 : 0), 9 * iconY, 9, 9);
                    if (highlight) {
                        if (idx < healthLast) {
                            this.drawTexturedModalRect(x, y, iconX + 54, 9 * iconY, 9, 9);
                        }
                        else if (idx == healthLast) {
                            this.drawTexturedModalRect(x, y, iconX + 63, 9 * iconY, 9, 9);
                        }
                    }
                    if (idx < health) {
                        this.drawTexturedModalRect(x, y, iconX + 36, 9 * iconY, 9, 9);
                    }
                    else if (idx == health) {
                        this.drawTexturedModalRect(x, y, iconX + 45, 9 * iconY, 9, 9);
                    }
                    final int displayedRow = row + 1;
                    String text = "" + displayedRow;
                    int adjustedColorX = colorX;
                    if (displayedRow >= 10) {
                        adjustedColorX -= 6;
                    }
                    if (displayedRow >= 100) {
                        adjustedColorX -= 6;
                    }
                    if (displayedRow >= 1000) {
                        adjustedColorX -= 6;
                    }
                    if (displayedRow >= 10000) {
                        text = "9999+";
                        adjustedColorX -= 6;
                    }
                    final FontRenderer fontrenderer = this.mc.fontRenderer;
                    fontrenderer.drawString(text, adjustedColorX + 1, colorY, 0);
                    fontrenderer.drawString(text, adjustedColorX - 1, colorY, 0);
                    fontrenderer.drawString(text, adjustedColorX, colorY + 1, 0);
                    fontrenderer.drawString(text, adjustedColorX, colorY - 1, 0);
                    fontrenderer.drawString(text, adjustedColorX, colorY, 15728640, false);
                    GL11.glColor4f(50.0f, 10.0f, 200.0f, 100.0f);
                    this.bind(Gui.icons);
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
}

package littlebreadloaf.bleachreborn.render;

import net.minecraftforge.client.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import org.lwjgl.opengl.*;

import littlebreadloaf.bleachreborn.render.models.ModelHogyoku;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderHogyoku implements IItemRenderer
{
    private ModelHogyoku t;
    
    public RenderHogyoku() {
        this.t = new ModelHogyoku();
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        switch (type) {
            case EQUIPPED:
                return true;
            case EQUIPPED_FIRST_PERSON:
                return true;
            case ENTITY:
                return true;
            default:
                return false;
        }
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return false;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        final Minecraft mc = Minecraft.getMinecraft();
        switch (type) {
            case EQUIPPED: {
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/hogyoku.png"));
                GL11.glScalef(0.4f, 0.4f, 0.4f);
                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-150.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-2.3f, -1.5f, -0.6f);
                this.t.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/hogyoku.png"));
                GL11.glScalef(0.5f, 0.5f, 0.5f);
                GL11.glRotatef(0.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-5.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-150.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-3.0f, -1.1f, -0.3f);
                this.t.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/hogyoku.png"));
                GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.3f, -0.3f, -0.1f);
                this.t.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
        }
    }
}

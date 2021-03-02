package littlebreadloaf.bleachreborn.render;

import org.lwjgl.opengl.GL11;

import littlebreadloaf.bleachreborn.render.models.ModelDiablo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class DiabloRenderer implements IItemRenderer
{
    private ModelDiablo t;
    
    public DiabloRenderer() {
        this.t = new ModelDiablo();
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
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/diablo.png"));
                GL11.glScalef(1.25f, 1.25f, 1.25f);
                GL11.glRotatef(-55.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-94.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-4.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(0.31f, 0.0f, -0.19f);
                this.t.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/diablo.png"));
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                GL11.glRotatef(10.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-3.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-100.0f, 0.0f, 0.0f, 1.0f);
                GL11.glTranslatef(-0.10f, -0.42f, -0.65f);
                this.t.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            }
            case ENTITY: {
                GL11.glPushMatrix();
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                mc.renderEngine.bindTexture(new ResourceLocation("bleachreborn:textures/models/diablo.png"));
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

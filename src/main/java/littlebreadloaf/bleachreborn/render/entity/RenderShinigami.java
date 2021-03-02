package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderShinigami extends RenderBiped
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    private static final ResourceLocation texture10;
    private static final ResourceLocation texture11;
    protected ModelBiped model;
    
    public RenderShinigami(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
        this.model = (ModelBiped)this.mainModel;
    }
    
    protected void renderEquippedItems(final EntityLiving par1EntityLiving, final float par2) {
        final ItemStack itemstack = par1EntityLiving.getHeldItem();
        if (ExtendedPlayer.getIs3D()) {
            final float f1 = 1.0f;
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            if (itemstack != null) {
                GL11.glPushMatrix();
                if (this.mainModel.isChild) {
                    final float f2 = 0.5f;
                    GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                    GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                    GL11.glScalef(0.5f, 0.5f, 0.5f);
                }
                this.modelBipedMain.bipedRightArm.postRender(0.0625f);
                final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
                final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (itemstack.getItem() == BleachItems.zanpakuto) {
                    final float f3 = 0.4f;
                    GL11.glScalef(0.4f, 0.4f, 0.4f);
                    GL11.glTranslatef(0.13f, -0.15f, -0.75f);
                    GL11.glRotatef(45.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
                    customRenderer.renderItem(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, new Object[0]);
                }
                GL11.glPopMatrix();
            }
        }
        else {
            final float f1 = 1.0f;
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            if (itemstack != null) {
                GL11.glPushMatrix();
                if (this.mainModel.isChild) {
                    final float f2 = 1.0f;
                    GL11.glTranslatef(0.0f, 0.625f, 0.0f);
                    GL11.glRotatef(-20.0f, -1.0f, 0.0f, 0.0f);
                    GL11.glScalef(1.0f, 1.0f, 1.0f);
                }
                this.modelBipedMain.bipedRightArm.postRender(0.0625f);
                if (itemstack.getItem() == BleachItems.zanpakuto) {
                    final float f2 = 0.725f;
                    GL11.glScalef(0.725f, 0.725f, 0.725f);
                    GL11.glTranslatef(-0.15f, 0.8f, 0.0f);
                    GL11.glRotatef(-129.0f, 14.2f, -9.0f, 9.0f);
                    GL11.glRotatef(-10.0f, 0.0f, 6.4f, -0.0f);
                    GL11.glRotated(33.0, 0.0, -178.0, -9.0);
                    GL11.glRotated(175.0, 0.0, -180.0, -12.0);
                    GL11.glRotatef(-26.0f, 0.0f, 0.0f, -0.0f);
                    this.renderManager.itemRenderer.renderItem((EntityLivingBase)par1EntityLiving, itemstack, 0);
                }
                GL11.glPopMatrix();
            }
        }
    }
    
    public void renderShinigami(final EntityShinigami par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderShinigami((EntityShinigami)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityShinigami)entity).getTexture()) {
            case 0: {
                return RenderShinigami.texture2;
            }
            case 1: {
                return RenderShinigami.texture3;
            }
            case 2: {
                return RenderShinigami.texture4;
            }
            case 3: {
                return RenderShinigami.texture5;
            }
            case 4: {
                return RenderShinigami.texture6;
            }
            case 5: {
                return RenderShinigami.texture7;
            }
            case 6: {
                return RenderShinigami.texture8;
            }
            case 7: {
                return RenderShinigami.texture9;
            }
            case 8: {
                return RenderShinigami.texture10;
            }
            case 9: {
                return RenderShinigami.texture11;
            }
            default: {
                return RenderShinigami.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami1.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami2.png");
        texture4 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami3.png");
        texture5 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami4.png");
        texture6 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami5.png");
        texture7 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami6.png");
        texture8 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami7.png");
        texture9 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami8.png");
        texture10 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami9.png");
        texture11 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/shinigami10.png");
    }
}

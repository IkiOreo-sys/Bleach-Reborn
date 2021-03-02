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

public class RenderAizen extends RenderBiped
{
    private static final ResourceLocation texture1;
    protected ModelBiped model;
    
    public RenderAizen(final ModelBiped par1ModelBiped, final float par2) {
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
    
    public void renderShinigami(final EntityAizen par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderShinigami((EntityAizen)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return texture1;
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/aizen.png");
    }
}

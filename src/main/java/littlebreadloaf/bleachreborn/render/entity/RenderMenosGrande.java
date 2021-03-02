package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.client.*;
import littlebreadloaf.bleachreborn.render.*;
import net.minecraft.entity.*;

public class RenderMenosGrande extends RenderLiving
{
    private static final ResourceLocation texture;
    protected ModelMenosGrande model;
    
    public RenderMenosGrande(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelMenosGrande)this.mainModel;
    }
    
    public void renderMenosGrande(final EntityMenosGrande entity, final double x, final double y, final double z, final float par5, final float par6) {
        super.doRender((EntityLiving)entity, x, y, z, par5, par6);
    }
    
    protected void func_110846_a(final EntityMenosGrande entity, final float x, final float y, final float z, final float par5, final float par6, final float par7) {
        this.bindEntityTexture((Entity)entity);
        if (!entity.isInvisible()) {
            this.mainModel.render((Entity)entity, x, y, z, par5, par6, par7);
        }
        else if (!entity.isInvisibleToPlayer((EntityPlayer)Minecraft.getMinecraft().thePlayer)) {
            GL11.glPushMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.15f);
            GL11.glDepthMask(false);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.003921569f);
            this.mainModel.render((Entity)entity, x, y, z, par5, par6, par7);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            GL11.glPopMatrix();
            GL11.glDepthMask(true);
        }
        else {
            this.mainModel.setRotationAngles(x, y, z, par5, par6, par7, (Entity)entity);
        }
        this.mainModel.setRotationAngles(x, y, z, par5, par6, par7, (Entity)entity);
        final int charging = 200 - entity.getChargingProgress();
        if (charging > 0) {
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("bleachreborn".toLowerCase() + ":/textures/blocks/cero.png"));
            RenderingHelper.drawCeroSphere(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ, 12.0f, 20, 20, entity);
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation("bleachreborn".toLowerCase() + ":/models/sphereLamp.png"));
        RenderingHelper.drawCeroSphere(entity.posX, entity.posY + entity.getEyeHeight(), entity.posZ, 12.0f, 20, 20, entity);
    }
    
    protected void renderModel(final EntityLivingBase entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.func_110846_a((EntityMenosGrande)entity, par2, par3, par4, par5, par6, par7);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderMenosGrande((EntityMenosGrande)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderMenosGrande.texture;
    }
    
    static {
        texture = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/menos.png");
    }
}

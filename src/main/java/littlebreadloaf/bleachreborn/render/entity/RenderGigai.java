package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderGigai extends RenderBiped
{
	
    protected ModelBiped model;
    
    public RenderGigai(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
        this.model = (ModelBiped)this.mainModel;
    }
    
    public void drawNameTag(final EntityLiving entityliving, final double par2, final double par4, final double par6) {
        if (Minecraft.isGuiEnabled() && entityliving instanceof EntityGigai) {
            final EntityGigai gigai = (EntityGigai)entityliving;
            if (gigai.isTamed() && gigai.getOwner() !=null) {
            	final String s = gigai.getOwner().getCommandSenderName().toString() + "'s Body";
                this.func_147906_a((Entity)gigai, s, par2, par4, par6, 64);
            }
        }
    }
    
    protected void renderName(final EntityGigai entitygigai, final EntityLivingBase entityliving, final double d, final double d1, final double d2) {
        final float var10 = entityliving.getDistanceToEntity((Entity)this.renderManager.livingPlayer);
        if (var10 <= 8.0f || ((EntityGigai)entityliving).isTamed()) {
            this.drawNameTag((EntityLiving)entitygigai, d, d1 - 2.2, d2);
        }
    }
    
    protected void passSpecialRender(final EntityLivingBase entityliving, final double d, final double d1, final double d2) {
        this.renderName((EntityGigai)entityliving, entityliving, d, d1 + entityliving.height / 2.0f, d2);
    }
    
    
    
    public void renderShinigami(final EntityGigai par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderShinigami((EntityGigai)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
    	return new ResourceLocation(((EntityGigai) entity).getTexture());
    }
}

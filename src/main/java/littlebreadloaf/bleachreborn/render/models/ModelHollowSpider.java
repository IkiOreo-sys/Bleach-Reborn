package littlebreadloaf.bleachreborn.render.models;

import cpw.mods.fml.relauncher.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class ModelHollowSpider extends ModelBase
{
    public ModelRenderer spiderHead;
    public ModelRenderer spiderNeck;
    public ModelRenderer spiderBody;
    public ModelRenderer spiderLeg1;
    public ModelRenderer spiderLeg2;
    public ModelRenderer spiderLeg3;
    public ModelRenderer spiderLeg4;
    public ModelRenderer spiderLeg5;
    public ModelRenderer spiderLeg6;
    public ModelRenderer spiderLeg7;
    public ModelRenderer spiderLeg8;
    
    public ModelHollowSpider() {
        final float f = 0.0f;
        final byte b0 = 15;
        (this.spiderHead = new ModelRenderer((ModelBase)this, 32, 4)).addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8, 0.0f);
        this.spiderHead.setRotationPoint(0.0f, 15.0f, -3.0f);
        (this.spiderNeck = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6, 0.0f);
        this.spiderNeck.setRotationPoint(0.0f, 15.0f, 0.0f);
        (this.spiderBody = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-5.0f, -4.0f, -6.0f, 10, 8, 12, 0.0f);
        this.spiderBody.setRotationPoint(0.0f, 15.0f, 9.0f);
        (this.spiderLeg1 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg1.setRotationPoint(-4.0f, 15.0f, 2.0f);
        (this.spiderLeg2 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg2.setRotationPoint(4.0f, 15.0f, 2.0f);
        (this.spiderLeg3 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg3.setRotationPoint(-4.0f, 15.0f, 1.0f);
        (this.spiderLeg4 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg4.setRotationPoint(4.0f, 15.0f, 1.0f);
        (this.spiderLeg5 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg5.setRotationPoint(-4.0f, 15.0f, 0.0f);
        (this.spiderLeg6 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg6.setRotationPoint(4.0f, 15.0f, 0.0f);
        (this.spiderLeg7 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-15.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg7.setRotationPoint(-4.0f, 15.0f, -1.0f);
        (this.spiderLeg8 = new ModelRenderer((ModelBase)this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 16, 2, 2, 0.0f);
        this.spiderLeg8.setRotationPoint(4.0f, 15.0f, -1.0f);
    }
    
    public void render(final Entity par1Entity, final float par2, final float par3, final float par4, final float par5, final float par6, final float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        this.spiderHead.render(par7);
        this.spiderNeck.render(par7);
        this.spiderBody.render(par7);
        this.spiderLeg1.render(par7);
        this.spiderLeg2.render(par7);
        this.spiderLeg3.render(par7);
        this.spiderLeg4.render(par7);
        this.spiderLeg5.render(par7);
        this.spiderLeg6.render(par7);
        this.spiderLeg7.render(par7);
        this.spiderLeg8.render(par7);
    }
    
    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final Entity par7Entity) {
        this.spiderHead.rotateAngleY = par4 / 57.295776f;
        this.spiderHead.rotateAngleX = par5 / 57.295776f;
        final float f6 = 0.7853982f;
        this.spiderLeg1.rotateAngleZ = -0.7853982f;
        this.spiderLeg2.rotateAngleZ = 0.7853982f;
        this.spiderLeg3.rotateAngleZ = -0.58119464f;
        this.spiderLeg4.rotateAngleZ = 0.58119464f;
        this.spiderLeg5.rotateAngleZ = -0.58119464f;
        this.spiderLeg6.rotateAngleZ = 0.58119464f;
        this.spiderLeg7.rotateAngleZ = -0.7853982f;
        this.spiderLeg8.rotateAngleZ = 0.7853982f;
        final float f7 = -0.0f;
        final float f8 = 0.3926991f;
        this.spiderLeg1.rotateAngleY = 0.7853982f;
        this.spiderLeg2.rotateAngleY = -0.7853982f;
        this.spiderLeg3.rotateAngleY = 0.3926991f;
        this.spiderLeg4.rotateAngleY = -0.3926991f;
        this.spiderLeg5.rotateAngleY = -0.3926991f;
        this.spiderLeg6.rotateAngleY = 0.3926991f;
        this.spiderLeg7.rotateAngleY = -0.7853982f;
        this.spiderLeg8.rotateAngleY = 0.7853982f;
        final float f9 = -(MathHelper.cos(par1 * 0.6662f * 2.0f + 0.0f) * 0.4f) * par2;
        final float f10 = -(MathHelper.cos(par1 * 0.6662f * 2.0f + 3.1415927f) * 0.4f) * par2;
        final float f11 = -(MathHelper.cos(par1 * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * par2;
        final float f12 = -(MathHelper.cos(par1 * 0.6662f * 2.0f + 4.712389f) * 0.4f) * par2;
        final float f13 = Math.abs(MathHelper.sin(par1 * 0.6662f + 0.0f) * 0.4f) * par2;
        final float f14 = Math.abs(MathHelper.sin(par1 * 0.6662f + 3.1415927f) * 0.4f) * par2;
        final float f15 = Math.abs(MathHelper.sin(par1 * 0.6662f + 1.5707964f) * 0.4f) * par2;
        final float f16 = Math.abs(MathHelper.sin(par1 * 0.6662f + 4.712389f) * 0.4f) * par2;
        final ModelRenderer spiderLeg17;
        final ModelRenderer spiderLeg1 = spiderLeg17 = this.spiderLeg1;
        spiderLeg17.rotateAngleY += f9;
        final ModelRenderer spiderLeg18;
        final ModelRenderer spiderLeg2 = spiderLeg18 = this.spiderLeg2;
        spiderLeg18.rotateAngleY += -f9;
        final ModelRenderer spiderLeg19;
        final ModelRenderer spiderLeg3 = spiderLeg19 = this.spiderLeg3;
        spiderLeg19.rotateAngleY += f10;
        final ModelRenderer spiderLeg20;
        final ModelRenderer spiderLeg4 = spiderLeg20 = this.spiderLeg4;
        spiderLeg20.rotateAngleY += -f10;
        final ModelRenderer spiderLeg21;
        final ModelRenderer spiderLeg5 = spiderLeg21 = this.spiderLeg5;
        spiderLeg21.rotateAngleY += f11;
        final ModelRenderer spiderLeg22;
        final ModelRenderer spiderLeg6 = spiderLeg22 = this.spiderLeg6;
        spiderLeg22.rotateAngleY += -f11;
        final ModelRenderer spiderLeg23;
        final ModelRenderer spiderLeg7 = spiderLeg23 = this.spiderLeg7;
        spiderLeg23.rotateAngleY += f12;
        final ModelRenderer spiderLeg24;
        final ModelRenderer spiderLeg8 = spiderLeg24 = this.spiderLeg8;
        spiderLeg24.rotateAngleY += -f12;
        final ModelRenderer spiderLeg25;
        final ModelRenderer spiderLeg9 = spiderLeg25 = this.spiderLeg1;
        spiderLeg25.rotateAngleZ += f13;
        final ModelRenderer spiderLeg26;
        final ModelRenderer spiderLeg10 = spiderLeg26 = this.spiderLeg2;
        spiderLeg26.rotateAngleZ += -f13;
        final ModelRenderer spiderLeg27;
        final ModelRenderer spiderLeg11 = spiderLeg27 = this.spiderLeg3;
        spiderLeg27.rotateAngleZ += f14;
        final ModelRenderer spiderLeg28;
        final ModelRenderer spiderLeg12 = spiderLeg28 = this.spiderLeg4;
        spiderLeg28.rotateAngleZ += -f14;
        final ModelRenderer spiderLeg29;
        final ModelRenderer spiderLeg13 = spiderLeg29 = this.spiderLeg5;
        spiderLeg29.rotateAngleZ += f15;
        final ModelRenderer spiderLeg30;
        final ModelRenderer spiderLeg14 = spiderLeg30 = this.spiderLeg6;
        spiderLeg30.rotateAngleZ += -f15;
        final ModelRenderer spiderLeg31;
        final ModelRenderer spiderLeg15 = spiderLeg31 = this.spiderLeg7;
        spiderLeg31.rotateAngleZ += f16;
        final ModelRenderer spiderLeg32;
        final ModelRenderer spiderLeg16 = spiderLeg32 = this.spiderLeg8;
        spiderLeg32.rotateAngleZ += -f16;
    }
}

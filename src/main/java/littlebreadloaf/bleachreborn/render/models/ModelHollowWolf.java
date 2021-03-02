package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.util.*;

public class ModelHollowWolf extends ModelBase
{
    ModelRenderer Body;
    ModelRenderer Mane;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer WolfHead;
    ModelRenderer Jaw;
    ModelRenderer Nose;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail4;
    ModelRenderer Tail3;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer upperleg_LF;
    ModelRenderer lower_leg_LF;
    ModelRenderer paw_LF;
    ModelRenderer upperleg_LB;
    ModelRenderer midleg_LB;
    ModelRenderer lower_leg_LB;
    ModelRenderer paw_LB;
    ModelRenderer upperleg_RF;
    ModelRenderer lower_leg_RF;
    ModelRenderer paw_RF;
    ModelRenderer upperleg_RB;
    ModelRenderer midleg_RB;
    ModelRenderer lower_leg_RB;
    ModelRenderer pawRB;
    
    public ModelHollowWolf() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Body = new ModelRenderer((ModelBase)this, 44, 21)).addBox(-4.0f, -3.0f, -2.0f, 8, 11, 8);
        this.Body.setRotationPoint(0.0f, 12.0f, 3.0f);
        this.Body.setTextureSize(128, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 1.37881f, 0.0f, 0.0f);
        (this.Mane = new ModelRenderer((ModelBase)this, 44, 0)).addBox(-6.0f, -5.0f, -3.0f, 12, 10, 11);
        this.Mane.setRotationPoint(0.0f, 13.0f, -3.0f);
        this.Mane.setTextureSize(128, 128);
        this.Mane.mirror = true;
        this.setRotation(this.Mane, 1.692969f, 0.0f, 0.0f);
        (this.Ear1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -5.0f, 1.0f, 2, 2, 1);
        this.Ear1.setRotationPoint(0.0f, 9.5f, -11.0f);
        this.Ear1.setTextureSize(128, 128);
        this.Ear1.mirror = true;
        this.setRotation(this.Ear1, 0.0f, 0.0f, 0.0f);
        (this.Ear2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(1.0f, -5.0f, 1.0f, 2, 2, 1);
        this.Ear2.setRotationPoint(0.0f, 9.5f, -11.0f);
        this.Ear2.setTextureSize(128, 128);
        this.Ear2.mirror = true;
        this.setRotation(this.Ear2, 0.0f, 0.0f, 0.0f);
        (this.WolfHead = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -3.0f, -3.0f, 8, 8, 6);
        this.WolfHead.setRotationPoint(0.0f, 9.5f, -11.0f);
        this.WolfHead.setTextureSize(128, 128);
        this.WolfHead.mirror = true;
        this.setRotation(this.WolfHead, 0.0f, 0.0f, 0.0f);
        (this.Jaw = new ModelRenderer((ModelBase)this, 28, 0)).addBox(-2.5f, 2.0f, -8.5f, 5, 3, 6);
        this.Jaw.setRotationPoint(0.0f, 9.5f, -11.0f);
        this.Jaw.setTextureSize(128, 128);
        this.Jaw.mirror = true;
        this.setRotation(this.Jaw, 0.0f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase)this, 0, 14)).addBox(-3.0f, 0.0f, -9.0f, 6, 4, 6);
        this.Nose.setRotationPoint(0.0f, 9.5f, -11.0f);
        this.Nose.setTextureSize(128, 128);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase)this, 0, 56)).addBox(-1.5f, 0.0f, -1.5f, 3, 3, 3);
        this.Tail1.setRotationPoint(0.0f, 9.0f, 11.0f);
        this.Tail1.setTextureSize(128, 128);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 1.130069f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase)this, 0, 62)).addBox(-2.0f, 3.0f, -2.0f, 4, 4, 4);
        this.Tail2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Tail2.setTextureSize(128, 128);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase)this, 0, 79)).addBox(-2.0f, 10.0f, -2.0f, 4, 4, 4);
        this.Tail4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Tail4.setTextureSize(128, 128);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-2.5f, 7.0f, -2.5f, 5, 4, 5);
        this.Tail3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Tail3.setTextureSize(128, 128);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase)this, 0, 87)).addBox(-1.5f, 14.0f, -1.5f, 3, 2, 3);
        this.Tail5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Tail5.setTextureSize(128, 128);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase)this, 0, 92)).addBox(-1.0f, 16.0f, -1.0f, 2, 2, 2);
        this.Tail6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Tail6.setTextureSize(128, 128);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 1.130069f, 0.0f, 0.0f);
        (this.upperleg_LF = new ModelRenderer((ModelBase)this, 0, 25)).addBox(-1.0f, -2.0f, -1.5f, 3, 8, 3);
        this.upperleg_LF.setRotationPoint(5.5f, 11.0f, -5.0f);
        this.upperleg_LF.setTextureSize(128, 128);
        this.upperleg_LF.mirror = true;
        this.setRotation(this.upperleg_LF, 0.0f, 0.0f, 0.0f);
        (this.lower_leg_LF = new ModelRenderer((ModelBase)this, 0, 36)).addBox(-0.5f, 4.0f, -0.5f, 2, 8, 2);
        this.lower_leg_LF.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.lower_leg_LF.setTextureSize(128, 128);
        this.lower_leg_LF.mirror = true;
        this.setRotation(this.lower_leg_LF, -0.2617994f, 0.0f, 0.0f);
        (this.paw_LF = new ModelRenderer((ModelBase)this, 8, 41)).addBox(-1.0f, 11.0f, -5.0f, 3, 2, 3);
        this.paw_LF.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.paw_LF.setTextureSize(128, 128);
        this.paw_LF.mirror = true;
        this.setRotation(this.paw_LF, 0.2617994f, 0.0f, 0.0f);
        (this.upperleg_LB = new ModelRenderer((ModelBase)this, 44, 42)).addBox(0.0f, -2.0f, -5.0f, 3, 4, 7);
        this.upperleg_LB.setRotationPoint(4.0f, 10.0f, 8.0f);
        this.upperleg_LB.setTextureSize(128, 128);
        this.upperleg_LB.mirror = true;
        this.setRotation(this.upperleg_LB, 0.7853982f, 0.0f, 0.0f);
        (this.midleg_LB = new ModelRenderer((ModelBase)this, 44, 53)).addBox(0.5f, 2.0f, -5.0f, 2, 7, 2);
        this.midleg_LB.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.midleg_LB.setTextureSize(128, 128);
        this.midleg_LB.mirror = true;
        this.setRotation(this.midleg_LB, -0.3490659f, 0.0f, 0.0f);
        (this.lower_leg_LB = new ModelRenderer((ModelBase)this, 52, 53)).addBox(-1.0f, 5.0f, -12.0f, 3, 3, 6);
        this.lower_leg_LB.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.lower_leg_LB.setTextureSize(128, 128);
        this.lower_leg_LB.mirror = true;
        this.setRotation(this.lower_leg_LB, 0.3490659f, 0.0f, 0.0f);
        (this.paw_LB = new ModelRenderer((ModelBase)this, 44, 62)).addBox(-0.5f, 12.0f, -7.0f, 4, 2, 5);
        this.paw_LB.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.paw_LB.setTextureSize(128, 128);
        this.paw_LB.mirror = true;
        this.setRotation(this.paw_LB, -0.7853982f, 0.0f, 0.0f);
        (this.upperleg_RF = new ModelRenderer((ModelBase)this, 0, 25)).addBox(-2.0f, -2.0f, -1.5f, 3, 8, 3);
        this.upperleg_RF.setRotationPoint(-5.5f, 11.0f, -5.0f);
        this.upperleg_RF.setTextureSize(128, 128);
        this.upperleg_RF.mirror = true;
        this.setRotation(this.upperleg_RF, 0.0f, 0.0f, 0.0f);
        (this.lower_leg_RF = new ModelRenderer((ModelBase)this, 0, 36)).addBox(-1.5f, 4.0f, -0.5f, 2, 8, 2);
        this.lower_leg_RF.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.lower_leg_RF.setTextureSize(128, 128);
        this.lower_leg_RF.mirror = true;
        this.setRotation(this.lower_leg_RF, -0.2617994f, 0.0f, 0.0f);
        (this.paw_RF = new ModelRenderer((ModelBase)this, 8, 41)).addBox(-2.0f, 11.0f, -5.0f, 3, 2, 3);
        this.paw_RF.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.paw_RF.setTextureSize(128, 128);
        this.paw_RF.mirror = true;
        this.setRotation(this.paw_RF, 0.2617994f, 0.0f, 0.0f);
        (this.upperleg_RB = new ModelRenderer((ModelBase)this, 44, 42)).addBox(-3.0f, -2.0f, -5.0f, 3, 4, 7);
        this.upperleg_RB.setRotationPoint(-4.0f, 10.0f, 8.0f);
        this.upperleg_RB.setTextureSize(128, 128);
        this.upperleg_RB.mirror = true;
        this.setRotation(this.upperleg_RB, 0.7853982f, 0.0f, 0.0f);
        (this.midleg_RB = new ModelRenderer((ModelBase)this, 44, 53)).addBox(-2.5f, 2.0f, -5.0f, 2, 7, 2);
        this.midleg_RB.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.midleg_RB.setTextureSize(128, 128);
        this.midleg_RB.mirror = true;
        this.setRotation(this.midleg_RB, -0.3490659f, 0.0f, 0.0f);
        (this.lower_leg_RB = new ModelRenderer((ModelBase)this, 52, 53)).addBox(-2.0f, 5.0f, -12.0f, 3, 3, 6);
        this.lower_leg_RB.setRotationPoint(-1.0f, 0.0f, 0.0f);
        this.lower_leg_RB.setTextureSize(128, 128);
        this.lower_leg_RB.mirror = true;
        this.setRotation(this.lower_leg_RB, 0.3490659f, 0.0f, 0.0f);
        (this.pawRB = new ModelRenderer((ModelBase)this, 44, 62)).addBox(-3.5f, 12.0f, -7.0f, 4, 2, 5);
        this.pawRB.setRotationPoint(1.0f, 0.0f, 0.0f);
        this.pawRB.setTextureSize(128, 128);
        this.pawRB.mirror = true;
        this.setRotation(this.pawRB, -0.7853982f, 0.0f, 0.0f);
        this.Tail1.addChild(this.Tail2);
        this.Tail2.addChild(this.Tail3);
        this.Tail3.addChild(this.Tail4);
        this.Tail4.addChild(this.Tail5);
        this.Tail5.addChild(this.Tail6);
        this.upperleg_LF.addChild(this.lower_leg_LF);
        this.upperleg_RF.addChild(this.lower_leg_RF);
        this.upperleg_LB.addChild(this.midleg_LB);
        this.upperleg_RB.addChild(this.midleg_RB);
        this.midleg_LB.addChild(this.lower_leg_LB);
        this.midleg_RB.addChild(this.lower_leg_RB);
        this.lower_leg_LF.addChild(this.paw_LF);
        this.lower_leg_RF.addChild(this.paw_RF);
        this.lower_leg_LB.addChild(this.paw_LB);
        this.lower_leg_RB.addChild(this.pawRB);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Body.render(f5);
        this.Mane.render(f5);
        this.Ear1.render(f5);
        this.Ear2.render(f5);
        this.WolfHead.render(f5);
        this.Jaw.render(f5);
        this.Nose.render(f5);
        this.Tail1.render(f5);
        this.upperleg_LF.render(f5);
        this.upperleg_LB.render(f5);
        this.upperleg_RF.render(f5);
        this.upperleg_RB.render(f5);
    }
    
    public void setLivingAnimations(final EntityLivingBase par1EntityLivingBase, final float par2, final float par3, final float par4) {
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final EntityHollowWolf wolf = (EntityHollowWolf)entity;
        if (entity.motionX == 0.0 && entity.motionZ == 0.0) {
            this.Tail1.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
            this.Tail2.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
            this.Tail3.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
            this.Tail4.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
            this.Tail5.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
            this.Tail6.rotateAngleZ = 0.05f * MathHelper.cos(f2 * 0.06662f);
        }
        else {
            this.Tail1.rotateAngleZ = 0.0f;
            this.Tail2.rotateAngleZ = 0.0f;
            this.Tail3.rotateAngleZ = 0.0f;
            this.Tail4.rotateAngleZ = 0.0f;
            this.Tail5.rotateAngleZ = 0.0f;
            this.Tail6.rotateAngleZ = 0.0f;
            this.Tail1.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1 + 1.130069f;
            this.Tail2.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1;
            this.Tail3.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1;
            this.Tail4.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1;
            this.Tail5.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1;
            this.Tail6.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.1f * f1;
            this.upperleg_LF.rotateAngleX = MathHelper.sin(f * 0.3662f + 1.0471976f) * 0.35f * f1;
            this.lower_leg_LF.rotateAngleX = MathHelper.sin(f * 0.3662f + 1.0471976f) * 0.35f * f1 - 0.2617994f;
            this.upperleg_RF.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.35f * f1;
            this.lower_leg_RF.rotateAngleX = MathHelper.sin(f * 0.3662f) * 0.35f * f1 - 0.2617994f;
            this.upperleg_LB.rotateAngleX = MathHelper.sin(f * 0.3662f + 2.0943952f) * 0.25f * f1 + 0.7853982f;
            this.upperleg_RB.rotateAngleX = MathHelper.sin(f * 0.3662f + 3.1415927f) * 0.25f * f1 + 0.7853982f;
            this.midleg_LB.rotateAngleX = MathHelper.sin(f * 0.3662f + 2.0943952f) * 0.25f * f1 - 0.3490659f;
            this.midleg_RB.rotateAngleX = MathHelper.sin(f * 0.3662f + 3.1415927f) * 0.25f * f1 - 0.3490659f;
            this.lower_leg_LB.rotateAngleX = MathHelper.sin(f * 0.3662f + 2.0943952f) * 0.15f * f1 + 0.3490659f;
            this.lower_leg_RB.rotateAngleX = MathHelper.sin(f * 0.3662f + 3.1415927f) * 0.15f * f1 + 0.3490659f;
        }
    }
}
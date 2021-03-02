package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelHollowSnake extends ModelBase
{
    ModelRenderer head_top;
    ModelRenderer mask;
    ModelRenderer bottom_jaw;
    ModelRenderer neck;
    ModelRenderer uppertorso;
    ModelRenderer lowertorso;
    ModelRenderer L_lower_arm;
    ModelRenderer L_upper_arm;
    ModelRenderer Lshoulder;
    ModelRenderer R_lower_arm;
    ModelRenderer R_upper_arm;
    ModelRenderer Rshoulder;
    ModelRenderer waist1;
    ModelRenderer waist2;
    ModelRenderer waist3;
    ModelRenderer waist4;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    
    public ModelHollowSnake() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.head_top = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-13.3f, -44.0f, 5.0f, 8, 8, 8);
        this.head_top.setRotationPoint(-3.0f, 17.0f, -12.0f);
        this.head_top.setTextureSize(128, 128);
        this.head_top.mirror = true;
        this.setRotation(this.head_top, 0.2617994f, 0.7679449f, 0.2600541f);
        (this.mask = new ModelRenderer((ModelBase)this, 0, 20)).addBox(-13.8f, -44.5f, 4.5f, 9, 9, 9);
        this.mask.setRotationPoint(-3.0f, 17.0f, -12.0f);
        this.mask.setTextureSize(128, 128);
        this.mask.mirror = true;
        this.setRotation(this.mask, 0.2617994f, 0.7679449f, 0.2600541f);
        (this.bottom_jaw = new ModelRenderer((ModelBase)this, 0, 39)).addBox(-2.5f, -39.0f, -7.0f, 5, 6, 9);
        this.bottom_jaw.setRotationPoint(0.0f, 17.0f, -5.0f);
        this.bottom_jaw.setTextureSize(128, 128);
        this.bottom_jaw.mirror = true;
        this.setRotation(this.bottom_jaw, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 48, 0)).addBox(-3.0f, -32.0f, 25.0f, 6, 11, 8);
        this.neck.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.neck.setTextureSize(128, 128);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.7853982f, 0.0f, 0.0f);
        (this.uppertorso = new ModelRenderer((ModelBase)this, 80, 0)).addBox(-6.0f, -30.0f, 13.0f, 12, 10, 12);
        this.uppertorso.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.uppertorso.setTextureSize(128, 128);
        this.uppertorso.mirror = true;
        this.setRotation(this.uppertorso, 0.4712389f, 0.0f, 0.0f);
        (this.lowertorso = new ModelRenderer((ModelBase)this, 43, 21)).addBox(-4.0f, -30.0f, -4.0f, 8, 17, 8);
        this.lowertorso.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.lowertorso.setTextureSize(128, 128);
        this.lowertorso.mirror = true;
        this.setRotation(this.lowertorso, -0.2617994f, 0.0f, 0.0f);
        (this.L_lower_arm = new ModelRenderer((ModelBase)this, 1, 68)).addBox(7.5f, -8.0f, 11.0f, 5, 5, 15);
        this.L_lower_arm.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.L_lower_arm.setTextureSize(128, 128);
        this.L_lower_arm.mirror = true;
        this.setRotation(this.L_lower_arm, 1.047198f, 0.0f, 0.0f);
        (this.L_upper_arm = new ModelRenderer((ModelBase)this, 0, 68)).addBox(8.0f, -31.0f, 6.0f, 4, 8, 4);
        this.L_upper_arm.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.L_upper_arm.setTextureSize(128, 128);
        this.L_upper_arm.mirror = true;
        this.setRotation(this.L_upper_arm, 0.0f, 0.0f, 0.0f);
        (this.Lshoulder = new ModelRenderer((ModelBase)this, 0, 54)).addBox(6.0f, -38.0f, 5.0f, 7, 7, 7);
        this.Lshoulder.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.Lshoulder.setTextureSize(128, 128);
        this.Lshoulder.mirror = true;
        this.setRotation(this.Lshoulder, 0.0f, 0.0f, 0.0f);
        (this.R_lower_arm = new ModelRenderer((ModelBase)this, 1, 102)).addBox(-12.5f, -8.0f, 11.0f, 5, 5, 15);
        this.R_lower_arm.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.R_lower_arm.setTextureSize(128, 128);
        this.R_lower_arm.mirror = true;
        this.setRotation(this.R_lower_arm, 1.047198f, 0.0f, 0.0f);
        (this.R_upper_arm = new ModelRenderer((ModelBase)this, 0, 102)).addBox(-12.0f, -31.0f, 6.0f, 4, 8, 4);
        this.R_upper_arm.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.R_upper_arm.setTextureSize(128, 128);
        this.R_upper_arm.mirror = true;
        this.setRotation(this.R_upper_arm, 0.0f, 0.0f, 0.0f);
        (this.Rshoulder = new ModelRenderer((ModelBase)this, 0, 88)).addBox(-13.0f, -38.0f, 5.0f, 7, 7, 7);
        this.Rshoulder.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.Rshoulder.setTextureSize(128, 128);
        this.Rshoulder.mirror = true;
        this.setRotation(this.Rshoulder, 0.0f, 0.0f, 0.0f);
        (this.waist1 = new ModelRenderer((ModelBase)this, 77, 25)).addBox(-5.5f, -11.0f, -13.0f, 11, 7, 11);
        this.waist1.setRotationPoint(0.0f, 17.0f, 3.0f);
        this.waist1.setTextureSize(128, 128);
        this.waist1.mirror = true;
        this.setRotation(this.waist1, -0.5235988f, 0.0f, 0.0f);
        (this.waist2 = new ModelRenderer((ModelBase)this, 47, 46)).addBox(-5.0f, -8.5f, -5.5f, 10, 8, 10);
        this.waist2.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.waist2.setTextureSize(128, 128);
        this.waist2.mirror = true;
        this.setRotation(this.waist2, -0.2617994f, 0.0f, 0.0f);
        (this.waist3 = new ModelRenderer((ModelBase)this, 87, 44)).addBox(-4.5f, -2.0f, -5.0f, 9, 3, 10);
        this.waist3.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.waist3.setTextureSize(128, 128);
        this.waist3.mirror = true;
        this.setRotation(this.waist3, 0.0f, 0.0f, 0.0f);
        (this.waist4 = new ModelRenderer((ModelBase)this, 41, 65)).addBox(-4.0f, -2.5f, -4.0f, 8, 8, 9);
        this.waist4.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.waist4.setTextureSize(128, 128);
        this.waist4.mirror = true;
        this.setRotation(this.waist4, 0.7853982f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 77, 65)).addBox(-3.5f, -5.0f, -2.0f, 7, 7, 10);
        this.tail1.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.tail1.setTextureSize(128, 128);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 77, 65)).addBox(-3.5f, -5.0f, 8.0f, 7, 7, 10);
        this.tail2.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.tail2.setTextureSize(128, 128);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 45, 83)).addBox(-3.0f, -4.0f, 18.0f, 6, 6, 10);
        this.tail3.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.tail3.setTextureSize(128, 128);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 0.0f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, 86, 82)).addBox(-2.0f, -2.0f, 28.0f, 4, 4, 8);
        this.tail4.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.tail4.setTextureSize(128, 128);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head_top.render(f5);
        this.mask.render(f5);
        this.bottom_jaw.render(f5);
        this.neck.render(f5);
        this.uppertorso.render(f5);
        this.lowertorso.render(f5);
        this.L_lower_arm.render(f5);
        this.L_upper_arm.render(f5);
        this.Lshoulder.render(f5);
        this.R_lower_arm.render(f5);
        this.R_upper_arm.render(f5);
        this.Rshoulder.render(f5);
        this.waist1.render(f5);
        this.waist2.render(f5);
        this.waist3.render(f5);
        this.waist4.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.R_upper_arm.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.23f;
        this.L_upper_arm.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.23f;
        this.R_lower_arm.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.23f + 1.0f;
        this.L_lower_arm.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.23f + 1.0f;
        this.Lshoulder.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.21f;
        this.Rshoulder.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.21f;
        this.uppertorso.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.17f + 0.4712389f;
        this.lowertorso.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.2f - 0.2617994f;
        this.waist1.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.2f - 0.5235988f;
        this.waist2.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.2f - 0.2617994f;
        this.neck.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.16f + 0.78f;
        this.bottom_jaw.rotateAngleX = -MathHelper.cos(f * 0.6662f) * 1.0f * f1 * 0.1f;
        this.head_top.rotateAngleX = -MathHelper.cos(f * 0.6662f) * f1 * 0.2f + 0.2617994f;
        this.mask.rotateAngleX = -MathHelper.cos(f * 0.6662f) * f1 * 0.2f + 0.2617994f;
        this.head_top.rotateAngleZ = -MathHelper.cos(f * 0.6662f) * f1 * 0.1f + 0.2617994f;
        this.mask.rotateAngleZ = -MathHelper.cos(f * 0.6662f) * f1 * 0.1f + 0.2617994f;
        this.tail1.rotateAngleY = MathHelper.cos(f * 0.6662f + 3.1415927f) * 0.1f * f1 * 0.5f;
        this.tail2.rotateAngleY = MathHelper.cos(f * 0.6662f + 3.1415927f) * 0.3f * f1 * 0.5f;
        this.tail3.rotateAngleY = MathHelper.cos(f * 0.6662f + 3.1415927f) * 0.5f * f1 * 0.5f;
        this.tail4.rotateAngleY = MathHelper.cos(f * 0.6662f + 3.1415927f) * 0.7f * f1 * 0.5f;
    }
}
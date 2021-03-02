package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelHollowWasp extends ModelBase
{
    ModelRenderer mainbody;
    ModelRenderer midsection;
    ModelRenderer stinger1;
    ModelRenderer neck;
    ModelRenderer legBL;
    ModelRenderer legML;
    ModelRenderer legFL;
    ModelRenderer legBR;
    ModelRenderer legMR;
    ModelRenderer legFR;
    ModelRenderer stinger;
    ModelRenderer stinger2;
    ModelRenderer stinger4;
    ModelRenderer Stinger3;
    ModelRenderer head;
    ModelRenderer mask;
    ModelRenderer mouth;
    ModelRenderer wingL;
    ModelRenderer wingR;
    private float rotatewings;
    private float rotatebody;
    private float rotatelegs;
    
    public ModelHollowWasp() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.mainbody = new ModelRenderer((ModelBase)this, 37, 0)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.mainbody.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.mainbody.setTextureSize(128, 64);
        this.mainbody.mirror = true;
        this.setRotation(this.mainbody, 0.0f, 0.0f, 0.0f);
        (this.midsection = new ModelRenderer((ModelBase)this, 61, 0)).addBox(-1.0f, -5.0f, 3.0f, 2, 2, 8);
        this.midsection.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.midsection.setTextureSize(128, 64);
        this.midsection.mirror = true;
        this.setRotation(this.midsection, -0.7853982f, 0.0f, 0.0f);
        (this.stinger1 = new ModelRenderer((ModelBase)this, 76, 0)).addBox(-2.0f, 8.0f, 5.0f, 4, 2, 4);
        this.stinger1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.stinger1.setTextureSize(128, 64);
        this.stinger1.mirror = true;
        this.setRotation(this.stinger1, 0.4363323f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.0f, -2.0f, -4.0f, 2, 2, 4);
        this.neck.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.neck.setTextureSize(128, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, 0.0f);
        (this.legBL = new ModelRenderer((ModelBase)this, 21, 28)).addBox(3.0f, -1.0f, 4.5f, 5, 1, 1);
        this.legBL.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legBL.setTextureSize(128, 64);
        this.legBL.mirror = true;
        this.setRotation(this.legBL, 0.0f, -0.2268928f, 0.6853982f);
        (this.legML = new ModelRenderer((ModelBase)this, 21, 28)).addBox(3.0f, -1.0f, 2.5f, 5, 1, 1);
        this.legML.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legML.setTextureSize(128, 64);
        this.legML.mirror = true;
        this.setRotation(this.legML, 0.0f, 0.0f, 0.7853982f);
        (this.legFL = new ModelRenderer((ModelBase)this, 21, 28)).addBox(3.0f, -1.0f, 0.5f, 5, 1, 1);
        this.legFL.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legFL.setTextureSize(128, 64);
        this.legFL.mirror = true;
        this.setRotation(this.legFL, 0.0f, 0.2268928f, 0.7853982f);
        (this.legBR = new ModelRenderer((ModelBase)this, 21, 26)).addBox(-8.0f, -1.0f, 4.5f, 5, 1, 1);
        this.legBR.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legBR.setTextureSize(128, 64);
        this.legBR.mirror = true;
        this.setRotation(this.legBR, 0.0f, 0.2268928f, -0.7853982f);
        (this.legMR = new ModelRenderer((ModelBase)this, 21, 26)).addBox(-8.0f, -1.0f, 2.5f, 5, 1, 1);
        this.legMR.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legMR.setTextureSize(128, 64);
        this.legMR.mirror = true;
        this.setRotation(this.legMR, 0.0f, 0.0f, -0.7853982f);
        (this.legFR = new ModelRenderer((ModelBase)this, 21, 26)).addBox(-8.0f, -1.0f, 0.5f, 5, 1, 1);
        this.legFR.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.legFR.setTextureSize(128, 64);
        this.legFR.mirror = true;
        this.setRotation(this.legFR, 0.0f, -0.2268928f, -0.7853982f);
        (this.stinger = new ModelRenderer((ModelBase)this, 68, 14)).addBox(-0.5f, 10.5f, 4.0f, 1, 1, 2);
        this.stinger.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.stinger.setTextureSize(128, 64);
        this.stinger.mirror = true;
        this.setRotation(this.stinger, 0.0f, 0.0f, 0.0f);
        (this.stinger2 = new ModelRenderer((ModelBase)this, 92, 0)).addBox(-2.5f, 8.0f, 6.5f, 5, 4, 5);
        this.stinger2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.stinger2.setTextureSize(128, 64);
        this.stinger2.mirror = true;
        this.setRotation(this.stinger2, 0.2617994f, 0.0f, 0.0f);
        (this.stinger4 = new ModelRenderer((ModelBase)this, 58, 14)).addBox(-1.0f, 11.0f, 4.0f, 2, 2, 2);
        this.stinger4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.stinger4.setTextureSize(128, 64);
        this.stinger4.mirror = true;
        this.setRotation(this.stinger4, 0.1745329f, 0.0f, 0.0f);
        (this.Stinger3 = new ModelRenderer((ModelBase)this, 39, 12)).addBox(-1.5f, 12.0f, -2.466667f, 3, 4, 6);
        this.Stinger3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Stinger3.setTextureSize(128, 64);
        this.Stinger3.mirror = true;
        this.setRotation(this.Stinger3, 0.7853982f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.5f, -2.0f, -2.0f, 5, 5, 4);
        this.head.setRotationPoint(0.0f, -1.0f, -5.0f);
        this.head.setTextureSize(128, 64);
        this.head.mirror = true;
        this.setRotation(this.head, -0.5235988f, 0.0f, 0.0f);
        (this.mask = new ModelRenderer((ModelBase)this, 0, 9)).addBox(-3.0f, -3.0f, -1.5f, 6, 6, 5);
        this.mask.setRotationPoint(0.0f, -1.0f, -6.0f);
        this.mask.setTextureSize(128, 64);
        this.mask.mirror = true;
        this.setRotation(this.mask, -0.5235988f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase)this, 0, 21)).addBox(-2.0f, 1.0f, -4.0f, 4, 3, 4);
        this.mouth.setRotationPoint(0.0f, -1.0f, -5.0f);
        this.mouth.setTextureSize(128, 64);
        this.mouth.mirror = true;
        this.setRotation(this.mouth, 0.1919862f, 0.0f, 0.0f);
        (this.wingL = new ModelRenderer((ModelBase)this, 21, 24)).addBox(0.0f, -11.0f, -1.0f, 0, 12, 8);
        this.wingL.setRotationPoint(2.0f, -3.0f, 1.0f);
        this.wingL.setTextureSize(128, 64);
        this.wingL.mirror = true;
        this.setRotation(this.wingL, 0.2617994f, 0.0f, 1.5235988f);
        (this.wingR = new ModelRenderer((ModelBase)this, 21, 36)).addBox(0.0f, -11.0f, -1.0f, 0, 12, 8);
        this.wingR.setRotationPoint(-2.0f, -3.0f, 1.0f);
        this.wingR.setTextureSize(128, 64);
        this.wingR.mirror = true;
        this.setRotation(this.wingR, 0.2617994f, 0.0f, -1.5235988f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.mainbody.render(f5);
        this.midsection.render(f5);
        this.stinger1.render(f5);
        this.neck.render(f5);
        this.legBL.render(f5);
        this.legML.render(f5);
        this.legFL.render(f5);
        this.legBR.render(f5);
        this.legMR.render(f5);
        this.legFR.render(f5);
        this.stinger.render(f5);
        this.stinger2.render(f5);
        this.stinger4.render(f5);
        this.Stinger3.render(f5);
        this.head.render(f5);
        this.mask.render(f5);
        this.mouth.render(f5);
        this.wingL.render(f5);
        this.wingR.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (this.wingR.rotateAngleZ > 0.1) {
            this.rotatewings = 0.17f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f);
        }
        else if (this.wingR.rotateAngleZ < -1.5) {
            this.rotatewings = -(0.17f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f));
        }
        final ModelRenderer wingR2;
        final ModelRenderer wingR = wingR2 = this.wingR;
        wingR2.rotateAngleZ -= this.rotatewings;
        this.wingL.rotateAngleZ = -this.wingR.rotateAngleZ;
        if (this.midsection.rotateAngleX > -0.8) {
            this.rotatebody = 7.0E-4f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f);
        }
        else if (this.midsection.rotateAngleX < -1.1) {
            this.rotatebody = -(7.0E-4f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f));
        }
        final ModelRenderer midsection2;
        final ModelRenderer midsection = midsection2 = this.midsection;
        midsection2.rotateAngleX -= 0.8f * this.rotatebody;
        final ModelRenderer stinger6;
        final ModelRenderer stinger = stinger6 = this.stinger;
        stinger6.rotateAngleX -= 0.6f * this.rotatebody;
        final ModelRenderer stinger7;
        final ModelRenderer stinger2 = stinger7 = this.stinger1;
        stinger7.rotateAngleX -= 0.6f * this.rotatebody;
        final ModelRenderer stinger8;
        final ModelRenderer stinger3 = stinger8 = this.stinger2;
        stinger8.rotateAngleX -= 0.6f * this.rotatebody;
        final ModelRenderer stinger9;
        final ModelRenderer stinger4 = stinger9 = this.Stinger3;
        stinger9.rotateAngleX -= 0.5f * this.rotatebody;
        final ModelRenderer stinger10;
        final ModelRenderer stinger5 = stinger10 = this.stinger4;
        stinger10.rotateAngleX -= 0.5f * this.rotatebody;
        final ModelRenderer mainbody2;
        final ModelRenderer mainbody = mainbody2 = this.mainbody;
        mainbody2.rotateAngleX -= 0.4f * this.rotatebody;
        if (this.legBL.rotateAngleX > -0.1) {
            this.rotatelegs = 9.0E-4f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f);
        }
        else if (this.legBL.rotateAngleX < -0.2) {
            this.rotatelegs = -(9.0E-4f * (MathHelper.cos(f1 * 1.3f) * 3.1415927f * 0.25f));
        }
        final ModelRenderer legBL3;
        final ModelRenderer legBL = legBL3 = this.legBL;
        legBL3.rotateAngleX -= 0.8f * this.rotatelegs;
        final ModelRenderer legBL4;
        final ModelRenderer legBL2 = legBL4 = this.legBL;
        legBL4.rotateAngleZ += 0.7f * this.rotatelegs;
        final ModelRenderer legBR3;
        final ModelRenderer legBR = legBR3 = this.legBR;
        legBR3.rotateAngleX += 0.8f * this.rotatelegs;
        final ModelRenderer legBR4;
        final ModelRenderer legBR2 = legBR4 = this.legBR;
        legBR4.rotateAngleZ -= 0.7f * this.rotatelegs;
        final ModelRenderer legML3;
        final ModelRenderer legML = legML3 = this.legML;
        legML3.rotateAngleX += 0.5f * this.rotatelegs;
        final ModelRenderer legML4;
        final ModelRenderer legML2 = legML4 = this.legML;
        legML4.rotateAngleZ -= 0.4f * this.rotatelegs;
        final ModelRenderer legMR3;
        final ModelRenderer legMR = legMR3 = this.legMR;
        legMR3.rotateAngleX -= 0.5f * this.rotatelegs;
        final ModelRenderer legMR4;
        final ModelRenderer legMR2 = legMR4 = this.legMR;
        legMR4.rotateAngleZ += 0.4f * this.rotatelegs;
        final ModelRenderer legFL3;
        final ModelRenderer legFL = legFL3 = this.legFL;
        legFL3.rotateAngleX -= 0.6f * this.rotatelegs;
        final ModelRenderer legFL4;
        final ModelRenderer legFL2 = legFL4 = this.legFL;
        legFL4.rotateAngleZ += 0.7f * this.rotatelegs;
        final ModelRenderer legFR3;
        final ModelRenderer legFR = legFR3 = this.legFR;
        legFR3.rotateAngleX += 0.6f * this.rotatelegs;
        final ModelRenderer legFR4;
        final ModelRenderer legFR2 = legFR4 = this.legFR;
        legFR4.rotateAngleZ -= 0.7f * this.rotatelegs;
    }
}

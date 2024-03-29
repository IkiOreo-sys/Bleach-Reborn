package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelMenosGrande extends ModelBase
{
    ModelRenderer head;
    ModelRenderer nose1;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer rightleg;
    ModelRenderer righttoe1;
    ModelRenderer righttoe2;
    ModelRenderer leftleg;
    ModelRenderer lefttoe1;
    ModelRenderer lefttoe2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer face1;
    ModelRenderer face2;
    ModelRenderer face3;
    ModelRenderer face4;
    ModelRenderer nose2;
    ModelRenderer body5;
    ModelRenderer spike1;
    ModelRenderer body6;
    ModelRenderer lefthand;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer spike6;
    ModelRenderer spike7;
    ModelRenderer spike8;
    ModelRenderer spike9;
    ModelRenderer spike10;
    ModelRenderer spike11;
    ModelRenderer spike12;
    ModelRenderer spike13;
    ModelRenderer spike14;
    ModelRenderer body7;
    ModelRenderer leftarm1;
    ModelRenderer rightarm1;
    ModelRenderer leftarm2;
    ModelRenderer righthand;
    ModelRenderer rightarm2;
    ModelRenderer body8;
    
    public ModelMenosGrande() {
        this.textureWidth = 256;
        this.textureHeight = 512;
        (this.head = new ModelRenderer((ModelBase)this, 159, 90)).addBox(-12.0f, -26.0f, -10.0f, 24, 26, 24);
        this.head.setRotationPoint(0.0f, -265.0f, -7.0f);
        this.head.setTextureSize(256, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.nose1 = new ModelRenderer((ModelBase)this, 223, 68)).addBox(-1.0f, -3.0f, -40.0f, 2, 2, 15);
        this.nose1.setRotationPoint(0.0f, -265.0f, -7.0f);
        this.nose1.setTextureSize(256, 512);
        this.nose1.mirror = true;
        this.setRotation(this.nose1, -0.0523599f, 0.0f, 0.0f);
        (this.body1 = new ModelRenderer((ModelBase)this, 0, 44)).addBox(-13.0f, 0.0f, -1.0f, 26, 16, 22);
        this.body1.setRotationPoint(0.0f, -265.0f, -15.0f);
        this.body1.setTextureSize(256, 512);
        this.body1.mirror = true;
        this.setRotation(this.body1, 0.1396263f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase)this, 0, 82)).addBox(-15.0f, 0.0f, 0.0f, 30, 32, 26);
        this.body2.setRotationPoint(0.0f, -250.0f, -16.0f);
        this.body2.setTextureSize(256, 512);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.1047198f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 191, 143)).addBox(-8.0f, 0.0f, -8.0f, 16, 36, 16);
        this.rightleg.setRotationPoint(-16.0f, -12.0f, 0.0f);
        this.rightleg.setTextureSize(256, 512);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.righttoe1 = new ModelRenderer((ModelBase)this, 191, 197)).addBox(-8.0f, 32.0f, -18.0f, 14, 10, 10);
        this.righttoe1.setRotationPoint(-15.0f, -18.0f, 0.0f);
        this.righttoe1.setTextureSize(256, 512);
        this.righttoe1.mirror = true;
        this.setRotation(this.righttoe1, 0.0f, 0.0f, 0.0f);
        (this.righttoe2 = new ModelRenderer((ModelBase)this, 149, 143)).addBox(-1.5f, 36.5f, -25.0f, 5, 5, 15);
        this.righttoe2.setRotationPoint(-17.0f, -18.0f, 0.0f);
        this.righttoe2.setTextureSize(256, 512);
        this.righttoe2.mirror = true;
        this.setRotation(this.righttoe2, -0.2443461f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 191, 143)).addBox(-8.0f, 0.0f, -2.0f, 16, 36, 16);
        this.leftleg.setRotationPoint(16.0f, -12.0f, -6.0f);
        this.leftleg.setTextureSize(256, 512);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.lefttoe1 = new ModelRenderer((ModelBase)this, 191, 197)).addBox(-6.5f, 26.0f, -12.0f, 14, 10, 10);
        this.lefttoe1.setRotationPoint(16.0f, -12.0f, -6.0f);
        this.lefttoe1.setTextureSize(256, 512);
        this.lefttoe1.mirror = true;
        this.setRotation(this.lefttoe1, 0.0f, 0.0f, 0.0f);
        (this.lefttoe2 = new ModelRenderer((ModelBase)this, 149, 143)).addBox(0.5f, 36.5f, -25.0f, 5, 5, 15);
        this.lefttoe2.setRotationPoint(13.0f, -18.0f, 0.0f);
        this.lefttoe2.setTextureSize(256, 512);
        this.lefttoe2.mirror = true;
        this.setRotation(this.lefttoe2, -0.2443461f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase)this, 0, 363)).addBox(-27.0f, 0.0f, 0.0f, 54, 108, 41);
        this.body3.setRotationPoint(0.0f, -108.0f, -15.0f);
        this.body3.setTextureSize(256, 512);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.0f, 0.0f, 0.0f);
        (this.body4 = new ModelRenderer((ModelBase)this, 79, 214)).addBox(9.0f, 42.0f, 0.0f, 9, 20, 30);
        this.body4.setRotationPoint(0.0f, -231.0f, -15.0f);
        this.body4.setTextureSize(256, 512);
        this.body4.mirror = true;
        this.setRotation(this.body4, 0.0523599f, 0.0f, 0.0f);
        (this.face1 = new ModelRenderer((ModelBase)this, 134, 0)).addBox(-3.7f, -27.5f, -12.0f, 15, 26, 3);
        this.face1.setRotationPoint(0.0f, -264.0f, -9.0f);
        this.face1.setTextureSize(256, 512);
        this.face1.mirror = true;
        this.setRotation(this.face1, 0.0f, -0.2974216f, 0.0f);
        (this.face2 = new ModelRenderer((ModelBase)this, 125, 30)).addBox(-8.3f, -0.5f, -12.0f, 12, 13, 3);
        this.face2.setRotationPoint(0.0f, -265.0f, -9.0f);
        this.face2.setTextureSize(256, 512);
        this.face2.mirror = true;
        this.setRotation(this.face2, -0.1784573f, 0.2974289f, -0.0610865f);
        (this.face3 = new ModelRenderer((ModelBase)this, 119, 0)).addBox(-11.3f, -27.5f, -12.0f, 15, 26, 3);
        this.face3.setRotationPoint(0.0f, -264.0f, -9.0f);
        this.face3.setTextureSize(256, 512);
        this.face3.mirror = true;
        this.setRotation(this.face3, 0.0f, 0.2974289f, 0.0f);
        (this.face4 = new ModelRenderer((ModelBase)this, 140, 30)).addBox(-3.7f, -0.5f, -12.0f, 12, 13, 3);
        this.face4.setRotationPoint(0.0f, -265.0f, -9.0f);
        this.face4.setTextureSize(256, 512);
        this.face4.mirror = true;
        this.setRotation(this.face4, -0.1784573f, -0.2974216f, 0.0610865f);
        (this.nose2 = new ModelRenderer((ModelBase)this, 219, 48)).addBox(-2.0f, -5.0f, -28.0f, 4, 4, 15);
        this.nose2.setRotationPoint(0.0f, -265.0f, -7.0f);
        this.nose2.setTextureSize(256, 512);
        this.nose2.mirror = true;
        this.setRotation(this.nose2, 0.0f, 0.0f, 0.0f);
        (this.body5 = new ModelRenderer((ModelBase)this, 0, 214)).addBox(-18.0f, 42.0f, 0.0f, 9, 20, 30);
        this.body5.setRotationPoint(0.0f, -231.0f, -15.0f);
        this.body5.setTextureSize(256, 512);
        this.body5.mirror = true;
        this.setRotation(this.body5, 0.0523599f, 0.0f, 0.0f);
        (this.spike1 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike1.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike1.setTextureSize(256, 512);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, -0.2936867f, -1.155811f, 0.0f);
        (this.body6 = new ModelRenderer((ModelBase)this, 0, 264)).addBox(-21.0f, 0.0f, 0.0f, 42, 70, 36);
        this.body6.setRotationPoint(0.0f, -170.0f, -15.0f);
        this.body6.setTextureSize(256, 512);
        this.body6.mirror = true;
        this.setRotation(this.body6, 0.0349066f, 0.0f, 0.0f);
        (this.lefthand = new ModelRenderer((ModelBase)this, 146, 169)).addBox(-3.0f, 92.0f, -6.0f, 6, 22, 14);
        this.lefthand.setRotationPoint(12.0f, -215.2133f, 25.49333f);
        this.lefthand.setTextureSize(256, 512);
        this.lefthand.mirror = true;
        this.setRotation(this.lefthand, -0.1828788f, 0.0297429f, -0.31415927f);
        (this.spike2 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -26.0f, 2, 2, 15);
        this.spike2.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike2.setTextureSize(256, 512);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, -0.1745329f, -0.62831855f, 0.0f);
        (this.spike3 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, 13.0f, -26.0f, 2, 2, 15);
        this.spike3.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike3.setTextureSize(256, 512);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, -0.1919862f, 0.1745329f, 0.0f);
        (this.spike4 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-5.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike4.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike4.setTextureSize(256, 512);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, -0.2094395f, 0.6108652f, 0.0f);
        (this.spike5 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike5.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike5.setTextureSize(256, 512);
        this.spike5.mirror = true;
        this.setRotation(this.spike5, -0.2268928f, 1.2566371f, 0.0f);
        (this.spike6 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike6.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike6.setTextureSize(256, 512);
        this.spike6.mirror = true;
        this.setRotation(this.spike6, -0.1919862f, 1.675516f, 0.0f);
        (this.spike7 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike7.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike7.setTextureSize(256, 512);
        this.spike7.mirror = true;
        this.setRotation(this.spike7, -0.2617994f, 2.129302f, 0.0f);
        (this.spike8 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike8.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike8.setTextureSize(256, 512);
        this.spike8.mirror = true;
        this.setRotation(this.spike8, -0.296706f, 2.548181f, 0.0f);
        (this.spike9 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike9.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike9.setTextureSize(256, 512);
        this.spike9.mirror = true;
        this.setRotation(this.spike9, -0.2617994f, 2.9147f, 0.0f);
        (this.spike10 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike10.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike10.setTextureSize(256, 512);
        this.spike10.mirror = true;
        this.setRotation(this.spike10, -0.296706f, -2.956793f, 0.0f);
        (this.spike11 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike11.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike11.setTextureSize(256, 512);
        this.spike11.mirror = true;
        this.setRotation(this.spike11, -0.2792527f, -2.587194f, 0.0f);
        (this.spike12 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike12.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike12.setTextureSize(256, 512);
        this.spike12.mirror = true;
        this.setRotation(this.spike12, -0.2792527f, -2.032795f, 0.0f);
        (this.spike13 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -29.0f, 2, 2, 15);
        this.spike13.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike13.setTextureSize(256, 512);
        this.spike13.mirror = true;
        this.setRotation(this.spike13, -0.3531725f, -1.558011f, 0.0f);
        (this.spike14 = new ModelRenderer((ModelBase)this, 0, 0)).addBox(0.0f, 13.0f, -26.0f, 2, 2, 15);
        this.spike14.setRotationPoint(0.0f, -231.0f, 0.0f);
        this.spike14.setTextureSize(256, 512);
        this.spike14.mirror = true;
        this.setRotation(this.spike14, -0.2042758f, -0.0594858f, 0.0f);
        (this.body7 = new ModelRenderer((ModelBase)this, 0, 141)).addBox(-18.0f, 0.0f, 0.0f, 36, 42, 30);
        this.body7.setRotationPoint(0.0f, -231.0f, -15.0f);
        this.body7.setTextureSize(256, 512);
        this.body7.mirror = true;
        this.setRotation(this.body7, 0.0523599f, 0.0f, 0.0f);
        (this.leftarm1 = new ModelRenderer((ModelBase)this, 176, 228)).addBox(-10.0f, 0.0f, -10.0f, 20, 50, 20);
        this.leftarm1.setRotationPoint(12.0f, -215.0f, 0.0f);
        this.leftarm1.setTextureSize(256, 512);
        this.leftarm1.mirror = true;
        this.setRotation(this.leftarm1, 0.1570796f, 0.0f, -0.296706f);
        (this.rightarm1 = new ModelRenderer((ModelBase)this, 176, 228)).addBox(-10.0f, 0.0f, -10.0f, 20, 50, 20);
        this.rightarm1.setRotationPoint(-12.0f, -215.0f, 0.0f);
        this.rightarm1.setTextureSize(256, 512);
        this.rightarm1.mirror = true;
        this.setRotation(this.rightarm1, 0.1570796f, 0.0f, 0.296706f);
        (this.leftarm2 = new ModelRenderer((ModelBase)this, 160, 300)).addBox(-18.0f, 48.0f, -6.0f, 24, 45, 24);
        this.leftarm2.setRotationPoint(12.0f, -215.0f, 0.0f);
        this.leftarm2.setTextureSize(256, 512);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, 0.037611f, 0.0f, -0.4014257f);
        (this.righthand = new ModelRenderer((ModelBase)this, 146, 169)).addBox(-3.0f, 92.0f, -6.0f, 6, 22, 14);
        this.righthand.setRotationPoint(-12.0f, -215.2133f, 25.49333f);
        this.righthand.setTextureSize(256, 512);
        this.righthand.mirror = true;
        this.setRotation(this.righthand, -0.1828788f, 0.0297429f, 0.31415927f);
        (this.rightarm2 = new ModelRenderer((ModelBase)this, 160, 300)).addBox(-6.0f, 48.0f, -6.0f, 24, 45, 24);
        this.rightarm2.setRotationPoint(-12.0f, -215.0f, 0.0f);
        this.rightarm2.setTextureSize(256, 512);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, 0.037611f, 0.0f, 0.4014257f);
        (this.body8 = new ModelRenderer((ModelBase)this, 0, 398)).addBox(-27.0f, 0.0f, 0.0f, 64, 64, 50);
        this.body8.setRotationPoint(-5.0f, -64.0f, -20.0f);
        this.body8.setTextureSize(256, 512);
        this.body8.mirror = true;
        this.setRotation(this.body8, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity var1, final float var2, final float var3, final float var4, final float var5, final float var6, final float var7) {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.head.render(var7);
        this.nose1.render(var7);
        this.body1.render(var7);
        this.body2.render(var7);
        this.rightleg.render(var7);
        this.righttoe1.render(var7);
        this.righttoe2.render(var7);
        this.leftleg.render(var7);
        this.lefttoe1.render(var7);
        this.lefttoe2.render(var7);
        this.body3.render(var7);
        this.body4.render(var7);
        this.face1.render(var7);
        this.face2.render(var7);
        this.face3.render(var7);
        this.face4.render(var7);
        this.nose2.render(var7);
        this.body5.render(var7);
        this.spike1.render(var7);
        this.body6.render(var7);
        this.lefthand.render(var7);
        this.spike2.render(var7);
        this.spike3.render(var7);
        this.spike4.render(var7);
        this.spike5.render(var7);
        this.spike6.render(var7);
        this.spike7.render(var7);
        this.spike8.render(var7);
        this.spike9.render(var7);
        this.spike10.render(var7);
        this.spike11.render(var7);
        this.spike12.render(var7);
        this.spike13.render(var7);
        this.spike14.render(var7);
        this.body7.render(var7);
        this.leftarm1.render(var7);
        this.rightarm1.render(var7);
        this.leftarm2.render(var7);
        this.righthand.render(var7);
        this.rightarm2.render(var7);
        this.body8.render(var7);
    }
    
    private void setRotation(final ModelRenderer var1, final float var2, final float var3, final float var4) {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
    
    public void setRotationAngles(final float var1, final float var2, final float var3, final float var4, final float var5, final float var6, final Entity var7) {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        this.face1.rotateAngleY = -0.3f;
        this.face2.rotateAngleY = 0.3f;
        this.face3.rotateAngleY = 0.3f;
        this.face4.rotateAngleY = -0.3f;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.3662f) * 0.8f * var2;
        this.rightleg.rotateAngleY = 0.0f;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.3662f + 3.1415927f) * 0.8f * var2;
        this.leftleg.rotateAngleY = 0.0f;
        this.righttoe1.rotateAngleX = MathHelper.cos(var1 * 0.3662f) * 0.8f * var2;
        this.righttoe1.rotateAngleY = 0.0f;
        this.lefttoe1.rotateAngleX = MathHelper.cos(var1 * 0.3662f + 3.1415927f) * 0.8f * var2;
        this.lefttoe1.rotateAngleY = 0.0f;
        this.righttoe2.rotateAngleX = MathHelper.cos(var1 * 0.3662f) * 0.8f * var2;
        this.righttoe2.rotateAngleY = 0.0f;
        this.lefttoe2.rotateAngleX = MathHelper.cos(var1 * 0.3662f + 3.1415927f) * 0.8f * var2;
        this.lefttoe2.rotateAngleY = 0.0f;
    }
}

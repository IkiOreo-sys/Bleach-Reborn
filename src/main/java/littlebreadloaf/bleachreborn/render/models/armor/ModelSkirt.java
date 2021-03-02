package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelSkirt extends ModelBiped
{
    ModelRenderer Shape13;
    ModelRenderer Shape12;
    ModelRenderer Shape11;
    ModelRenderer Shape10;
    ModelRenderer Shape9;
    ModelRenderer Shape8;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape5;
    ModelRenderer Shape4;
    ModelRenderer Shape3;
    ModelRenderer Shape2;
    ModelRenderer Shape1;
    ModelRenderer body;
    
    public ModelSkirt(final float f) {
        super(f, 0.0f, 64, 64);
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.Shape13 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-3.0f, 11.0f, 0.5f, 2, 5, 2);
        this.Shape13.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape13.setTextureSize(64, 64);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, -0.2792527f, 3.141593f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-1.0f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape12.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape12.setTextureSize(64, 64);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, -0.2792527f, -1.570796f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-2.5f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape11.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape11.setTextureSize(64, 64);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, -0.2792527f, -2.356194f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(0.5f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape10.setTextureSize(64, 64);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, -0.2792527f, -0.7853982f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(1.0f, 11.0f, 0.5f, 2, 5, 2);
        this.Shape9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape9.setTextureSize(64, 64);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, -0.2792527f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-1.0f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape8.setTextureSize(64, 64);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, -0.2792527f, 1.570796f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(1.0f, 11.0f, 0.5f, 2, 5, 2);
        this.Shape7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape7.setTextureSize(64, 64);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, -0.2792527f, 3.141593f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-3.0f, 11.0f, 0.5f, 2, 5, 2);
        this.Shape6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape6.setTextureSize(64, 64);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, -0.2792527f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-2.5f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape5.setTextureSize(64, 64);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, -0.2792527f, 0.7853982f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(0.5f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape4.setTextureSize(64, 64);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, -0.2792527f, 2.356194f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-1.0f, 11.0f, 1.0f, 2, 5, 2);
        this.Shape3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape3.setTextureSize(64, 64);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, -0.2792527f, 3.141593f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-1.0f, 11.0f, 1.0f, 2, 5, 2);
        this.Shape2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape2.setTextureSize(64, 64);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, -0.2792527f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase)this, 4, 18)).addBox(-1.0f, 11.5f, -1.0f, 2, 5, 2);
        this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape1.setTextureSize(64, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, -0.2792527f, 1.570796f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 16, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        this.bipedBody.addChild(this.body);
        this.bipedBody.addChild(this.Shape1);
        this.bipedBody.addChild(this.Shape2);
        this.bipedBody.addChild(this.Shape3);
        this.bipedBody.addChild(this.Shape4);
        this.bipedBody.addChild(this.Shape5);
        this.bipedBody.addChild(this.Shape6);
        this.bipedBody.addChild(this.Shape7);
        this.bipedBody.addChild(this.Shape8);
        this.bipedBody.addChild(this.Shape9);
        this.bipedBody.addChild(this.Shape10);
        this.bipedBody.addChild(this.Shape11);
        this.bipedBody.addChild(this.Shape12);
        this.bipedBody.addChild(this.Shape13);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}

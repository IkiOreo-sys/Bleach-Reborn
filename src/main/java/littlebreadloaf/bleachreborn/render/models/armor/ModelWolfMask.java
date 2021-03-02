package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelWolfMask extends ModelBiped
{
    ModelRenderer WolfHead;
    ModelRenderer Nose;
    
    public ModelWolfMask(final float f) {
        super(f, 0.0f, 128, 128);
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.WolfHead = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.WolfHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.WolfHead.setTextureSize(128, 128);
        this.WolfHead.mirror = true;
        this.setRotation(this.WolfHead, 0.0f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase)this, 0, 20)).addBox(-3.0f, -5.0f, -8.0f, 6, 4, 6);
        this.Nose.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Nose.setTextureSize(128, 128);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(this.WolfHead);
        this.bipedHead.addChild(this.Nose);
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

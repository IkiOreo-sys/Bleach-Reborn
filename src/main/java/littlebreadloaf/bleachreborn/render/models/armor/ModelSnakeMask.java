package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelSnakeMask extends ModelBiped
{
    ModelRenderer mask;
    ModelRenderer bottom_jaw;
    
    public ModelSnakeMask(final float f) {
        super(f, 0.0f, 128, 128);
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.mask = new ModelRenderer((ModelBase)this, 0, 20)).addBox(-3.3f, -8.5f, -6.3f, 9, 9, 9);
        this.mask.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.mask.setTextureSize(128, 128);
        this.mask.mirror = true;
        this.setRotation(this.mask, 0.0f, 0.7853982f, 0.0f);
        (this.bottom_jaw = new ModelRenderer((ModelBase)this, 0, 39)).addBox(-2.5f, -3.0f, -8.5f, 5, 6, 9);
        this.bottom_jaw.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bottom_jaw.setTextureSize(128, 128);
        this.bottom_jaw.mirror = true;
        this.setRotation(this.bottom_jaw, 0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(this.mask);
        this.bipedHead.addChild(this.bottom_jaw);
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

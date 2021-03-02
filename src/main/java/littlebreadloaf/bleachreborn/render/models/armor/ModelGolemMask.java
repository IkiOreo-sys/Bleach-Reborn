package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelGolemMask extends ModelBiped
{
    ModelRenderer mask;
    
    public ModelGolemMask(final float f) {
        super(f, 0.0f, 64, 64);
        (this.mask = new ModelRenderer((ModelBase)this, 0, 21)).addBox(-4.3f, -8.55f, -5.7f, 10, 10, 10);
        this.mask.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.mask.setTextureSize(64, 64);
        this.mask.mirror = true;
        this.setRotation(this.mask, 0.0f, 0.7853982f, 0.0f);
        this.bipedHead.addChild(this.mask);
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

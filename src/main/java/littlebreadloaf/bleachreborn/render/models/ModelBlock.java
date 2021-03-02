package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class ModelBlock extends ModelBase
{
    ModelRenderer block;
    
    public ModelBlock() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        (this.block = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.block.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.block.setTextureSize(16, 16);
        this.block.mirror = true;
        this.setRotation(this.block, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.block.render(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.block.rotateAngleX = -0.25f * MathHelper.cos(f2 * 0.06662f * 1.5f);
        this.block.rotateAngleZ = -0.35f * MathHelper.sin(f2 * 0.16662f * 1.5f);
    }
}

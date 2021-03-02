package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelSoulChain extends ModelBiped
{
    ModelRenderer soulchainanchor;
    ModelRenderer soulchainchain;
    
    public ModelSoulChain(final float f) {
        super(f);
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.soulchainanchor = new ModelRenderer((ModelBase)this, 24, 4)).addBox(1.0f, 1.0f, -2.5f, 3, 3, 1);
        this.soulchainanchor.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.soulchainanchor.setTextureSize(64, 32);
        this.soulchainanchor.mirror = true;
        this.setRotation(this.soulchainanchor, 0.0f, 0.0f, 0.7853982f);
        (this.soulchainchain = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.5f, 4.0f, -2.0f, 3, 7, 0);
        this.soulchainchain.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.soulchainchain.setTextureSize(64, 32);
        this.soulchainchain.mirror = true;
        this.setRotation(this.soulchainchain, -0.1396263f, 0.0f, -0.7853982f);
        this.bipedBody.addChild(this.soulchainanchor);
        this.soulchainanchor.addChild(this.soulchainchain);
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

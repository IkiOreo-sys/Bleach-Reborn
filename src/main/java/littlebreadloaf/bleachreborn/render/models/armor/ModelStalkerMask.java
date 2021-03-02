package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelStalkerMask extends ModelBiped
{
    ModelRenderer jaw;
    ModelRenderer head;
    ModelRenderer hornLF;
    ModelRenderer hornLB;
    ModelRenderer hornRF;
    ModelRenderer hornRB;
    
    public ModelStalkerMask(final float f) {
        super(f, 0.0f, 64, 64);
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.jaw = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-3.0f, -3.0f, -6.5f, 6, 3, 4);
        this.jaw.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.jaw.setTextureSize(64, 64);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.2443461f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -7.0f, 8, 7, 8);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, -0.0349066f, 0.0f, 0.0f);
        (this.hornLF = new ModelRenderer((ModelBase)this, 0, 0)).addBox(2.0f, -9.0f, -7.0f, 1, 2, 1);
        this.hornLF.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.hornLF.setTextureSize(64, 64);
        this.hornLF.mirror = true;
        this.setRotation(this.hornLF, 0.0f, 0.0f, 0.0f);
        (this.hornLB = new ModelRenderer((ModelBase)this, 16, 20)).addBox(3.0f, -8.5f, -1.5f, 3, 4, 5);
        this.hornLB.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.hornLB.setTextureSize(64, 64);
        this.hornLB.mirror = true;
        this.setRotation(this.hornLB, 0.2617994f, 0.5235988f, 0.0f);
        (this.hornRF = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -9.0f, -7.0f, 1, 2, 1);
        this.hornRF.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.hornRF.setTextureSize(64, 64);
        this.hornRF.mirror = true;
        this.setRotation(this.hornRF, 0.0f, 0.0f, 0.0f);
        (this.hornRB = new ModelRenderer((ModelBase)this, 16, 20)).addBox(-6.0f, -8.5f, -1.5f, 3, 4, 5);
        this.hornRB.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.hornRB.setTextureSize(64, 64);
        this.hornRB.mirror = true;
        this.setRotation(this.hornRB, 0.2617994f, -0.5235988f, 0.0f);
        this.bipedHead.addChild(this.jaw);
        this.bipedHead.addChild(this.head);
        this.bipedHead.addChild(this.hornLF);
        this.bipedHead.addChild(this.hornLB);
        this.bipedHead.addChild(this.hornRF);
        this.bipedHead.addChild(this.hornRB);
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

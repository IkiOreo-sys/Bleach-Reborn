package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.util.*;

public class ModelHollowBat extends ModelBase
{
    private ModelRenderer batHead;
    private ModelRenderer batBody;
    private ModelRenderer batRightWing;
    private ModelRenderer batLeftWing;
    private ModelRenderer batOuterRightWing;
    private ModelRenderer batOuterLeftWing;
    
    public ModelHollowBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.batHead = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        final ModelRenderer var1 = new ModelRenderer((ModelBase)this, 24, 0);
        var1.addBox(-4.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(var1);
        final ModelRenderer var2 = new ModelRenderer((ModelBase)this, 24, 0);
        var2.mirror = true;
        var2.addBox(1.0f, -6.0f, -2.0f, 3, 4, 1);
        this.batHead.addChild(var2);
        (this.batBody = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-3.0f, 4.0f, -3.0f, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5.0f, 16.0f, 0.0f, 10, 6, 1);
        (this.batRightWing = new ModelRenderer((ModelBase)this, 42, 0)).addBox(-12.0f, 1.0f, 1.5f, 10, 16, 1);
        (this.batOuterRightWing = new ModelRenderer((ModelBase)this, 24, 16)).setRotationPoint(-12.0f, 1.0f, 1.5f);
        this.batOuterRightWing.addBox(-8.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batLeftWing = new ModelRenderer((ModelBase)this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0f, 1.0f, 1.5f, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer((ModelBase)this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12.0f, 1.0f, 1.5f);
        this.batOuterLeftWing.addBox(0.0f, 1.0f, 0.0f, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }
    
    public int getBatSize() {
        return 36;
    }
    
    public void render(final Entity var1, final float var2, final float var3, final float var4, final float var5, final float var6, final float var7) {
        final EntityHollowBat var8 = (EntityHollowBat)var1;
        this.batHead.rotateAngleX = var6 / 57.295776f;
        this.batHead.rotateAngleY = var5 / 57.295776f;
        this.batHead.rotateAngleZ = 0.0f;
        this.batHead.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.batRightWing.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.batLeftWing.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.batBody.rotateAngleX = 0.7853982f + MathHelper.cos(var4 * 0.1f) * 0.15f;
        this.batBody.rotateAngleY = 0.0f;
        this.batRightWing.rotateAngleY = MathHelper.cos(var4 * 1.3f) * 3.1415927f * 0.25f;
        this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
        this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5f;
        this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5f;
        this.batHead.render(var7);
        this.batBody.render(var7);
    }
}

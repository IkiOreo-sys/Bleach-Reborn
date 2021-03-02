package littlebreadloaf.bleachreborn.render.models.armor;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSanrei extends ModelBase
{
  //fields
    ModelRenderer side1;
    ModelRenderer side2;
    ModelRenderer side3;
    ModelRenderer side4;
    ModelRenderer side5;
  
  public ModelSanrei()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      side1 = new ModelRenderer(this, 2, 15);
      side1.addBox(0F, 0F, 0F, 0, 7, 4);
      side1.setRotationPoint(8.05F, 5F, -2F);
      side1.setTextureSize(64, 32);
      side1.mirror = true;
      setRotation(side1, 0F, 0F, 0F);
      side2 = new ModelRenderer(this, 13, 15);
      side2.addBox(0F, 0F, 0F, 0, 7, 4);
      side2.setRotationPoint(8F, 5F, -2.05F);
      side2.setTextureSize(64, 32);
      side2.mirror = true;
      setRotation(side2, 0F, -1.570796F, 0F);
      side3 = new ModelRenderer(this, 24, 15);
      side3.addBox(0F, 0F, 0F, 0, 7, 4);
      side3.setRotationPoint(4F, 5F, 2.05F);
      side3.setTextureSize(64, 32);
      side3.mirror = true;
      setRotation(side3, 0F, 1.570796F, 0F);
      side4 = new ModelRenderer(this, 36, 15);
      side4.addBox(0F, 0F, 0F, 0, 7, 4);
      side4.setRotationPoint(3.95F, 5F, -2F);
      side4.setTextureSize(64, 32);
      side4.mirror = true;
      setRotation(side4, 0F, 0F, 0F);
      side5 = new ModelRenderer(this, 4, 5);
      side5.addBox(0F, 0F, 0F, 4, 0, 4);
      side5.setRotationPoint(4F, 12.05F, -2F);
      side5.setTextureSize(64, 32);
      side5.mirror = true;
      setRotation(side5, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    side1.render(f5);
    side2.render(f5);
    side3.render(f5);
    side4.render(f5);
    side5.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

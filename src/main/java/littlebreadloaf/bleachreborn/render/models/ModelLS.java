package littlebreadloaf.bleachreborn.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLS extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
  
  public ModelLS()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 28);
      Shape1.addBox(0F, 0F, 0F, 17, 1, 1);
      Shape1.setRotationPoint(2F, 1F, -3F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0.0918105F, -0.0449379F);
      Shape2 = new ModelRenderer(this, 0, 24);
      Shape2.addBox(0F, 0F, 0F, 24, 1, 1);
      Shape2.setRotationPoint(2F, 2F, -3F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0.1092576F, -0.2322626F);
      Shape3 = new ModelRenderer(this, 0, 20);
      Shape3.addBox(0F, 1F, 0F, 28, 1, 1);
      Shape3.setRotationPoint(2F, 1F, -3F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0.1267109F, -0.3457148F);
      Shape4 = new ModelRenderer(this, 0, 14);
      Shape4.addBox(2F, 1F, 0F, 35, 1, 1);
      Shape4.setRotationPoint(2F, 1F, -3F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0.1441642F, -0.4242546F);
      Shape5 = new ModelRenderer(this, 0, 10);
      Shape5.addBox(1F, 1F, 0F, 26, 1, 1);
      Shape5.setRotationPoint(2F, 1F, -3F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0.1267109F, -0.5115211F);
      Shape6 = new ModelRenderer(this, 0, 6);
      Shape6.addBox(1F, 1F, 0F, 18, 1, 1);
      Shape6.setRotationPoint(2F, 1F, -3F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0.1092576F, -0.6336941F);
      Shape7 = new ModelRenderer(this, 0, 2);
      Shape7.addBox(1F, 1F, 0F, 11, 1, 1);
      Shape7.setRotationPoint(2F, 1F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0.0569039F, -0.7954295F);
      Shape8 = new ModelRenderer(this, 0, 26);
      Shape8.addBox(3F, 1F, 0F, 16, 1, 1);
      Shape8.setRotationPoint(2F, 1F, -3F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0.1033235F, -0.1752558F);
      Shape9 = new ModelRenderer(this, 0, 22);
      Shape9.addBox(0F, 1F, 0F, 26, 1, 1);
      Shape9.setRotationPoint(2F, 1F, -3F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0.1267109F, -0.287543F);
      Shape10 = new ModelRenderer(this, 0, 16);
      Shape10.addBox(2F, 1F, 0F, 30, 1, 1);
      Shape10.setRotationPoint(2F, 1F, -3F);
      Shape10.setTextureSize(64, 32);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0.1441642F, -0.3864333F);
      Shape11 = new ModelRenderer(this, 0, 12);
      Shape11.addBox(3F, 1F, 0F, 30, 1, 1);
      Shape11.setRotationPoint(2F, 1F, -3F);
      Shape11.setTextureSize(64, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0.1441642F, -0.4591612F);
      Shape12 = new ModelRenderer(this, 0, 8);
      Shape12.addBox(2F, 1F, 0F, 21, 1, 1);
      Shape12.setRotationPoint(2F, 1F, -3F);
      Shape12.setTextureSize(64, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0.1267109F, -0.563881F);
      Shape13 = new ModelRenderer(this, 0, 4);
      Shape13.addBox(0F, 1F, 0F, 16, 1, 1);
      Shape13.setRotationPoint(2F, 1F, -3F);
      Shape13.setTextureSize(64, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0.0569039F, -0.708163F);
      Shape14 = new ModelRenderer(this, 0, 18);
      Shape14.addBox(2F, 0F, 0F, 28, 1, 1);
      Shape14.setRotationPoint(2F, 1F, -3F);
      Shape14.setTextureSize(64, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0.1441642F, -0.3282615F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
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

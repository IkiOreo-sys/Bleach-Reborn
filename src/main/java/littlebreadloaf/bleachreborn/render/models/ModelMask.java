package littlebreadloaf.bleachreborn.render.models;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMask extends ModelBase
{
	public ModelMask()
	{
		front = new ModelRenderer(this, 33, 0);
		front.addBox(0F, 0F, 0F, 12, 12, 1, 0F);
		front.setRotationPoint(-4F, -8F, -5F);
		front.rotateAngleX = 0F;
		front.rotateAngleY = 0F;
		front.rotateAngleZ = 0F;
		front.mirror = false;
		Shape1 = new ModelRenderer(this, 8, 0);
		Shape1.addBox(0F, 0F, 0F, 10, 1, 1, 0F);
		Shape1.setRotationPoint(-3F, -9F, -4F);
		Shape1.rotateAngleX = 0F;
		Shape1.rotateAngleY = 0F;
		Shape1.rotateAngleZ = 0F;
		Shape1.mirror = false;
		Shape2 = new ModelRenderer(this, 10, 11);
		Shape2.addBox(0F, 0F, 0F, 1, 10, 1, 0F);
		Shape2.setRotationPoint(-5F, -7F, -4F);
		Shape2.rotateAngleX = 0F;
		Shape2.rotateAngleY = 0F;
		Shape2.rotateAngleZ = 0F;
		Shape2.mirror = false;
		Shape3 = new ModelRenderer(this, 16, 11);
		Shape3.addBox(0F, 0F, 0F, 1, 10, 1, 0F);
		Shape3.setRotationPoint(8F, -7F, -4F);
		Shape3.rotateAngleX = 0F;
		Shape3.rotateAngleY = 0F;
		Shape3.rotateAngleZ = 0F;
		Shape3.mirror = false;
		Shape4 = new ModelRenderer(this, 8, 5);
		Shape4.addBox(0F, 0F, 0F, 10, 1, 1, 0F);
		Shape4.setRotationPoint(-3F, 4F, -4F);
		Shape4.rotateAngleX = 0F;
		Shape4.rotateAngleY = 0F;
		Shape4.rotateAngleZ = 0F;
		Shape4.mirror = false;
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		front.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	//fields
	public ModelRenderer front;
	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
}

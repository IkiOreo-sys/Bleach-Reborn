package littlebreadloaf.bleachreborn.render;

import net.minecraft.client.renderer.tileentity.*;
import cpw.mods.fml.client.registry.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import org.lwjgl.opengl.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import cpw.mods.fml.client.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.*;

public class RenderGraveStone extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
    private final ResourceLocation TEXTURE_LANTERN;
    public static ModelBase model;
    private ModelRenderer b5;
    private ModelRenderer b4;
    private ModelRenderer b3;
    private ModelRenderer b2;
    private ModelRenderer b1;
    private ModelRenderer b6;
    private ModelRenderer b7;
    private ModelRenderer b8;
    private ModelRenderer b9;
    
    public RenderGraveStone() {
        this.TEXTURE_LANTERN = new ResourceLocation("bleachreborn:textures/models/paper_lantern.png");
        RenderGraveStone.model.textureWidth = 64;
        RenderGraveStone.model.textureHeight = 128;
        (this.b5 = new ModelRenderer(RenderGraveStone.model, 0, 41)).addBox(-7.0f, 0.0f, -7.0f, 14, 6, 14);
        this.b5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b5.setTextureSize(64, 128);
        this.b5.mirror = true;
        this.setRotation(this.b5, 0.0f, 0.0f, 0.0f);
        (this.b4 = new ModelRenderer(RenderGraveStone.model, 0, 27)).addBox(-6.0f, -2.0f, -6.0f, 12, 2, 12);
        this.b4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b4.setTextureSize(64, 128);
        this.b4.mirror = true;
        this.setRotation(this.b4, 0.0f, 0.0f, 0.0f);
        (this.b3 = new ModelRenderer(RenderGraveStone.model, 0, 16)).addBox(-5.0f, -3.0f, -5.0f, 10, 1, 10);
        this.b3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b3.setTextureSize(64, 128);
        this.b3.mirror = true;
        this.setRotation(this.b3, 0.0f, 0.0f, 0.0f);
        (this.b2 = new ModelRenderer(RenderGraveStone.model, 0, 7)).addBox(-4.0f, -4.0f, -4.0f, 8, 1, 8);
        this.b2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b2.setTextureSize(64, 128);
        this.b2.mirror = true;
        this.setRotation(this.b2, 0.0f, 0.0f, 0.0f);
        (this.b1 = new ModelRenderer(RenderGraveStone.model, 0, 0)).addBox(-3.0f, -5.0f, -3.0f, 6, 1, 6);
        this.b1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b1.setTextureSize(64, 128);
        this.b1.mirror = true;
        this.setRotation(this.b1, 0.0f, 0.0f, 0.0f);
        (this.b6 = new ModelRenderer(RenderGraveStone.model, 0, 61)).addBox(-6.0f, 6.0f, -6.0f, 12, 2, 12);
        this.b6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b6.setTextureSize(64, 128);
        this.b6.mirror = true;
        this.setRotation(this.b6, 0.0f, 0.0f, 0.0f);
        (this.b7 = new ModelRenderer(RenderGraveStone.model, 0, 75)).addBox(-5.0f, 8.0f, -5.0f, 10, 1, 10);
        this.b7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b7.setTextureSize(64, 128);
        this.b7.mirror = true;
        this.setRotation(this.b7, 0.0f, 0.0f, 0.0f);
        (this.b8 = new ModelRenderer(RenderGraveStone.model, 0, 86)).addBox(-4.0f, 9.0f, -4.0f, 8, 1, 8);
        this.b8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b8.setTextureSize(64, 128);
        this.b8.mirror = true;
        this.setRotation(this.b8, 0.0f, 0.0f, 0.0f);
        (this.b9 = new ModelRenderer(RenderGraveStone.model, 0, 95)).addBox(-3.0f, 10.0f, -3.0f, 6, 1, 6);
        this.b9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.b9.setTextureSize(64, 128);
        this.b9.mirror = true;
        this.setRotation(this.b9, 0.0f, 0.0f, 0.0f);
    }
    
    public void render(final float f5) {
        GL11.glDisable(2884);
        this.b5.render(f5);
        this.b4.render(f5);
        this.b3.render(f5);
        this.b2.render(f5);
        this.b1.render(f5);
        this.b6.render(f5);
        this.b7.render(f5);
        this.b8.render(f5);
        this.b9.render(f5);
        GL11.glEnable(2884);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
    
    public void renderTileEntityAt(final TileEntity tile, final double x, final double y, final double z, final float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.68, z + 0.5);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        Minecraft.getMinecraft().renderEngine.bindTexture(this.TEXTURE_LANTERN);
        this.render(0.0625f);
        GL11.glPopMatrix();
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glEnable(2929);
        GL11.glTranslated(0.0, 0.30000001192092896, 0.0);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_LANTERN);
        this.render(0.0625f);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }
    
    public boolean renderWorldBlock(final IBlockAccess world, final int x, final int y, final int z, final Block block, final int modelId, final RenderBlocks renderer) {
        return false;
    }
    
    public boolean shouldRender3DInInventory(final int modelId) {
        return true;
    }
    
    public int getRenderId() {
        return BleachIds.lanternRenderingID;
    }
    
    static {
        RenderGraveStone.model = new ModelBase() {};
    }
}

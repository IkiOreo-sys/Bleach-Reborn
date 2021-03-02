package littlebreadloaf.bleachreborn.render;

import net.minecraft.client.renderer.tileentity.*;
import net.minecraftforge.client.model.*;
import net.minecraft.tileentity.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.client.*;
import littlebreadloaf.bleachreborn.tiles.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.*;
import net.minecraft.util.*;

public class SeeleSchneiderBlockRenderer extends TileEntitySpecialRenderer
{
    private ResourceLocation TEXTURE_SEELESCHNEIDER;
    private ResourceLocation TEXTURE_BEAM;
    private ResourceLocation TEXTURE_MODEL;
    private ResourceLocation TEXTURE_BLADE;
    private ResourceLocation TEXTURE_CIRCLE;
    private IModelCustom model;
    private IModelCustom blade;
    
    public SeeleSchneiderBlockRenderer() {
        this.TEXTURE_CIRCLE = new ResourceLocation("bleachreborn:models/circle_gray.png");
        this.TEXTURE_SEELESCHNEIDER = new ResourceLocation("bleachreborn:models/SeeleSchneider_Bottom.png");
        this.TEXTURE_BEAM = new ResourceLocation("bleachreborn:models/beam_gray.png");
        this.TEXTURE_MODEL = new ResourceLocation("bleachreborn:models/SeeleSchneider.obj");
        this.TEXTURE_BLADE = new ResourceLocation("bleachreborn:models/SeeleSchneider_Blade.obj");
        this.model = AdvancedModelLoader.loadModel(this.TEXTURE_MODEL);
        this.blade = AdvancedModelLoader.loadModel(this.TEXTURE_BLADE);
    }
    
    public void renderTileEntityAt(final TileEntity tileentity, final double x, final double y, final double z, final float f) {
        GL11.glPushMatrix();
        GL11.glDisable(2896);
        GL11.glTranslated(x + 0.5, y + 1.5, z + 0.5);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        final float scale = 0.01f;
        GL11.glScalef(0.01f, 0.01f, 0.01f);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_SEELESCHNEIDER);
        this.blade.renderAll();
        this.model.renderAll();
        GL11.glEnable(2896);
        GL11.glPopMatrix();
        final TileSeeleSchneider tile = (TileSeeleSchneider)tileentity;
        if (tile.isMain) {
            GL11.glPushMatrix();
            GL11.glDisable(2896);
            GL11.glDisable(2884);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(1.0f / (tile.alpha * 50.0f + 120.0f), 1.0f, 1.0f, tile.alpha);
            GL11.glTranslated(x, y, z);
            FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_BEAM);
            GL11.glBegin(7);
            Entity entity = null;
            for (int i = 0; i < tile.getWorldObj().getLoadedEntityList().size(); ++i) {
                entity = (Entity) tile.getWorldObj().getLoadedEntityList().get(i);
                if (((entity != null && entity instanceof EntityLiving) || entity instanceof EntityPlayer) && this.isEntityInCube(entity)) {
                    FMLLog.info("Entity in cube", new Object[0]);
                    RenderingHelper.renderBeam(0.5f, 1.5f, 0.5f, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
                    RenderingHelper.renderBeam(tile.side + 0.5f, 1.5f, 0.5f, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
                    RenderingHelper.renderBeam(0.5f, 1.5f, tile.side + 0.5f, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
                    RenderingHelper.renderBeam(tile.side + 0.5f, 1.5f, tile.side + 0.5f, entity.posX - tile.xCoord, entity.posY - tile.yCoord - entity.yOffset, entity.posZ - tile.zCoord);
                    GL11.glEnd();
                    FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_CIRCLE);
                    RenderingHelper.renderFacingQuad(0.5, 1.5, 0.5, 1.5f);
                    RenderingHelper.renderFacingQuad(tile.side + 0.5f, 1.5, 0.5, 1.5f);
                    RenderingHelper.renderFacingQuad(0.5, 1.5, tile.side + 0.5f, 1.5f);
                    RenderingHelper.renderFacingQuad(tile.side + 0.5f, 1.5, tile.side + 0.5f, 1.5f);
                    RenderingHelper.renderFacingQuad(entity.posX - tile.xCoord, entity.posY - tile.yCoord + 0.30000001192092896 - entity.yOffset, entity.posZ - tile.zCoord, 8.0f);
                    FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.TEXTURE_BEAM);
                    GL11.glBegin(7);
                }
            }
            GL11.glEnd();
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            GL11.glEnable(2896);
            GL11.glPopMatrix();
        }
    }
    
    private boolean isEntityInCube(final Entity entity) {
        for (int i = 0; i < TileSeeleSchneider.magicSquare.size(); ++i) {
            final int x = TileSeeleSchneider.magicSquare.get(i).posX;
            final int y = TileSeeleSchneider.magicSquare.get(i).posY;
            final int z = TileSeeleSchneider.magicSquare.get(i).posZ;
            final TileSeeleSchneider tile = (TileSeeleSchneider)entity.worldObj.getTileEntity(x, y, z);
            if (tile == null) {
                TileSeeleSchneider.magicSquare.remove(i);
                return false;
            }
            final int side = tile.side;
            if (entity.posX > x + 0.5f && entity.posX < x + side - 0.5f && entity.posZ > z + 0.5f && entity.posZ < z + side - 0.5f && entity.posY >= y) {
                return true;
            }
        }
        return false;
    }
}

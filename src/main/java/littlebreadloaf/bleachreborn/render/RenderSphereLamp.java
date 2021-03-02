package littlebreadloaf.bleachreborn.render;

import net.minecraft.client.renderer.tileentity.*;
import cpw.mods.fml.client.registry.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import cpw.mods.fml.client.*;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.*;
import littlebreadloaf.bleachreborn.tiles.*;
import java.awt.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.*;

public class RenderSphereLamp extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler
{
    private static ResourceLocation TEXTURE_SPHERE_LAMP;
    
    public static void render(final TileEntity tile) {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(RenderSphereLamp.TEXTURE_SPHERE_LAMP);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 1.0f);
        new Sphere().draw(1.0f, 20, 18);
    }
    
    public void renderTileEntityAt(final TileEntity tile, final double x, final double y, final double z, final float f) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        final float scale = 0.5f;
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        if (tile instanceof TileSphereLamp) {
            final TileSphereLamp lampTile = (TileSphereLamp)tile;
            final Color color = RenderingHelper.getColorFromPlayer(lampTile.getOwnerEntity());
            GL11.glColor3f((float)color.getRed(), (float)color.getGreen(), (float)color.getBlue());
        }
        render(tile);
        GL11.glPopMatrix();
    }
    
    public void renderInventoryBlock(final Block block, final int metadata, final int modelID, final RenderBlocks renderer) {
        GL11.glPushMatrix();
        GL11.glPushAttrib(8192);
        GL11.glEnable(2929);
        GL11.glTranslated(0.0, 0.0, 0.0);
        final float scale = 0.7f;
        GL11.glScalef(0.7f, 0.7f, 0.7f);
        GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
        final Color color = RenderingHelper.getColorFromPlayer((EntityPlayer)FMLClientHandler.instance().getClient().thePlayer);
        GL11.glColor3f((float)color.getRed(), (float)color.getGreen(), (float)color.getBlue());
        render(null);
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
        return BleachIds.sphereLampRenderID;
    }
    
    static {
        RenderSphereLamp.TEXTURE_SPHERE_LAMP = new ResourceLocation("bleachreborn".toLowerCase() + ":/models/sphereLamp.png");
    }
}

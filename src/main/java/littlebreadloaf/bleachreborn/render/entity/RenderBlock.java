package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.entity.*;
import littlebreadloaf.bleachreborn.entities.*;
import org.lwjgl.opengl.*;

public class RenderBlock extends Render
{
    private static final ResourceLocation blockDirt;
    private static final ResourceLocation blockStone;
    protected ModelBlock model;
    
    public RenderBlock() {
        this.model = new ModelBlock();
    }
    
    public void doRender(final Entity var1, final double var2, final double var4, final double var6, final float var8, final float var9) {
        this.renderBlock((EntityBlock)var1, var2, var4, var6, var8, var9);
    }
    
    private void renderBlock(final EntityBlock var1, final double var2, final double var4, final double var6, final float var8, final float var9) {
        GL11.glPushMatrix();
        GL11.glTranslated(var2, var4, var6);
        final float f4 = 0.75f;
        GL11.glScalef(0.75f, 0.75f, 0.75f);
        GL11.glScalef(1.3333334f, 1.3333334f, 1.3333334f);
        this.bindEntityTexture((Entity)var1);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.model.render(var1, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getBlockTextures(final EntityBlock par1EntityBoat) {
        return RenderBlock.blockDirt;
    }
    
    protected ResourceLocation getEntityTexture(final Entity var1) {
        return this.getBlockTextures((EntityBlock)var1);
    }
    
    static {
        blockDirt = new ResourceLocation("bleachreborn:textures/blocks/dirt.png");
        blockStone = new ResourceLocation("bleachreborn:textures/blocks/stone.png");
    }
}

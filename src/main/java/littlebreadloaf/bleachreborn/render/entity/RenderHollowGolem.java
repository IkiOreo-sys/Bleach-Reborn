package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import org.lwjgl.opengl.*;
import net.minecraft.entity.*;

public class RenderHollowGolem extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    protected ModelHollowGolem model;
    
    public RenderHollowGolem(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelHollowGolem)this.mainModel;
    }
    
    public void renderHollowGolem(final EntityHollowGolem par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.scaleHollow((EntityHollowGolem)par1EntityLivingBase, par2);
    }
    
    protected void scaleHollow(final EntityHollowGolem par1, final float par2) {
        final float scale = par1.getRenderSize() / 100.0f;
        GL11.glScalef(0.6f + scale, 0.6f + scale, 0.6f + scale);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderHollowGolem((EntityHollowGolem)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityHollowGolem)entity).getTexture()) {
            case 0: {
                return RenderHollowGolem.texture2;
            }
            case 1: {
                return RenderHollowGolem.texture3;
            }
            default: {
                return RenderHollowGolem.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_golem.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_golem2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_golem3.png");
    }
}

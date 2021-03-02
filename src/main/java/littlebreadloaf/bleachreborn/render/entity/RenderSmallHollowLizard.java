package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderSmallHollowLizard extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    protected ModelSmallHollowLizard model;
    
    public RenderSmallHollowLizard(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelSmallHollowLizard)this.mainModel;
    }
    
    public void renderSmallHollowLizard(final EntitySmallHollowLizard par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderSmallHollowLizard((EntitySmallHollowLizard)par1, par2, par3, par4, par5, par6);
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.scaleLizard((EntitySmallHollowLizard)par1EntityLivingBase, par2);
    }
    
    protected void scaleLizard(final EntitySmallHollowLizard par1, final float par2) {
        GL11.glScalef(0.4f, 0.4f, 0.4f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntitySmallHollowLizard)entity).getTexture()) {
            case 5: {
                return RenderSmallHollowLizard.texture7;
            }
            case 4: {
                return RenderSmallHollowLizard.texture6;
            }
            case 3: {
                return RenderSmallHollowLizard.texture5;
            }
            case 2: {
                return RenderSmallHollowLizard.texture4;
            }
            case 1: {
                return RenderSmallHollowLizard.texture3;
            }
            case 0: {
                return RenderSmallHollowLizard.texture2;
            }
            default: {
                return RenderSmallHollowLizard.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small3.png");
        texture4 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small4.png");
        texture5 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small5.png");
        texture6 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small6.png");
        texture7 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_lizard_small7.png");
    }
}

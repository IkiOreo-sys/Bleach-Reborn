package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;

public class RenderHollowSpider extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    protected ModelHollowSpider model;
    
    public RenderHollowSpider(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelHollowSpider)this.mainModel;
    }
    
    public void renderHollowSpider(final EntityHollowSpider par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderHollowSpider((EntityHollowSpider)par1, par2, par3, par4, par5, par6);
    }
    
    protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.scaleSpider((EntityHollowSpider)par1EntityLivingBase, par2);
    }
    
    protected void scaleSpider(final EntityHollowSpider par1, final float par2) {
        GL11.glScalef(1.7f, 1.7f, 1.7f);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityHollowSpider)entity).getTexture()) {
            case 0: {
                return RenderHollowSpider.texture2;
            }
            case 1: {
                return RenderHollowSpider.texture3;
            }
            default: {
                return RenderHollowSpider.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_spider.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_spider2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_spider3.png");
    }
}

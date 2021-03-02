package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderFisher extends RenderLiving
{
    private static final ResourceLocation texture;
    protected ModelFisher model;
    
    public RenderFisher(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelFisher)this.mainModel;
    }
    
    public void renderFisher(final EntityFisher par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderFisher((EntityFisher)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderFisher.texture;
    }
    
    static {
        texture = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/grand_fisher.png");
    }
}

package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderAshido extends RenderLiving
{
    private static final ResourceLocation texture1;
    protected ModelAshido model;
    
    public RenderAshido(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelAshido)this.mainModel;
    }
    
    public void renderAshido(final EntityAshido par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderAshido((EntityAshido)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderAshido.texture1;
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/ashido.png");
    }
}

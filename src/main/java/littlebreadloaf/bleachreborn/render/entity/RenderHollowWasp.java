package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderHollowWasp extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    protected ModelHollowWasp model;
    
    public RenderHollowWasp(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelHollowWasp)this.mainModel;
    }
    
    public void renderHollowWasp(final EntityHollowWasp par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderHollowWasp((EntityHollowWasp)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityHollowWasp)entity).getTexture()) {
            case 0: {
                return RenderHollowWasp.texture2;
            }
            case 1: {
                return RenderHollowWasp.texture3;
            }
            case 2: {
                return RenderHollowWasp.texture4;
            }
            default: {
                return RenderHollowWasp.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_wasp.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_wasp2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_wasp3.png");
        texture4 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_wasp4.png");
    }
}

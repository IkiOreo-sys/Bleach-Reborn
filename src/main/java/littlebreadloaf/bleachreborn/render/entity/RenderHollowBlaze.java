package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderHollowBlaze extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    protected ModelHollowBlaze model;
    
    public RenderHollowBlaze(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelHollowBlaze)this.mainModel;
    }
    
    public void renderHollowBlaze(final EntityHollowBlaze par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderHollowBlaze((EntityHollowBlaze)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityHollowBlaze)entity).getTexture()) {
            case 0: {
                return RenderHollowBlaze.texture2;
            }
            case 1: {
                return RenderHollowBlaze.texture3;
            }
            default: {
                return RenderHollowBlaze.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_blaze.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_blaze2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_blaze3.png");
    }
}

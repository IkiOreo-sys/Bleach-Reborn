package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import littlebreadloaf.bleachreborn.render.models.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderHollowOre extends RenderLiving
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    protected ModelHollowOre model;
    
    public RenderHollowOre(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelHollowOre)this.mainModel;
    }
    
    public void renderHollowOre(final EntityHollowOre par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderHollowOre((EntityHollowOre)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityHollowOre)entity).getTexture()) {
            case 0: {
                return RenderHollowOre.texture2;
            }
            case 1: {
                return RenderHollowOre.texture3;
            }
            default: {
                return RenderHollowOre.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_ore.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_ore2.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/hollow_ore3.png");
    }
}

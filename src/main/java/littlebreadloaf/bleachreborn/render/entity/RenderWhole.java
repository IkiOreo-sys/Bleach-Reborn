package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderWhole extends RenderBiped
{
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    private static final ResourceLocation texture10;
    protected ModelBiped model;
    
    public RenderWhole(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelBiped)this.mainModel;
    }
    
    public void renderWhole(final EntityWhole par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderWhole((EntityWhole)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        switch (((EntityWhole)entity).getTexture()) {
            case 0: {
                return RenderWhole.texture2;
            }
            case 1: {
                return RenderWhole.texture3;
            }
            case 2: {
                return RenderWhole.texture4;
            }
            case 3: {
                return RenderWhole.texture5;
            }
            case 4: {
                return RenderWhole.texture6;
            }
            case 5: {
                return RenderWhole.texture7;
            }
            case 6: {
                return RenderWhole.texture8;
            }
            case 7: {
                return RenderWhole.texture9;
            }
            case 8: {
                return RenderWhole.texture10;
            }
            default: {
                return RenderWhole.texture1;
            }
        }
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole.png");
        texture2 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole1.png");
        texture3 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole2.png");
        texture4 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole3.png");
        texture5 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole4.png");
        texture6 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole5.png");
        texture7 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole6.png");
        texture8 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole7.png");
        texture9 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole8.png");
        texture10 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/whole9.png");
    }
}

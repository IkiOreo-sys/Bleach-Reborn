package littlebreadloaf.bleachreborn.render.entity;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.client.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;

public class RenderOrihime extends RenderBiped
{
    private static final ResourceLocation texture1;
    protected ModelBiped model;
    
    public RenderOrihime(final ModelBiped par1ModelBiped, final float par2) {
        super(par1ModelBiped, par2);
        this.model = (ModelBiped)this.mainModel;
    }
    
    public void renderShinigami(final EntityOrihime par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        super.doRender((EntityLiving)par1, par2, par3, par4, par5, par6);
    }
    
    public void doRender(final Entity par1, final double par2, final double par3, final double par4, final float par5, final float par6) {
        this.renderShinigami((EntityOrihime)par1, par2, par3, par4, par5, par6);
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        return texture1;
    }
    
    static {
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/orihime.png");
    }
}

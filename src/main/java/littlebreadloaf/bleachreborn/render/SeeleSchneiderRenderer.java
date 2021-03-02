package littlebreadloaf.bleachreborn.render;

import net.minecraftforge.client.*;
import net.minecraft.util.*;
import net.minecraftforge.client.model.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.client.*;

public class SeeleSchneiderRenderer implements IItemRenderer
{
    public IModelCustom model;
    public IModelCustom blade;
    private ResourceLocation TEXTURE_SEELESCHNEIDER;
    private ResourceLocation TEXTURE_MODEL;
    private ResourceLocation TEXTURE_BLADE;
    
    public SeeleSchneiderRenderer() {
        this.TEXTURE_SEELESCHNEIDER = new ResourceLocation("bleachreborn".toLowerCase() + ":models/SeeleSchneider_Bottom.png");
        this.TEXTURE_MODEL = new ResourceLocation("bleachreborn".toLowerCase() + ":models/SeeleSchneider.obj");
        this.TEXTURE_BLADE = new ResourceLocation("bleachreborn".toLowerCase() + ":models/SeeleSchneider_Blade.obj");
        this.model = AdvancedModelLoader.loadModel(this.TEXTURE_MODEL);
        this.blade = AdvancedModelLoader.loadModel(this.TEXTURE_BLADE);
    }
    
    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        return ExtendedPlayer.getIs3D();
    }
    
    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item, final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }
    
    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        GL11.glPushMatrix();
        GL11.glDisable(2896);
        switch (type) {
            case ENTITY: {
                final float scale = 0.01f;
                GL11.glScalef(0.01f, 0.01f, 0.01f);
                break;
            }
            case EQUIPPED: {
                GL11.glRotatef(135.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(110.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(180.0f, 1.0f, 0.0f, 0.0f);
                GL11.glTranslated(1.0, -2.200000047683716, 0.0);
                final float scale = 0.025f;
                GL11.glScalef(0.025f, 0.025f, 0.025f);
                break;
            }
            case INVENTORY: {
                GL11.glTranslated(1.5, 0.0, 0.5);
                GL11.glRotatef(45.0f, 1.0f, 0.0f, 1.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
                float scale;
                if (item.getItemDamage() == 0) {
                    scale = 0.022f;
                }
                else {
                    scale = 0.008f;
                }
                GL11.glScalef(scale, scale, scale);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glTranslated(-0.5, -0.4000000059604645, 0.6000000238418579);
                GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslated(0.30000001192092896, 0.800000011920929, -0.10000000149011612);
                GL11.glRotatef(186.0f, 0.0f, 1.0f, 0.0f);
                final float scale = 0.01f;
                GL11.glScalef(0.01f, 0.01f, 0.01f);
                break;
            }
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.getTextureForItem(item));
        if (item.getItemDamage() == 1) {
            this.blade.renderAll();
        }
        this.getModelForItem(item).renderAll();
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
    
    private ResourceLocation getTextureForItem(final ItemStack item) {
        return this.TEXTURE_SEELESCHNEIDER;
    }
    
    private IModelCustom getModelForItem(final ItemStack item) {
        return this.model;
    }
}

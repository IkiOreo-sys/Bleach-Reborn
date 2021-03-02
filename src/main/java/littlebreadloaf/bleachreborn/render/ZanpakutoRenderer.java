package littlebreadloaf.bleachreborn.render;

import net.minecraftforge.client.*;
import net.minecraft.util.*;
import net.minecraftforge.client.model.*;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.events.*;
import org.lwjgl.opengl.*;
import cpw.mods.fml.client.*;

public class ZanpakutoRenderer implements IItemRenderer
{
    public IModelCustom zanpakuto1;
    private ResourceLocation TEXTURE_ZANPAKUTO_1;
    private ResourceLocation TEXTURE_SWORD;
    
    public ZanpakutoRenderer() {
        this.TEXTURE_ZANPAKUTO_1 = new ResourceLocation("bleachreborn".toLowerCase() + ":models/Zanpakuto.png");
        this.TEXTURE_SWORD = new ResourceLocation("bleachreborn".toLowerCase() + ":models/Zanpakuto.obj");
        if (this.TEXTURE_SWORD != null) {
            this.zanpakuto1 = AdvancedModelLoader.loadModel(this.TEXTURE_SWORD);
        }
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
                final float scale = 0.15f;
                GL11.glScalef(0.15f, 0.15f, 0.15f);
                break;
            }
            case EQUIPPED: {
                GL11.glTranslated(1.2000000476837158, 0.5, 1.2000000476837158);
                GL11.glRotatef(0.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-55.0f, 1.0f, 0.0f, 0.0f);
                final float scale = 0.3f;
                GL11.glScalef(0.3f, 0.3f, 0.3f);
                break;
            }
            case INVENTORY: {
                GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
                final float scale = 0.14f;
                GL11.glScalef(0.14f, 0.14f, 0.14f);
                GL11.glTranslated(0.0, -7.400000095367432, 0.0);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glTranslated(-0.5, 0.0, 0.30000001192092896);
                GL11.glRotatef(-45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glTranslated(0.30000001192092896, 0.800000011920929, -0.10000000149011612);
                GL11.glRotatef(186.0f, 0.0f, 1.0f, 0.0f);
                final float scale = 0.12f;
                GL11.glScalef(0.12f, 0.12f, 0.12f);
                break;
            }
        }
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.getTextureForItem(item));
        this.getModelForItem(item).renderAll();
        GL11.glEnable(2896);
        GL11.glPopMatrix();
    }
    
    private ResourceLocation getTextureForItem(final ItemStack item) {
        return this.TEXTURE_ZANPAKUTO_1;
    }
    
    private IModelCustom getModelForItem(final ItemStack item) {
        return this.zanpakuto1;
    }
}

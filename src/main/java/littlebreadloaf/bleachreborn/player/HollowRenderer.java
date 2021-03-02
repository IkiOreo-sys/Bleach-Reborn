package littlebreadloaf.bleachreborn.player;

import littlebreadloaf.bleachreborn.ConfigHandler;
import littlebreadloaf.bleachreborn.player.models.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.*;
import littlebreadloaf.bleachreborn.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraftforge.common.*;
import net.minecraftforge.client.event.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import net.minecraftforge.client.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import java.util.*;
import com.mojang.authlib.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.client.model.*;

public class HollowRenderer extends RenderPlayer
{
    private static final ResourceLocation texture1_overlay;
    private static final ResourceLocation texture1;
    protected ModelPlayerHollow model;
    public static final float[][] colorTable;
    private ModelBase oldModel;
    private ModelBiped oldMain;
    private ModelBiped oldChestplate;
    private ModelBiped oldArmor;
    private ModelBase oldRenderPass;
    private ModelBase trueModel;
    private ModelBiped trueChestplate;
    private ModelBiped trueArmor;
    private ModelBase trueRenderPass;
    
    public HollowRenderer() {
        this.oldModel = super.mainModel;
        this.mainModel = trueModel = (ModelBase)new ModelPlayerHollow();
        this.oldMain = super.modelBipedMain;
        this.modelBipedMain = (ModelBiped)this.mainModel;
        this.oldChestplate = super.modelArmorChestplate;
        this.modelArmorChestplate = trueChestplate = new ModelBiped(1.0f);
        this.oldArmor = super.modelArmor;
        this.modelArmor = trueArmor = new ModelBiped(0.5f);
        this.renderManager = RenderManager.instance;
        this.oldRenderPass = super.renderPassModel;
        this.renderPassModel = this.trueRenderPass = this.mainModel;
    }
    
    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (!(entity instanceof AbstractClientPlayer)) {
            return null;
        }
        final AbstractClientPlayer player = (AbstractClientPlayer)entity;
        if(!isRenderable(player))
            return player.getLocationSkin();
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)player);
        if (props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) {
            return HollowRenderer.texture1;
        }
        return player.getLocationSkin();
    }
    
    protected int shouldRenderPass(final EntityLivingBase entity, final int par2, final float par3) {
        if (!(entity instanceof AbstractClientPlayer)) {
            return -1;
        }
        final AbstractClientPlayer player = (AbstractClientPlayer)entity;
        if(!isRenderable(player))
            return super.shouldRenderPass(entity, par2, par3);
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)player);
        if (props.getFaction() != 3 && props.getFaction() != 7 && props.getFaction() != 8) {
            return super.shouldRenderPass(player, par2, par3);
        }
        if (par2 != 0) {
            return -1;
        }
        final int blug = props.getHColor();
        this.bindTexture(HollowRenderer.texture1_overlay);
        GL11.glColor3f(HollowRenderer.colorTable[blug][0], HollowRenderer.colorTable[blug][1], HollowRenderer.colorTable[blug][2]);
        return 1;
    }
    
    private boolean isRenderable(Entity entity) {
        if(!(entity instanceof EntityPlayer))
            return false;
        EntityPlayer p = (EntityPlayer) entity;
        final ExtendedPlayer props = ExtendedPlayer.get(p);
        if(Minecraft.getMinecraft().thePlayer.getDisplayName().equals(p.getDisplayName())) {
            boolean b = ConfigHandler.renderHollow;
            int faction = props.getFaction();
            if(faction != 3 && faction != 7 && faction != 8)
                b = false;
            if(!b) {
                this.mainModel = this.oldModel;
                this.modelBipedMain = this.oldMain;
                this.modelArmorChestplate = this.oldChestplate;
                this.modelArmor = this.oldArmor;
                this.renderPassModel = this.oldRenderPass;
            } else {
                this.mainModel = this.trueModel;
                this.modelArmorChestplate = this.trueChestplate;
                this.modelBipedMain = (ModelBiped) mainModel;
                this.modelArmor = this.trueArmor;
                this.renderPassModel = this.trueRenderPass;
            }
            return b;
        } else {
            if(ConfigHandler.renderHollowMap.containsKey(p.getUniqueID().getMostSignificantBits())) {
                boolean b = ConfigHandler.renderHollowMap.get(p.getUniqueID().getMostSignificantBits());
                int faction = props.getFaction();
                if(faction != 3 && faction != 7 && faction != 8)
                    b = false;
                if(!b) {
                    this.mainModel = this.oldModel;
                    this.modelBipedMain = this.oldMain;
                    this.modelArmorChestplate = this.oldChestplate;
                    this.modelArmor = this.oldArmor;
                    this.renderPassModel = this.oldRenderPass;
                } else {
                    this.mainModel = this.trueModel;
                    this.modelArmorChestplate = this.trueChestplate;
                    this.modelBipedMain = (ModelBiped) mainModel;
                    this.modelArmor = this.trueArmor;
                    this.renderPassModel = this.trueRenderPass;
                }
            }
        }
        return true;
    }
    protected void func_82408_c(final AbstractClientPlayer par1AbstractClientPlayer, final int par2, final float par3) {
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)par1AbstractClientPlayer);
        if (props.getFaction() != 3 && props.getFaction() != 7 && props.getFaction() != 8 || !isRenderable(par1AbstractClientPlayer)) {
            super.func_82408_c(par1AbstractClientPlayer, par2, par3);
        }
    }
    
    public void doRender(final AbstractClientPlayer par1AbstractClientPlayer, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if(!isRenderable(par1AbstractClientPlayer)) {
            super.doRender(par1AbstractClientPlayer, par2, par4, par6, par8, par9);
            return;
        }
        final ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer)par1AbstractClientPlayer);
        if (props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) {
            this.mainModel = (ModelBase)new ModelPlayerHollow();
            this.modelBipedMain = new ModelPlayerHollow();
        } else {
            this.modelBipedMain = new ModelBiped();
            this.mainModel = (ModelBase)new ModelBiped();
        }
        super.doRender(par1AbstractClientPlayer, par2, par4, par6, par8, par9);
        if (MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Pre((EntityPlayer)par1AbstractClientPlayer, (RenderPlayer)this, par9))) {
            return;
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        final ItemStack itemstack = par1AbstractClientPlayer.inventory.getCurrentItem();
        final ModelBiped modelBipedMain = this.modelBipedMain;
        final ModelBiped modelArmorChestplate = this.modelArmorChestplate;
        final ModelBiped modelArmor = this.modelArmor;
        final boolean b;
        final boolean heldItemRight = b = (itemstack != null);
        modelArmor.heldItemRight = (b ? 1 : 0);
        modelArmorChestplate.heldItemRight = (b ? 1 : 0);
        modelBipedMain.heldItemRight = (heldItemRight ? 1 : 0);
        if (itemstack != null && par1AbstractClientPlayer.getItemInUseCount() > 0) {
            final EnumAction enumaction = itemstack.getItemUseAction();
            if (enumaction == EnumAction.block) {
                final ModelBiped modelBipedMain2 = this.modelBipedMain;
                final ModelBiped modelArmorChestplate2 = this.modelArmorChestplate;
                final ModelBiped modelArmor2 = this.modelArmor;
                final int heldItemRight2 = 3;
                modelArmor2.heldItemRight = 3;
                modelArmorChestplate2.heldItemRight = 3;
                modelBipedMain2.heldItemRight = 3;
            }
            else if (enumaction == EnumAction.bow) {
                final ModelBiped modelBipedMain3 = this.modelBipedMain;
                final ModelBiped modelArmorChestplate3 = this.modelArmorChestplate;
                final ModelBiped modelArmor3 = this.modelArmor;
                final boolean aimedBow = true;
                modelArmor3.aimedBow = true;
                modelArmorChestplate3.aimedBow = true;
                modelBipedMain3.aimedBow = true;
            }
        }
        final ModelBiped modelBipedMain4 = this.modelBipedMain;
        final ModelBiped modelArmorChestplate4 = this.modelArmorChestplate;
        final ModelBiped modelArmor4 = this.modelArmor;
        final boolean sneaking = par1AbstractClientPlayer.isSneaking();
        modelArmor4.isSneak = sneaking;
        modelArmorChestplate4.isSneak = sneaking;
        modelBipedMain4.isSneak = sneaking;
        double d3 = par4 - par1AbstractClientPlayer.yOffset;
        if (par1AbstractClientPlayer.isSneaking() && !(par1AbstractClientPlayer instanceof EntityPlayerSP)) {
            d3 -= 0.125;
        }
        final ModelBiped modelBipedMain5 = this.modelBipedMain;
        final ModelBiped modelArmorChestplate5 = this.modelArmorChestplate;
        final ModelBiped modelArmor5 = this.modelArmor;
        final boolean aimedBow2 = false;
        modelArmor5.aimedBow = false;
        modelArmorChestplate5.aimedBow = false;
        modelBipedMain5.aimedBow = false;
        final ModelBiped modelBipedMain6 = this.modelBipedMain;
        final ModelBiped modelArmorChestplate6 = this.modelArmorChestplate;
        final ModelBiped modelArmor6 = this.modelArmor;
        final boolean isSneak = false;
        modelArmor6.isSneak = false;
        modelArmorChestplate6.isSneak = false;
        modelBipedMain6.isSneak = false;
        final ModelBiped modelBipedMain7 = this.modelBipedMain;
        final ModelBiped modelArmorChestplate7 = this.modelArmorChestplate;
        final ModelBiped modelArmor7 = this.modelArmor;
        final boolean heldItemRight3 = false;
        modelArmor7.heldItemRight = 0;
        modelArmorChestplate7.heldItemRight = 0;
        modelBipedMain7.heldItemRight = 0;
        MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Post((EntityPlayer)par1AbstractClientPlayer, (RenderPlayer)this, par9));
    }
    
    protected void preRenderCallback(final AbstractClientPlayer par1AbstractClientPlayer, final float par2) {
        if(!isRenderable(par1AbstractClientPlayer)) {
            super.preRenderCallback(par1AbstractClientPlayer, par2);
            return;
        }
        final float f1 = 0.9375f;
        GL11.glScalef(0.9375f, 0.9375f, 0.9375f);
    }
    
    protected void func_96449_a(final AbstractClientPlayer par1AbstractClientPlayer, final double par2, final double par4, final double par6, final String par8Str, final float par9, final double par10) {
        super.func_96449_a(par1AbstractClientPlayer, par2, par4, par6, par8Str, par9, par10);
    }
    
    public void renderFirstPersonArm(final EntityPlayer par1EntityPlayer) {
        super.renderFirstPersonArm(par1EntityPlayer);
    }
    
    public void doRender(final EntityLivingBase par1EntityLivingBase, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if(!isRenderable((AbstractClientPlayer)par1EntityLivingBase)) {
            super.doRender(par1EntityLivingBase, par2, par4, par6, par8, par9);
            return;
        }
        this.doRender((AbstractClientPlayer)par1EntityLivingBase, par2, par4, par6, par8, par9);
    }
    
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        if(!isRenderable(par1Entity)) {
            this.mainModel = super.mainModel;
            super.doRender(par1Entity, par2, par4, par6, par8, par9);
            return;
        }
        this.doRender((EntityLivingBase)par1Entity, par2, par4, par6, par8, par9);
    }
    
    protected void renderEquippedItems(final AbstractClientPlayer par1AbstractClientPlayer, final float par2) {
        if(!isRenderable(par1AbstractClientPlayer)) {
            super.renderEquippedItems(par1AbstractClientPlayer, par2);
            return;
        }
        final RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre((EntityPlayer)par1AbstractClientPlayer, (RenderPlayer)this, par2);
        if (MinecraftForge.EVENT_BUS.post((Event)event)) {
            return;
        }
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        super.renderEquippedItems(par1AbstractClientPlayer, par2);
        super.renderArrowsStuckInEntity((EntityLivingBase)par1AbstractClientPlayer, par2);
        final ItemStack itemstack = par1AbstractClientPlayer.inventory.armorItemInSlot(3);
        if (itemstack != null && event.renderHelmet) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedHead.postRender(0.0625f);
            if (itemstack.getItem() instanceof ItemBlock) {
                final IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
                final boolean is3D = customRenderer != null && customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D);
                if (is3D || RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack.getItem()).getRenderType())) {
                    final float f1 = 0.625f;
                    GL11.glTranslatef(0.0f, -0.25f, 0.0f);
                    GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glScalef(0.625f, -0.625f, -0.625f);
                }
                this.renderManager.itemRenderer.renderItem((EntityLivingBase)par1AbstractClientPlayer, itemstack, 0);
            }
            else if (itemstack.getItem() == Items.skull) {
                final float f2 = 1.0625f;
                GL11.glScalef(1.0625f, -1.0625f, -1.0625f);
                GameProfile gameprofile = null;
                if (itemstack.hasTagCompound()) {
                    final NBTTagCompound nbttagcompound = itemstack.getTagCompound();
                    if (nbttagcompound.hasKey("SkullOwner", 10)) {
                        gameprofile = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("SkullOwner"));
                    }
                    else if (nbttagcompound.hasKey("SkullOwner", 8) && !StringUtils.isNullOrEmpty(nbttagcompound.getString("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID)null, nbttagcompound.getString("SkullOwner"));
                    }
                }
                TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5f, 0.0f, -0.5f, 1, 180.0f, itemstack.getItemDamage(), gameprofile);
            }
            GL11.glPopMatrix();
        }
        if (par1AbstractClientPlayer.getCommandSenderName().equals("deadmau5") && par1AbstractClientPlayer.func_152123_o()) {
            this.bindTexture(par1AbstractClientPlayer.getLocationSkin());
            for (int j = 0; j < 2; ++j) {
                final float f3 = par1AbstractClientPlayer.prevRotationYaw + (par1AbstractClientPlayer.rotationYaw - par1AbstractClientPlayer.prevRotationYaw) * par2 - (par1AbstractClientPlayer.prevRenderYawOffset + (par1AbstractClientPlayer.renderYawOffset - par1AbstractClientPlayer.prevRenderYawOffset) * par2);
                final float f4 = par1AbstractClientPlayer.prevRotationPitch + (par1AbstractClientPlayer.rotationPitch - par1AbstractClientPlayer.prevRotationPitch) * par2;
                GL11.glPushMatrix();
                GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
                GL11.glTranslatef(0.375f * (j * 2 - 1), 0.0f, 0.0f);
                GL11.glTranslatef(0.0f, -0.375f, 0.0f);
                GL11.glRotatef(-f4, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(-f3, 0.0f, 1.0f, 0.0f);
                final float f5 = 1.3333334f;
                GL11.glScalef(1.3333334f, 1.3333334f, 1.3333334f);
                this.modelBipedMain.renderEars(0.0625f);
                GL11.glPopMatrix();
            }
        }
        boolean flag = par1AbstractClientPlayer.func_152122_n();
        flag = (event.renderCape && flag);
        if (flag && !par1AbstractClientPlayer.isInvisible() && !par1AbstractClientPlayer.getHideCape()) {
            this.bindTexture(par1AbstractClientPlayer.getLocationCape());
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, 0.0f, 0.125f);
            final double d3 = par1AbstractClientPlayer.field_71091_bM + (par1AbstractClientPlayer.field_71094_bP - par1AbstractClientPlayer.field_71091_bM) * par2 - (par1AbstractClientPlayer.prevPosX + (par1AbstractClientPlayer.posX - par1AbstractClientPlayer.prevPosX) * par2);
            final double d4 = par1AbstractClientPlayer.field_71096_bN + (par1AbstractClientPlayer.field_71095_bQ - par1AbstractClientPlayer.field_71096_bN) * par2 - (par1AbstractClientPlayer.prevPosY + (par1AbstractClientPlayer.posY - par1AbstractClientPlayer.prevPosY) * par2);
            final double d5 = par1AbstractClientPlayer.field_71097_bO + (par1AbstractClientPlayer.field_71085_bR - par1AbstractClientPlayer.field_71097_bO) * par2 - (par1AbstractClientPlayer.prevPosZ + (par1AbstractClientPlayer.posZ - par1AbstractClientPlayer.prevPosZ) * par2);
            final float f6 = par1AbstractClientPlayer.prevRenderYawOffset + (par1AbstractClientPlayer.renderYawOffset - par1AbstractClientPlayer.prevRenderYawOffset) * par2;
            final double d6 = MathHelper.sin(f6 * 3.1415927f / 180.0f);
            final double d7 = -MathHelper.cos(f6 * 3.1415927f / 180.0f);
            float f7 = (float)d4 * 10.0f;
            if (f7 < -6.0f) {
                f7 = -6.0f;
            }
            if (f7 > 32.0f) {
                f7 = 32.0f;
            }
            float f8 = (float)(d3 * d6 + d5 * d7) * 100.0f;
            final float f9 = (float)(d3 * d7 - d5 * d6) * 100.0f;
            if (f8 < 0.0f) {
                f8 = 0.0f;
            }
            final float f10 = par1AbstractClientPlayer.prevCameraYaw + (par1AbstractClientPlayer.cameraYaw - par1AbstractClientPlayer.prevCameraYaw) * par2;
            f7 += MathHelper.sin((par1AbstractClientPlayer.prevDistanceWalkedModified + (par1AbstractClientPlayer.distanceWalkedModified - par1AbstractClientPlayer.prevDistanceWalkedModified) * par2) * 6.0f) * 32.0f * f10;
            if (par1AbstractClientPlayer.isSneaking()) {
                f7 += 25.0f;
            }
            GL11.glRotatef(6.0f + f8 / 2.0f + f7, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f9 / 2.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(-f9 / 2.0f, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            this.modelBipedMain.renderCloak(0.0625f);
            GL11.glPopMatrix();
        }
        ItemStack itemstack2 = par1AbstractClientPlayer.inventory.getCurrentItem();
        if (itemstack2 != null && event.renderItem) {
            GL11.glPushMatrix();
            this.modelBipedMain.bipedRightArm.postRender(0.0625f);
            GL11.glTranslatef(-0.0625f, 0.4375f, 0.0625f);
            if (par1AbstractClientPlayer.fishEntity != null) {
                itemstack2 = new ItemStack(Items.stick);
            }
            EnumAction enumaction = null;
            if (par1AbstractClientPlayer.getItemInUseCount() > 0) {
                enumaction = itemstack2.getItemUseAction();
            }
            final IItemRenderer customRenderer2 = MinecraftForgeClient.getItemRenderer(itemstack2, IItemRenderer.ItemRenderType.EQUIPPED);
            final boolean is3D2 = customRenderer2 != null && customRenderer2.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack2, IItemRenderer.ItemRendererHelper.BLOCK_3D);
            if (is3D2 || (itemstack2.getItem() instanceof ItemBlock && RenderBlocks.renderItemIn3d(Block.getBlockFromItem(itemstack2.getItem()).getRenderType()))) {
                float f11 = 0.5f;
                GL11.glTranslatef(0.0f, 0.1875f, -0.3125f);
                f11 *= 0.75f;
                GL11.glRotatef(20.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-f11, -f11, f11);
            }
            else if (itemstack2.getItem() == Items.bow) {
                final float f11 = 0.625f;
                GL11.glTranslatef(0.0f, 0.125f, 0.3125f);
                GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(0.625f, -0.625f, 0.625f);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (itemstack2.getItem().isFull3D()) {
                final float f11 = 0.625f;
                if (itemstack2.getItem().shouldRotateAroundWhenRendering()) {
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glTranslatef(0.0f, -0.125f, 0.0f);
                }
                if (par1AbstractClientPlayer.getItemInUseCount() > 0 && enumaction == EnumAction.block) {
                    GL11.glTranslatef(0.05f, 0.0f, -0.1f);
                    GL11.glRotatef(-50.0f, 0.0f, 1.0f, 0.0f);
                    GL11.glRotatef(-10.0f, 1.0f, 0.0f, 0.0f);
                    GL11.glRotatef(-60.0f, 0.0f, 0.0f, 1.0f);
                }
                GL11.glTranslatef(0.0f, 0.1875f, 0.0f);
                GL11.glScalef(0.625f, -0.625f, 0.625f);
                GL11.glRotatef(-100.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(45.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                final float f11 = 0.375f;
                GL11.glTranslatef(0.25f, 0.1875f, -0.1875f);
                GL11.glScalef(0.375f, 0.375f, 0.375f);
                GL11.glRotatef(60.0f, 0.0f, 0.0f, 1.0f);
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(20.0f, 0.0f, 0.0f, 1.0f);
            }
            if (itemstack2.getItem().requiresMultipleRenderPasses()) {
                for (int k = 0; k < itemstack2.getItem().getRenderPasses(itemstack2.getItemDamage()); ++k) {
                    final int i = itemstack2.getItem().getColorFromItemStack(itemstack2, k);
                    final float f12 = (i >> 16 & 0xFF) / 255.0f;
                    final float f13 = (i >> 8 & 0xFF) / 255.0f;
                    final float f14 = (i & 0xFF) / 255.0f;
                    GL11.glColor4f(f12, f13, f14, 1.0f);
                    this.renderManager.itemRenderer.renderItem((EntityLivingBase)par1AbstractClientPlayer, itemstack2, k);
                }
            }
            else {
                final int k = itemstack2.getItem().getColorFromItemStack(itemstack2, 0);
                final float f15 = (k >> 16 & 0xFF) / 255.0f;
                final float f12 = (k >> 8 & 0xFF) / 255.0f;
                final float f13 = (k & 0xFF) / 255.0f;
                GL11.glColor4f(f15, f12, f13, 1.0f);
                this.renderManager.itemRenderer.renderItem((EntityLivingBase)par1AbstractClientPlayer, itemstack2, 0);
            }
            GL11.glPopMatrix();
        }
        MinecraftForge.EVENT_BUS.post((Event)new RenderPlayerEvent.Specials.Post((EntityPlayer)par1AbstractClientPlayer, (RenderPlayer)this, par2));
    }
    
    static {
        texture1_overlay = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/player_hollow_1_overlay.png");
        texture1 = new ResourceLocation("bleachreborn".toLowerCase() + ":textures/models/mobs/player_hollow_1.png");
        colorTable = new float[][] { { 1.0f, 1.0f, 1.0f }, { 0.85f, 0.5f, 0.2f }, { 0.7f, 0.3f, 0.85f }, { 0.4f, 0.6f, 0.85f }, { 0.9f, 0.9f, 0.2f }, { 0.5f, 0.8f, 0.1f }, { 0.95f, 0.5f, 0.65f }, { 0.3f, 0.3f, 0.3f }, { 0.6f, 0.6f, 0.6f }, { 0.3f, 0.5f, 0.6f }, { 0.5f, 0.25f, 0.7f }, { 0.2f, 0.3f, 0.7f }, { 0.4f, 0.3f, 0.2f }, { 0.4f, 0.5f, 0.2f }, { 0.6f, 0.2f, 0.2f }, { 0.1f, 0.1f, 0.1f } };
    }
}

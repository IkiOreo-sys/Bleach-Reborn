package littlebreadloaf.bleachreborn.world;

import net.minecraft.world.*;
import littlebreadloaf.bleachreborn.*;
import cpw.mods.fml.common.*;
import littlebreadloaf.bleachreborn.render.*;
import net.minecraftforge.client.*;
import net.minecraft.entity.*;
import cpw.mods.fml.relauncher.*;
import net.minecraft.util.*;
import net.minecraft.world.chunk.*;

public class HuecoMundoWorldProvider extends WorldProvider
{
    public void registerWorldChunkManager() {
        this.dimensionId = BleachIds.worldHuecoMundoID;
        this.worldChunkMgr = new HuecoMundoChunkManager(this.worldObj);
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            this.setSkyRenderer((IRenderHandler)new SkyRendererHuecoMundo());
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(final Entity cameraEntity, final float partialTicks) {
        return Vec3.createVectorHelper(0.1, 0.1, 0.1);
    }
    
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(final float par1, final float par2) {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public float calculateCelestialAngle(final long par1, final float par3) {
        final int j = (int)(par1 % 24000L);
        float f1 = (j + par3) / 24000.0f - 0.25f;
        if (f1 < 0.0f) {
            ++f1;
        }
        if (f1 > 1.0f) {
            --f1;
        }
        final float f2 = f1;
        f1 = 1.0f - (float)((Math.cos(f1 * 3.141592653589793) + 1.0) / 2.0);
        f1 = f2 + (f1 - f2) / 3.0f;
        return f1;
    }
    
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(final float par1, final float par2) {
        float f2 = MathHelper.cos(par1 * 3.1415927f * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = 0.7529412f;
        float f4 = 0.84705883f;
        float f5 = 1.0f;
        f3 *= f2 * 0.94f + 0.06f;
        f4 *= f2 * 0.94f + 0.06f;
        f5 *= f2 * 0.91f + 0.09f;
        return Vec3.createVectorHelper((double)f3, (double)f4, (double)f5);
    }
    
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(final int par1, final int par2) {
        return false;
    }
    
    public IChunkProvider createChunkGenerator() {
        return (IChunkProvider)new HuecoMundoChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
    }
    
    public boolean isDaytime() {
        return false;
    }
    
    public int getActualHeight() {
        return 256;
    }
    
    public boolean canDoLightning(final Chunk chunk) {
        return false;
    }
    
    public void generateLightBrightnessTable() {
        final float f = 0.005f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.lightBrightnessTable[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * 0.995f + 0.005f;
        }
    }
    
    public boolean canDoRainSnowIce(final Chunk chunk) {
        return false;
    }
    
    public String getDimensionName() {
        return "Hueco Mundo";
    }
}

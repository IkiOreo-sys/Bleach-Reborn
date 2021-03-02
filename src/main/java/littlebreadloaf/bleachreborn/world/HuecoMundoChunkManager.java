package littlebreadloaf.bleachreborn.world;

import net.minecraft.world.biome.*;
import littlebreadloaf.bleachreborn.world.biomes.*;
import net.minecraft.world.gen.layer.*;
import cpw.mods.fml.relauncher.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;

public class HuecoMundoChunkManager extends WorldChunkManager
{
    public BiomeGenBase[] huecoMundoBiomes;
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;
    
    protected HuecoMundoChunkManager() {
        this.huecoMundoBiomes = new BiomeGenBase[] { BleachBiomes.HuecoMundo };
        HuecoMundoChunkManager.allowedBiomes.clear();
        HuecoMundoChunkManager.allowedBiomes.add(BleachBiomes.HuecoMundo);
        this.biomeCache = new BiomeCache((WorldChunkManager)this);
        (this.biomesToSpawnIn = new ArrayList()).addAll(HuecoMundoChunkManager.allowedBiomes);
    }
    
    public HuecoMundoChunkManager(final long seed, final WorldType worldType) {
        this();
        GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(seed, worldType);
        agenlayer = this.getModdedBiomeGenerators(worldType, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }
    
    public HuecoMundoChunkManager(final World world) {
        this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }
    
    public List getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }
    
    public BiomeGenBase getBiomeGenAt(final int par1, final int par2) {
        return this.biomeCache.getBiomeGenAt(par1, par2);
    }
    
    public float[] getRainfall(float[] par1ArrayOfFloat, final int par2, final int par3, final int par4, final int par5) {
        IntCache.resetIntCache();
        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }
        final int[] aint = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
        for (int i1 = 0; i1 < par4 * par5; ++i1) {
            float f = this.huecoMundoBiomes[aint[i1] % this.huecoMundoBiomes.length].getIntRainfall() / 65536.0f;
            if (f > 1.0f) {
                f = 1.0f;
            }
            par1ArrayOfFloat[i1] = f;
        }
        return par1ArrayOfFloat;
    }
    
    @SideOnly(Side.CLIENT)
    public float getTemperatureAtHeight(final float par1, final int par2) {
        return par1;
    }
    
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        IntCache.resetIntCache();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        final int[] aint = this.genBiomes.getInts(par2, par3, par4, par5);
        for (int i1 = 0; i1 < par4 * par5; ++i1) {
            par1ArrayOfBiomeGenBase[i1] = this.huecoMundoBiomes[aint[i1] % this.huecoMundoBiomes.length];
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public BiomeGenBase[] loadBlockGeneratorData(final BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5) {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }
    
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, final int par2, final int par3, final int par4, final int par5, final boolean par6) {
        IntCache.resetIntCache();
        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }
        if (par6 && par4 == 16 && par5 == 16 && (par2 & 0xF) == 0x0 && (par3 & 0xF) == 0x0) {
            final BiomeGenBase[] abiomegenbase1 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(abiomegenbase1, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        final int[] aint = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
        for (int i1 = 0; i1 < par4 * par5; ++i1) {
            par1ArrayOfBiomeGenBase[i1] = this.huecoMundoBiomes[aint[i1] % this.huecoMundoBiomes.length];
        }
        return par1ArrayOfBiomeGenBase;
    }
    
    public boolean areBiomesViable(final int par1, final int par2, final int par3, final List par4List) {
        IntCache.resetIntCache();
        final int l = par1 - par3 >> 2;
        final int i1 = par2 - par3 >> 2;
        final int j1 = par1 + par3 >> 2;
        final int k1 = par2 + par3 >> 2;
        final int l2 = j1 - l + 1;
        final int i2 = k1 - i1 + 1;
        final int[] aint = this.genBiomes.getInts(l, i1, l2, i2);
        for (int j2 = 0; j2 < l2 * i2; ++j2) {
            final BiomeGenBase biomegenbase = this.huecoMundoBiomes[aint[j2] % this.huecoMundoBiomes.length];
            if (!par4List.contains(biomegenbase)) {
                return false;
            }
        }
        return true;
    }
    
    public ChunkPosition findBiomePosition(final int par1, final int par2, final int par3, final List par4List, final Random par5Random) {
        IntCache.resetIntCache();
        final int l = par1 - par3 >> 2;
        final int i1 = par2 - par3 >> 2;
        final int j1 = par1 + par3 >> 2;
        final int k1 = par2 + par3 >> 2;
        final int l2 = j1 - l + 1;
        final int i2 = k1 - i1 + 1;
        final int[] aint = this.genBiomes.getInts(l, i1, l2, i2);
        ChunkPosition chunkposition = null;
        int j2 = 0;
        for (int k2 = 0; k2 < l2 * i2; ++k2) {
            final int l3 = l + k2 % l2 << 2;
            final int i3 = i1 + k2 / l2 << 2;
            final BiomeGenBase biomegenbase = this.huecoMundoBiomes[aint[k2] % this.huecoMundoBiomes.length];
            if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(j2 + 1) == 0)) {
                chunkposition = new ChunkPosition(l3, 0, i3);
                ++j2;
            }
        }
        return chunkposition;
    }
    
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
    
    public GenLayer[] getModdedBiomeGenerators(final WorldType worldType, final long seed, final GenLayer[] original) {
        final WorldTypeEvent.InitBiomeGens event = new WorldTypeEvent.InitBiomeGens(worldType, seed, original);
        MinecraftForge.TERRAIN_GEN_BUS.post((Event)event);
        return event.newBiomeGens;
    }
}

package littlebreadloaf.bleachreborn.world;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import littlebreadloaf.bleachreborn.blocks.*;
import net.minecraft.init.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.eventhandler.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;
import net.minecraftforge.event.terraingen.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.world.*;

public class HuecoMundoChunkProvider implements IChunkProvider
{
    private Random rand;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private double[] noiseArray;
    private double[] stoneNoise;
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] parabolicField;
    int[][] field_73219_j;
    
    public HuecoMundoChunkProvider(final World world, final long seed, final boolean features) {
        this.stoneNoise = new double[256];
        this.field_73219_j = new int[32][32];
        this.worldObj = world;
        this.rand = new Random(seed);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        NoiseGeneratorOctaves[] noiseGens = { this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noiseGen4, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise };
        noiseGens = (NoiseGeneratorOctaves[])TerrainGen.getModdedNoiseGenerators(world, this.rand, (NoiseGenerator[])noiseGens);
        this.noiseGen1 = noiseGens[0];
        this.noiseGen2 = noiseGens[1];
        this.noiseGen3 = noiseGens[2];
        this.noiseGen4 = noiseGens[3];
        this.noiseGen5 = noiseGens[4];
        this.noiseGen6 = noiseGens[5];
        this.mobSpawnerNoise = noiseGens[6];
    }
    
    public void generateTerrain(final int par1, final int par2, final Block[] chunk) {
        final byte miniChunk = 4;
        final byte chunkSize = 16;
        final byte seeLevel = 59;
        final int k = 5;
        final byte b3 = 17;
        final int l = 5;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
        this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * 4, 0, par2 * 4, 5, 17, 5);
        for (int x = 0; x < 4; ++x) {
            for (int z = 0; z < 4; ++z) {
                for (int y = 0; y < 16; ++y) {
                    final double d0 = 0.125;
                    double d2 = this.noiseArray[((x + 0) * 5 + z + 0) * 17 + y + 0];
                    double d3 = this.noiseArray[((x + 0) * 5 + z + 1) * 17 + y + 0];
                    double d4 = this.noiseArray[((x + 1) * 5 + z + 0) * 17 + y + 0];
                    double d5 = this.noiseArray[((x + 1) * 5 + z + 1) * 17 + y + 0];
                    final double d6 = (this.noiseArray[((x + 0) * 5 + z + 0) * 17 + y + 1] - d2) * 0.125;
                    final double d7 = (this.noiseArray[((x + 0) * 5 + z + 1) * 17 + y + 1] - d3) * 0.125;
                    final double d8 = (this.noiseArray[((x + 1) * 5 + z + 0) * 17 + y + 1] - d4) * 0.125;
                    final double d9 = (this.noiseArray[((x + 1) * 5 + z + 1) * 17 + y + 1] - d5) * 0.125;
                    for (int subY = 0; subY < 8; ++subY) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * 0.25;
                        final double d14 = (d5 - d3) * 0.25;
                        for (int subX = 0; subX < 4; ++subX) {
                            int j2 = subX + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + subY;
                            final short short1 = 128;
                            j2 -= 128;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * 0.25;
                            double d17 = d11 - d16;
                            for (int subZ = 0; subZ < 4; ++subZ) {
                                if ((d17 += d16) > 0.0 && y * 8 + subY >= 59) {
                                    j2 += 128;
                                    chunk[j2] = BleachBlocks.whitesand;
                                }
                                else {
                                    j2 += 128;
                                    chunk[j2] = Blocks.air;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
        this.noiseArray = this.initializeNoiseFieldBottom(this.noiseArray, par1 * 4, 0, par2 * 4, 5, 17, 5);
        for (int x = 0; x < 4; ++x) {
            for (int z = 0; z < 4; ++z) {
                for (int y = 0; y < 16; ++y) {
                    final double d0 = 0.125;
                    double d2 = this.noiseArray[((x + 0) * 5 + z + 0) * 17 + y + 0];
                    double d3 = this.noiseArray[((x + 0) * 5 + z + 1) * 17 + y + 0];
                    double d4 = this.noiseArray[((x + 1) * 5 + z + 0) * 17 + y + 0];
                    double d5 = this.noiseArray[((x + 1) * 5 + z + 1) * 17 + y + 0];
                    final double d6 = (this.noiseArray[((x + 0) * 5 + z + 0) * 17 + y + 1] - d2) * 0.125;
                    final double d7 = (this.noiseArray[((x + 0) * 5 + z + 1) * 17 + y + 1] - d3) * 0.125;
                    final double d8 = (this.noiseArray[((x + 1) * 5 + z + 0) * 17 + y + 1] - d4) * 0.125;
                    final double d9 = (this.noiseArray[((x + 1) * 5 + z + 1) * 17 + y + 1] - d5) * 0.125;
                    for (int subY = 0; subY < 8; ++subY) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * 0.25;
                        final double d14 = (d5 - d3) * 0.25;
                        for (int subX = 0; subX < 4; ++subX) {
                            int j2 = subX + x * 4 << 11 | 0 + z * 4 << 7 | y * 8 + subY;
                            final short short1 = 128;
                            j2 -= 128;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * 0.25;
                            double d17 = d11 - d16;
                            for (int subZ = 0; subZ < 4; ++subZ) {
                                if ((d17 += d16) < -25.0 && y * 8 + subY <= 33) {
                                    j2 += 128;
                                    chunk[j2] = Blocks.stone;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }
    
    public void replaceBlocksForBiome(final int par1, final int par2, final Block[] blocks, final BiomeGenBase[] biomeArray) {
        final ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks((IChunkProvider)this, par1, par2, blocks, biomeArray);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return;
        }
        final byte oceanLevel = 30;
        final double d0 = 0.03125;
        this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, 0.0625, 0.0625, 0.0625);
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                final BiomeGenBase biomegenbase = biomeArray[z + x * 16];
                final int i1 = (int)(this.stoneNoise[x + z * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                int j1 = -1;
                Block b1 = biomegenbase.topBlock;
                Block b2 = biomegenbase.fillerBlock;
                for (int y = 127; y >= 0; --y) {
                    final int index = (z * 16 + x) * 128 + y;
                    if (y <= 0) {
                        blocks[index] = Blocks.bedrock;
                    }
                    else {
                        final Block b3 = blocks[index];
                        if (b3 == Blocks.air) {
                            j1 = -1;
                        }
                        else if (b3 == Blocks.stone) {
                            if (j1 == -1) {
                                if (i1 <= 0) {
                                    b1 = Blocks.air;
                                    b2 = Blocks.stone;
                                }
                                else if (y >= 26 && y <= 31) {
                                    b1 = biomegenbase.topBlock;
                                    b2 = biomegenbase.fillerBlock;
                                }
                                j1 = i1;
                                blocks[index] = b2;
                            }
                            else if (j1 > 0) {
                                --j1;
                                blocks[index] = b2;
                            }
                        }
                    }
                }
            }
        }
    }
    
    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }
    
    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[32768];
        this.generateTerrain(par1, par2, ablock);
        this.replaceBlocksForBiome(par1, par2, ablock, this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16));
        final Chunk chunk = new Chunk(this.worldObj, ablock, par1, par2);
        final byte[] abyte1 = chunk.getBiomeArray();
        for (int k = 0; k < abyte1.length; ++k) {
            abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }
    
    private double[] initializeNoiseField(double[] par1ArrayOfDouble, final int par2, final int par3, final int par4, final int par5, final int par6, final int par7) {
        final ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((IChunkProvider)this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (par1ArrayOfDouble == null) {
            par1ArrayOfDouble = new double[par5 * par6 * par7];
        }
        if (this.parabolicField == null) {
            this.parabolicField = new float[25];
            for (int k1 = -2; k1 <= 2; ++k1) {
                for (int l1 = -2; l1 <= 2; ++l1) {
                    final float f = 10.0f / MathHelper.sqrt_float(k1 * k1 + l1 * l1 + 0.2f);
                    this.parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
                }
            }
        }
        final double d0 = 684.412;
        final double d2 = 684.412;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121, 1.121, 0.5);
        this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, 684.412, 684.412, 684.412);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, 684.412, 684.412, 684.412);
        final boolean flag = false;
        final boolean flag2 = false;
        int i2 = 0;
        int j2 = 0;
        for (int k2 = 0; k2 < par5; ++k2) {
            for (int l2 = 0; l2 < par7; ++l2) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                final byte b0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[k2 + 2 + (l2 + 2) * (par5 + 5)];
                for (int i3 = -2; i3 <= 2; ++i3) {
                    for (int j3 = -2; j3 <= 2; ++j3) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[k2 + i3 + 2 + (l2 + j3 + 2) * (par5 + 5)];
                        float f5 = this.parabolicField[i3 + 2 + (j3 + 2) * 5] / (biomegenbase2.rootHeight + 2.0f);
                        if (biomegenbase2.rootHeight > biomegenbase.rootHeight) {
                            f5 /= 2.0f;
                        }
                        f2 += biomegenbase2.rootHeight * f5;
                        f3 += biomegenbase2.rootHeight * f5;
                        f4 += f5;
                    }
                }
                f2 /= f4;
                f3 /= f4;
                f2 = f2 * 0.9f + 0.1f;
                f3 = (f3 * 4.0f - 1.0f) / 8.0f;
                double d3 = this.noise6[j2] / 8000.0;
                if (d3 < 0.0) {
                    d3 = -d3 * 0.3;
                }
                d3 = d3 * 3.0 - 2.0;
                if (d3 < 0.0) {
                    d3 /= 2.0;
                    if (d3 < -1.0) {
                        d3 = -1.0;
                    }
                    d3 /= 1.4;
                    d3 /= 2.0;
                }
                else {
                    if (d3 > 1.0) {
                        d3 = 1.0;
                    }
                    d3 /= 8.0;
                }
                ++j2;
                for (int k3 = 0; k3 < par6; ++k3) {
                    double d4 = f3;
                    final double d5 = f2;
                    d4 += d3 * 0.2;
                    d4 = d4 * par6 / 16.0;
                    final double d6 = par6 / 2.0 + d4 * 4.0;
                    double d7 = 0.0;
                    double d8 = (k3 - d6) * 12.0 * 128.0 / 128.0 / d5;
                    if (d8 < 0.0) {
                        d8 *= 4.0;
                    }
                    final double d9 = this.noise1[i2] / 512.0;
                    final double d10 = this.noise2[i2] / 512.0;
                    final double d11 = (this.noise3[i2] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    }
                    else if (d11 > 1.0) {
                        d7 = d10;
                    }
                    else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (k3 > par6 - 4) {
                        final double d12 = (k3 - (par6 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    par1ArrayOfDouble[i2] = d7;
                    ++i2;
                }
            }
        }
        return par1ArrayOfDouble;
    }
    
    private double[] initializeNoiseFieldBottom(double[] noiseField, final int par2, final int par3, final int par4, final int par5, final int par6, final int par7) {
        final ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField((IChunkProvider)this, noiseField, par2, par3, par4, par5, par6, par7);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.getResult() == Event.Result.DENY) {
            return event.noisefield;
        }
        if (noiseField == null) {
            noiseField = new double[par5 * par6 * par7];
        }
        if (this.parabolicField == null) {
            this.parabolicField = new float[25];
            for (int k1 = -2; k1 <= 2; ++k1) {
                for (int l1 = -2; l1 <= 2; ++l1) {
                    final float f = 10.0f / MathHelper.sqrt_float(k1 * k1 + l1 * l1 + 0.2f);
                    this.parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
                }
            }
        }
        final double d0 = 684.412;
        final double d2 = 684.412;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121, 1.121, 0.5);
        this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0, 200.0, 0.5);
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, 8.555150000000001, 4.277575000000001, 8.555150000000001);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, 684.412, 684.412, 684.412);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, 684.412, 684.412, 684.412);
        final boolean flag = false;
        final boolean flag2 = false;
        int i2 = 0;
        int j2 = 0;
        final float minHeight = -1.1f;
        final float maxHeight = -1.0f;
        for (int k2 = 0; k2 < par5; ++k2) {
            for (int l2 = 0; l2 < par7; ++l2) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                float f4 = 0.0f;
                final byte b0 = 2;
                for (int i3 = -2; i3 <= 2; ++i3) {
                    for (int j3 = -2; j3 <= 2; ++j3) {
                        final float f5 = this.parabolicField[i3 + 2 + (j3 + 2) * 5] / 0.9f;
                        f2 += -1.0f * f5;
                        f3 += -1.1f * f5;
                        f4 += f5;
                    }
                }
                f2 /= f4;
                f3 /= f4;
                f2 = f2 * 0.9f + 0.1f;
                f3 = (f3 * 4.0f - 1.0f) / 8.0f;
                double d3 = this.noise6[j2] / 8000.0;
                if (d3 < 0.0) {
                    d3 = -d3 * 0.3;
                }
                d3 = d3 * 3.0 - 2.0;
                if (d3 < 0.0) {
                    d3 /= 2.0;
                    if (d3 < -1.0) {
                        d3 = -1.0;
                    }
                    d3 /= 1.4;
                    d3 /= 2.0;
                }
                else {
                    if (d3 > 1.0) {
                        d3 = 1.0;
                    }
                    d3 /= 8.0;
                }
                ++j2;
                for (int k3 = 0; k3 < par6; ++k3) {
                    double d4 = f3;
                    final double d5 = f2;
                    d4 += d3 * 0.2;
                    d4 = d4 * par6 / 16.0;
                    final double d6 = par6 / 2.0 + d4 * 4.0;
                    double d7 = 0.0;
                    double d8 = (k3 - d6) * 12.0 * 128.0 / 128.0 / d5;
                    if (d8 < 0.0) {
                        d8 *= 4.0;
                    }
                    final double d9 = this.noise1[i2] / 512.0;
                    final double d10 = this.noise2[i2] / 512.0;
                    final double d11 = (this.noise3[i2] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    }
                    else if (d11 > 1.0) {
                        d7 = d10;
                    }
                    else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (k3 > par6 - 4) {
                        final double d12 = (k3 - (par6 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    noiseField[i2] = d7;
                    ++i2;
                }
            }
        }
        return noiseField;
    }
    
    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }
    
    public void populate(final IChunkProvider par1IChunkProvider, final int chunkX, final int chunkZ) {
        BlockSand.fallInstantly = true;
        final int k = chunkX * 16;
        final int l = chunkZ * 16;
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * i1 + chunkZ * j1 ^ this.worldObj.getSeed());
        final boolean flag = false;
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, false));
        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, chunkX, chunkZ, false));
        BlockSand.fallInstantly = false;
    }
    
    public boolean saveChunks(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }
    
    public void saveExtraData() {
    }
    
    public boolean unloadQueuedChunks() {
        return false;
    }
    
    public boolean canSave() {
        return true;
    }
    
    public String makeString() {
        return "HuecoMundoChunkProvider";
    }
    
    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3, final int par4) {
        return null;
    }
    
    public int getLoadedChunkCount() {
        return 0;
    }
    
    public void recreateStructures(final int par1, final int par2) {
    }
    
    public ChunkPosition func_147416_a(final World var1, final String var2, final int var3, final int var4, final int var5) {
        return null;
    }
}

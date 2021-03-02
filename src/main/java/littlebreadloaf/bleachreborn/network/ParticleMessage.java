package littlebreadloaf.bleachreborn.network;

import java.util.*;
import io.netty.buffer.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.extras.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;

public class ParticleMessage implements IMessage
{
    private int id;
    private double posx;
    private double posy;
    private double posz;
    Random rand;
    
    public ParticleMessage() {
        this.rand = new Random();
    }
    
    public ParticleMessage(final int id, final double x, final double y, final double z) {
        this.rand = new Random();
        this.id = id;
        this.posx = x;
        this.posy = y;
        this.posz = z;
    }
    
    public void fromBytes(final ByteBuf buf) {
        this.id = buf.readInt();
        this.posx = buf.readDouble();
        this.posy = buf.readDouble();
        this.posz = buf.readDouble();
    }
    
    public void toBytes(final ByteBuf buf) {
        buf.writeInt(this.id);
        buf.writeDouble(this.posx);
        buf.writeDouble(this.posy);
        buf.writeDouble(this.posz);
    }
    
    public static class Handler implements IMessageHandler<ParticleMessage, IMessage>
    {
        Random rand;
        
        public Handler() {
            this.rand = new Random();
        }
        
        public IMessage onMessage(final ParticleMessage message, final MessageContext ctx) {
            final EntityPlayer player = BleachMod.proxy.getPlayerFromMessage(ctx);
            if (message.id == 0) {
                ParticleEffects.spawnParticle("tensho", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.0, 0.0);
            }
            if (message.id == 1) {
                ParticleEffects.spawnParticle("poison", message.posx + this.rand.nextDouble() - this.rand.nextDouble(), message.posy + this.rand.nextDouble() - this.rand.nextDouble(), message.posz + this.rand.nextDouble() - this.rand.nextDouble(), 0.0, 0.0, 0.0);
            }
            if (message.id == 2) {
                final Block block = player.worldObj.getBlock((int)player.posX, (int)player.posY - 2, (int)player.posZ);
                if (block != Blocks.air) {
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(block) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                }
                else {
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.stone) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                }
            }
            if (message.id == 3) {
                ParticleEffects.spawnParticle("wind", message.posx, message.posy, message.posz, 0.0, 0.0, 0.0);
            }
            if (message.id == 4) {
                final double d0 = this.rand.nextGaussian() * 0.02;
                final double d2 = this.rand.nextGaussian() * 0.02;
                final double d3 = this.rand.nextGaussian() * 0.02;
                player.worldObj.spawnParticle("heart", message.posx + this.rand.nextFloat() * 2.0f, message.posy + 0.5 + this.rand.nextFloat(), message.posz + this.rand.nextFloat() * 2.0f, d0, d2, d3);
            }
            if (message.id == 5) {
                ParticleEffects.spawnParticle("spirit", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.0, 0.0);
                ParticleEffects.spawnParticle("spirit", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.0, 0.0);
                ParticleEffects.spawnParticle("spirit", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.0, 0.0);
            }
            if (message.id == 6) {
            	if (!player.worldObj.isRemote) {
	                player.worldObj.setBlockToAir((int)player.posX + 1, (int)player.posY - 2, (int)player.posZ);
	                player.worldObj.setBlockToAir((int)player.posX + 1, (int)player.posY - 2, (int)player.posZ + 1);
	                player.worldObj.setBlockToAir((int)player.posX + 1, (int)player.posY - 2, (int)player.posZ - 1);
	                player.worldObj.setBlockToAir((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ);
	                player.worldObj.setBlockToAir((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ + 1);
	                player.worldObj.setBlockToAir((int)player.posX - 1, (int)player.posY - 2, (int)player.posZ - 1);
	                player.worldObj.setBlockToAir((int)player.posX, (int)player.posY - 2, (int)player.posZ + 1);
	                player.worldObj.setBlockToAir((int)player.posX, (int)player.posY - 2, (int)player.posZ - 1);
	                
	                player.worldObj.setBlock((int)player.posX + 1, (int)player.posY + 1, (int)player.posZ, Blocks.sand);
                
            	}
            }
            if (message.id == 7) {
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.obsidian) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.obsidian) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.obsidian) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
            }
            if (message.id == 8) {
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
                    player.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(Blocks.ice) + "_0", message.posx + this.rand.nextDouble(), message.posy + this.rand.nextDouble(), message.posz + this.rand.nextDouble(), 0.0, 0.002, 0.0);
            }
            return null;
        }
    }
}

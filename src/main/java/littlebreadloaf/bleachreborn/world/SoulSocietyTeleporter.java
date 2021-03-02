package littlebreadloaf.bleachreborn.world;

import net.minecraft.world.*;
import net.minecraft.entity.*;

public class SoulSocietyTeleporter extends Teleporter
{
    private final WorldServer worldServer;
    
    public SoulSocietyTeleporter(final WorldServer worldServer) {
        super(worldServer);
        this.worldServer = worldServer;
    }
    
    public boolean canPlacePortalAt(final int x, final int y, final int z) {
        return true;
    }
    
    public void placeInPortal(final Entity entity, final double px, final double py, final double pz, final float pitch) {
        final int x = (int)Math.floor(px);
        final int z = (int)Math.floor(pz);
        final int y = 128;
        final double d = this.worldServer.rand.nextDouble() * 3.141592653589793 * 2.0;
        entity.posX = x + 0.5 + Math.cos(d) * 1.5;
        entity.posZ = z + 0.5 + Math.sin(d) * 1.5;
        entity.posY = this.worldServer.getTopSolidOrLiquidBlock((int)entity.posX, (int)entity.posZ) + 4;
    }
}

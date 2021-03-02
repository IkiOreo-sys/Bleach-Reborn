package littlebreadloaf.bleachreborn.gui;

import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class ContainerHollowBook extends Container
{
    public ContainerHollowBook(final EntityPlayer player) {
    }
    
    public boolean canInteractWith(final EntityPlayer entityplayer) {
        return true;
    }
}

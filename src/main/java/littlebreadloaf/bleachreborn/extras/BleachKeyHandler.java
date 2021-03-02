package littlebreadloaf.bleachreborn.extras;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.settings.*;
import cpw.mods.fml.client.registry.*;
import cpw.mods.fml.common.gameevent.*;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import littlebreadloaf.bleachreborn.network.*;
import cpw.mods.fml.common.eventhandler.*;

public class BleachKeyHandler
{
    public static final int FLASH = 0;
    public static final int ACTIVATE = 1;
    public static final int DEACTIVATE = 2;
    public static final int HOLLOW = 3;
    public static final int CERO = 4;
    Minecraft mc;
    EntityPlayer Player;
    private static final String[] desc;
    private static final int[] keyValues;
    private final KeyBinding[] keys;
    
    public BleachKeyHandler() {
        this.mc = Minecraft.getMinecraft();
        this.Player = (EntityPlayer)this.mc.thePlayer;
        this.keys = new KeyBinding[BleachKeyHandler.desc.length];
        for (int i = 0; i < BleachKeyHandler.desc.length; ++i) {
            ClientRegistry.registerKeyBinding(this.keys[i] = new KeyBinding(BleachKeyHandler.desc[i], BleachKeyHandler.keyValues[i], "key.bleachreborn.category"));
        }
    }
    
    @SubscribeEvent
    public void onKeyInput(final InputEvent.KeyInputEvent event) {
        if (FMLClientHandler.instance().getClient().inGameHasFocus) {}
        if (this.keys[0].isPressed()) {
            PacketDispatcher.sendToServer((IMessage)new FlashMessage(1));
        }
        if (this.keys[1].isPressed()) {
            PacketDispatcher.sendToServer((IMessage)new ActivateMessage());
        }
        if (this.keys[2].isPressed()) {
            PacketDispatcher.sendToServer((IMessage)new DeactivateMessage());
        }
        if (this.keys[3].isPressed()) {
            PacketDispatcher.sendToServer((IMessage)new FlashMessage(4));
        }
        if (this.keys[4].isPressed()) {
            PacketDispatcher.sendToServer((IMessage)new FlashMessage(2));
        }
        if (this.keys[5].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(6));
        }
        if (this.keys[6].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(7));
        }
        if (this.keys[7].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(8));
        }
        if(this.keys[8].isPressed()) {
            PacketDispatcher.sendToServer(new FlashMessage(9));
        }
        if(this.keys[9].isPressed()) {
            PacketDispatcher.sendToServer(new FlashMessage(10));
        }
        if(this.keys[10].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(25));
        }
        if(this.keys[11].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(45));
        }
        if(this.keys[12].isPressed()) {
        	PacketDispatcher.sendToServer(new FlashMessage(135));
        }
    }
    
    static {
        desc = new String[] {
                "key.flash.desc",
                "key.activate.desc",
                "key.deactivate.desc",
                "key.hollow.desc",
                "key.cero.desc",
                "key.meditation.desc",
                "key.spiritpressure.desc",
                "key.hollowbite.desc",
                "key.zanpakatoup.desc" /* zanpotato :) */,
                "key.zanpakatodown.desc",
                "key.unlocksub.desc",
                "key.playercard.desc",
                "key.kido.desc"
        };
        keyValues = new int[] { 
                46, 45, 44, 47, 48,
                Keyboard.KEY_M,
                Keyboard.KEY_R,
                Keyboard.KEY_F,
                Keyboard.KEY_X,
                Keyboard.KEY_Z,
                Keyboard.KEY_K,
                Keyboard.KEY_P,
                Keyboard.KEY_G
        };
    }
}

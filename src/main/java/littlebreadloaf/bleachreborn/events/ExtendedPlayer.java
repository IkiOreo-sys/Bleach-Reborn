package littlebreadloaf.bleachreborn.events;

import net.minecraftforge.common.*;
import net.minecraft.client.*;
import littlebreadloaf.bleachreborn.items.*;
import net.minecraft.nbt.*;
import littlebreadloaf.bleachreborn.proxies.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import cpw.mods.fml.common.network.simpleimpl.*;
import cpw.mods.fml.relauncher.Side;
import littlebreadloaf.bleachreborn.armor.*;
import littlebreadloaf.bleachreborn.entities.*;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.potion.*;
import littlebreadloaf.bleachreborn.network.*;

import java.awt.*;
import java.util.*;
import java.util.List;

import littlebreadloaf.bleachreborn.*;
import littlebreadloaf.bleachreborn.items.shikai.*;
import net.minecraft.util.*;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.item.*;
import littlebreadloaf.bleachreborn.items.bankai.*;

public class ExtendedPlayer implements IExtendedEntityProperties
{
    public static final String EXT_PROP_NAME = "BleachPlayer";
    private final EntityPlayer player;
    Minecraft mc;
    public boolean renderHollow = true;
    private Random rand;
    private int SoulCap;
    private float SoulEnergy;
    private float SoulXP;
    private int Flame;
    private int Ice;
    private int Heal;
    private int Poison;
    private int Earth;
    private int Wind;
    private int Light;
    private int Dark;
    private int ZTotal;
    private int ZType;
    private int ZTex;
    private String ZName;
    private int CurrentHPoints;
    private int TotalHPoints;
    private static boolean does3D;
    private boolean validFlash;
    private int faction;
    private int HTex;
    private int Head;
    private int Back;
    private int Arms;
    private int Legs;
    private int Tail;
    private int HColor;
    private int MColor;
    private boolean hasBlock;
    private boolean hasGift;
    private boolean pressure;
    private boolean affected;
    private int evo;
    private boolean unlock;
    private boolean ready;
    private boolean meditation;
    private int mediCount;
    private boolean bankaiUnlock;
    private int hollowKills;
    private int xpRate;
    private boolean vUnlock;
    private int backupCap;
    private int currentP;
    private boolean sanreiBroken;
    private int sanreiUsed;
    private boolean plusDmg;
    private boolean flightUnlocked;
    private int health;
    private int bleedTimer;
    private int bleedStacks;
    private boolean spiritSpawn;
    private int follow;
    private int stay;
    private int returnb;
    private int autofarm;
    private String bodyID;
    private int deathPotion;
    private boolean capUnlocked;
    private boolean subUnlocked;
    private int subType;
    private int subpoints;
    private boolean skill1a;
    private boolean skill1d;
    private boolean skill1h;
    private int skill1alevel;
    private int skill1dlevel;
    private int skill1hlevel;
    private int killcounter;
    private int selectedskill;
    private int kidopoints;
    private int hado4level;
    private int hado4cost;
    private int bakudo1level;
    private int bakudo1cost;
    private int kidoskill;
    private int skillcounter;
    int ceroCharge;
    private int chainCount;
    ItemStack[] Shikai;
    ItemStack[] Bankai;
    public static ItemStack shikaipre;
    public static String shikainame;
    public float growth;
    
    public ExtendedPlayer(final EntityPlayer player) {
        this.rand = new Random();
        this.SoulCap = 50;
        this.SoulEnergy = 1.0f;
        this.SoulXP = 0.0f;
        this.Flame = 0;
        this.Ice = 0;
        this.Heal = 0;
        this.Poison = 0;
        this.Earth = 0;
        this.Wind = 0;
        this.Light = 0;
        this.Dark = 0;
        this.ZTotal = 0;
        this.ZType = 0;
        this.ZTex = 5;
        this.ZName = "";
        this.validFlash = true;
        this.faction = 0;
        this.HColor = this.rand.nextInt(16);
        this.MColor = this.rand.nextInt(16);
        this.hasBlock = false;
        this.ceroCharge = 0;
        this.Shikai = new ItemStack[] { new ItemStack(BleachItems.shikaifire, 1), new ItemStack(BleachItems.shikaiice, 1), new ItemStack(BleachItems.shikaipoison, 1), new ItemStack(BleachItems.shikaiheal, 1), new ItemStack(BleachItems.shikaiearth, 1), new ItemStack(BleachItems.shikaiwind, 1), new ItemStack(BleachItems.shikailight, 1), new ItemStack(BleachItems.shikaidark, 1), new ItemStack(BleachItems.shikailunar, 1), new ItemStack(BleachItems.shikailightning, 1), new ItemStack(BleachItems.shikainormal, 1), new ItemStack(BleachItems.shikaiwater, 1) };
        this.player = player;
        this.SoulCap = 50;
        this.faction = 0;
        this.hasGift = false;
        this.pressure = false;
        this.affected = false;
        this.evo = 0;
        this.unlock = false;
        this.meditation = false;
        this.mediCount = 0;
        this.bankaiUnlock = false;
        this.hollowKills = 0;
        this.xpRate = 1;
        this.vUnlock = false;
        this.backupCap = 50;
        this.currentP = 100;
        this.sanreiBroken = false;
        this.sanreiUsed = 0;
        this.plusDmg = false;
        this.chainCount = 0;
        this.flightUnlocked = false;
        this.health = 0;
        this.bleedTimer = 80;
        this.bleedStacks = 0;
        this.spiritSpawn = false;
        this.growth = 1;
        this.follow = 1;
        this.stay = 0;
        this.autofarm = 0;
        this.returnb = 0;
        this.bodyID = "";
        this.deathPotion = 0;
        this.capUnlocked = false;
        this.subUnlocked = false;
        this.subType = 0;
        this.subpoints = 0;
        this.skill1a = false;
        this.skill1d = false;
        this.skill1h = false;
        this.skill1alevel = 0;
        this.skill1dlevel = 0;
        this.skill1hlevel = 0;
        this.killcounter = 0;
        this.skillcounter = 0;
        this.selectedskill = 0;
        this.kidopoints = 0;
        this.hado4level = 0;
        this.hado4cost = 2;
        this.bakudo1level = 0;
        this.bakudo1cost = 2;
        this.kidoskill = 0;
    }
    
    public String getFactionName() {
        switch(this.getFaction()) {
            case 1:
                return "Shinigami";
            case 2:
                return "Quincy";
            case 3:
                return "Hollow";
            case 4:
                return "Arrancar";
            case 5:
                return "Visored";
            /* 6 is human */
            case 7:
                return "Gillian";
            case 8:
                return "Adjuchas";
            case 9:
                return "Vasto Arrancar";
            case 10:
                return "Vasto Lorde";
            case 11:
                return "Ascended Shinigami";
            case 12:
                return "Arrancar Resurrection";
            case 13:
                return "Fullbringer";
            case 14:
            	return "Substitute Shinigami";
            case 15:
            	return "Substitute Quincy";
            case 16:
            	return "Chad's Diablo";
            case 17:
            	return "Orihime's Rejection";
            default:
                return "Human";
        }
    }

    public void setGrowth(float growth) {
        this.growth = growth;
    }
    public float getGrowth() {
        return growth;
    }

    public static final void register(final EntityPlayer player) {
        player.registerExtendedProperties("BleachPlayer", (IExtendedEntityProperties)new ExtendedPlayer(player));
    }
    
    public static final ExtendedPlayer get(final EntityPlayer player) {
        return (ExtendedPlayer)player.getExtendedProperties("BleachPlayer");
    }
    
    public void saveNBTData(final NBTTagCompound nbt) {
        final NBTTagCompound properties = new NBTTagCompound();
        properties.setInteger("SoulCap", this.SoulCap);
        properties.setFloat("SoulEnergy", this.SoulEnergy);
        properties.setFloat("SoulXP", this.SoulXP);
        properties.setInteger("Flame", this.Flame);
        properties.setInteger("Ice", this.Ice);
        properties.setInteger("Heal", this.Heal);
        properties.setInteger("Poison", this.Poison);
        properties.setInteger("Earth", this.Earth);
        properties.setInteger("Wind", this.Wind);
        properties.setInteger("Light", this.Light);
        properties.setInteger("Dark", this.Dark);
        properties.setInteger("ZTotal", this.ZTotal);
        properties.setInteger("ZType", this.ZType);
        properties.setInteger("ZTex", this.ZTex);
        properties.setString("ZName", this.ZName);
        properties.setInteger("Faction", this.faction);
        properties.setBoolean("Does3D", ExtendedPlayer.does3D);
        properties.setInteger("HTex", this.HTex);
        properties.setInteger("Head", this.Head);
        properties.setInteger("Back", this.Back);
        properties.setInteger("Arms", this.Arms);
        properties.setInteger("Legs", this.Legs);
        properties.setInteger("Tail", this.Tail);
        properties.setInteger("HColor", this.HColor);
        properties.setInteger("MColor", this.MColor);
        properties.setInteger("HpointsC", this.CurrentHPoints);
        properties.setInteger("HpointsT", this.TotalHPoints);
        properties.setBoolean("gift", this.hasGift);
        properties.setBoolean("pressure", this.pressure);
        properties.setBoolean("affected", this.affected);
        properties.setInteger("evo", this.evo);
        properties.setBoolean("unlock", this.unlock);
        properties.setBoolean("ready", this.ready);
        properties.setBoolean("meditation", this.meditation);
        properties.setInteger("mediCount", this.mediCount);
        properties.setBoolean("bankaiUnlock", this.bankaiUnlock);
        properties.setInteger("hollowKills", this.hollowKills);
        properties.setInteger("xpRate", this.xpRate);
        properties.setBoolean("vUnlock", this.vUnlock);
        properties.setInteger("backupCap", this.backupCap);
        properties.setInteger("currentP", this.currentP);
        properties.setBoolean("sanreiBroken", this.sanreiBroken);
        properties.setBoolean("plusDmg", this.plusDmg);
        properties.setInteger("chainCount", this.chainCount);
        properties.setBoolean("flightUnlocked", this.flightUnlocked);
        properties.setBoolean("spiritSpawn", this.spiritSpawn);
        properties.setInteger("health", this.health);
        properties.setInteger("follow", this.follow);
        properties.setInteger("autofarm", this.autofarm);
        properties.setInteger("stay", this.stay);
        properties.setInteger("returnb", this.returnb);
        properties.setString("bodyID", this.bodyID);
        properties.setInteger("deathPotion", this.deathPotion);
        properties.setBoolean("capUnlocked", this.capUnlocked);
        properties.setBoolean("subUnlocked", this.subUnlocked);
        properties.setInteger("subType", this.subType);
        properties.setInteger("subpoints", this.subpoints);
        properties.setBoolean("skill1a", this.skill1a);
        properties.setBoolean("skill1d", this.skill1d);
        properties.setBoolean("skill1h", this.skill1h);
        properties.setInteger("skill1alevel", this.skill1alevel);
        properties.setInteger("skill1dlevel", this.skill1dlevel);
        properties.setInteger("skill1hlevel", this.skill1hlevel);
        properties.setInteger("killcounter", this.killcounter);
        properties.setInteger("selectedskill", this.selectedskill);
        properties.setInteger("kidoPoints", this.kidopoints);
        properties.setInteger("hado4level", this.hado4level);
        properties.setInteger("hado4cost", this.hado4cost);
        properties.setInteger("bakudo1level", this.bakudo1level);
        properties.setInteger("bakudo1cost", this.bakudo1cost);
        properties.setInteger("kidoSkill", this.kidoskill);
        properties.setInteger("skillCounter", this.skillcounter);
        nbt.setTag("BleachPlayer", (NBTBase)properties);
    }
    
    public void loadNBTData(final NBTTagCompound nbt) {
        final NBTTagCompound properties = (NBTTagCompound)nbt.getTag("BleachPlayer");
        this.SoulCap = properties.getInteger("SoulCap");
        this.SoulEnergy = properties.getFloat("SoulEnergy");
        this.SoulXP = properties.getFloat("SoulXP");
        this.Flame = properties.getInteger("Flame");
        this.Ice = properties.getInteger("Ice");
        this.Heal = properties.getInteger("Heal");
        this.Poison = properties.getInteger("Poison");
        this.Earth = properties.getInteger("Earth");
        this.Wind = properties.getInteger("Wind");
        this.Light = properties.getInteger("Light");
        this.Dark = properties.getInteger("Dark");
        this.ZTotal = properties.getInteger("ZTotal");
        this.ZType = properties.getInteger("ZType");
        this.ZTex = properties.getInteger("ZTex");
        this.ZName = properties.getString("ZName");
        this.faction = properties.getInteger("Faction");
        ExtendedPlayer.does3D = properties.getBoolean("Does3D");
        this.HTex = properties.getInteger("HTex");
        this.Head = properties.getInteger("Head");
        this.Back = properties.getInteger("Back");
        this.Arms = properties.getInteger("Arms");
        this.Legs = properties.getInteger("Legs");
        this.Tail = properties.getInteger("Tail");
        this.HColor = properties.getInteger("HColor");
        this.MColor = properties.getInteger("MColor");
        this.CurrentHPoints = properties.getInteger("HpointsC");
        this.TotalHPoints = properties.getInteger("HpointsT");
        this.hasGift = properties.getBoolean("gift");
        this.pressure = properties.getBoolean("pressure");
        this.affected = properties.getBoolean("affected");
        this.evo = properties.getInteger("evo");
        this.unlock = properties.getBoolean("unlock");
        this.ready = properties.getBoolean("ready");
        this.meditation = properties.getBoolean("meditation");
        this.mediCount = properties.getInteger("mediCount");
        this.bankaiUnlock = properties.getBoolean("bankaiUnlock");
        this.hollowKills = properties.getInteger("hollowKills");
        this.xpRate = properties.getInteger("xpRate");
        this.vUnlock = properties.getBoolean("vUnlock");
        this.backupCap = properties.getInteger("backupCap");
        this.currentP = properties.getInteger("currentP");
        this.sanreiBroken = properties.getBoolean("sanreiBroken");
        this.plusDmg = properties.getBoolean("plusDmg");
        this.chainCount = properties.getInteger("chainCount");
        this.flightUnlocked = properties.getBoolean("flightUnlocked");
        this.spiritSpawn = properties.getBoolean("spiritSpawn");
        this.health = properties.getInteger("health");
        this.follow = properties.getInteger("follow");
        this.autofarm = properties.getInteger("autofarm");
        this.stay = properties.getInteger("stay");
        this.returnb = properties.getInteger("returnb");
        this.bodyID = properties.getString("bodyID");
        this.deathPotion = properties.getInteger("deathPotion");
        this.capUnlocked = properties.getBoolean("capUnlocked");
        this.subUnlocked = properties.getBoolean("subUnlocked");
        this.subType = properties.getInteger("subType");
        this.subpoints = properties.getInteger("subpoints");
        this.skill1a = properties.getBoolean("skill1a");
        this.skill1d = properties.getBoolean("skill1d");
        this.skill1h = properties.getBoolean("skill1h");
        this.skill1alevel = properties.getInteger("skill1alevel");
        this.skill1dlevel = properties.getInteger("skill1dlevel");
        this.skill1hlevel = properties.getInteger("skill1hlevel");
        this.killcounter = properties.getInteger("killcounter");
        this.selectedskill = properties.getInteger("selectedskill");
        this.kidopoints = properties.getInteger("kidoPoints");
        this.hado4level = properties.getInteger("hado4level");
        this.hado4cost = properties.getInteger("hado4cost");
        this.bakudo1level = properties.getInteger("bakudo1level");
        this.bakudo1cost = properties.getInteger("bakudo1cost");
        this.kidoskill = properties.getInteger("kidoSkill");
        this.skillcounter = properties.getInteger("skillCounter");
    }
    
    private static String getSaveKey(final EntityPlayer player) {
        return player.getCommandSenderName() + ":BleachPlayer";
    }
    
    public static void saveProxyData(final EntityPlayer player) {
        final ExtendedPlayer playerData = get(player);
        final NBTTagCompound savedData = new NBTTagCompound();
        playerData.saveNBTData(savedData);
        CommonProxy.storeEntityData(getSaveKey(player), savedData);
    }
    
    public static final void loadProxyData(final EntityPlayer player) {
        final ExtendedPlayer playerData = get(player);
        final NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
        if (savedData != null) {
            playerData.loadNBTData(savedData);
        }
    }
    
    public void init(final Entity entity, final World world) {
    }
    
    public void copy(ExtendedPlayer props) {
        this.SoulCap = props.SoulCap;
        this.SoulEnergy = props.SoulEnergy;
        this.SoulXP = props.SoulXP;
        this.Flame = props.Flame;
        this.Ice = props.Ice;
        this.Heal = props.Heal;
        this.Poison = props.Poison;
        this.Earth = props.Earth;
        this.Wind = props.Wind;
        this.Light = props.Light;
        this.Dark = props.Dark;
        this.ZTotal = props.ZTotal;
        this.ZType = props.ZType;
        this.ZTex = props.ZTex;
        this.ZName = props.ZName;
        this.validFlash = props.validFlash;
        this.faction = props.faction;
        this.HColor = props.HColor;
        this.MColor = props.MColor;
        this.hasBlock = props.hasBlock;
        this.ceroCharge = props.ceroCharge;
        this.Shikai = props.Shikai;
        this.SoulCap = props.SoulCap;
        this.faction = props.faction;
        this.hasGift = props.hasGift;
        this.pressure = props.pressure;
        this.affected = props.affected;
        this.evo = props.evo;
        this.unlock = props.unlock;
        this.meditation = props.meditation;
        this.mediCount = props.mediCount;
        this.bankaiUnlock = props.bankaiUnlock;
        this.hollowKills = props.hollowKills;
        this.xpRate = props.xpRate;
        this.vUnlock = props.vUnlock;
        this.backupCap = props.backupCap;
        this.currentP = props.currentP;
        this.sanreiBroken = props.sanreiBroken;
        this.sanreiUsed = props.sanreiUsed;
        this.plusDmg = props.plusDmg;
        this.chainCount = props.chainCount;
        this.flightUnlocked = props.flightUnlocked;
        this.health = props.health;
        this.spiritSpawn = props.spiritSpawn;
        this.follow = props.follow;
        this.stay = props.stay;
        this.autofarm = props.autofarm;
        this.returnb = props.returnb;
        this.bodyID = props.bodyID;
        this.deathPotion = props.deathPotion;
        this.capUnlocked = props.capUnlocked;
        this.subUnlocked = props.subUnlocked;
        this.subType = props.subType;
        this.subpoints = props.subpoints;
        this.killcounter = props.killcounter;
        this.skill1a = props.skill1a;
        this.skill1d = props.skill1d;
        this.skill1h = props.skill1h;
        this.skill1alevel = props.skill1alevel;
        this.skill1dlevel = props.skill1dlevel;
        this.skill1hlevel = props.skill1hlevel;
        this.selectedskill = props.selectedskill;
        this.kidopoints = props.kidopoints;
        this.hado4level = props.hado4level;
        this.hado4cost = props.hado4cost;
        this.bakudo1level = props.bakudo1level;
        this.bakudo1cost = props.bakudo1cost;
        this.kidoskill = props.kidoskill;
        this.skillcounter = props.skillcounter;
    }
    
    public void setCurrentEnergy(final float amount) {
        this.SoulEnergy = ((amount > 0.0f) ? amount : 0.0f);
    }
    
    public void setMaxCap(final int amount) {
        this.SoulCap = ((amount > 0) ? amount : 0);
    }
    
    public void setCapMin() {
        this.SoulCap = 50;
    }
    
    public void setCapMax() {
        this.SoulCap = 10000;
    }
    
    public void setCapMaxUnlocked() {
    	this.SoulCap = 25000;
    }
    
    public void setZType(final int var1) {
        this.ZType = var1;
    }
    
    public void setName(final String name) {
        this.ZName = name;
    }
    
    public void setZName(final String name) {
        this.ZName = name;
    }
    
    public void setTexture(final int var1) {
        this.ZTex = var1;
    }
    
    public void setFaction(final int var1) {
        this.faction = var1;
    }
    
    public void setHTex(final int var1) {
        this.HTex = var1;
    }
    
    public void setHead(final int var1) {
        this.Head = var1;
    }
    
    public void setBack(final int var1) {
        this.Back = var1;
    }
    
    public void setArms(final int var1) {
        this.Arms = var1;
    }
    
    public void setLegs(final int var1) {
        this.Legs = var1;
    }
    
    public void setTail(final int var1) {
        this.Tail = var1;
    }
    
    public void setHColor(final int var1) {
        this.HColor = var1;
    }
    
    public void setMColor(final int var1) {
        this.MColor = var1;
    }
    
    public void addCurrentHPoints(final int var1) {
    	this.CurrentHPoints += var1;
    }
    
    public void subtractCurrentHPoints(final int var1) {
        this.CurrentHPoints -= var1;
    }
    
    public void setTotalHPoints(final int var1) {
        this.TotalHPoints = var1;
    }
    
    public void setValidFlash(final boolean var1) {
        this.validFlash = var1;
    }
    
    public static void set3D(final boolean var1) {
        ExtendedPlayer.does3D = var1;
    }
    
    public void setHasBlock(final boolean var1) {
        this.hasBlock = var1;
    }
    
    public void addCeroCharge(final int var2) {
        this.ceroCharge += var2;
    }
    
    public void setCeroCharge(final int var2) {
        this.ceroCharge = var2;
    }
    
    public void setGift(final boolean b) {
        this.hasGift = b;
    }
    
    public boolean getGift() {
        return this.hasGift;
    }
    
    public void setPressure(final boolean b) {
        this.pressure = b;
    }
    
    public boolean getPressure() {
        return this.pressure;
    }
    
    public void setAffected(final boolean b) {
        this.affected = b;
    }
    
    public boolean getAffected() {
        return this.affected;
    }
    
    public void setEvo(final int evo) {
        this.evo = evo;
    }
    
    public int getEvo() {
        return this.evo;
    }
    
    public void setUnlock(final boolean b) {
        this.unlock = b;
    }
    
    public boolean getUnlock() {
        return this.unlock;
    }
    
    public void setReady(final boolean b) {
        this.ready = b;
    }
    
    public boolean getReady() {
        return this.ready;
    }
    
    public void setMeditation(final boolean b) {
        this.meditation = b;
    }
    
    public boolean getMeditation() {
        return this.meditation;
    }
    
    public void setMediCount(final int s) {
        this.mediCount = s;
    }
    
    public int getMediCount() {
        return this.mediCount;
    }
    
    public void setBankaiUnlock(final boolean s) {
        this.bankaiUnlock = s;
    }
    
    public boolean getBankaiUnlock() {
        return this.bankaiUnlock;
    }
    
    public void setHollowKills(final int s) {
        this.hollowKills = s;
    }
    
    public int getHollowKills() {
        return this.hollowKills;
    }
    
    
    public void setXpRate(final int s) {
        this.xpRate = s;
    }
    
    public int getXpRate() {
        return this.xpRate;
    }
    
    public void setVUnlock(final boolean b) {
        this.vUnlock = b;
    }
    
    public boolean getVUnlock() {
        return this.vUnlock;
    }
    
    public void setBackupCap(final int s) {
        this.backupCap = s;
    }
    
    public int getBackupCap() {
        return this.backupCap;
    }
    
    public void setCurrentP(final int s) {
        this.currentP = s;
    }
    
    public int getCurrentP() {
        return this.currentP;
    }
    
    public void setSanreiBroken(final boolean s) {
        this.sanreiBroken = s;
    }
    
    public boolean getSanreiBroken() {
        return this.sanreiBroken;
    }
    
    public void setSanreiCount(final int s) {
        this.sanreiUsed = s;
    }
    
    public int getSanreiCount() {
        return this.sanreiUsed;
    }
    
    public void setPlusDmg(final boolean b) {
        this.plusDmg = b;
    }
    
    public boolean getPlusDmg() {
        return this.plusDmg;
    }
    
    public void setChainCount(final int i) {
        this.chainCount = i;
    }
    
    public int getChainCount() {
        return this.chainCount;
    }
    
    public void setFlightUnlocked(final boolean b) {
        this.flightUnlocked = b;
    }
    
    public boolean getFlightUnlocked() {
        return this.flightUnlocked;
    }
    
    public void setSpiritSpawn(boolean b) {
    	this.spiritSpawn = b;
    }
    
    public boolean getSpiritSpawn() {
    	return this.spiritSpawn;
    }
    
    public void setFollow(int s) {
    	this.follow = s;
    }

    public void setStay(int s) {
    	this.stay = s;
    }

    public void setAutofarm(int s) {
    	this.autofarm = s;
    }

    public void setReturnB(int s) {
    	this.returnb = s;
    }
    
    public int getFollow() {
    	return this.follow;
    }
    
    public int getStay() {
    	return this.stay;
    }
    
    public int getAutofarm() {
    	return this.autofarm;
    }
    
    public int getReturnB() {
    	return this.returnb;
    }
    
    public void setBodyID(String s) {
    	this.bodyID = s;
    }
    
    public String getBodyID() {
    	return this.bodyID;
    }
    
    public void setDeathPotion(int s) {
    	this.deathPotion = s;
    }
    
    public int getDeathPotion() {
    	return this.deathPotion;
    }
    
    public void setCapUnlocked(boolean s) {
    	this.capUnlocked = s;
    }
    
    public boolean getCapUnlocked() {
    	return this.capUnlocked;
    }
        
    public void setSubUnlocked(boolean s, int t) {
    	this.subUnlocked = s;
    	this.subType = t;
    }
    
    public boolean getSubUnlocked() {
    	return this.subUnlocked;
    }
    
    public int getSubType() {
    	return this.subType;
    }
    
    public void setSubPoints(int s) {
    	this.subpoints = s;
    }
    
    public int getSubPoints() {
    	return this.subpoints;
    }
    
    public void setSkill1a(boolean s) {
    	this.skill1a = s;
    }
    
    public void setSkill1d(boolean s) {
    	this.skill1d = s;
    }
    
    public void setSkill1h(boolean s) {
    	this.skill1h = s;
    }
    
    public boolean getSkill1a() {
    	return this.skill1a;
    }
    
    public boolean getSkill1d() {
    	return this.skill1d;
    }
    
    public boolean getSkill1h() {
    	return this.skill1h;
    }
    
    public void setSkill1alevel(int s) {
    	this.skill1alevel = s;
    }
    
    public void setSkill1dlevel(int s) {
    	this.skill1dlevel = s;
    }
    
    public void setSkill1hlevel(int s) {
    	this.skill1hlevel = s;
    }
    
    public int getSkill1alevel() {
    	return this.skill1alevel;
    }
    
    public int getSkill1dlevel() {
    	return this.skill1dlevel;
    }
    
    public int getSkill1hlevel() {
    	return this.skill1hlevel;
    }
    
    public void setKillCounter(int s) {
    	this.killcounter = s;
    }
    
    public int getKillCounter() {
    	return this.killcounter;
    }
    
    public void setSelectedSkill(int s) {
    	this.selectedskill = s;
    }
    
    public int getSelectedSkill() {
    	return this.selectedskill;
    }
    
    public void setKidoPoints(int s) {
    	this.kidopoints = s;
    }
    
    public int getKidoPoints() {
    	return this.kidopoints;
    }
    
    public void setHado4Level(int s) {
    	this.hado4level = s;
    }
    
    public int getHado4Level() {
    	return this.hado4level;
    }
    
    public void setHado4Cost(int s) {
    	this.hado4cost = s;
    }
    
    public int getHado4Cost() {
    	return this.hado4cost;
    }
    
    public void setBakudo1Level(int s) {
    	this.bakudo1level = s;
    }
    
    public int getBakudo1Level() {
    	return this.bakudo1level;
    }
    
    public void setBakudo1Cost(int s) {
    	this.bakudo1cost = s;
    }
    
    public int getBakudo1Cost() {
    	return this.bakudo1cost;
    }
    
    public void setKidoSkill(int s) {
    	this.kidoskill = s;
    }
    
    public int getKidoSkill() {
    	return this.kidoskill;
    }
    
    public void setSkillCounter(int s) {
    	this.skillcounter = s;
    }
    
    public int getSkillCounter() {
    	return this.skillcounter;
    }
    
    private void resetTypes() {
        this.Flame = 0;
        this.Ice = 0;
        this.Poison = 0;
        this.Heal = 0;
        this.Earth = 0;
        this.Wind = 0;
        this.Light = 0;
        this.Dark = 0;
    }
    public void setType(final int var3) {
        resetTypes();
        switch(var3) {
            case 0:
                this.Flame = 400;break;
            case 1:
                this.Ice = 400;break;
            case 2:
                this.Poison = 400;break;
            case 3:
                this.Heal = 400;break;
            case 4:
                this.Earth = 400;break;
            case 5:
                this.Wind = 400;break;
            case 6:
                this.Light = 400;break;
            case 7:
                this.Dark = 400;break;
            case 8:
                this.Light = this.Dark = 200;break;
            case 9:
                this.Wind = this.Light = 200;break;
            case 10:
                this.Flame = this.Ice = this.Poison = this.Heal = 50;
                this.Earth = this.Wind = this.Light = this.Dark = 50;break;
            case 11:
                this.Ice = this.Flame = 200;
            default:
                break;
        }
    }
    
    public void setPoints(final int var1, final int amount) {
        switch(var1) {
            case 1: this.Flame = amount;break;
            case 2: this.Ice = amount;break;
            case 3: this.Poison = amount;break;
            case 4: this.Heal = amount;break;
            case 5: this.Earth = amount;break;
            case 6: this.Wind = amount;break;
            case 7: this.Light = amount;break;
            case 8: this.Dark = amount;break;
            default: this.ZTotal = amount;break;
        }
    }
    
    public void resetType() {
        this.Flame = 0;
        this.Ice = 0;
        this.Heal = 0;
        this.Poison = 0;
        this.Earth = 0;
        this.Wind = 0;
        this.Light = 0;
        this.Dark = 0;
        this.ZTotal = 0;
        this.ZType = 0;
        this.randomTexture();
        this.ZName = "";
    }
    
    public int getCurrentCap() {
        return this.SoulCap;
    }
    
    public float getCurrentEnergy() {
        return this.SoulEnergy;
    }
    
    public float getCurrentSXP() {
        return this.SoulXP;
    }
    
    public String getName() {
        return this.ZName;
    }
    
    public int getZTex() {
        return this.ZTex;
    }
    
    public int getZTotal() {
        return this.ZTotal;
    }
    
    public String getZName() {
        return this.ZName;
    }
    
    public int getZType() {
        return this.ZType;
    }
    
    public int getFaction() {
        return this.faction;
    }
    
    public int getHTex() {
        return this.HTex;
    }
    
    public int getHead() {
        return this.Head;
    }
    
    public int getBack() {
        return this.Back;
    }
    
    public int getArms() {
        return this.Arms;
    }
    
    public int getLegs() {
        return this.Legs;
    }
    
    public int getTail() {
        return this.Tail;
    }
    
    public int getHColor() {
        return this.HColor;
    }
    
    public int getMColor() {
        return this.MColor;
    }
    
    public int getCurrentHPoints() {
        return this.CurrentHPoints;
    }
    
    public int getTotalHPoints() {
        return this.TotalHPoints;
    }
    
    public boolean getValidFlash() {
        return this.validFlash;
    }
    
    public static boolean getIs3D() {
        return ExtendedPlayer.does3D;
    }
    
    public boolean getHasBlock() {
        return this.hasBlock;
    }
    
    public int getCeroCharge() {
        return this.ceroCharge;
    }
    
    public int getPoints(final int var1) {
        switch(var1) {
            case 1: return this.Flame;
            case 2: return this.Ice;
            case 3: return this.Poison;
            case 4: return this.Heal;
            case 5: return this.Earth;
            case 6: return this.Wind;
            case 7: return this.Light;
            case 8: return this.Dark;
            case 23: return 2;
            default: return this.ZTotal;
        }
    }
    
    public void addCap() {
        this.SoulCap += 5;
        this.SoulXP = 0.0f;
        if (this.getFaction() == 3 && this.SoulCap / (this.TotalHPoints + 2) == 50 && this.TotalHPoints < 6) {
            ++this.TotalHPoints;
            ++this.CurrentHPoints;
        }
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
    }
    
    public void addSXP(final int amount) {
        this.SoulXP += amount / (float)(this.SoulCap - 50);
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
    }
    
    public boolean consumeEnergy(final int amount) {
        final boolean sufficient = amount <= this.SoulEnergy * this.SoulCap;
        this.SoulEnergy -= ((amount < this.SoulEnergy * this.SoulCap) ? (amount / (float)this.SoulCap) : this.SoulEnergy);
        if (this.SoulEnergy <= 0.0f) {
            this.SoulEnergy = 0.0f;
        }
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
        return sufficient;
    }
    
    public boolean replenishEnergy(final int amount) {
        final boolean sufficient = this.SoulEnergy < 1.0f;
        this.SoulEnergy += ((this.SoulEnergy < 1.0f) ? (amount / (float)this.SoulCap) : this.SoulEnergy);
        if (this.SoulEnergy >= 1.0f) {
            this.SoulEnergy = 1.0f;
        }
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
        return sufficient;
    }
    
    public void addPoints(final int type, final int amount) {
        switch(type) {
            case 1: this.Flame += amount;break;
            case 2:this.Ice += amount;break;
            case 3: this.Poison += amount;break;
            case 4: this.Heal += amount;break;
            case 5: this.Earth += amount;break;
            case 6: this.Wind += amount;break;
            case 7: this.Light += amount;break;
            case 8: this.Dark += amount;break;
            default: this.ZTotal += amount;break;
        }
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
    }
    
    public void balanceTotal() {
        this.ZTotal = this.Flame + this.Ice + this.Heal + this.Poison + this.Earth + this.Wind + this.Light + this.Dark;
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
    }
    
    public void randomTexture() {
        this.ZTex = this.rand.nextInt(5);
        if (this.player instanceof EntityPlayerMP) {
            PacketDispatcher.sendTo((IMessage)new ClientSyncMessage(this.player), (EntityPlayerMP)this.player);
        }
    }
// Flash Step  
    public void decideWhatToDo(final int readInt) {
        if (readInt == 1) {
            final ItemStack var9 = this.player.inventory.armorInventory[0];
            final ItemStack var10 = this.player.inventory.armorInventory[1];
            final ItemStack var11 = this.player.inventory.armorInventory[2];
            final ItemStack var12 = this.player.inventory.armorInventory[3];
            final int distance = 9;
            if (this.getValidFlash() && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                if (this.faction == 1 || this.faction == 5) {
                    if (var9 != null && var9.getItem() == Armor.Sandals && var10 != null && var10.getItem() == Armor.ShiniPants && var11 != null && var11.getItem() == Armor.ShiniRobe && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                        this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                        if (this.player instanceof EntityPlayerMP) {
                            PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                        }
                        this.consumeEnergy(5);
                        this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                        this.setValidFlash(false);
                    }
                }
                
                else if (this.faction == 2 && var9 != null && var9.getItem() == Armor.QuincyShoes && var10 != null && var10.getItem() == Armor.QuincyPants && var11 != null && var11.getItem() == Armor.QuincyRobe && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
      
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
                else if (this.faction == 4 && var9 != null && var9.getItem() == Armor.ArrancarShoes && var10 != null && var10.getItem() == Armor.ArrancarPants && var11 != null && var11.getItem() == Armor.ArrancarJacket && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:sonido", 0.9f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:sonido", 0.9f, 1.0f);
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
                else if (this.faction == 1 && var9 != null && var9.getItem() == Armor.Sandals && var10 != null && var10.getItem() == Armor.MaleAcademyBottom && var11 != null && var11.getItem() == Armor.MaleAcademyTop && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
                else if (this.faction == 1 && var9 != null && var9.getItem() == Armor.Sandals && var10 != null && var10.getItem() == Armor.FemaleAcademyBottom && var11 != null && var11.getItem() == Armor.FemaleAcademyTop && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
                else if (this.faction == 11 && var9 != null && var9.getItem() == Armor.HogyokuShoes && var10 != null && var10.getItem() == Armor.HogyokuPants && var11 != null && var11.getItem() == Armor.HogyokuJacket && this.getCurrentEnergy() >= 5.0f / this.getCurrentCap()) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(9), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
                else if (this.faction == 3) {
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    if (this.player instanceof EntityPlayerMP) {
                        PacketDispatcher.sendTo((IMessage)new MoveMessage(3), (EntityPlayerMP)this.player);
                    }
                    this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:shunpo", 0.4f, 1.0f);
                    this.consumeEnergy(5);
                    this.setValidFlash(false);
                }
            }
        } 
        
        else if (readInt == 2) {
            if ((this.getFaction() == 4 || this.getFaction() == 5 || this.getFaction() == 7 || this.getFaction() == 8 || this.getFaction() == 11) && this.getCurrentEnergy() * this.getCurrentCap() > 50.0f && this.ceroCharge == 0) {
                this.ceroCharge = 1;
                if (!this.player.worldObj.isRemote) {
                    this.consumeEnergy(50);
                }
            }
            if (this.getFaction() == 3 && this.getHead() == 1 && this.getCurrentEnergy() * this.getCurrentCap() > 10.0f && !this.player.worldObj.isRemote) {
                this.player.worldObj.spawnEntityInWorld((Entity)new EntityGlob(this.player.worldObj, (EntityLivingBase)this.player));
                this.consumeEnergy(10);
            }
        }
        else if (readInt == 4) {
            final ExtendedPlayer props = get(this.player);
            if ((props.getFaction() == 3 || props.getFaction() == 7 || props.getFaction() == 8) && this.player instanceof EntityPlayerMP) {
                PacketDispatcher.sendTo((IMessage)new GuiMessage(3), (EntityPlayerMP)this.player);
            }
        }
        else if (readInt == 6) {
            if (this.getFaction() == 1 || this.getFaction() == 5 || this.getFaction() == 11) {
                if (!this.getMeditation() && this.player.getHeldItem() != null && this.player.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
                    this.setMeditation(true);
                    this.player.addChatComponentMessage((IChatComponent)new ChatComponentText("You are now meditating."));
                    this.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200000000, 6, true));
                }
                else if (this.getMeditation() && this.player.getHeldItem() != null && this.player.getHeldItem().getItem().equals(BleachItems.zanpakuto)) {
                    this.setMeditation(false);
                    this.player.addChatComponentMessage((IChatComponent)new ChatComponentText("You stopped meditating."));
                    this.player.removePotionEffect(Potion.moveSlowdown.id);
                }
            }
        }
        else if (readInt == 7) {
            if (!this.player.worldObj.isRemote) {
                if (!this.getPressure() && this.getCurrentCap() >= 300) {
                    this.setPressure(true);
                    if (this.getPressure()) {
                        final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.player.posX - 64.0, this.player.posY - 64.0, this.player.posZ - 64.0, this.player.posX + 64.0, this.player.posY + 64.0, this.player.posZ + 64.0));
                        for (int i = 0; i < players.size(); ++i) {
                            final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                            if (entity != null && entity instanceof EntityPlayer && entity != this.player) {
                                final ExtendedPlayer props2 = get((EntityPlayer)entity);
                                if (props2.getCurrentCap() < this.getCurrentCap()) {
                                    entity.addPotionEffect(new PotionEffect(BleachMod.spiritpressure.id, 200000000, 0, true));
                                    entity.addPotionEffect(new PotionEffect(Potion.weakness.id, 200000000, 0, true));
                                    entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200000000, 2, true));
                                }
                            }
                        }
                    }
                    this.player.addChatComponentMessage((IChatComponent)new ChatComponentText("Activated Spiritual Pressure."));
                }
                else if (this.getPressure() && this.getCurrentCap() >= 300) {
                    this.setPressure(false);
                    if (!this.getPressure()) {
                        final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.player.posX - 64.0, this.player.posY - 64.0, this.player.posZ - 64.0, this.player.posX + 64.0, this.player.posY + 64.0, this.player.posZ + 64.0));
                        for (int i = 0; i < players.size(); ++i) {
                            final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                            if (entity != null && entity instanceof EntityPlayer && entity != this.player) {
                                final ExtendedPlayer props2 = get((EntityPlayer)entity);
                                if (props2.getCurrentCap() < this.getCurrentCap()) {
                                    entity.removePotionEffect(BleachMod.spiritpressure.id);
                                    entity.removePotionEffect(Potion.weakness.id);
                                    entity.removePotionEffect(Potion.moveSlowdown.id);
                                }
                            }
                        }
                    }
                    this.player.addChatComponentMessage((IChatComponent)new ChatComponentText("De-Activated Spiritual Pressure."));
                }
            }
        }
        else if (readInt == 8) {
            if (!this.player.worldObj.isRemote && BleachEvents.biteTimer <= 0 && this.getFaction() == 3) {
                if (this.getCurrentCap() >= 150) {
                    final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.player.posX - 5.0, this.player.posY - 5.0, this.player.posZ - 5.0, this.player.posX + 5.0, this.player.posY + 5.0, this.player.posZ + 5.0));
                    for (int i = 0; i < players.size(); ++i) {
                        final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                        if (entity != null && entity instanceof EntityPlayer && entity != this.player) {
                            final ExtendedPlayer props2 = get((EntityPlayer)entity);
                            entity.attackEntityFrom(DamageSource.generic, (float)(4.0 + this.getCurrentCap() * 0.01));
                            for (int j = -5; j < 5; ++j) {
                                for (int k = -5; k < 5; ++k) {
                                    if (Math.ceil(this.player.getDistance(this.player.posX + j, this.player.posY, this.player.posZ + k)) == 5.0) {
                                        PacketDispatcher.sendToAll((IMessage)new ParticleMessage(7, this.player.posX + j, this.player.posY, this.player.posZ + k));
                                    }
                                }
                            }
                            props2.consumeEnergy(25);
                            this.replenishEnergy(20);
                            this.consumeEnergy(15);
                            this.player.heal((float)(1.0 + this.getCurrentCap() * 0.2));
                            this.player.getFoodStats().addStats(0, 0.3f);
                            this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:chomp", 0.5f, 1.0f);
                        }
                        else if (entity != null && entity instanceof EntityLivingBase && entity != this.player) {
                            entity.attackEntityFrom(DamageSource.generic, (float)(4.0 + this.getCurrentCap() * 0.01));
                            for (int l = -5; l < 5; ++l) {
                                for (int m = -5; m < 5; ++m) {
                                    if (Math.ceil(this.player.getDistance(this.player.posX + l, this.player.posY, this.player.posZ + m)) == 5.0) {
                                        PacketDispatcher.sendToAll((IMessage)new ParticleMessage(7, this.player.posX + l, this.player.posY, this.player.posZ + m));
                                    }
                                }
                            }
                            this.replenishEnergy(25);
                            this.consumeEnergy(15);
                            this.player.heal((float)(1.0 + this.getCurrentCap() * 0.2));
                            this.player.getFoodStats().addStats(0, 0.3f);
                            this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:chomp", 0.5f, 1.0f);
                        }
                    }
                }
                BleachEvents.biteTimer = 750;
            }
            else if (!this.player.worldObj.isRemote && BleachEvents.biteTimer <= 0 && this.getFaction() == 7) {
                final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityLivingBase.class, AxisAlignedBB.getBoundingBox(this.player.posX - 5.0, this.player.posY - 5.0, this.player.posZ - 5.0, this.player.posX + 5.0, this.player.posY + 5.0, this.player.posZ + 5.0));
                for (int i = 0; i < players.size(); ++i) {
                    final EntityLivingBase entity = (EntityLivingBase) players.get(i);
                    if (entity != null && entity instanceof EntityPlayer && entity != this.player) {
                        entity.attackEntityFrom(DamageSource.generic, (float)(6.0 + this.getCurrentCap() * 0.04));
                    }
                    else if (entity != null && entity instanceof EntityLivingBase && entity != this.player) {
                        entity.attackEntityFrom(DamageSource.generic, (float)(6.0 + this.getCurrentCap() * 0.04));
                    }
                }
                for (int j2 = -5; j2 < 5; ++j2) {
                    for (int k2 = -5; k2 < 5; ++k2) {
                        if (Math.ceil(this.player.getDistance(this.player.posX + j2, this.player.posY, this.player.posZ + k2)) == 5.0) {
                            PacketDispatcher.sendToAll((IMessage)new ParticleMessage(7, this.player.posX + j2, this.player.posY, this.player.posZ + k2));
                        }
                    }
                }
                this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:chomp", 0.5f, 1.0f);
                this.consumeEnergy(40);
                BleachEvents.biteTimer = 750;
            }
        } else if(readInt == 9) {
            if(this.getFaction() != 4)
                return;
            if(this.getCurrentCap() >= 5000 && this.getHollowKills() >= 5000) {
                this.setFaction(12);
                this.player.addChatComponentMessage(new ChatComponentText("Successfully converted into " + this.getFactionName()));
                //this.setMaxCap(this.getCurrentCap()-5000);
            } else {
                this.player.addChatComponentMessage(new ChatComponentText("You don't have 5000 Energy and 5000 Hollow Kills to convert!"));
            }
        } else if(readInt == 10) {
            if(this.getFaction() != 12)
                return;
            this.setFaction(4);
            this.player.addChatComponentMessage(new ChatComponentText("Successfully converted back to " + this.getFactionName()));
        }
        else if (readInt == 11) {
            this.setFaction(1);
        }
        else if (readInt == 12) {
            this.setFaction(2);
        }
        else if (readInt == 13) {
            this.setFaction(3);
        }
        else if (readInt == 14) {
            this.setFaction(6);
        }
        else if (readInt == 25) {
        	if (this.getSubUnlocked() == true && this.getFaction() == 6) {
        		if (this.subType == 1) {
	        		this.setFaction(14);
	        		this.setMaxCap(this.getCurrentCap() + 100);
	        		this.setSubUnlocked(false, 1);
	        		player.addChatComponentMessage(new ChatComponentText("You have successfully become a " + this.getFactionName() + "!"));
        		}
        		if (this.subType == 2) {
        			this.setFaction(15);
        			this.setMaxCap(this.getCurrentCap() + 100);
        			this.setSubUnlocked(false, 2);
	        		player.addChatComponentMessage(new ChatComponentText("You have successfully become a " + this.getFactionName() + "!"));
        		}
        	}
        }
        else if (readInt == 31) {
			this.setSubUnlocked(true, 3);
        }
        else if (readInt == 45) {
            PacketDispatcher.sendTo((IMessage)new GuiMessage(14), (EntityPlayerMP)this.player);
        }
        else if (readInt == 120) {
        	if (player.isPotionActive(BleachMod.soulDisconnect.id)) {

            	player.removePotionEffect(BleachMod.soulDisconnectPotionID);
				for (int i = 0; i < player.worldObj.loadedEntityList.size(); ++i) {
                    final Entity currentEntity = (Entity) player.worldObj.loadedEntityList.get(i);
                    if (currentEntity.getUniqueID().toString().equalsIgnoreCase(getBodyID())) {
                        player.addChatComponentMessage((IChatComponent)new ChatComponentText("Returned to body."));
                        currentEntity.setDead();
                    }
                    player.inventory.consumeInventoryItem(BleachItems.control);
                    player.inventoryContainer.detectAndSendChanges();
				}
				setBodyID("");
			}
        }
        else if (readInt == 121) {
        	if (player.isPotionActive(BleachMod.soulDisconnect.id)) {
            	if (getFollow() == 0) {
					setFollow(1);
					setStay(0);
					player.addChatComponentMessage(new ChatComponentText("Body set to follow."));
				}
				else if (getFollow() == 1) {
					setFollow(0);
					player.addChatComponentMessage(new ChatComponentText("Follow has been disabled."));
				}
			}
        }
        else if (readInt == 122) {
        	if (player.isPotionActive(BleachMod.soulDisconnect.id)) {

            	if (getStay() == 0) {
					setStay(1);
					setFollow(0);
					player.addChatComponentMessage(new ChatComponentText("Body set to stay."));
				}
				else if (getStay() == 1) {
					setStay(0);
					player.addChatComponentMessage(new ChatComponentText("Stay has been disabled."));
				}
			}
        }
		else if (readInt == 123) {
			if (player.isPotionActive(BleachMod.soulDisconnect.id)) {

            	if (getAutofarm() == 0 && getStay() == 0) {
					setAutofarm(1);
					player.addChatComponentMessage(new ChatComponentText("Body set to autofarm."));
				}
				else if (getAutofarm() == 1) {
					setAutofarm(0);
					player.addChatComponentMessage(new ChatComponentText("Autofarm has been disabled."));
				}
				else {
					player.addChatComponentMessage(new ChatComponentText("Your body is probably set on stay, you should turn that off."));
				}
			}
		}
		else if (readInt == 125) {
			if (!this.getSkill1h()) {
				if (this.getSubPoints() >= 3) {
					this.setSkill1h(true);
					this.setSkill1hlevel(1);
					this.setSubPoints(this.getSubPoints() - 3);
				}
			}
			else if (this.getSkill1h()) {
				if (this.getSkill1hlevel() == 1) {
					if (this.getSubPoints() >= 6) {
						this.setSkill1hlevel(2);
						this.setSubPoints(this.getSubPoints() - 6);
					}
				}
				else if (this.getSkill1hlevel() == 2) {
					if (this.getSubPoints() >= 12) {
						this.setSkill1hlevel(3);
						this.setSubPoints(this.getSubPoints() - 12);
					}
				}
				else if (this.getSkill1hlevel() == 3) {
					if (this.getSubPoints() >= 24) {
						this.setSkill1hlevel(4);
						this.setSubPoints(this.getSubPoints() - 24);
					}
				}
				else if (this.getSkill1hlevel() == 4) {
					if (this.getSubPoints() >= 36) {
						this.setSkill1hlevel(5);
						this.setSubPoints(this.getSubPoints() - 36);
					}
				}
				else if (this.getSkill1hlevel() == 5) {
					if (this.getSubPoints() >= 48) {
						this.setSkill1hlevel(6);
						this.setSubPoints(this.getSubPoints() - 48);
					}
				}
				else if (this.getSkill1hlevel() == 6) {
					if (this.getSubPoints() >= 60) {
						this.setSkill1hlevel(7);
						this.setSubPoints(this.getSubPoints() - 60);
					}
				}
				else if (this.getSkill1hlevel() == 7) {
					if (this.getSubPoints() >= 72) {
						this.setSkill1hlevel(8);
						this.setSubPoints(this.getSubPoints() - 72);
					}
				}
			}
		}
		else if (readInt == 126) {
			if (!this.getSkill1d()) {
				if (this.getSubPoints() >= 3) {
					this.setSkill1d(true);
					this.setSkill1dlevel(1);
					this.setSubPoints(this.getSubPoints() - 3);
				}
			}
			else if (this.getSkill1d()) {
				if (this.getSkill1dlevel() == 1) {
					if (this.getSubPoints() >= 6) {
						this.setSkill1dlevel(2);
						this.setSubPoints(this.getSubPoints() - 6);
					}
				}
				else if (this.getSkill1dlevel() == 2) {
					if (this.getSubPoints() >= 12) {
						this.setSkill1dlevel(3);
						this.setSubPoints(this.getSubPoints() - 12);
					}
				}
				else if (this.getSkill1dlevel() == 3) {
					if (this.getSubPoints() >= 24) {
						this.setSkill1dlevel(4);
						this.setSubPoints(this.getSubPoints() - 24);
					}
				}
				else if (this.getSkill1dlevel() == 4) {
					if (this.getSubPoints() >= 36) {
						this.setSkill1dlevel(5);
						this.setSubPoints(this.getSubPoints() - 36);
					}
				}
				else if (this.getSkill1dlevel() == 5) {
					if (this.getSubPoints() >= 48) {
						this.setSkill1dlevel(6);
						this.setSubPoints(this.getSubPoints() - 48);
					}
				}
				else if (this.getSkill1dlevel() == 6) {
					if (this.getSubPoints() >= 60) {
						this.setSkill1dlevel(7);
						this.setSubPoints(this.getSubPoints() - 60);
					}
				}
				else if (this.getSkill1dlevel() == 7) {
					if (this.getSubPoints() >= 72) {
						this.setSkill1dlevel(8);
						this.setSubPoints(this.getSubPoints() - 72);
					}
				}
			}
		}
		else if (readInt == 127) {
			if (!this.getSkill1a()) {
				if (this.getSubPoints() >= 3) {
					this.setSkill1a(true);
					this.setSkill1alevel(1);
					this.setSubPoints(this.getSubPoints() - 3);
				}
			}
			else if (this.getSkill1a()) {
				if (this.getSkill1alevel() == 1) {
					if (this.getSubPoints() >= 6) {
						this.setSkill1alevel(2);
						this.setSubPoints(this.getSubPoints() - 6);
					}
				}
				else if (this.getSkill1alevel() == 2) {
					if (this.getSubPoints() >= 12) {
						this.setSkill1alevel(3);
						this.setSubPoints(this.getSubPoints() - 12);
					}
				}
				else if (this.getSkill1alevel() == 3) {
					if (this.getSubPoints() >= 24) {
						this.setSkill1alevel(4);
						this.setSubPoints(this.getSubPoints() - 24);
					}
				}
				else if (this.getSkill1alevel() == 4) {
					if (this.getSubPoints() >= 36) {
						this.setSkill1alevel(5);
						this.setSubPoints(this.getSubPoints() - 36);
					}
				}
				else if (this.getSkill1alevel() == 5) {
					if (this.getSubPoints() >= 48) {
						this.setSkill1alevel(6);
						this.setSubPoints(this.getSubPoints() - 48);
					}
				}
				else if (this.getSkill1alevel() == 6) {
					if (this.getSubPoints() >= 60) {
						this.setSkill1alevel(7);
						this.setSubPoints(this.getSubPoints() - 60);
					}
				}
				else if (this.getSkill1alevel() == 7) {
					if (this.getSubPoints() >= 72) {
						this.setSkill1alevel(8);
						this.setSubPoints(this.getSubPoints() - 72);
					}
				}
			}
		}
		else if (readInt == 128) {
			if (this.getSelectedSkill() == 0 || this.getSelectedSkill() == 1 || this.getSelectedSkill() == 2 || this.getSelectedSkill() == 3) {
				if (this.getSkill1h()) {
					this.setSelectedSkill(1);
				}
			}
		}
		else if (readInt == 129) {
			if (this.getSelectedSkill() == 0 || this.getSelectedSkill() == 1 || this.getSelectedSkill() == 2 || this.getSelectedSkill() == 3) {
				if (this.getSkill1d()) {
					this.setSelectedSkill(2);
				}
			}
		}
		else if (readInt == 130) {
			if (this.getSelectedSkill() == 0 || this.getSelectedSkill() == 1 || this.getSelectedSkill() == 2 || this.getSelectedSkill() == 3) {
				if (this.getSkill1a()) {
					this.setSelectedSkill(3);
				}
			}
		}
		else if (readInt == 131) {
			if (this.getKidoPoints() >= this.getHado4Cost()) {
				if (this.getHado4Level() <= 7) {
					this.setHado4Level(this.getHado4Level() + 1);
					this.setKidoPoints(this.getKidoPoints() - this.getHado4Cost());
					this.setHado4Cost(this.getHado4Cost() + 2);
				}
			}
		}
		else if (readInt == 132) {
			if (this.getKidoPoints() >= this.getBakudo1Cost()) {
				if (this.getBakudo1Level() <= 7) {
					this.setBakudo1Level(this.getBakudo1Level() + 1);
					this.setKidoPoints(this.getKidoPoints() - this.getBakudo1Cost());
					this.setBakudo1Cost(this.getBakudo1Cost() + 2);
				}
			}
		}
		else if (readInt == 133) {
			if (this.getKidoSkill() == 0 || this.getKidoSkill() == 2) {
				this.setKidoSkill(1);
			}
		}
		else if (readInt == 134) {
			if (this.getKidoSkill() == 0 || this.getKidoSkill() == 1) {
				this.setKidoSkill(2);
			}
		}
		else if (readInt == 135) {
			if (this.getKidoSkill() == 1) {
				if (this.getCurrentEnergy() >= (80/this.getBakudo1Level()) / this.getCurrentCap()) {
					final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityLiving.class, AxisAlignedBB.getBoundingBox(this.player.posX - 5.0, this.player.posY - 5.0, this.player.posZ - 5.0, this.player.posX + 5.0, this.player.posY + 5.0, this.player.posZ + 5.0));
	                for (int i = 0; i < players.size(); ++i) {
	                    final EntityLiving entity = (EntityLiving) players.get(i);
						if (entity instanceof EntityLiving) {
							EntityLiving e = (EntityLiving) entity;
							int time = this.getBakudo1Level() * 60;
				    		((EntityLiving) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, time, 4));	
						}
					}
	                this.consumeEnergy(80 / this.getBakudo1Level());
		    		player.addChatComponentMessage(new ChatComponentText("Bakudou 1: Sai!"));
				}
			}
			else if (this.getKidoSkill() == 2) {
				if (this.getCurrentEnergy() >= (80/this.getHado4Level()) / this.getCurrentCap()) {
					final List players = this.player.worldObj.getEntitiesWithinAABB((Class)EntityLiving.class, AxisAlignedBB.getBoundingBox(this.player.posX - 5.0, this.player.posY - 5.0, this.player.posZ - 5.0, this.player.posX + 5.0, this.player.posY + 5.0, this.player.posZ + 5.0));
	                for (int i = 0; i < players.size(); ++i) {
	                    final EntityLiving entity = (EntityLiving) players.get(i);
						if (entity instanceof EntityLiving) {
							EntityLiving e = (EntityLiving) entity;
							float damage = (this.getCurrentCap() / 100) + 10;
							EntityLightningBolt var7 = new EntityLightningBolt(e.worldObj, e.posX, e.posY, e.posZ);
				            e.worldObj.addWeatherEffect((Entity)var7);
				            e.worldObj.addWeatherEffect((Entity)var7);
				            e.attackEntityFrom(DamageSource.generic, damage);
				    		((EntityLiving) e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 4, 1));	
						}
					}
	                this.consumeEnergy(80 / this.getHado4Level());
		    		player.addChatComponentMessage(new ChatComponentText("Hado 4: Byakurai!"));
				}
			}
		}
    }
    
    public void activate(final ItemStack stack) {
        if (stack.getItem() == BleachItems.zanpakuto) {
            if (this.getCurrentCap() >= 200 && this.getPoints(9) >= 400 && stack.hasDisplayName() && stack.getDisplayName().equals(this.getZName()) && !this.player.worldObj.isRemote) {
                if (this.getFaction() == 1 || this.getFaction() == 11 || this.getFaction() == 5) {
                    if (this.getZType() == 1 && this.getZName().equalsIgnoreCase("vox populi")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 1 && this.getZName().equalsIgnoreCase("amaterasu")) {
                        this.setTexture(6);
                    } else if (this.getZType() == 2 && this.getZName().equalsIgnoreCase("ice cream")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 3 && this.getZName().equalsIgnoreCase("ashisogi jizo")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 4 && this.getZName().equalsIgnoreCase("love")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 5 && this.getZName().equalsIgnoreCase("piko piko")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 6 && this.getZName().equalsIgnoreCase("fightin words")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 7 && this.getZName().equalsIgnoreCase("master sword")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 8 && this.getZName().equalsIgnoreCase("souledge")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 9 && this.getZName().equalsIgnoreCase("zangetsu")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 9 && this.getZName().equalsIgnoreCase("benehime")) {
                        this.setTexture(6);
                    } else if (this.getZType() == 10 && this.getZName().equalsIgnoreCase("mjolnir")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 12 && this.getZName().equalsIgnoreCase("sakana")) {
                        this.setTexture(5);
                    } else if (this.getZType() == 11 && this.getZName().equalsIgnoreCase("ticonderoga")) {
                        this.setTexture(5);
                    }
                    final ItemStack shikai = this.Shikai[this.getZType() - 1];
                    shikai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, shikai);
                    this.shikaipre = shikai;
                    this.shikainame = shikai.getDisplayName();
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.ShikaiPhrases[6 * (this.getZType() - 1) + this.getZTex()] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                this.consumeEnergy(10);
            }
            }
            else if (stack.getItem() instanceof ItemShikai && this.getCurrentCap() >= 2500 && stack.hasDisplayName() && stack.getDisplayName().equals(this.getZName()) && (this.getFaction() == 1 || this.getFaction() == 5) && !this.player.worldObj.isRemote && this.getReady() && this.getBankaiUnlock()) {
                if (this.getZType() == 11) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankainormal);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 12) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaiwater);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 10) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankailightning);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 9) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankailunar);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 8) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaidark);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 7) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankailight);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 6) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaiwind);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 5) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaiearth);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 4) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaiheal);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 3) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaipoison);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 2) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaiice);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                else if (this.getZType() == 1) {
                    final ItemStack bankai = new ItemStack(BleachItems.bankaifire);
                    bankai.setStackDisplayName(stack.getDisplayName());
                    this.player.setCurrentItemOrArmor(0, bankai);
                    final Vec3 normalizer = Vec3.createVectorHelper(0.008, 0.008, 0.008).normalize();
                    final List list = this.player.worldObj.getEntitiesWithinAABB((Class)EntityPlayer.class, this.player.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 15.0), Math.abs(normalizer.yCoord * 15.0), Math.abs(normalizer.zCoord * 15.0)));
                    for (int l = 0; l < list.size(); ++l) {
                        final Entity entity1 = (Entity) list.get(l);
                        if (entity1 instanceof EntityPlayer) {
                            final EntityPlayer surroundingPlayers = (EntityPlayer)entity1;
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "BANNNNNN-"));
                            surroundingPlayers.addChatComponentMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.DARK_RED + "-KAIIIIIII"));
                            surroundingPlayers.addChatMessage((IChatComponent)new ChatComponentText(Names.BankaiPhrases[0] + " " + stack.getDisplayName() + "!"));
                        }
                    }
                }
                this.consumeEnergy(100);
                this.player.worldObj.playSoundAtEntity((Entity)this.player, "bleachreborn:bankai", 0.5f, 1.0f);
                this.setReady(false);
            }
    }
    
    public void deactivate(final Item theItem) {
        if (theItem instanceof ItemShikai) {
            final ItemStack Sword = new ItemStack(BleachItems.zanpakuto, 1);
            if (this.player.getHeldItem().getDisplayName() != null) {
                Sword.setStackDisplayName(this.player.getHeldItem().getDisplayName());
            }
            this.player.setCurrentItemOrArmor(0, Sword);
        } else if (theItem == BleachItems.quincybow) {
            final ItemStack Pendant = new ItemStack(BleachItems.quincypendant, 1, 0);
            this.player.setCurrentItemOrArmor(0, Pendant);
            this.player.getHeldItem().setItemDamage(0);
        } else if (theItem == BleachItems.quincyweb) {
            final ItemStack Pendant = new ItemStack(BleachItems.quincypendant, 1, 1);
            this.player.setCurrentItemOrArmor(0, Pendant);
            this.player.getHeldItem().setItemDamage(1);
        } else if (theItem == BleachItems.sanrei_bow) {
            final ItemStack Sanrei = new ItemStack(BleachItems.sanrei, 1, 1);
            this.player.setCurrentItemOrArmor(0, Sanrei);
        } else if (theItem instanceof ItemBankai) {
        	final ItemStack Sword = new ItemStack(BleachItems.zanpakuto, 1);
            if (this.player.getHeldItem().getDisplayName() != null) {
                Sword.setStackDisplayName(this.player.getHeldItem().getDisplayName());
            }
            this.player.setCurrentItemOrArmor(0, Sword);
        } else if (theItem == BleachItems.seele && this.player.getHeldItem().getItemDamage() == 1) {
            final ItemStack seele = new ItemStack(BleachItems.seele, 1, 0);
            this.player.setCurrentItemOrArmor(0, seele);
            this.player.getHeldItem().setItemDamage(0);
        }
    }
    
    static {
        ExtendedPlayer.does3D = false;
    }
}

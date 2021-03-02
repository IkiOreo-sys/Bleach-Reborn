package littlebreadloaf.bleachreborn.events;

public class BleachSounds
{
    private static final String BLEACH;
    public static String[] soundFiles;
    public static String[] streamingFiles;
    public static String[] HuecoMundoMusic;
    
    public boolean isHuecoMundoMusic(final String name) {
        for (int i = 0; i < BleachSounds.HuecoMundoMusic.length; ++i) {
            if (name.equals("bleachreborn:" + BleachSounds.HuecoMundoMusic[i])) {
                return true;
            }
        }
        return false;
    }
    
    static {
        BLEACH = "bleachreborn".toLowerCase() + ":";
        BleachSounds.soundFiles = new String[] { "bowcharge.ogg", "bowfire.ogg", "fisherlaugh1.ogg", "fisherlaugh2.ogg", "fisherlaugh3.ogg", "hollowscream.ogg", "ore_hollow.ogg", "shunpo.ogg", "pressure.ogg", "sonido.ogg", "bankai.ogg", "meditation.ogg", "bankainumber.ogg", "chomp.ogg" };
        BleachSounds.streamingFiles = new String[] { "asterisk.ogg", "NumberOne.ogg", "Escalon.ogg" };
        BleachSounds.HuecoMundoMusic = new String[] { "ardor.ogg", "belong.ogg", "heart.ogg", "home.ogg", "stay.ogg" };
    }
}

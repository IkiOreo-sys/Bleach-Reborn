package xyz.ashleyz.factions;

public enum BleachFactions {
    Hollow(HollowFaction.class);
    private final Class<?> at;
    BleachFactions(Class<?> at) {
        this.at = at;
    }
}

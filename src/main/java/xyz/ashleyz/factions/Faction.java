package xyz.ashleyz.factions;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public abstract class Faction {
    private static List<Faction> factions = new ArrayList<Faction>();
    Faction() {
        factions.add(this);
    }
    public interface FactionTypes {
        int test = 0;
    }
    public abstract int getId();
    public abstract String getName();
    
    
    @Nullable
    public static Faction getFactionByID(int id) {
        for(Faction faction : factions) {
            if(faction.getId() == id)
                return faction;
        }
        return null;
    }
}

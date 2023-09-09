package cz.vitekform.timv.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerUtil {

    private static Map<String, PData> PData = new HashMap<>();

    public static PData getPlayerData (Player p){
        if (!PData.containsKey(p.getUniqueId().toString())){
            PData pdata = new PData();
            PData.put(p.getUniqueId().toString(), pdata);
            return pdata;
        }
        return PData.get(p.getUniqueId().toString());
    }

    public static void setPData(Player p, PData data){
        if (data == null){
            PData.remove(p.getUniqueId().toString());
        }
        else {PData.put(p.getUniqueId().toString(), data);}

    }

    public static String folderPath(Player p){
        return Bukkit.getPluginsFolder().getAbsolutePath() + "/player/" + p.getUniqueId();
    }
}

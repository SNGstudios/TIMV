package cz.vitekform.timv.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class PJoinDataCreate implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        PData memory = new PData();
        File f = new File(PlayerUtil.folderPath(event.getPlayer()) + "/general.yml");

        if (f.exists()){
            FileConfiguration config = YamlConfiguration.loadConfiguration(f);
            memory.setTokens(config.getInt("eco.tokens"));
            memory.setKarma(config.getInt("eco.karma"));
            memory.setInnopoint(config.getInt("stats.innopoints"));
            memory.setDetectivepoint(config.getInt("stats.detectivepoints"));
            memory.setMurderpoint(config.getInt("stats.murderpoints"));
            memory.setKills(config.getInt("stats.kills"));
        }
        else {
            memory.setDetectivepoint(0);
            memory.setMurderpoint(0);
            memory.setInnopoint(0);
            memory.setKarma(100);
            memory.setTokens(500);
            memory.setKills(0);
        }

        PlayerUtil.setPData(event.getPlayer(), memory);
    }

    @EventHandler
    public void onPlayerQuits(PlayerQuitEvent event){
        PData memory = PlayerUtil.getPlayerData(event.getPlayer());
        File f = new File(PlayerUtil.folderPath(event.getPlayer()) + "/general.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("eco.tokens", memory.getTokens());
        config.set("eco.karma", memory.getKarma());
        config.set("stats.innopoints", memory.getInnopoint());
        config.set("stats.detectivepoints", memory.getDetectivepoint());
        config.set("stats.murderpoints", memory.getMurderpoint());
        config.set("stats.kills", memory.getKills());

        try {
            config.save(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PlayerUtil.setPData(event.getPlayer(), null);
    }
}

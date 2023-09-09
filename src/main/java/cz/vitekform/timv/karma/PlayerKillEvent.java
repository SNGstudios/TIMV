package cz.vitekform.timv.karma;

import cz.vitekform.timv.data.PlayerUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.io.File;
import java.io.IOException;

public class PlayerKillEvent implements Listener {

    @EventHandler
    public void PlayerKillsPlayer(EntityDeathEvent e) throws IOException {
        if (e.getEntity() instanceof Player){
            Player dead = (Player) e.getEntity();
            Player killer = e.getEntity().getKiller();
            File f = new File(PlayerUtil.folderPath(killer) + "/general.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(f);
            int curkarma = config.getInt("eco.karma");
            int totalkarma = curkarma;
            if (killer.hasMetadata("murder")){
                if (dead.hasMetadata("detective")){
                    totalkarma = curkarma + 40;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else if (dead.hasMetadata("murder")){
                    totalkarma = curkarma - 50;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else {
                    totalkarma = curkarma + 10;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
            }
            else if (killer.hasMetadata("detective")){
                if (dead.hasMetadata("murder")){
                    totalkarma = curkarma + 20;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else if (dead.hasMetadata("detective")){
                    totalkarma = curkarma - 40;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else {
                    totalkarma = curkarma - 20;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
            }
            else {
                if (dead.hasMetadata("murder")){
                    totalkarma = curkarma + 20;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else if (dead.hasMetadata("detective")){
                    totalkarma = curkarma - 40;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
                else {
                    totalkarma = curkarma - 20;
                    config.set("eco.karma", totalkarma);
                    config.save(f);
                }
            }
        }
    }
}

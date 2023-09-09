package cz.vitekform.timv.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class game_end_innocent implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(EntityDeathEvent event){
        if (event.getEntity() instanceof Player){
            Player dead = (Player) event.getEntity();
            if (dead.hasMetadata("murder")){
                if (Bukkit.getDefaultGameMode().equals(GameMode.ADVENTURE)){
                    Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
                }
                else if (Bukkit.getDefaultGameMode().equals(GameMode.SURVIVAL)){
                    Bukkit.setDefaultGameMode(GameMode.CREATIVE);
                }
                else if (Bukkit.getDefaultGameMode().equals(GameMode.CREATIVE)){

                }
                else {
                    ConsoleCommandSender console = Bukkit.getConsoleSender();
                    String cmd = "timv:innocentwin";
                    Bukkit.dispatchCommand(console, cmd);
                }
            }
        }
    }
}

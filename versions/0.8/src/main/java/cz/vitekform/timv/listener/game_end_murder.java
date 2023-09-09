package cz.vitekform.timv.listener;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class game_end_murder implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(EntityDeathEvent event){
        if (event.getEntity() instanceof Player){
            Player everyone = (Player) Bukkit.getOnlinePlayers();
            if (everyone.hasMetadata("murder")){
                ConsoleCommandSender console = Bukkit.getConsoleSender();
                String command = "timv:murderwin";
                Bukkit.dispatchCommand(console, command);
            }
        }
    }
}

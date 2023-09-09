package cz.vitekform.timv.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class dead_is_silent implements Listener {

    @EventHandler
    public void DeadTalkCancel (AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        if (p.hasMetadata("dead")){
            event.setCancelled(true);
            p.sendMessage("Shh. Dead can't talk!");
        }
    }
}

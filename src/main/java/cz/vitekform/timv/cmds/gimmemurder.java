package cz.vitekform.timv.cmds;

import cz.vitekform.timv.Timv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class gimmemurder implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            Timv plugin = Timv.getPlugin(Timv.class);
            if (sender.hasPermission("timv.admin")){
                Player p = (Player) sender;
                p.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
            }
        }
        return false;
    }
}

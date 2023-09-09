package cz.vitekform.timv.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class innocentwin implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)){
            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle(ChatColor.GREEN + "Innocents", ChatColor.GOLD + "won!", 1, 100, 1);
                World lobbyw = Bukkit.getWorld("lobby");
                Location lobby = new Location(lobbyw, 0, 140, -1);
                p.teleport(lobby);
            }
            Bukkit.broadcastMessage(" ---------------------------------");
            Bukkit.broadcastMessage("|" + ChatColor.GREEN + "         Innocents won!          " + ChatColor.WHITE + "|");
            Bukkit.broadcastMessage(" ---------------------------------");
        }
        return false;
    }
    }

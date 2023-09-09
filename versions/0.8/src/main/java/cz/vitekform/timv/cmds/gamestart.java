package cz.vitekform.timv.cmds;

import cz.vitekform.timv.Timv;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class gamestart implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Timv plugin = Timv.getPlugin(Timv.class);
        Player[] onlinePlayers = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        Player[] onlinePlayers1_murder = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        Player[] onlinePlayers2_murder = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        Player[] onlinePlayers3_murder = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        Player[] onlinePlayers4_detective = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        Player[] onlinePlayers5_detective = Bukkit.getOnlinePlayers().toArray(new Player[0]);
        if (onlinePlayers.length >= 10){
            Bukkit.broadcastMessage("[" + ChatColor.RED + "!" + ChatColor.WHITE + "] Game is starting in 20 seconds!" );
            for (Player player : Bukkit.getOnlinePlayers()){
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BANJO, 100, 100);
            }
            if (onlinePlayers.length == 20){
                Bukkit.getServer().setDefaultGameMode(GameMode.ADVENTURE);
                Arrays.sort(onlinePlayers1_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers2_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers3_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers4_detective, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers5_detective, Comparator.comparing(Player::getName));
                Random random1_murder = new Random();
                Random random2_murder = new Random();
                Random random3_murder = new Random();
                Random random4_detective = new Random();
                Random random5_detective = new Random();
                int randomIndex1_murder = random1_murder.nextInt(onlinePlayers.length);
                int randomIndex2_murder = random2_murder.nextInt(onlinePlayers.length);
                int randomIndex3_murder = random3_murder.nextInt(onlinePlayers.length);
                int randomIndex4_detective = random4_detective.nextInt(onlinePlayers.length);
                int randomIndex5_detective = random5_detective.nextInt(onlinePlayers.length);
                Player randomPlayer2_murder = onlinePlayers2_murder[randomIndex2_murder];
                Player randomPlayer3_murder = onlinePlayers3_murder[randomIndex3_murder];
                Player randomPlayer4_detective = onlinePlayers4_detective[randomIndex4_detective];
                Player randomPlayer5_detective = onlinePlayers5_detective[randomIndex5_detective];
                Player randomPlayer1_murder = onlinePlayers1_murder[randomIndex1_murder];
                randomPlayer1_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer2_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer3_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer4_detective.setMetadata("detective", new FixedMetadataValue(plugin, "true"));
                randomPlayer5_detective.setMetadata("detective", new FixedMetadataValue(plugin, "true"));
                for (Player player : Bukkit.getOnlinePlayers()){

                }
            }
            else if (onlinePlayers.length >= 15){
                Bukkit.getServer().setDefaultGameMode(GameMode.SURVIVAL);
                Arrays.sort(onlinePlayers1_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers2_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers3_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers4_detective, Comparator.comparing(Player::getName));
                Random random1_murder = new Random();
                Random random2_murder = new Random();
                Random random3_murder = new Random();
                Random random4_detective = new Random();
                int randomIndex1_murder = random1_murder.nextInt(onlinePlayers.length);
                int randomIndex2_murder = random2_murder.nextInt(onlinePlayers.length);
                int randomIndex3_murder = random3_murder.nextInt(onlinePlayers.length);
                int randomIndex4_detective = random4_detective.nextInt(onlinePlayers.length);
                Player randomPlayer2_murder = onlinePlayers2_murder[randomIndex2_murder];
                Player randomPlayer3_murder = onlinePlayers3_murder[randomIndex3_murder];
                Player randomPlayer4_detective = onlinePlayers4_detective[randomIndex4_detective];
                Player randomPlayer1_murder = onlinePlayers1_murder[randomIndex1_murder];
                randomPlayer1_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer2_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer3_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer4_detective.setMetadata("detective", new FixedMetadataValue(plugin, "true"));
                for (Player player : Bukkit.getOnlinePlayers()){

                }
            }
            else {
                Bukkit.getServer().setDefaultGameMode(GameMode.CREATIVE);
                Arrays.sort(onlinePlayers1_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers2_murder, Comparator.comparing(Player::getName));
                Arrays.sort(onlinePlayers4_detective, Comparator.comparing(Player::getName));
                Random random1_murder = new Random();
                Random random2_murder = new Random();
                Random random4_detective = new Random();
                int randomIndex1_murder = random1_murder.nextInt(onlinePlayers.length);
                int randomIndex2_murder = random2_murder.nextInt(onlinePlayers.length);
                int randomIndex4_detective = random4_detective.nextInt(onlinePlayers.length);
                Player randomPlayer2_murder = onlinePlayers2_murder[randomIndex2_murder];
                Player randomPlayer4_detective = onlinePlayers4_detective[randomIndex4_detective];
                Player randomPlayer1_murder = onlinePlayers1_murder[randomIndex1_murder];
                randomPlayer1_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer2_murder.setMetadata("murder", new FixedMetadataValue(plugin, "true"));
                randomPlayer4_detective.setMetadata("detective", new FixedMetadataValue(plugin, "true"));
                for (Player player : Bukkit.getOnlinePlayers()){

                }
            }
        }
        else {
            Bukkit.broadcastMessage("[" + ChatColor.RED + "!" + ChatColor.WHITE + "] " + ChatColor.RED + "TIMV tried to start but there wasn't enought online players!");
        }
        return false;
    }
}

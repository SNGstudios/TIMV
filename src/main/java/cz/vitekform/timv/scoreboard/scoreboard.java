package cz.vitekform.timv.scoreboard;

import cz.vitekform.timv.Timv;
import cz.vitekform.timv.data.PData;
import cz.vitekform.timv.data.PlayerUtil;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class scoreboard implements Listener {
    Integer Alive = 0;


    @EventHandler
    public void onDeadPlayer(PlayerDeathEvent event){
        Integer Alive1 = Alive;
        Alive = Alive1 - 1;
    }
    private final Map<UUID, FastBoard> boards = new HashMap<>();
    public scoreboard(Timv plugin){
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);

        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {



            for (FastBoard board : boards.values()){
                Player player = board.getPlayer();
                World lobby = Bukkit.getWorld("lobby");
                if (!player.getWorld().equals(lobby)){
                String role = "null";
                String alive = String.valueOf(Alive);

                if (player.hasMetadata("murder")){role = "&cTraitor";}
                else if (player.hasMetadata("detective")){role = "&bDetective";}
                else {role = "&aInnocent";}
                UpdateBoard(board,
                        "",
                        "&fRole",
                        role,
                        "Remaining players",
                        alive);

                    }
                else {
                    PData memory = new PData();
                    File f = new File(PlayerUtil.folderPath(player) + "/general.yml");
                    FileConfiguration config = YamlConfiguration.loadConfiguration(f);
                    int tokens = config.getInt("eco.tokens");
                    String tokenss = String.valueOf(tokens);
                    int karma = config.getInt("eco.karma");
                    String karmas = String.valueOf(karma);
                    int dep = config.getInt("stats.detectivepoints");
                    int mup = config.getInt("stats.murderpoints");
                    int inp = config.getInt("stats.innopoints");
                    int rolepoints = inp + mup + dep;
                    String rolepointss = String.valueOf(rolepoints);
                    String inps = String.valueOf(inp);
                    String deps = String.valueOf(dep);
                    String mups = String.valueOf(mup);
                    UpdateBoard(board, "Stats",
                            " ",
                            "Tokens      " + tokenss,
                            "Karma      " + karmas,
                            "Role Points      " + rolepointss,
                            "Innocent      " + inps,
                            "Detective      " + deps,
                            "Traitor      " + mups
                            );
                }
            }

        }, 0L, 10L);
    }

    @EventHandler
    public void onGameStart(PlayerChangedWorldEvent event){
        Player p = event.getPlayer();
        FastBoard board = new FastBoard(p);

        String title = "&7&lTIMV";
        board.updateTitle(ChatColor.translateAlternateColorCodes('&', title));

        boards.put(p.getUniqueId(), board);
    }

    @EventHandler
    public void onPlayerLeaves(PlayerQuitEvent event){
        Player p = event.getPlayer();
        FastBoard board = boards.remove(p.getUniqueId());

        if (board != null){
            board.delete();
        }
    }

    private void UpdateBoard(FastBoard board, String ... lines){
        for (int a = 0; a < lines.length; ++a){
            lines[a] = ChatColor.translateAlternateColorCodes('&', lines[a]);
        }

        board.updateLines(lines);
    }

    @EventHandler
    public void onPlayerChangesWorld(PlayerChangedWorldEvent event){
        Alive = Bukkit.getOnlinePlayers().size();
    }
}

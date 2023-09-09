package cz.vitekform.timv;

import cz.vitekform.timv.cmds.*;
import cz.vitekform.timv.data.PJoinDataCreate;
import cz.vitekform.timv.karma.PlayerKillEvent;
import cz.vitekform.timv.listener.*;
import cz.vitekform.timv.scoreboard.scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class Timv extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getLogger().log(Level.INFO, ChatColor.YELLOW + "Enabling plugin...");
        getServer().getPluginManager().registerEvents(new dead_is_silent(), this);
        getServer().getPluginManager().registerEvents(new game_end_innocent(), this);
        getServer().getPluginManager().registerEvents(new game_end_murder(), this);
        getServer().getPluginManager().registerEvents(new chest_loot(), this);
        getServer().getPluginManager().registerEvents(new PJoinDataCreate(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillEvent(), this);
        getCommand("start_timv").setExecutor(new gamestart());
        getCommand("murderwin").setExecutor(new murderwin());
        getCommand("innocentwin").setExecutor(new innocentwin());
        getCommand("murder").setExecutor(new gimmemurder());
        getCommand("detective").setExecutor(new gimmedetective());
        getCommand("gimmetoken").setExecutor(new gimmetoken());
        super.onEnable();
        new scoreboard(this);
        this.getLogger().log(Level.INFO, ChatColor.GREEN + "Plugin enabled!");
    }

    @Override
    public void onDisable() {
        this.getLogger().log(Level.INFO, ChatColor.YELLOW + "Disabling plugin...");
        super.onDisable();
        this.getLogger().log(Level.INFO, ChatColor.RED + "Plugin disabled!");
    }
}

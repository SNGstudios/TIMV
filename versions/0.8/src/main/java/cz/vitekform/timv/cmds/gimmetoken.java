package cz.vitekform.timv.cmds;

import cz.vitekform.timv.data.PlayerUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class gimmetoken implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender.hasPermission("timv.tokengive")){
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length != 1){
                p.sendMessage("You must provide 1 argument!");
            }
            else {
                String str = args[0];
                File f = new File(PlayerUtil.folderPath(p) + "/general.yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(f);
                int currenttoken = config.getInt("eco.tokens");
                try{
                    int number = Integer.parseInt(str);
                    int totaltokens = currenttoken + number;
                    config.set("eco.tokens", totaltokens);
                    try {
                        config.save(f);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        }}
        return false;
    }
}

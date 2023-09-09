package cz.vitekform.timv.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class chest_loot implements Listener {

    @EventHandler
    public void ChestLoot(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if (event.getClickedBlock().getType().equals(Material.CHEST)){
                Random loot = new Random();
                int looti = loot.nextInt(3);
                Player p = event.getPlayer();
                if (looti == 1){
                    ItemStack woodensword = new ItemStack(Material.WOODEN_SWORD);
                    p.getInventory().addItem(woodensword);
                }
                else if (looti == 2){
                    ItemStack stonesword = new ItemStack(Material.STONE_SWORD);
                    p.getInventory().addItem(stonesword);
                }
                else {
                    ItemStack bow = new ItemStack(Material.BOW);
                    ItemStack arrow = new ItemStack(Material.ARROW, 32);
                    if (p.getInventory().contains(Material.BOW)){
                        p.getInventory().addItem(arrow);
                    }
                    else {
                        p.getInventory().addItem(bow);
                        p.getInventory().addItem(arrow);
                    }
                }
            }
        }
    }
}

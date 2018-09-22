package me.Jelle30.Events;

import org.bukkit.ChatColor;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class PlayerListner implements Listener {

    public PlayerListner(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler

    public void onThrow(PlayerEggThrowEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("Events.throw.egg")) {
            player.sendMessage(ChatColor.RED + "Do not throw egg's!");
        } else {

            player.sendMessage(ChatColor.GREEN + "I like to throw egg's!");

        }


    }

    @EventHandler

    public void onInventoryOpenEvent(InventoryOpenEvent e)  {
        if(e.getInventory().getHolder() instanceof Chest || e.getInventory().getHolder() instanceof DoubleChest)    {
            Player player = (Player) e.getPlayer();
            if(!player.hasPermission("Events.open.chest")) {
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You may not open chests!");
            } else {
                e.setCancelled(false);
                player.sendMessage(ChatColor.GREEN + "You opened a chest!");

            }
        }
    }
}
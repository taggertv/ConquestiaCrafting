/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spearhartt.conquestiacrafting;

import com.spearhartt.conquestiacrafting.Config.Config;
//import com.spearhartt.conquestiacrafting.command.CqCommandHandler;
import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Taggert
 */
public class ConquestiaCrafting extends JavaPlugin implements Listener {

    private JavaPlugin plugin;
    private Player player;
    
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
//        new CqCommandHandler(this);
        reloadConfig();
        Config PlayerConfig = new Config(this, "players");
    }
    
    public void onDisable()
    {
    }
    
    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=false)
    public void onJoin(PlayerJoinEvent event)
    {
        player = event.getPlayer();
        Config markConfig = new Config(this.plugin, "Marks" + File.separator + player.getName());
        markConfig.getConfig().set("x", player.getLocation().getX());
        markConfig.getConfig().set("y", player.getLocation().getY());
        markConfig.getConfig().set("z", player.getLocation().getZ());
        markConfig.getConfig().set("world", player.getWorld().toString());
//        craftConfig.getConfig().set("Platecraft", 1);
//        craftConfig.getConfig().set("Magecraft", 1);
//        craftConfig.getConfig().set("Stovecraft", 1);
//        craftConfig.getConfig().set("Huntcraft", 1);
//        craftConfig.getConfig().set("Gemcraft", 1);
//        craftConfig.getConfig().set("Leathercraft", 1);
//        craftConfig.getConfig().set("Weaponcraft", 1);
        markConfig.saveConfig();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "ConquestiaCrafting" + ChatColor.BLUE + "]" + ChatColor.RESET + "created config for " + ChatColor.AQUA + event.getPlayer().getName());
        
//        craftConfig.getConfig().set("Weaponsmith", );
    }
}

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
        Config PlayerConfig = new Config(this, "Players" + File.separator);
    }
    
    public void onDisable()
    {
    }
    
    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=false)
    public void onJoin(PlayerJoinEvent event) throws InterruptedException
    {
        player = event.getPlayer();
        Config PlayerConfig = new Config(this, "Players" + File.separator + player.getName());
        PlayerConfig.getConfig().set("Test", "Taggert likes pie");
        PlayerConfig.saveConfig();
//        craftConfig.getConfig().set("Platecraft", 1);
//        craftConfig.getConfig().set("Magecraft", 1);
//        craftConfig.getConfig().set("Stovecraft", 1);
//        craftConfig.getConfig().set("Huntcraft", 1);
//        craftConfig.getConfig().set("Gemcraft", 1);
//        craftConfig.getConfig().set("Leathercraft", 1);
//        craftConfig.getConfig().set("Weaponcraft", 1);
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(ChatColor.BLUE + "[" + ChatColor.GOLD + "ConquestiaCrafting" + ChatColor.BLUE + "]" + ChatColor.RESET + "created config for " + ChatColor.AQUA + event.getPlayer().getName());
        
//        craftConfig.getConfig().set("Weaponsmith", );
    }
}

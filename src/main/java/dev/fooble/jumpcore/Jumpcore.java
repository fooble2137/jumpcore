package dev.fooble.jumpcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Jumpcore extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aJumpcore successfully started!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§aJumpcore successfully stopped!");
    }
}
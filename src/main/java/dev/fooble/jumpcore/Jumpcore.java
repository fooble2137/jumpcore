package dev.fooble.jumpcore;

import dev.fooble.jumpcore.commands.JumpcoreCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Jumpcore extends JavaPlugin {

    @Override
    public void onEnable () {
        this.getCommand("jumpcore").setExecutor(new JumpcoreCommand(this));
        this.getCommand("jumpcore").setTabCompleter(new JumpcoreCommand(this));

        Bukkit.getConsoleSender().sendMessage("§aJumpcore successfully started!");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§aJumpcore successfully stopped!");
    }
}
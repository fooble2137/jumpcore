package dev.fooble.mc.jumpcore;

import dev.fooble.mc.jumpcore.command.JumpcoreCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        Objects.requireNonNull(this.getCommand("jumpcore")).setExecutor(new JumpcoreCommand());
        Objects.requireNonNull(this.getCommand("jumpcore")).setTabCompleter(new JumpcoreCommand());

        this.getLogger().info("Jumpcore has been enabled!");
    }

    @Override
    public void onDisable() {
        super.onDisable();

        this.getLogger().info("Jumpcore has been disabled!");
    }
}
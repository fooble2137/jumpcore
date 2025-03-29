package dev.fooble.mc.jumpcore;

import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();

        this.getLogger().info("JumpCore has been enabled!");
    }

    @Override
    public void onDisable() {
        super.onDisable();

        this.getLogger().info("JumpCore has been disabled!");
    }
}
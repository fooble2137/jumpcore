package dev.fooble.mc.jumpcore.command;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {

    public abstract String getName();

    public abstract String getUsage();

    public abstract String getPermission();

    public abstract void execute(Player player, String[] args);

}
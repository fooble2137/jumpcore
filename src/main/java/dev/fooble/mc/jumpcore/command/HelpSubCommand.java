package dev.fooble.mc.jumpcore.command;

import org.bukkit.entity.Player;

import java.util.List;

public class HelpSubCommand extends SubCommand {

    private final List<SubCommand> subCommands;

    public HelpSubCommand(List<SubCommand> subCommands) {
        this.subCommands = subCommands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getUsage() {
        return "help";
    }

    @Override
    public String getPermission() {
        return "jumpcore.help";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("test");
    }
}

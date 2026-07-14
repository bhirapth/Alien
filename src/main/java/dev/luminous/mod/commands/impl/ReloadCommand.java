package dev.luminous.mod.commands.impl;

import dev.luminous.Supernova;
import dev.luminous.core.impl.CommandManager;
import dev.luminous.core.impl.ConfigManager;
import dev.luminous.mod.commands.Command;

import java.util.List;

public class ReloadCommand extends Command {

	public ReloadCommand() {
		super("reload", "");
	}

	@Override
	public void runCommand(String[] parameters) {
		CommandManager.sendChatMessage("§fReloading..");
		Supernova.CONFIG = new ConfigManager();
		Supernova.PREFIX = Supernova.CONFIG.getString("prefix", Supernova.PREFIX);
		Supernova.CONFIG.loadSettings();
		Supernova.XRAY.read();
		Supernova.TRADE.read();
		Supernova.FRIEND.read();
	}

	@Override
	public String[] getAutocorrect(int count, List<String> seperated) {
		return null;
	}
}

package cc.supernova.mod.commands.impl;

import cc.supernova.Supernova;
import cc.supernova.core.impl.CommandManager;
import cc.supernova.core.impl.ConfigManager;
import cc.supernova.mod.commands.Command;

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

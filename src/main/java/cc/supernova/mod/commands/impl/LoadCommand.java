package cc.supernova.mod.commands.impl;

import cc.supernova.Supernova;
import cc.supernova.core.Manager;
import cc.supernova.core.impl.CommandManager;
import cc.supernova.core.impl.ConfigManager;
import cc.supernova.mod.commands.Command;

import java.util.List;

public class LoadCommand extends Command {

	public LoadCommand() {
		super("load", "[config]");
	}

	@Override
	public void runCommand(String[] parameters) {
		if (parameters.length == 0) {
			sendUsage();
			return;
		}
		CommandManager.sendChatMessage("§fLoading..");
		ConfigManager.options = Manager.getFile(parameters[0] + ".cfg");
		Supernova.CONFIG = new ConfigManager();
		Supernova.PREFIX = Supernova.CONFIG.getString("prefix", Supernova.PREFIX);
		Supernova.CONFIG.loadSettings();
        ConfigManager.options = Manager.getFile("options.txt");
		Supernova.save();
	}

	@Override
	public String[] getAutocorrect(int count, List<String> seperated) {
		return null;
	}
}

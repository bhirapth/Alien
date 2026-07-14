package cc.supernova.mod.commands.impl;

import cc.supernova.Supernova;
import cc.supernova.core.impl.CommandManager;
import cc.supernova.mod.commands.Command;

import java.util.List;

public class ReloadAllCommand extends Command {

	public ReloadAllCommand() {
		super("reloadall", "");
	}

	@Override
	public void runCommand(String[] parameters) {
		CommandManager.sendChatMessage("§fReloading..");
		Supernova.unload();
        try {
            Supernova.load();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public String[] getAutocorrect(int count, List<String> seperated) {
		return null;
	}
}

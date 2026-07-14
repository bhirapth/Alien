package cc.supernova.mod.commands.impl;

import cc.supernova.Supernova;
import cc.supernova.core.impl.CommandManager;
import cc.supernova.mod.commands.Command;
import cc.supernova.mod.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class ToggleCommand extends Command {

	public ToggleCommand() {
		super("toggle", "[module]");
	}

	@Override
	public void runCommand(String[] parameters) {
		if (parameters.length == 0) {
			sendUsage();
			return;
		}
		String moduleName = parameters[0];
		Module module = Supernova.MODULE.getModuleByName(moduleName);
		if (module == null) {
			CommandManager.sendChatMessage("§cUnknown module");
			return;
		}
		module.toggle();
	}

	@Override
	public String[] getAutocorrect(int count, List<String> seperated) {
		if (count == 1) {
			String input = seperated.get(seperated.size() - 1).toLowerCase();
			List<String> correct = new ArrayList<>();
			for (Module x : Supernova.MODULE.modules) {
				if (input.equalsIgnoreCase(Supernova.PREFIX + "toggle") || x.getName().toLowerCase().startsWith(input)) {
					correct.add(x.getName());
				}
			}
			int numCmds = correct.size();
			String[] commands = new String[numCmds];

			int i = 0;
			for (String x : correct) {
				commands[i++] = x;
			}

			return commands;
		}
		return null;
	}
}

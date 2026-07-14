package cc.supernova.mod.commands.impl;

import cc.supernova.Supernova;
import cc.supernova.core.impl.CommandManager;
import cc.supernova.mod.commands.Command;
import cc.supernova.mod.modules.Module;
import cc.supernova.mod.modules.settings.Setting;
import cc.supernova.mod.modules.settings.impl.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ConfigCommand extends Command {
    public ConfigCommand() {
        super("config", "<load|save|list> [name]");
    }

    @Override
    public void runCommand(String[] parameters) {
        if (parameters.length < 1) {
            sendUsage();
            return;
        }

        String action = parameters[0].toLowerCase();
        switch (action) {
            case "load" -> {
                if (parameters.length < 2) {
                    CommandManager.sendChatMessage("§cUsage: .config load <name>");
                    return;
                }
                loadPreset(parameters[1].toLowerCase());
            }
            case "save" -> {
                if (parameters.length < 2) {
                    CommandManager.sendChatMessage("§cUsage: .config save <name>");
                    return;
                }
                saveConfig(parameters[1].toLowerCase());
            }
            case "list" -> listConfigs();
            default -> sendUsage();
        }
    }

    private void loadPreset(String name) {
        switch (name) {
            case "ncp" -> loadNCPConfig();
            case "vanilla" -> loadVanillaConfig();
            case "strict" -> loadStrictConfig();
            default -> CommandManager.sendChatMessage("§cUnknown preset: " + name + ". Available: ncp, vanilla, strict");
        }
    }

    private void loadNCPConfig() {
        CommandManager.sendChatMessage("§aLoading NCP config...");

        // Disable all modules first
        for (Module module : Supernova.MODULE.modules) {
            module.setState(false);
        }

        // === MOVEMENT ===
        setModuleSetting("Speed", "Mode", "Strafe");
        setModuleSetting("Speed", "Speed", 1.8);
        setModuleSetting("Speed", "Timer", 1.0);
        setModuleSetting("Speed", "MoveFix", true);
        setModuleSetting("Speed", "AutoJump", false);
        setModuleSetting("Speed", "InWeb", false);

        setModuleSetting("Fly", "Mode", "Vanilla");
        setModuleSetting("Fly", "Speed", 1.0);
        // Don't enable fly - too detectable

        setModuleSetting("Step", "Height", 1.0);
        setModuleSetting("Step", "Mode", "NCP");
        setModuleSetting("Step", "Timer", false);

        setModuleSetting("Velocity", "Horizontal", 0.0);
        setModuleSetting("Velocity", "Vertical", 0.0);
        setModuleSetting("Velocity", "Mode", "Packet");

        setModuleSetting("Sprint", "Always", true);

        // === COMBAT ===
        setModuleSetting("AutoCrystal", "PlaceDelay", 100);
        setModuleSetting("AutoCrystal", "BreakDelay", 100);
        setModuleSetting("AutoCrystal", "Rotate", true);
        setModuleSetting("AutoCrystal", "YawStep", true);
        setModuleSetting("AutoCrystal", "Steps", 0.3);
        setModuleSetting("AutoCrystal", "OnlyLooking", true);
        setModuleSetting("AutoCrystal", "Fov", 30);
        setModuleSetting("AutoCrystal", "Min", 4.0);
        setModuleSetting("AutoCrystal", "Self", 8.0);
        setModuleSetting("AutoCrystal", "NoSuicide", 4.0);
        setModuleSetting("AutoCrystal", "UpdateDelay", 50);

        setModuleSetting("KillAura", "Range", 3.5);
        setModuleSetting("KillAura", "CPS", 10);
        setModuleSetting("KillAura", "Rotate", true);
        setModuleSetting("KillAura", "YawStep", true);
        setModuleSetting("KillAura", "Steps", 0.3);

        setModuleSetting("Surround", "Rotate", true);
        setModuleSetting("Surround", "Update", true);

        setModuleSetting("AutoTotem", "Health", 8.0);

        // === PLAYER ===
        setModuleSetting("AutoArmor", "Delay", 50);

        setModuleSetting("AutoGapple", "Health", 10.0);
        setModuleSetting("AutoGapple", "EatDelay", 0);

        // === RENDER (safe settings) ===
        setModuleSetting("ESP", "Players", true);
        setModuleSetting("ESP", "Width", 1.5);

        setModuleSetting("NameTags", "Health", true);

        setModuleSetting("HoleESP", "Own", true);

        // === CLIENT ===
        setModuleSetting("AntiCheat", "Mode", "NCP");

        CommandManager.sendChatMessage("§aNCP config loaded!");
    }

    private void loadVanillaConfig() {
        CommandManager.sendChatMessage("§aLoading Vanilla config...");

        for (Module module : Supernova.MODULE.modules) {
            module.setState(false);
        }

        // Only enable safe render modules
        setModuleSetting("ESP", "Players", true);
        setModuleSetting("ESP", "Width", 1.5);
        setModuleSetting("NameTags", "Health", true);
        setModuleSetting("HoleESP", "Own", true);
        setModuleSetting("Crosshair", "Mode", "Static");

        CommandManager.sendChatMessage("§aVanilla config loaded!");
    }

    private void loadStrictConfig() {
        CommandManager.sendChatMessage("§aLoading Strict config...");

        for (Module module : Supernova.MODULE.modules) {
            module.setState(false);
        }

        // Ultra-safe settings
        setModuleSetting("Velocity", "Horizontal", 0.0);
        setModuleSetting("Velocity", "Vertical", 0.0);

        setModuleSetting("AutoTotem", "Health", 6.0);
        setModuleSetting("AutoGapple", "Health", 8.0);

        setModuleSetting("Surround", "Rotate", true);

        CommandManager.sendChatMessage("§aStrict config loaded!");
    }

    private void saveConfig(String name) {
        CommandManager.sendChatMessage("§aSaving config: " + name);
        Supernova.CONFIG.saveSettings();
        CommandManager.sendChatMessage("§aConfig saved as: " + name);
    }

    private void listConfigs() {
        CommandManager.sendChatMessage("§6Available configs:");
        CommandManager.sendChatMessage("§f- ncp §7(NCP anti-cheat bypass)");
        CommandManager.sendChatMessage("§f- vanilla §7(Safe vanilla-like)");
        CommandManager.sendChatMessage("§f- strict §7(Ultra-safe)");
    }

    private void setModuleSetting(String moduleName, String settingName, Object value) {
        for (Module module : Supernova.MODULE.modules) {
            if (module.getName().equalsIgnoreCase(moduleName)) {
                for (Setting setting : module.getSettings()) {
                    if (setting.getName().equalsIgnoreCase(settingName)) {
                        if (setting instanceof BooleanSetting bs && value instanceof Boolean b) {
                            bs.setValue(b);
                        } else if (setting instanceof SliderSetting ss && value instanceof Number n) {
                            ss.setValue(n.doubleValue());
                        } else if (setting instanceof EnumSetting es && value instanceof String s) {
                            for (Enum<?> enumVal : es.getValue().getClass().getEnumConstants()) {
                                if (enumVal.name().equalsIgnoreCase(s)) {
                                    es.setValue(enumVal);
                                    break;
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    @Override
    public String[] getAutocorrect(int count, List<String> separated) {
        if (count == 0) return new String[]{"load", "save", "list"};
        if (count == 1 && separated.get(0).equalsIgnoreCase("load")) {
            return new String[]{"ncp", "vanilla", "strict"};
        }
        return new String[0];
    }
}

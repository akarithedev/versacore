package dev.ayame.versacore.handlers;
import dev.ayame.versacore.VersaCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
public class dataHandler {
    public final File locations;
    public static dataHandler INSTANCE;
    private FileConfiguration data, config;
    public dataHandler() {
        INSTANCE = this;
        VersaCore.INSTANCE.getConfig().options().copyDefaults(true);
        VersaCore.INSTANCE.saveDefaultConfig();
        updateConfig();
        locations = new File(VersaCore.INSTANCE.getDataFolder().getPath(), "locations.yml");

        if (!locations.exists()) {
            try {
                if (locations.createNewFile()) {
                    VersaCore.INSTANCE.getLogger().info("§aCreated a new file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateData();
    }
        public void updateConfig() {
            VersaCore.INSTANCE.reloadConfig();
            config = VersaCore.INSTANCE.getConfig();
        }
       public void updateData() {
           data = YamlConfiguration.loadConfiguration(locations);
       }
        public void writeData(final String key, final Object value) {
            data.set(key, value);
            try {
                data.save(locations);
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
       public Object getData(final String key) {
        if (data.isSet(key))
            return data.get(key);
        return null;
    }

    }

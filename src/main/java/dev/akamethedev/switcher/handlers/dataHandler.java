package dev.akamethedev.switcher.handlers;
import dev.akamethedev.switcher.Switcher;
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
        Switcher.INSTANCE.getConfig().options().copyDefaults(true);
        Switcher.INSTANCE.saveDefaultConfig();
        updateConfig();
        locations = new File(Switcher.INSTANCE.getDataFolder().getPath(), "locations.yml");

        if (!locations.exists()) {
            try {
                if (locations.createNewFile()) {
                    Switcher.INSTANCE.getLogger().info("§aCreated a new file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateData();
    }
        public void updateConfig() {
            Switcher.INSTANCE.reloadConfig();
            config = Switcher.INSTANCE.getConfig();
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

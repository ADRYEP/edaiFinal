package app;

import edai.proyectoFinal.lib.Cache;
import edai.proyectoFinal.lib.FileHandler;
import edai.proyectoFinal.lib.exceptions.KeyNotFoundException;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "CacheCLI", mixinStandardHelpOptions = true, version = "1.0",
        description = "A command line application that implements a cache and file handler.")
public class CacheApp implements Runnable {

    private Cache cache;
    private FileHandler fileHandler;

    @CommandLine.Option(names = {"-a", "--add"}, description = "Add key and value to the cache.")
    private String key;
    @CommandLine.Option(names = {"-v", "--value"}, description = "Value of the key.")
    private String value;

    @CommandLine.Option(names = {"-g", "--get"}, description = "Retrieve the value of a key.")
    private String getKey;

    @CommandLine.Option(names = {"-s", "--save"}, description = "Save the cache to a file.")
    private String saveFile;

    @CommandLine.Option(names = {"-l", "--load"}, description = "Load the keys from a file.")
    private String loadFile;

    /**
     *
     */
    @Override
    public void run() {
        cache = new Cache();
        if (key != null && value != null) {
            cache.put(key, value);
        }
        if (getKey != null) {
            try {
                System.out.println(cache.get(getKey));
            } catch (KeyNotFoundException e) {
                System.out.println("Key not found");
            }
        }
        if (saveFile != null) {
            fileHandler = new FileHandler(saveFile);
            try {
                fileHandler.saveCacheToFile(cache);
                System.out.println("Cache saved to " + saveFile);
            } catch (IOException e) {
                System.out.println("An error occurred while saving the cache to file: " + e.getMessage());
            }
        }
        if (loadFile != null) {
            fileHandler = new FileHandler(loadFile);
            try {
                cache = fileHandler.loadCacheFromFile();
                System.out.println("Cache loaded from " + loadFile);
            } catch (IOException e) {
                System.out.println("An error occurred while loading the cache from file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new CacheApp()).execute(args);
        System.exit(exitCode);
    }
}

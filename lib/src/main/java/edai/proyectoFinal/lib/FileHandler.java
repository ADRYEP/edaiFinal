package edai.proyectoFinal.lib;

import java.io.*;

public class FileHandler {
    private final String fileName;
    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    public void saveCacheToFile(Cache cache) throws IOException{
        FileWriter writer = new FileWriter(fileName);
        String[] keys = cache.getAll();
        for (String key : keys){
            writer.write(key + System.lineSeparator());
        }
        writer.close();
    }

    public Cache loadCacheFromFile() throws IOException{
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Cache cache = new Cache();
        String key;
        while ((key = bufferedReader.readLine()) != null) {
            cache.put(key, null); // loading only keys, no values
        }
        bufferedReader.close();
        return cache;
    }
}

package edai.proyectoFinal.lib;

import edai.proyectoFinal.lib.exceptions.DuplicatedKeyException;
import edai.proyectoFinal.lib.exceptions.KeyNotFoundException;

import java.util.HashMap;

public class Cache implements ICache {

    private HashMap<String, String> cache;

    public Cache() {
        cache = new HashMap<>();
    }

    public void put(String key1, String value1) {
        cache.put(key1, value1);
    }

    /**
     * @param key   Key to be stored.
     * @param value Value to be stored.
     */
    @Override
    public void addNew(String key, String value) throws DuplicatedKeyException {
        if (cache.containsKey(key)) {
            throw new DuplicatedKeyException();
        }
        cache.put(key, value);
    }

    /**
     * @param key Key to be stored.
     */
    @Override
    public void remove(String key) throws KeyNotFoundException {
        if (!cache.containsKey(key)){
            throw new KeyNotFoundException();
        }
        cache.remove(key);
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return cache.size();
    }

    /**
     * @return
     */
    @Override
    public String[] getAll() {
        return cache.keySet().toArray(new String[0]);
    }

    public String get(String key1) throws KeyNotFoundException {
        if (!cache.containsKey(key1)){
            throw new KeyNotFoundException();
        }
        return cache.get(key1);
    }

    public String getOrDefault(String key2, String aDefault) {
        return cache.getOrDefault(key2, aDefault);
    }

    /**
     * @param key Key to look for
     * @return
     */
    @Override
    public boolean exists(String key) {
        return cache.containsKey(key);
    }
}

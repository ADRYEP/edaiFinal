package edai.proyectoFinal.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {

    @Test
    public void testGet(){
        Cache cache = new Cache();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        try {
            String value = cache.get("key1");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetOrDefault(){
        Cache cache = new Cache();
        cache.put("key1", "value1");
        String value = cache.getOrDefault("key2","default");
        assertEquals("default", value);
    }

}

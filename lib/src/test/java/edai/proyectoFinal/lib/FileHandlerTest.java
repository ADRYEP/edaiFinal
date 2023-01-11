package edai.proyectoFinal.lib;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileHandlerTest {
    private FileHandler fileHandler;
    private Cache cache;

    @BeforeEach
    public void setUp(){
        fileHandler = new FileHandler("testFile.txt");
        cache = new Cache();
    }

    @Test
    public void testSaveCAcheToFile() throws IOException{
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        fileHandler.saveCacheToFile(cache);
        BufferedReader reader = new BufferedReader(new FileReader("testFile.txt"));
        assertEquals("key1", reader.readLine());
        assertEquals("key2", reader.readLine());
        reader.close();
    }

}

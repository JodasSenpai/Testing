
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class SkladTest {

    static Sklad<String> instance;

    public SkladTest() {
    }

    @BeforeClass
    public static void setUpOnce() {
        instance = new Sklad<>();
    }

    @Before
    public void setUp() {
        while (!instance.isEmpty()) {
            instance.pop();
        }
    }

    @Test
    public void testPush() {
        String a = "Test";
        instance.push(a);
    }

    @Test
    public void testPop() {
        String a = "Test";
        instance.push(a);
        String b = instance.pop();
        assertEquals("Test", b);
    }

    @Test
    public void testWithTwoElements() {
        String a = "Prvi element";
        String b = "Drugi element";
        instance.push(a);
        instance.push(b);
        assertEquals(b, instance.pop());
        assertEquals(a, instance.pop());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        String a = instance.pop();
    }

    @Test
    public void testIsEmptyOnEmpty() {
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsEmptyOnFull() {
        instance.push("Test");
        assertFalse(instance.isEmpty());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testTopOnEmptyStack() {
        String a = instance.top();
    }

    @Test
    public void testTopOnFullStack() {
        String a = "Vrednost 1";
        String b = "Vrednost 2";
        instance.push(a);
        instance.push(b);
        String c = instance.top();
        assertEquals(c, b);
    }

    @Test
    public void testTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test3", instance.top());
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(0, instance.size());
    }

    @Test(timeout = 100)
    public void testSizeNonEmpty() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(3, instance.size());
    }

    @Test
    public void testSizeSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(3, instance.size());
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsTopTrue() {
        instance.push("Test");
        assertTrue(instance.isTop("Test"));
    }

    @Test
    public void testIsTopFalse() {
        instance.push("Test1");
        assertFalse(instance.isTop("Test2"));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testIsTopEmpty() {
        assertFalse(instance.isTop("Test"));
    }

    @Test
    public void testIsTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertTrue(instance.isTop("Test3"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSearchEmpty() {
        assertEquals(-1, instance.search("Test"));
    }

    @Test(timeout = 100)
    public void testSearchFoundTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(0, instance.search("Vrednost 3"));
    }

    @Test(timeout = 100)
    public void testSearchFoundNonTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(2, instance.search("Vrednost 1"));
    }

    @Test(timeout = 100)
    public void testSearchNotFound() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(-1, instance.search("Vrednost"));
    }

    @Test
    public void testSearchSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(1, instance.search("Test2"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    // Testi za add, removeFirst, getFirst, size in depth
    // so izpuščeni, ker gre le za klice že testiranih metod! 
    
    // TO DO
    // Testi za remove() in exists() ...
    @Test(timeout = 100)
    public void testRemoveSimple() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(3, instance.size());
        assertEquals("Test2", instance.remove("Test2"));
        assertEquals(2, instance.size());
        
    }
    
    @Test(timeout = 100)
    public void testRemoveWrong() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(3, instance.size());
        assertEquals(null, instance.remove("Test4"));
        assertEquals(3, instance.size());
        
    }
    @Test
    public void testRemoveRoot() {
        instance.push("Test1");
        
        assertEquals("Test1", instance.remove("Test1"));
        
        
    }
    
    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemoveEmpty() {
        assertEquals(0, instance.size());
        instance.remove("test");
        
    }
    @Test
    public void testExistsTrue() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(3, instance.size());
        assertEquals(true, instance.exists("Test2"));
        assertEquals(3, instance.size());
        
    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void testExistsEmpty() {
        assertEquals(0, instance.size());
        instance.exists("test");
    }
    
    @Test
    public void testExistsFalse() {
        instance.push("Test1");        
        instance.push("Test3");
        assertEquals(2, instance.size());
        assertEquals(false, instance.exists("Test2"));
        assertEquals(2, instance.size());
        
    }
    
    
    @Test(expected=java.util.NoSuchElementException.class)
    public void testListEmpty() {
        assertEquals(0, instance.size());
        instance.asList();
    }
    
    @Test
    public void testList() {
        instance.push("3");
        instance.push("2");
        instance.push("4");
        instance.push("5");
        instance.push("1");
        instance.push("8");
        
        assertEquals(Arrays.asList("8","1","5","4","2","3"), instance.asList());
    }
    
}

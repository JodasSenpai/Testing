import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.*;

public class BstTest {

    private Bst<String> bst;

    public BstTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        bst = new Bst<>();
    }

    @After
    public void tearDown() {
    }

    // Praviloma bi morali testirati vsako funkcijo v razredu
    // torej tudi: member, insert, delete, deleteMin, getDepth, countNodes
    
    // Glede na to, da teste zasnujemo pred poznavanjem podrobnosti implementacije
    // zasnujemo teste za metode vmesnika: 
    // add, removeFirst, getFirst, size,depth, isEmpty, remove, exists
    
    @Test
    public void testAdd() {
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99"); 
        assertEquals(7,bst.size());
    }

    @Test
    public void testRemoveFirst(){
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99"); 
        assertEquals("Test6",bst.removeFirst());
    }   
    
    @Test
    public void testGetFirstOne() {
        bst.add("Test");
        assertEquals("Test", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
    }

    @Test
    public void testGetFirstMultiple() {
        bst.add("Test2");
        assertEquals("Test2", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
        bst.add("Test3");
        bst.add("Test1");
        assertEquals("Test2", bst.getFirst());
        assertEquals("Test2", bst.getFirst());
        assertEquals(3, bst.size());
        assertEquals(2, bst.depth());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetFirstOnEmpty() {
        bst.getFirst();
    }
    
    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemoveOnEmpty() {
        bst.remove("test");
    }
    
   @Test
    public void testSizeOnEmpty() {
        assertEquals(0, bst.size());
    }
    
    @Test
    public void testSize(){
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99"); 
        assertEquals(7,bst.size());
    }
    
    @Test
    public void testDepthOnEmpty() {
        assertEquals(0, bst.depth());
    }
    
    @Test
    public void testDepth(){
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99");    
        assertEquals(3,bst.depth());
    }
    
    @Test
    public void isEmpty(){
        assertEquals(true,bst.isEmpty());
    }
    
    @Test
    public void testExists(){
        bst.add("Test2");
        bst.add("Test3");
        bst.add("Test1");
        
        assertEquals(true, bst.exists("Test3"));
        assertEquals(3,bst.size());
    }
    
    @Test
    public void testRemove(){
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99");        
        assertEquals(7,bst.size());
        assertEquals("Test6",bst.remove("Test6"));
        assertEquals(6,bst.size());
    }
    @Test
    public void testRemoveRight(){
        bst.add("Test6");
        bst.add("Test4");
        bst.add("Test9");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test8");
        bst.add("Test99");        
        assertEquals(7,bst.size());
        assertEquals("Test99",bst.remove("Test99"));
        assertEquals(6,bst.size());
    }
    
    @Test(expected=java.util.NoSuchElementException.class)
    public void testListEmpty() {
        assertEquals(0, bst.size());
        bst.asList();
    }
    
    @Test
    public void testList() {
        bst.add("5");
        bst.add("3");
        bst.add("7");
        bst.add("4");
        bst.add("1");
        bst.add("6");
        bst.add("8");
        
        assertEquals(Arrays.asList("1","3","4","5","6","7","8"), bst.asList());
    }
}


import org.junit.*;
import static org.junit.Assert.*;

public class SeznamiUVTest {

    private SeznamiUV uv;

    public SeznamiUVTest() {
    }

    @Before
    public void setUp() {
        uv = new SeznamiUV();
    }

    // TO DO 
    // razsirite integracijske teste za metodo Use
    @Test
    public void testUse() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|d23})", uv.processInput("add"));
        assertEquals("Error: please specify a correct data structure type {pv|sk|bst|d23}", uv.processInput("use add"));
        assertEquals("Error: please specify a data structure type {pv|sk|bst|d23}", uv.processInput("use"));
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("OK", uv.processInput("use sk"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("OK", uv.processInput("use bst"));
    }

    // TO DO
    // napišite teste za sklad, prioritetno vrsto in BS drevo
    // testi kličejo (zaporedoma) vse operacije nad določeno strukturo 
    // glej POMOZNE METODE
    
    @Test
    public void testUseSklad() {
        runHelpTest("sk");
        
    }
    
    @Test
    public void testUsePrioritetnaVrsta() {
        runHelpTest("pv");
    }

    @Test
    public void testUseBst() {
        runHelpTest("bst");
    }
    
    
    public void runHelpTest(String structure){
        assertEquals("OK", uv.processInput("use " + structure));
        if(structure == "sk"){
            testSklad(true);
            reset();
            testSkladDepth();
        }
        else if(structure == "pv"){
            testPrioritetnaVrsta(true);
            reset();
            testPrioritetnaVrstaDepth();
        }
        else if(structure == "bst"){
            testBst(true);
            reset();
            testBstDepth();
        }
        reset();
        testAdd();
        reset();
        testAddNothing();
        reset();
        testRemoveFirst();
        reset();
        testRemoveFirstNothing();
        reset();
        testRemove();
        reset();
        testRemove2();
        reset();
        testGetFirst();
        reset();
        testGetFirstNothing();
        reset();
        testSizeOnEmpty();
        reset();
        testSizeOne();
        reset();
        testSizeTwo();
        reset();
        testExists();
        reset();
        testIsEmpty();
        reset();
        testIsNotEmpty();
        reset();
        testInvalidCommand();
        reset();
    }
    // *****************
    // POMOZNE METODE
    // *****************   
    
    
    public void reset() {
        uv.processInput("reset");
    }

    public void testInvalidCommand(){
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Error: invalid command", uv.processInput("command"));
    }

    public void testIsEmpty(){
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty"));
    }
    public void testIsNotEmpty(){        
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
    }


    public void testAdd() {
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
    }

    public void testAddNothing() {
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    public void testRemoveFirst() {
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("remove_first"));
    }

    public void testRemoveFirstNothing() {
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    public void testGetFirst() {
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("getfirst"));
    }

    public void testGetFirstNothing() {
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
    }

    public void testSizeOnEmpty() {
        assertEquals("0", uv.processInput("size"));
    }

    public void testSizeOne() {
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
    }

    public void testSizeTwo() {
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }

    public void testDepthOnEmpty() {
        assertEquals("0", uv.processInput("depth"));
    }

    public void testDepthOne() {
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("depth"));
    }

    public void testDepthTwo() {
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("depth"));
    }

    public void testIsEmptyEmpty() {
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
    }

    public void testIsEmptyNotEmpty() {
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty"));
    }

    public void testResetOnEmpty() {
        assertEquals("OK", uv.processInput("reset"));
    }

    public void testResetOnFull() {
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    // TO DO
    public void testExists() {
        assertEquals("Error: please specify a string", uv.processInput("exists"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("Element exists in data structure.", uv.processInput("exists Test2"));
        assertEquals("Element doesn't exist in data structure.", uv.processInput("exists neki"));
    }

    // TO DO
    public void testRemove() {
        testAddTestSequence();
        assertEquals("Error: please specify a string", uv.processInput("remove"));
        uv.processInput("add Test3");
        uv.processInput("add Test1");
        assertEquals("Test3", uv.processInput("remove Test3"));
        
    }
    public void testRemove2() {
        testAddTestSequence();
        assertEquals("Error: please specify a string", uv.processInput("remove"));
        uv.processInput("add Test3");
        uv.processInput("add Test1");
        assertEquals("Test3", uv.processInput("remove Test3"));
        
    }
    public void testAddTestSequence() {
        assertEquals("OK", uv.processInput("add Test4"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test5"));
    }

    public void testSklad(boolean add) {
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
    }

    public void testPrioritetnaVrsta(boolean add) {
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

    public void testBst(boolean add) {
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test4", uv.processInput("remove_first"));
        
    }
    
    public void testSkladDepth() {
        
        testAddTestSequence();        
        assertEquals("5", uv.processInput("depth"));
        
    }
    public void testPrioritetnaVrstaDepth() {
        testAddTestSequence();
        assertEquals("3", uv.processInput("depth"));
    }
    public void testBstDepth() {
        testAddTestSequence();
        assertEquals("3", uv.processInput("depth"));
    }

}

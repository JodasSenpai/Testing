/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author sabina
 */
public class Drevo23Test {
    private Drevo23<String> d23;
    private Drevo23<Integer> d23i;
    public Drevo23Test() {
    }
    
    @Before
    public void setUp() {
        d23 = new Drevo23<>();
    }
    @Test
    public void testAdd() {
        d23.insert("60");
        d23.insert("150");
        d23.insert("15");
        d23.insert("30");
        d23.insert("70");
        d23.insert("120");
        d23.insert("180");
        d23.insert("210");
        d23.insert("5");      
        d23.insert("2202");        
        d23.insert("254");
        d23.insert("430");
        d23.insert("540");
        d23.insert("820");
        d23.insert("10");
        d23.insert("20");
        d23.insert("25");
        d23.insert("40");
        d23.insert("50");
        d23.insert("80");
        d23.insert("90");
        d23.insert("110");
        d23.insert("140");        
        d23.insert("160");
        d23.insert("170");
        d23.insert("190");
        d23.insert("200");
        
        assertEquals(27,d23.size());
                
        
    }
    @Test
    public void testAdd3() {
        d23i.insert(60);
        d23i.insert(150);
        d23i.insert(15);
        d23i.insert(30);
        d23i.insert(70);
        d23i.insert(120);
        d23i.insert(180);
        d23i.insert(210);
        d23i.insert(5);      
        d23i.insert(2202);        
        d23i.insert(54);
        d23i.insert(430);
        d23i.insert(540);
        d23i.insert(820);
        d23i.insert(10);
        d23i.insert(20);
        d23i.insert(25);
        d23i.insert(40);
        d23i.insert(50);
        d23i.insert(80);
        d23i.insert(90);
        d23i.insert(110);
        d23i.insert(140);        
        d23i.insert(160);
        d23i.insert(170);
        d23i.insert(190);
        d23i.insert(200);
        
        assertEquals(27,d23.size());
                
        
    }
    @Test(expected = java.util.NoSuchElementException.class)
    public void testAdd2() {
        
        d23.insert("200");
        d23.insert("220");        
        d23.insert("240");
        d23.insert("110");
        d23.insert("140");        
        d23.insert("160");
        d23.insert("210");
        d23.insert("5");        
        d23.insert("10");
        d23.insert("20");
        d23.insert("25");
        d23.insert("40");
        d23.insert("50");
        d23.insert("80");
        d23.insert("170");
        d23.insert("60");
        d23.insert("150");
        d23.insert("15");
        d23.insert("30");
        d23.insert("70");
        d23.insert("170");
        
        
    }
 
 

    // Praviloma bi morali testirati vsako funkcijo v razredu
    // torej tudi: member, insert, delete, deleteMin, getDepth, countNodes
    
    // Glede na to, da teste zasnujemo pred poznavanjem podrobnosti implementacije
    // zasnujemo teste za metode vmesnika: 
    // add, removeFirst, getFirst, size,depth, isEmpty, remove, exists
    


    @Test
    public void testRemoveFirst(){
        d23.add("Test6");
        d23.add("Test4");
        d23.add("Test9");
        d23.add("Test3");
        d23.add("Test5");
        d23.add("Test8");
        d23.add("Test99"); 
        assertEquals("Test6",d23.removeFirst());
    }   
    
    @Test
    public void testGetFirstOne() {
        d23.add("Test");
        assertEquals("Test", d23.getFirst());
        assertEquals(1, d23.size());
        assertEquals(0, d23.depth());
    }

    @Test
    public void testGetFirstMultiple() {
        d23.add("Test2");
        assertEquals("Test2", d23.getFirst());
        assertEquals(1, d23.size());
        assertEquals(0, d23.depth());
        d23.add("Test3");
        d23.add("Test1");
        assertEquals("Test2", d23.getFirst());
        assertEquals("Test2", d23.getFirst());
        assertEquals(3, d23.size());
        assertEquals(1, d23.depth());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetFirstOnEmpty() {
        d23.getFirst();
    }
    
    @Test(expected = java.util.NoSuchElementException.class)
    public void testRemoveOnEmpty() {
        d23.remove("test");
    }
    
   @Test
    public void testSizeOnEmpty() {
        assertEquals(0, d23.size());
    }
    
    @Test
    public void testSize(){
        d23.add("Test6");
        d23.add("Test4");
        d23.add("Test9");
        d23.add("Test3");
        d23.add("Test5");
        d23.add("Test8");
        d23.add("Test99"); 
        assertEquals(7,d23.size());
    }
    
    @Test
    public void testDepthOnEmpty() {
        assertEquals(0, d23.depth());
    }
    
    @Test
    public void testDepth(){
        d23.add("Test6");
        d23.add("Test4");
        d23.add("Test9");
        d23.add("Test3");
        d23.add("Test5");
        d23.add("Test8");
        d23.add("Test99");    
        assertEquals(1,d23.depth());
    }
    
    @Test
    public void isEmpty(){
        assertEquals(true,d23.isEmpty());
    }
    
    @Test
    public void testExists(){
        d23.add("Test2");
        d23.add("Test3");
        d23.add("Test1");
        
        assertEquals(true, d23.exists("Test3"));
        assertEquals(3,d23.size());
    }
    
    @Test
    public void testExists2(){
        d23.insert("60");
        d23.insert("150");
        d23.insert("15");
        d23.insert("30");
        d23.insert("70");
        d23.insert("120");
        d23.insert("180");
        d23.insert("210");
        d23.insert("5");        
        d23.insert("10");
        d23.insert("20");
        d23.insert("25");
        d23.insert("40");
        d23.insert("50");
        d23.insert("80");
        d23.insert("90");
        d23.insert("110");
        d23.insert("140");        
        d23.insert("160");
        d23.insert("170");
        d23.insert("190");
        d23.insert("200");
        d23.insert("220");        
        d23.insert("340");
        
        
        assertEquals(true, d23.exists("5"));
        assertEquals(true, d23.exists("340"));
        assertEquals(true, d23.exists("140"));
        assertEquals(true, d23.exists("50"));
        assertEquals(true, d23.exists("60"));
        assertEquals(true, d23.exists("120"));
        assertEquals(true, d23.exists("15"));
        assertEquals(true, d23.exists("10"));
        //System.out.println(d23.asList());
        assertEquals(24,d23.size());
    }
    @Test
    public void testNotExists(){
        d23.add("Test2");
        d23.add("Test3");
        d23.add("Test1");
        
        assertEquals(false, d23.exists("Test4"));
        assertEquals(3,d23.size());
    }
    @Test
    public void testRemove(){
        d23.add("Test6");
        d23.add("Test4");
        d23.add("Test9");
        d23.add("Test3");
        d23.add("Test5");
        d23.add("Test8");
        d23.add("Test99");        
        assertEquals(7,d23.size());
        assertEquals("Test6",d23.remove("Test6"));
        assertEquals(6,d23.size());
    }
    @Test
    public void testRemoveRight(){
        d23.add("Test6");
        d23.add("Test4");
        d23.add("Test9");
        d23.add("Test3");
        d23.add("Test5");
        d23.add("Test8");
        d23.add("Test99");        
        assertEquals(7,d23.size());
        assertEquals("Test99",d23.remove("Test99"));
        assertEquals(6,d23.size());
    }
    
    @Test(expected=java.util.NoSuchElementException.class)
    public void testListEmpty() {
        assertEquals(0, d23.size());
        d23.asList();
    }
    
    @Test
    public void testList() {
        d23.add("5");
        d23.add("3");
        d23.add("7");
        d23.add("4");
        d23.add("1");
        d23.add("6");
        d23.add("8");
        
        assertEquals(Arrays.asList("4","6","1","3","5","7","8"), d23.asList());
    }
}

    


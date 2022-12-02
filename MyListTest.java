package com.enikeili.lab1;

import org.junit.jupiter.api.TestInstance;

import com.enikeili.lab1.MyList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing the MyContainer2.0
 * @author enikeili
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MyListTest
{
    private MyList<String> list;
    @BeforeEach
    public void set_up()
    {
        list = new MyList<String>();
    }
    /**
     * Checks isEmpty() method
     */
    @Test
    void test_isEmpty()
    {
    	assertEquals(true, list.isEmpty());
    	list.addToHead("ein");
    	assertEquals(false, list.isEmpty());
    }
    /**
     * Checks getSize() method
     */
    @Test
    void test_getSize()
    {
    	assertEquals(0, list.getSize());
    	list.addToHead("ein");
    	assertEquals(1, list.getSize());
    	list.addToHead("zwei");
    	assertEquals(2, list.getSize());
    }
    /**
     * Checks delFromHead() method
     */
    @Test
    void test_delFromHead()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	list.addToHead("vier");
    	list.delFromHead();
    	assertEquals("drei",list.getHead().getVal());
    	assertEquals(3, list.getSize());
    }
    /**
     * Checks delAll() method
     */
    @Test
    void test_delAll()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.delAll();
    	assertEquals(true, list.isEmpty());
    	assertEquals(0, list.getSize());
    }
    /**
     * Checks addToHead() method
     */
    @Test
    void test_addToHead()
    {
    	list.addToHead("ein");
    	assertEquals(false, list.isEmpty());
    	assertEquals(1, list.getSize());
    	list.addToHead("zwei");
    	assertEquals("zwei", list.getHead().getVal());
    }
    /**
     * Checks findPos() method
     */
    @Test
    void test_findPos()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	assertEquals("ein", list.findPos(2).getVal());
    	assertEquals("zwei", list.findPos(1).getVal());
    	assertEquals("drei", list.findPos(0).getVal());
    }
    /**
     * Checks getElement_by_index() method
     */
    @Test
    void test_getElement_by_index()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	assertEquals("ein", list.getElement_by_index(2));
    }
    /**
     * Checks setElement_by_index() method
     */
    @Test
    void test_setElement_by_index()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	list.setElement_by_index(2,"million");
    	assertEquals("million", list.getElement_by_index(2));
    }
    /**
     * Checks insert_element_by_index() method
     */
    @Test
    void test_insert_element_by_index()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	list.insert_element_by_index(1,"million");
    	assertEquals("ein", list.getElement_by_index(3));
    	assertEquals("zwei", list.getElement_by_index(2));
    	assertEquals("drei", list.getElement_by_index(0));
    	assertEquals("million", list.getElement_by_index(1));
    	assertEquals(4, list.getSize());
    }
    /**
     * Checks delete_element_by_index() method
     */
    @Test
    void test_delete_element_by_index()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	list.delete_element_by_index(1);
    	assertEquals("ein", list.getElement_by_index(1));
    	assertEquals("drei", list.getElement_by_index(0));
    	assertEquals(2, list.getSize());
    }
    /**
     * Checks extract_element_by_index() method
     */
    @Test
    void extract_delete_element_by_index()
    {
    	list.addToHead("ein");
    	list.addToHead("zwei");
    	list.addToHead("drei");
    	assertEquals("zwei",list.extract_element_by_index(1));
    	assertEquals("ein", list.getElement_by_index(1));
    	assertEquals("drei", list.getElement_by_index(0));
    	assertEquals(2, list.getSize());
    }
}

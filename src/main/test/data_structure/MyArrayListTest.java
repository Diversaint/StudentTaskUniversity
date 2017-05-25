package data_structure;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by macbook on 25.05.17.
 */
public class MyArrayListTest {

    private MyArrayList myArrayList;

    @Before
    public void setUp(){
        myArrayList = new MyArrayList();
    }

    @After
    public void tearDown(){
        myArrayList = null;
    }

    @Test
    public void test_add_when_empty(){
        assertTrue(myArrayList.add("One"));
    }

    @Test
    public void test_add_null_when_empty(){
        assertTrue(myArrayList.add(null));
    }


    @Test
    public void test_add_more_than_start_size(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertTrue(myArrayList.add("Eleven"));
    }

    //test isEmpty
    @Test
    public void test_isEmpty_when_empty(){
        assertTrue(myArrayList.isEmpty());
    }
    //test size
    @Test
    public void test_isEmpty_when_add_one_element(){
        assertTrue(myArrayList.add("One"));
        assertFalse(myArrayList.isEmpty());

    }

    @Test
    public void test_size_when_empty(){
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void test_size_when_add_one_element(){
        assertTrue(myArrayList.add("One"));
        assertEquals(1, myArrayList.size());
    }


    @Test
    public void test_size_more_than_start_size(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertTrue(myArrayList.add("Eleven"));

        assertEquals(11, myArrayList.size());
    }

    @Test
    public void test_size_when_remove_one_element(){
        assertTrue(myArrayList.add("One"));
        assertEquals(1, myArrayList.size());
        assertTrue(myArrayList.remove("One"));
        assertEquals(0, myArrayList.size());
    }

    // tests for remove by object
    @Test
    public void test_remove_obj_when_empty(){
        assertFalse(myArrayList.remove("One"));
    }

    @Test
    public void test_remove_obj_when_not_empty_and_element_not_present(){
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertFalse(myArrayList.remove("One"));
    }

    @Test
    public void test_remove_obj_when_not_empty_and_element_present(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.remove("One"));
    }

    @Test
    public void test_remove_obj_when_not_empty_and_element_present_in_last_position(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.remove("Seven"));
    }

    @Test
    public void test_remove_null_when_empty(){
        assertFalse(myArrayList.remove(null));
    }

    @Test
    public void test_remove_null_when_not_empty_and_element_not_present(){
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertFalse(myArrayList.remove(null));
    }

    @Test
    public void test_remove_null_when_not_empty_and_element_present(){
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.remove(null));
    }

    // tests for contains

    @Test
    public void test_contains_null_when_empty(){
        assertFalse(myArrayList.contains(null));
    }

    @Test
    public void test_contains_null_when_not_empty(){
        assertTrue(myArrayList.add("One"));
        assertFalse(myArrayList.contains(null));
    }

    @Test
    public void test_contains_null_when_contains_null(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.contains(null));
    }

    @Test
    public void test_contains_when_el_in_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.contains("Two"));
    }
    @Test
    public void test_contains_when_no_el_in_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertFalse(myArrayList.contains("oops"));
    }

    //tests for clear

    @Test
    public void test_clear_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        myArrayList.clear();
        assertTrue(myArrayList.isEmpty());
    }

    //test add object in position

    @Test
    public void test_add_in_position_more_than_size(){
        assertTrue(myArrayList.add("One"));
        assertFalse(myArrayList.add("Two", 2));
    }

    @Test
    public void test_add_into_list_null(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add(null, 4));
    }
    @Test
    public void test_add_into_list_when_size_like_length(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertTrue(myArrayList.add("Between three and four", 3));
    }


    @Test
    public void test_add_object_in_correct_pos(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertTrue(myArrayList.add("Eleven"));
        assertTrue(myArrayList.add("Between 5 and 6", 4));

    }

    //test get o by position

    @Test
    public void test_get_invalid_position(){
        assertTrue(myArrayList.add("One"));
        assertNull(myArrayList.get(2));
    }

    @Test
    public void test_get_null(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.add("Four"));
        assertNull(myArrayList.get(2));
    }
    @Test
    public void test_get_o_in_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertNotNull(myArrayList.get(2));
    }

    //remove o by position

    @Test
    public void test_remove_invalid_position(){
        assertTrue(myArrayList.add("One"));
        assertNull(myArrayList.remove(2));
    }

    @Test
    public void test_remove_null(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.add("Four"));
        assertNull(myArrayList.remove(2));
    }
    @Test
    public void test_remove_o_in_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertNotNull(myArrayList.remove(2));
    }
    @Test
    public void test_remove_when_list_full(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertNotNull(myArrayList.remove(2));
    }

    //set in position

    @Test
    public void test_set_invalid_position(){
        assertTrue(myArrayList.add("One"));
        assertFalse(myArrayList.set("Two", 2));
    }

    @Test
    public void test_set_o_in_list(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.set("2", 2));
    }
    @Test
    public void test_set_in_last_when_list_full(){
        assertTrue(myArrayList.add("One"));
        assertTrue(myArrayList.add("Two"));
        assertTrue(myArrayList.add("Three"));
        assertTrue(myArrayList.add("Four"));
        assertTrue(myArrayList.add("Five"));
        assertTrue(myArrayList.add("Six"));
        assertTrue(myArrayList.add("Seven"));
        assertTrue(myArrayList.add("Eight"));
        assertTrue(myArrayList.add("Nine"));
        assertTrue(myArrayList.add("Ten"));
        assertFalse(myArrayList.set("Ten", 10));
    }

}

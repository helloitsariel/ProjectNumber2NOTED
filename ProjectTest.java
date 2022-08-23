import com.example.projectnumber2.Notes;
import com.example.projectnumber2.Password;
import com.example.projectnumber2.ToDo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProjectTest {

    Password passwordTest;
    Password passwordTest2;
    Notes notesTest;
    Notes notesTest2;
    ToDo toDoTest;
    ToDo toDoTest2;

    @Before
    public void setUp(){
        passwordTest = new Password("Gmail", "test@gmail.com", "testing123");
        passwordTest2 = new Password("Paypal", "paypal@gmail.com", "important");
        notesTest = new Notes("I like apples");
        notesTest2 = new Notes("I dislike apples");
        toDoTest = new ToDo("buy apples");
        toDoTest2 = new ToDo("cut down apple trees");
    }

    @Test
    public void addToPasswordList(){
        //checking if the list is empty
        assertEquals(passwordTest.getList().size(), 0);
        //checking if all the information is inputted properly
        String expectedType = "Gmail";
        assertEquals(expectedType, passwordTest.getAccountType());
        String expectedUser = "test@gmail.com";
        assertEquals(expectedUser, passwordTest.getAccountUser());
        assertEquals(passwordTest.toString(),"Gmail: test@gmail.com");
        String expectedPassword = "testing123";
        assertEquals(expectedPassword, passwordTest.getPassword());
        //adding the object to list
        passwordTest.addToList(passwordTest);
        //checking that the object is in the correct index and the information is correct
        String a = ((passwordTest.getList()).get(0)).toString();
        assertEquals("Gmail: test@gmail.com", a);
        String c = ((passwordTest.getList()).get(0)).getPassword();
        String d = ((passwordTest.getList()).get(0)).getAccountType();
        String e = ((passwordTest.getList()).get(0)).getAccountUser();
        assertEquals("testing123", c);
        assertEquals("Gmail", d);
        assertEquals("test@gmail.com", e);
        //adding a second object to check if the information is correct for the second object
        passwordTest2.addToList(passwordTest2);
        String b = ((passwordTest.getList()).get(1)).toString();
        assertEquals("Paypal: paypal@gmail.com", b);
        String f = ((passwordTest.getList()).get(1)).getPassword();
        String g = ((passwordTest.getList()).get(1)).getAccountType();
        String h = ((passwordTest.getList()).get(1)).getAccountUser();
        assertEquals("important", f);
        assertEquals("Paypal", g);
        assertEquals("paypal@gmail.com", h);
        //resetting ArrayList to no objects because the ArrayList is static and final
        passwordTest.deleteFromList(passwordTest);
        passwordTest2.deleteFromList(passwordTest2);
    }

    @Test
    public void deleteFromPasswordList(){
        //checking if the list is empty
        assertEquals(passwordTest.getList().size(), 0);
        //adding both Passwords to the list
        passwordTest.addToList(passwordTest);
        passwordTest2.addToList(passwordTest2);
        //checking if the list size is 2
        assertEquals(passwordTest.getList().size(), 2);
        //delete object from list
        passwordTest.deleteFromList(passwordTest);
        //check if the list size decreased by one
        assertEquals(passwordTest.getList().size(), 1);
        //check if the object is passwordTest2
        assertEquals(passwordTest2.getList().get(0), passwordTest2);
        //check if the information is correct
        assertEquals(passwordTest2.getList().get(0).toString(), "Paypal: paypal@gmail.com");
        assertEquals(passwordTest2.getList().get(0).getAccountType(), "Paypal");
        assertEquals(passwordTest2.getList().get(0).getAccountUser(), "paypal@gmail.com");
        assertEquals(passwordTest2.getList().get(0).getPassword(), "important");
        //delete object from list
        passwordTest2.deleteFromList(passwordTest2);
        //check if the list size decreased by one
        assertEquals(passwordTest2.getList().size(), 0);
    }

    @Test
    public void addToNotesList(){
        //checking if the list is empty
        assertEquals(notesTest.getList().size(), 0);
        //checking if all the information is inputted properly
        String expectedNote = "I like apples";
        assertEquals(expectedNote, notesTest.toString());
        //adding the object to list
        notesTest.addToList(notesTest);
        //checking that the object is in the correct index and the information is correct
        String a = ((notesTest.getList()).get(0)).toString();
        assertEquals("I like apples", a);
        //adding a second object to check if the information is correct for the second object
        notesTest2.addToList(notesTest2);
        String b = ((notesTest2.getList()).get(1)).toString();
        assertEquals("I dislike apples", b);
        //resetting ArrayList to no objects because the ArrayList is static and final
        notesTest.deleteFromList(notesTest);
        notesTest2.deleteFromList(notesTest2);
    }

    @Test
    public void addToNotesUrgentList(){
        //checking if the list is empty
        assertEquals(notesTest.getUrgentList().size(), 0);
        //checking if all the information is inputted properly
        String expectedNote = "I like apples";
        assertEquals(expectedNote, notesTest.toString());
        //adding the object to list
        notesTest.addToUrgentList(notesTest);
        //checking that the object is in the correct index and the information is correct
        String a = ((notesTest.getUrgentList()).get(0)).toString();
        assertEquals("I like apples", a);
        //adding a second object to check if the information is correct for the second object
        notesTest2.addToUrgentList(notesTest2);
        String b = ((notesTest2.getUrgentList()).get(1)).toString();
        assertEquals("I dislike apples", b);
        //resetting ArrayList to no objects because the ArrayList is static and final
        notesTest.deleteFromListUrgent(notesTest);
        notesTest2.deleteFromListUrgent(notesTest2);
    }

    @Test
    public void deleteFromNotesList(){
        //checking if the list is empty
        assertEquals(notesTest.getList().size(), 0);
        //adding both Passwords to the list
        notesTest.addToList(notesTest);
        notesTest2.addToList(notesTest2);
        //checking if the list size is 2
        assertEquals(notesTest.getList().size(), 2);
        //delete object from list
        notesTest.deleteFromList(notesTest);
        //check if the list size decreased by one
        assertEquals(notesTest2.getList().size(), 1);
        //check if the object is passwordTest2
        assertEquals(notesTest2.getList().get(0), notesTest2);
        //check if the information is correct
        assertEquals(notesTest2.getList().get(0).toString(), "I dislike apples");
        //delete object from list
        notesTest2.deleteFromList(notesTest2);
        //check if the list size decreased by one
        assertEquals(notesTest2.getList().size(), 0);
    }

    @Test
    public void deleteFromNotesUrgentList(){
        //checking if the list is empty
        assertEquals(notesTest.getUrgentList().size(), 0);
        //adding both Passwords to the list
        notesTest.addToUrgentList(notesTest);
        notesTest2.addToUrgentList(notesTest2);
        //checking if the list size is 2
        assertEquals(notesTest.getUrgentList().size(), 2);
        //delete object from list
        notesTest.deleteFromListUrgent(notesTest);
        //check if the list size decreased by one
        assertEquals(notesTest2.getUrgentList().size(), 1);
        //check if the object is passwordTest2
        assertEquals(notesTest2.getUrgentList().get(0), notesTest2);
        //check if the information is correct
        assertEquals(notesTest2.getUrgentList().get(0).toString(), "I dislike apples");
        //delete object from list
        notesTest2.deleteFromListUrgent(notesTest2);
        //check if the list size decreased by one
        assertEquals(notesTest2.getUrgentList().size(), 0);
    }

    @Test
    public void addToToDoList(){
        //checking if the list is empty
        assertEquals(toDoTest.getList().size(), 0);
        //checking if all the information is inputted properly
        String expectedTask = "buy apples";
        assertEquals(expectedTask, toDoTest.toString());
        //adding the object to list
        toDoTest.addToList(toDoTest);
        //checking that the object is in the correct index and the information is correct
        String a = ((toDoTest.getList().get(0))).toString();
        assertEquals("buy apples", a);
        //adding a second object to check if the information is correct for the second object
        toDoTest2.addToList(toDoTest2);
        String b = ((toDoTest2.getList()).get(1)).toString();
        assertEquals("cut down apple trees", b);
        //resetting ArrayList to no objects because the ArrayList is static and final
        toDoTest.deleteFromList(toDoTest);
        toDoTest2.deleteFromList(toDoTest2);
    }

    @Test
    public void addToToDoUrgentList(){
        //checking if the list is empty
        assertEquals(toDoTest.getListUrgent().size(), 0);
        //checking if all the information is inputted properly
        String expectedTask = "buy apples";
        assertEquals(expectedTask, toDoTest.toString());
        //adding the object to list
        toDoTest.addToUrgentList(toDoTest);
        //checking that the object is in the correct index and the information is correct
        String a = ((toDoTest.getListUrgent().get(0))).toString();
        assertEquals("buy apples", a);
        //adding a second object to check if the information is correct for the second object
        toDoTest2.addToUrgentList(toDoTest2);
        String b = ((toDoTest2.getListUrgent()).get(1)).toString();
        assertEquals("cut down apple trees", b);
        //resetting ArrayList to no objects because the ArrayList is static and final
        toDoTest.deleteFromListUrgent(toDoTest);
        toDoTest2.deleteFromListUrgent(toDoTest2);
    }

    @Test
    public void deleteFromToDoList(){
        //checking if the list is empty
        assertEquals(toDoTest.getList().size(), 0);
        //adding both Passwords to the list
        toDoTest.addToList(toDoTest);
        toDoTest2.addToList(toDoTest2);
        //checking if the list size is 2
        assertEquals(toDoTest.getList().size(), 2);
        //delete object from list
        toDoTest.deleteFromList(toDoTest);
        //check if the list size decreased by one
        assertEquals(toDoTest2.getList().size(), 1);
        //check if the object is passwordTest2
        assertEquals(toDoTest2.getList().get(0), toDoTest2);
        //check if the information is correct
        assertEquals(toDoTest2.getList().get(0).toString(), "cut down apple trees");
        //delete object from list
        toDoTest2.deleteFromList(toDoTest2);
        //check if the list size decreased by one
        assertEquals(toDoTest2.getList().size(), 0);
    }

    @Test
    public void deleteFromToDoUrgentList(){
        //checking if the list is empty
        assertEquals(toDoTest.getListUrgent().size(), 0);
        //adding both Passwords to the list
        toDoTest.addToUrgentList(toDoTest);
        toDoTest2.addToUrgentList(toDoTest2);
        //checking if the list size is 2
        assertEquals(toDoTest.getListUrgent().size(), 2);
        //delete object from list
        toDoTest.deleteFromListUrgent(toDoTest);
        //check if the list size decreased by one
        assertEquals(toDoTest2.getListUrgent().size(), 1);
        //check if the object is passwordTest2
        assertEquals(toDoTest2.getListUrgent().get(0), toDoTest2);
        //check if the information is correct
        assertEquals(toDoTest2.getListUrgent().get(0).toString(), "cut down apple trees");
        //delete object from list
        toDoTest2.deleteFromListUrgent(toDoTest2);
        //check if the list size decreased by one
        assertEquals(toDoTest2.getListUrgent().size(), 0);
    }

}
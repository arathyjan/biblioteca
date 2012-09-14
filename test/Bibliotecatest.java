import static org.junit.Assert.*;
import  org.junit.Test;

public class Bibliotecatest {

    String Menu[]={"VIEW","RESERVE","CHECK LIBRARY NUMBER","EXIT"};

    @Test
    public void WelcomeNoteDisplaysWelcome()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertEquals("WELCOME",objBiblioteca.welcomeNote);
    }

    @Test
    public void MenuHaveMinimumOneOption()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertTrue(0<objBiblioteca.menuOption.length);
    }

    @Test
    public void CheckMenuOption()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertArrayEquals(Menu,objBiblioteca.menuOption);
    }

    @Test
    public void SelectedMenuDoesnotAcceptNegativeInput()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertFalse(objBiblioteca.chooseMenuOption(-1) == -1);

    }
    //@Test
    //public void SelectedMenuDoesnotAcceptZeroAsInput()
    //{
    //    Biblioteca objBiblioteca=new Biblioteca();
    //    assertFalse(objBiblioteca.chooseMenuOption(0) == 0);

    //}

    @Test
    public void SelectedmenuIsGreaterThanInMenuOption()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertFalse(objBiblioteca.chooseMenuOption(5) == 5);

    }

     @Test
    public void ReserveBookNotResearved()
     {
         Biblioteca objBiblioteca=new Biblioteca();
         assertEquals(objBiblioteca.ReserveBook(1),true);

     }

      @Test
    public void ReserveBookCodeGreaterThanBookCode()
      {
          Biblioteca objBiblioteca=new Biblioteca();
          assertEquals(objBiblioteca.ReserveBook(5),false);
      }
    @Test
    public void ReserveBookCodeLesserThanBookCode()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertEquals(objBiblioteca.ReserveBook(0),false);
    }






}
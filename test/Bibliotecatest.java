import static org.junit.Assert.*;
import  org.junit.Test;
import java.util.*;

public class Bibliotecatest {

    @Test
    public void WelcomeNoteDisplaysWelcome()
    {
        assertEquals("WELCOME",Biblioteca.welcomeNote);
    }

    @Test
    public void MenuHaveMinimumOneOption()
    {
        assertTrue(0<Biblioteca.menuOption.length);
    }

    @Test
    public void checkMenuHasViewAsOption()
    {
        assertTrue(Arrays.toString(Biblioteca.menuOption).contains("VIEW"));
    }

    @Test
    public void checkMenuHasReserveAsOption()
    {
        assertTrue(Arrays.toString(Biblioteca.menuOption).contains("RESERVE"));
    }

    @Test
    public void checkMenuHasCheckLibraryNumberAsOption()
    {
        assertTrue(Arrays.toString(Biblioteca.menuOption).contains("CHECK LIBRARY NUMBER"));
    }

    @Test
    public void checkMenuHasExitAsOption()
    {
        assertTrue(Arrays.toString(Biblioteca.menuOption).contains("EXIT"));
    }

    @Test
    public void checkMenuHasViewMovieAsOption()
    {
        assertTrue(Arrays.toString(Biblioteca.menuOption).contains("VIEW MOVIES"));

    }

    @Test
    public void SelectedMenuDoesnotAcceptNegativeInput()
    {
        Biblioteca objBiblioteca=new Biblioteca();
        assertFalse(objBiblioteca.chooseMenuOption(-1) == -1);
    }


    @Test
    public void SelectedmenuIsGreaterThanInMenuOption()
    {
        int noOfMenuOption=Biblioteca.menuOption.length;
        noOfMenuOption++;
        Biblioteca objBiblioteca=new Biblioteca();
        assertFalse(objBiblioteca.chooseMenuOption(noOfMenuOption) == noOfMenuOption);
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
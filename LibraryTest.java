import static org.junit.Assert.assertEquals;
import org.junit.*;

public class LibraryTest {
  Book book;
  Book book2;
  Library library;

  @Before
  public void before() {
    book = new Book("Consider Phlebas");
    book2 = new Book("Look to Windward");
    library = new Library();
  }

  @Test
  public void howManyBooks() {
    assertEquals(0, library.numberOfBooks());
  }

  @Test
  public void canAddBook() {
    library.add(book);
    assertEquals(1, library.numberOfBooks());
  }

  @Test
  public void libraryIsFull() {
    for (int i = 0; i < 100; i++) {
      library.add(book);
    }
    assertEquals(true, library.isFull());
  }

  @Test
  public void canFindBook() {
    library.add(book);
    library.add(book2);
    assertEquals(1, library.findByName("Look to Windward"));
  }

  @Test
  public void cannotFindBook() {
    library.add(book);
    library.add(book2);
    assertEquals(-1, library.findByName("The Picture of Dorian Gray"));
  }

  @Test
  public void canLendBook() {
    library.add(book);
    library.add(book2);
    library.lend(library.findByName("Consider Phlebas"));
    assertEquals(1, library.numberOfBooks());
  }
}

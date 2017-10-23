import static org.junit.Assert.assertEquals;
import org.junit.*;

public class ReaderTest {
  Book book;
  Book book2;
  Library library;
  Reader reader;

  @Before
  public void before() {
    book = new Book("Consider Phlebas");
    book2 = new Book("Look to Windward");
    reader = new Reader("Bob");
    library = new Library();
    for (int i = 0; i < 50; i++) {
      library.add(book);
    }
    for (int i = 0; i < 50; i++) {
      library.add(book2);
    }
  }

  @Test
  public void hasNoBooksToRead() {
    assertEquals(0, reader.booksToRead());
  }

  @Test
  public void canAddToBookshelf() {
    reader.addToBookshelf(book);
    assertEquals(1, reader.booksToRead());
  }

  @Test
  public void cannotBorrowTooManyBooks() {
    for (int i = 0; i < 12; i++) {
      reader.borrow(library, "Consider Phlebas");
    }
    assertEquals(10, reader.booksToRead());
  }

  @Test
  public void canReadABook() {
    for (int i = 0; i < 5; i++) {
      reader.borrow(library, "Consider Phlebas");
    }
    assertEquals(5, reader.booksToRead());
    reader.readTopBookAndReturnIt(library);
    assertEquals(4, reader.booksToRead());
  }
}

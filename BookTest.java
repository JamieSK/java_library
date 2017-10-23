import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BookTest {
  Book book;

  @Before
  public void before() {
    book = new Book("Consider Phlebas");
  }

  @Test
  public void bookHasTitle() {
    assertEquals("Consider Phlebas", book.getTitle());
  }
}

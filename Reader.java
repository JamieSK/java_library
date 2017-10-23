public class Reader {
  String name;
  Book[] bookshelf;

  public Reader(String name) {
    this.name = name;
    this.bookshelf = new Book[10];
  }

  public int booksToRead() {
    int count = 0;
    for (Book book : this.bookshelf) {
      if (book != null) {
        count++;
      }
    }
    return count;
  }

  public boolean addToBookshelf(Book book) {
    int howManyBooks = booksToRead();
    try {
      this.bookshelf[howManyBooks] = book;
      return true;
    } catch (IndexOutOfBoundsException error) {
      return false;
    }
  }

  public void borrow(Library library, String title) {
    int bookIndex = library.findByName(title);
    Book tempBook = library.lend(bookIndex);
    if (!addToBookshelf(tempBook)) {
      library.returnBook(tempBook);
    }
  }

  public void readTopBookAndReturnIt(Library library) {
    for (int i = this.bookshelf.length - 1; i >= 0; i--) {
      if (this.bookshelf[i] != null) {
        library.returnBook(this.bookshelf[i]);
        this.bookshelf[i] = null;
        return;
      }
    }
  }
}

public class Library {
  Book[] stock;

  public Library() {
    this.stock = new Book[100];
  }

  public int numberOfBooks() {
    int count = 0;
    for (Book book : this.stock) {
      if (book != null) {
        count++;
      }
    }
    return count;
  }

  public void add(Book book) {
    int numberOfBooks = numberOfBooks();
    if (numberOfBooks < this.stock.length) {
      this.stock[numberOfBooks] = book;
    }
  }

  public boolean isFull() {
    return numberOfBooks() == this.stock.length;
  }

  public int findByName(String title) {
    for (int i = 0; i < this.stock.length; i++) {
      Book book = this.stock[i];
      // Uses lazy evaluation to avoid NullPointerException.
      if (book != null && book.getTitle() == title) {
        return i;
      }
    }
    return -1;
  }

  public Book lend(int index) {
    Book tempBook = this.stock[index];
    this.stock[index] = null;
    return tempBook;
  }

  public void returnBook(Book book) {
    add(book);
  }
}

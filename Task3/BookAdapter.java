public class BookAdapter extends Book{
  IncompatibleBook BadBook;

  public BookAdapter(){
    BadBook = new IncompatibleBook();
  }

  public void setTitleString(String aString){
    BadBook.setTitle(aString);
  };

  public String getTitleString(){
    return(BadBook.getTitle());
  };
}

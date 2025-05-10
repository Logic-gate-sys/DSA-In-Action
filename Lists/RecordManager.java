import java.util.Scanner;

public class RecordManager {
    public static void main(String[] args) {
    // implement an interface to welcome 
    String msg="""
    WELCOME TO ASHESI LIBRARY MANAGER INTERFACE: 
    PLEASE SELECT AND OPTION TO CONTINUE: 
    1. Add a book 
    2. View a book
    3. View All records
    4. Insert a book
    5. Exit         
            """;
   Book b1=new Book("0204","Good things take time","Daniel Kwasi",Status.AVAILABLE);
   Book b2=new Book("4004","I have shown you","Daniel Kwasi",Status.UNAVAILABLE);
   Book b3=new Book("0204","I have disgrace myself","Daniel kk",Status.BORROWED);

   BookRecord<Book> nb=new BookRecord<>();
   nb.add(b1);
   nb.insert(1, b2);
   nb.add(b3);
   nb.display();
   Book bk=nb.getBook(1);
   System.out.println("Returned book: "+bk);

    }
    
}

import java.util.Comparator;

public class Book implements Comparator<Book>{
    private String title;
    private String id;
    private String author;
    private Status status;

    // book constructor
    public Book(String id,String title,String author,Status status){
        this.id=id;
        this.title=title;
        this.author=author;
        this.status=status;
    }

    // getters and setters
    public String getID(){
        return this.id;
    }
    public Status getStatus(){
        return this.status;
    }
    public String getTitle(){
        return this.title;
    } 
    public String getAuthor(){
        return this.author;  
    }

    //Setters 
    public void setAuthor(String author){
        this.author=author;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setStatus(Status status){
        this.status=status;
    }
    public void setId(String id){
        this.id=id;
    }
    
    // toString method
    public String toString(){
        return "Book: "+ title+" by: "+author+" \nstatus: "+ status;
    }


    @Override
    public int compare(Book o1, Book o2) {  // comparison for sorting according to titles
        int result=o1.title.compareTo(o2.title);
        return result;
    }
}









 enum Status{
    AVAILABLE,
    UNAVAILABLE,
    BORROWED
}
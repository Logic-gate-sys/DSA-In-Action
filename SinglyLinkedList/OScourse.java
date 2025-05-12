package SinglyLinkedList;
import java.time.Instant;

public class OScourse {
    private String id;
    private String name;
    private int courseCode;
    private Instant timestamp;
    
    // constructor
    public OScourse(String id,String name,int courseCode){
        this.id=id;
        this.name=name;
        this.courseCode=courseCode;
        this.timestamp=Instant.now();
    }
    // getters
    public String getId(){
        return id;
    }
    
    // toString method
    public String toString(){
        return "Id: "+id+" Name: "+name+" courseCode: "+courseCode+" Timestamp: "+timestamp;
    }
}

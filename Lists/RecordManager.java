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
    Scanner sc=new Scanner(System.in);
    System.out.println(msg);
    int user_choice=sc.nextInt();
    sc.next();
    boolean execute=true;
    while(execute){
    // into the loop with switch
        switch (user_choice) {
            case 1:
                
            
                break;
            default:
                throw new AssertionError();
    }
    }

    }
    
}

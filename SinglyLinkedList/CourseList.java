package SinglyLinkedList;

public class CourseList {
    private int size;
    private Node head;
    private Node tail;
    // constructor
    public CourseList(){
        this.size=0;
        this.head=null;
        this.tail=null;
    }
    // adding course to the list
    public void add_front(OScourse data){
        // create a new node to be add
        Node n_node = new Node();
        n_node.data=data;
        // inserting at the front
        if(size==0){ // list is empty
           head=tail=n_node; // their nexts is already 
           size++; // size is increased
        }
        else{
            Node h=head;
            head = n_node;
            head.next=h;
            head.next.next=tail;
            size ++;
        }
    }
    // adding an element to the end
    public void add_end(OScourse data){
        // create new node to be inserted
        Node n_node = new Node();
        n_node.data =data;
        // if the list is empty
        if (size==0){
            head=tail=n_node;
            size ++; // increase size
        }
        else{
            tail.next = n_node;
            size ++;// increase size 
        }
    }
        // inserting student at a given position
        public void addAt(int pos,OScourse data){
            // is the pos away from what's avaialble
            if (pos>size+1){
                throw new RuntimeException("Positioin "+pos+" is out of the bounds");
            }
            // check if the list is empty;
            Node n_node=new Node();
            n_node.data=data;
            if(size==0){
                throw new RuntimeException("The position : "+pos+" does not exist ");
            }
            else{
                 int count = 1; // atleast one element exists
                 Node h = head;
                 while(count<pos){
                    h=h.next;
                    count ++;
                 }
                 // now let's try to insert
                 Node k=h.next; // placeholder 
                 h.next =n_node; 
                 n_node.next=k;
                 size++;
            }
        }

        // remove the records for a given student
        public void remove(String id){
            //  is the student in the first position?
            if(head.data.getId().equals(id)){
                Node h=head.next; // place holder for new head
                head=h;
                size--;
            }
            else{
                Node p1=head;
                Node p2=head;
                int count=1;
                while(p1.next !=null){
                    p1=p1.next;
                    if(count%2==0){p2=p2.next; } //delay the movement of the secondary pointer to keep  track of previous
                    if(p1.data.getId().equals(id)){
                      p2.next=p1.next;
                      size--;
                      return ; 
                    }
                    count ++;
                }
                throw new RuntimeException("No record for such id");
            }
        }
        // method to find a student by id
        public OScourse find(String id){
            if(head.data.getId().equals(id)){
                return head.data;
            }else{
                Node p1=head;
                Node p2=head;
                int count=1;
                while(p1.next !=null){
                    p1=p1.next;
                    if(count%2==0){p2=p2.next; } //delay the movement of the secondary pointer to keep  track of previous
                    if(p1.data.getId().equals(id)){
                      return p1.data; 
                    }
                    count ++;
                }
                throw new RuntimeException("No record for such id");
            }    
        }
        // display method all elements
        public void display(){
            Node h=head;
            System.out.println("=============================================================================================================");
            while(h.next !=null){
                  System.out.print("| " +h.data+" |");
                  h=h.next;
            }
            System.out.println("=============================================================================================================");
        }

        // Reversing the entire list in-place
        public Node reverse(){
            // create and array to store elements in the reverse order
            Node current=head;
            Node next=null;
            Node prev=null;
            while(current !=null){
                next=current.next; // we save the node directly in fron to prevent missing links
                current.next=prev; // exchange the position current and prev
                prev =current; // prev node comes to the current possiont
                current=next; // current now points to the save position
            }
            head= prev;  // the time current becomes null , prev is now the new head
            return head;
        }
    
}





// node for the signly linkedlist class;
class Node{
     OScourse data;
     Node next;

    // constructor
    public Node(){
        this.next =null;
        this.data=null;
    }
}
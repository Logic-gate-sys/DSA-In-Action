package music_player;

public class SongList {
private int size;
private Node head;
private Node tail;

public SongList(){
    this.size=0;
    head=null;
    tail=null;
}
// method to add to front of list
public void add_first(Song data){
    Node n_node=new Node(data);
    // check list is empyt
    if(size==0){
        head=tail=n_node;
        size++;
    }else{ // or the new node must become the head and head the second node
        n_node.next =head;
        head.prev=n_node;
        head=n_node;
        size++;
    }   
    }
    // another method to add song to front
    public void add_last(Song data){
        Node n_node=new Node(data);
        // check if the list is empty
        if(size==0){
            head=tail=n_node;
            size++;
        }
        else{
            tail.next=n_node;
            n_node.prev=tail;
            tail=n_node;
            size++;
        }
    }
    // add a song after a given song;
    public void add_after(String id,Song new_song){
        Node n_node=new Node(new_song);
        // make sure the list is not empyt before this operation can go through
        if(size==0){
            throw new RuntimeException("Invalid!, Song list is empty");
        }else{ // search for the song with such id
            Node h=head;
            while(h.next!=null){
                h=h.next;
                if(h.data.getId().equals(id)){
                    n_node.next=h.next;
                    n_node.prev=h;
                    h.next.prev=n_node;
                    h.next=n_node;
                    size ++;
                    return ;
                }
            }
            throw new RuntimeException("No such id");
        }
    }
    // remove song by it's id
    public Song remove(String id){
        if(head.data.getId().equals(id)){
            Song sn=head.data;
            head =head.next;
            head.prev=null;
            size--;
            return sn;
        }else{
            Node h=head;
            while(h.next!=null){
                h=h.next;
                if(h.data.getId().equals(id)){
                    Song sn =h.data;
                    h.prev.next=h.next; // remove prev link of h
                    h.next.prev=h.prev;
                    size--;
                  return sn;
                }
            }
            throw new RuntimeException("No such id");
        }
    }
    // find a song by a given id
    public Song find(String id){
       if(head.data.getId().equals(id)){
            Song sn=head.data;
            return sn;
        }else{
            Node h=head;
            while(h.next!=null){
                h=h.next;
                if(h.data.getId().equals(id)){
                    Song sn =h.data;
                  return sn;
                }
            }
            throw new RuntimeException("No such id");
        }
    }
    //display forward 
    public void displayForward(){
        Node h =head;
        int count =1;
        System.out.println("=====================================FORWARD LIST========================================");
        while(h.next !=null){
           System.out.println(count+". "+h.data +"\n");
           count++;
           h=h.next;
        }
       System.out.println("=====================================END========================================");
    }
    // display backwards
    public void displayBackward(){
        Node h =tail;
        int count =1;
        System.out.println("=====================================BACKWARD LIST========================================");
        while(h.prev !=null){
           System.out.println(count+". "+h.data +"\n");
           count++;
           h=h.prev;
        }
       System.out.println("=====================================END========================================");
    }
}

// Node for the doubly linked list
class Node{
     Node prev;
     Node next;
     Song data;

    public Node(Song data){
        this.data=data;
        prev=null;
        next=null;
    }
}
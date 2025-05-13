package cafetaria_ordering;

import java.util.TooManyListenersException;

public class Orderqueue {
    private Order[] arr;
    private int size;
    private int initCapacity;
    private int head;
    private int tail;

    public Orderqueue(){
        this.size=0;
        this.initCapacity=10;
        this.arr = new Order[initCapacity];
        this.head =-1;
        this.tail=-1;
    }
    //adding an order to the back of the queue
    public void enqueue(Order order){
        int  resize_count=0;
        // if this is the first order
        if(size==0){
            head=tail= 0;// head and tail initialise to 0
            arr[tail]=order;
            size ++;
        }
        else if(size<initCapacity){
            tail= (tail+1)%initCapacity; // circular
            arr[tail]=order;
            size++;
        }
        else{
            // is the stack full?
            if(isFull()){
                resize_count++;
                resize();  // resize the array
                tail = (tail+1)%initCapacity;
                arr[tail]=order;
                size++; 
            }
        }
        System.out.println("Number of resizes: "+resize_count);
    }
    // removing and order from the queue
    public Order dequeue(){
        if(size==0){
            throw new RuntimeException("Error, No item to remove");
        }
        head=(head +1)%initCapacity;
        Order toremove=arr[head];
        arr[head]=null;
        size--;
        head++;
        System.out.println("The removed order is: "+toremove);
        return toremove;
    }

     //another helper function to resize the inner array

    public void resize(){
     int new_cap=initCapacity*2;
     Order[] new_arr=new Order[new_cap];
     for(int i=0;i<=size;i++){
         new_arr[i]=arr[(head +i)%initCapacity];
     }
     head=0;
     tail=size-1;
     initCapacity=new_cap;
     arr=new_arr;
    }

    //retrieve the order at the top without removing it;
    public Order peek(){
         if(size==0){
            throw new RuntimeException("Error, No item to remove");
        }
        Order peek_order=arr[head];
        System.out.println("The peek order is: "+peek_order);
        return peek_order;
    }
    // return the size of the queue

    public int getSize(){
        return size;
    }

   // helper function to validate that the list is trully full;
   public boolean isFull(){
    if(size==initCapacity){
        for(int i=0;i<size;i++){
            if(arr[i]==null){
                return false;
            }
        }
            }
            return false;
      }

      // printing all orders from head to tail
      public void print(){
        System.out.println("=========================================ALL ORDERS===============================================");
        for(int i=0;i<size;i++){
            System.out.println((i+1)+". "+ arr[i]);
        }
        System.out.println("=========================================END===============================================");

      }
}

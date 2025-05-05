
import java.lang.reflect.Array;
import java.util.Arrays;

public class BookRecord <Book> {  // parameterised for type safety
    /*      
     This class holds book objects in an underlying array structure that is resized dynamically by:
     doubling size when the array is full
     */
    private int size;
    private Book[] inner_array;
    private int init_capacity;
    private int count;
    
    public BookRecord(){
        this.size=0;
        this.init_capacity=20; // initial underlying array capacity
        this.count=0;
        this.inner_array= (Book[]) new Object[init_capacity]; // cast object into book
    }
    // Helper method for resizing the inner array
    public void resize(){
       if(init_capacity==size){
          int new_capacity=init_capacity *2;  
          Book[] new_inner_arr=(Book[]) new Object[new_capacity];
          // copy all books into the new array
          for(int i=0;i<inner_array.length;i++){
                new_inner_arr[i]=inner_array[i];
          }
          // now give the contents of the new array to the old array
          inner_array=new_inner_arr;
       }
    }
    
    // adding a book at the end of records
    public void add(Book book){
      //get the index of the end
      if(size==init_capacity){
        resize();
        inner_array[size]=book;
        size++;// increment size 
      }
      else{
        inner_array[size]=book;
        size ++; // also increments
      }
    }
    // We also want to insert a book at an index
    public void insert(int index,Book book){     // Assumption: if there is a free index then no need to check if array is full
        //check  if the given index is empty first
        if (inner_array[index]==null){
            inner_array[index]=book;
            size ++;// increment size after sucessful insertion
        }
        else{
            throw new RuntimeException("Index already has and element");
        }
    }
    
    // get the size of the BookRecords
    public int getSize(){
         return size;
    }
    //Remove and element
    public void remove(int index){
        if(index > 0 || index <inner_array.length){
            throw new RuntimeException("Index out of bounds");
        }
        // does the element exist
        if(inner_array[index] !=null){
            // create a new array to store the elements that are to be kept with the capacity of the old array
            int capacity=inner_array.length;
            Book[] new_arr=(Book[]) new Object[capacity];
            for (int i=0;i<inner_array.length;i++){
                if(i!=index){
                 new_arr[i]=inner_array[i]; // do not store the element of the index to be removed
                }
            }
            inner_array=new_arr; // reset the inner array
            size--; // size is reduced
        }
        else{
            throw new RuntimeException("No element at given index"+index);
        }
        
    }
    
    // get an element at a given index
    public Book getBook(int index){
        if(index > 0 || index <inner_array.length){
            throw new RuntimeException("Index out of bounds");
        }
        if(inner_array[index]==null){
            throw new RuntimeException("No element at given index"+index);
        }
        else return inner_array[index];
    }
    
    // display all records
    public void display(){
        // first copy the occupied array only
        Book[] n_arr=Arrays.copyOfRange(inner_array,0,size);
        System.out.println("====================================BOOK RECORDS===================================");
        for(int i=0;i<size;i++){
            System.out.println((i+1)+". "+ n_arr[i]);
        }
        System.out.println("===================================================================================");
    }
}

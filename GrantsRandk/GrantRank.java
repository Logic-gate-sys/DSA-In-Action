package GrantsRandk;

public class GrantRank {
    // this is an array based structure
       public int size;
    public Grant[] inner_array;
    private int initcap;//  initial array capacity
    private int count;
    
    public GrantRank(){
        this.size=0;
        this.initcap=20; // initial underlying array capacity
        this.count=0;
        this.inner_array=new Grant[initcap]; // cast object into book
    }
    // Helper method for resizing the inner array
    public void resize(){
        count ++ ;  // keep track of the number of times the list has been resized
       if(initcap==size){
          int new_capacity=initcap *2;  
          Grant[] new_inner_arr=(Grant[]) new Object[new_capacity];
          // copy all books into the new array
          for(int i=0;i<inner_array.length;i++){
                new_inner_arr[i]=inner_array[i];
          }
          // now give the contents of the new array to the old array
          inner_array=new_inner_arr;
       }
    }
    
    // adding a book at the end of records
    public void add(Grant grant){
      //get the index of the end
      if(size==initcap){
        resize();
        inner_array[size]=grant;
        size++;// increment size 
      }
      else{
        inner_array[size]=grant;
        size ++; // also increments
      }
    }
    //CUSTOM SORTING ALL GORITHMNS
    // Insertion sort
    public void insertionSort(){
    // we assume that the first index is sorted so we loop from the second index
    for(int i=1;i<size;i++){
        Grant current=inner_array[i];
        // a pointer to the previous element
        int j=i-1;
        //when the previous element is greater than the current we swap
        while(j >=0 && inner_array[j].pscore.score > current.pscore.score){
            //swap position
            inner_array[j+1]=inner_array[j];
            j--;
        }
        inner_array[j+1]=current;
    }
    
    }

    public void selectionSort(){
        // keep the first initial sorted part empty
        int sorted=0;
        for(int i=sorted;i<size-1; i++){
            int smallest=i; // keep the first element as the smallest
            for(int j=i+1; j<size; j++){
                if(inner_array[j].pscore.score<inner_array[smallest].pscore.score){
                 smallest=j;
            }
            else if(inner_array[j].pscore.score==inner_array[smallest].pscore.score){   // if priorty scores are the same compare and use title
                int result=inner_array[j].title.compareTo(inner_array[smallest].title);
                if(result<0){ // arragin in ascending order
                  smallest=j;
                }
            } 
        }
        //in the situation where i itself is not mean
            if(smallest !=i){
                Grant grant=inner_array[i]; // hold the value of i
                inner_array[i]=inner_array[smallest];
                inner_array[smallest]=grant;
            }
        }
    }

}








//=================HELPER CLASSES==================================================

// How the grant structure should look like
class Grant{
    int proposalID;
    String title;
    PriorityScore pscore;
    String inv_name;
    // constructor
    public Grant(int proposalID,String title,PriorityScore pscore,String inv_name){
        this.proposalID=proposalID;
        this.title=title;
        this.pscore=pscore;
        this.inv_name=inv_name;
    }
  // toString
  @Override
  public String toString(){
    return proposalID+" Title: "+title+" priority score: "+pscore+" investor: "+inv_name;
  }
}

enum PriorityScore{
    HIGHEST(5),
    HIGH(4),
    MEDIUW(3),
    LOW(2),
    LOWEST(1); // have to terminate
    int score;
    PriorityScore(int score){
        this.score=score;
    }
}
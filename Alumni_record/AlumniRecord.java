package Alumni_record;

import java.util.Comparator;    
import javax.management.RuntimeErrorException;

public class AlumniRecord implements Comparator<Alumni> {
    public int initCap;
    public Alumni[] arr;
    public int size;

    public AlumniRecord(){
        this.initCap=20;
        this.size=0;
        this.arr=new Alumni[initCap];
    }
   @Override
   public int compare(Alumni a1,Alumni a2){
        Integer val1=(Integer) a1.id;
        Integer val2=(Integer) a2.id;
        return val1.compareTo(val2);
   }
   // adding an element to the alumin record
   public void add(Alumni al){
    if(size==initCap){
        throw new RuntimeException("Alumni Record is full");
    }
    arr[size]=al;
    size++;
   }
   // find record using the student id;
   public Alumni bsiterative(int id){
    Alumni found=null;
    int low =0; 
    int high=size-1;
    int mid =(int) Math.floor((low + high)/2);
    while(low<=high){
        if(arr[mid].id > id){ // is the value pointing to left
            high=mid-1;
        }
        else if(arr[mid].id < id){ // is the value pointing to right
            low=mid+1;
        }
        else if(arr[mid].id==id){
            found= arr[mid];
             return found;
        }
      }
      throw new RuntimeException("No record found for id "+id); // if value is not found throw and exception
   }
   // recursive binary search;
   public Alumni bsrecursive(int low,int high,int id){
    if(low>high){
        throw new RuntimeException("Invalid input");
    }
    int mid =(int) Math.floor((low+high)/2);
    if(arr[mid].id==id){
        return arr[mid];
    }
    if(arr[mid].id > id){
       return  bsrecursive(low, mid-1, id);
    }
        return bsrecursive(mid+1, high, id);
   }
}


















class Alumni{
    int id;
    String name;
    String major;
    String graduationYear;
    public Alumni(int id,String name,String major,String graduationYear){
        this.id=id;
        this.name=name;
        this.major=major;
        this.graduationYear=graduationYear;
    }
    @Override
    public String toString(){
        return id +" name: "+name +" major: "+major+"graduation year: "+graduationYear;
    }  
}

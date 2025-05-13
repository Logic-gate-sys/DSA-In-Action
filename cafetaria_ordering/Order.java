package cafetaria_ordering;

import java.time.Instant;

public class Order {
    private int orderId;
    private int customerId;
    private String mealName;
    private  Instant timestamp; 
    // dynamic constructors for each method
    public Order(int orderId,int customerId,String mealName){
        this.orderId=orderId;
         this.customerId=customerId;
         this.mealName=mealName;
         this.timestamp=Instant.now();
    }
    //getters 
    public String getMealName(){
        return mealName;
    }
    public int getOrderId(){
        return orderId;
    }
    public int getCustomerId(){
        return customerId;
    }
    public Instant getTimeStamp(){
        return timestamp;
    }
    @Override
    public String toString(){
        return "OrderId: "+orderId+ " Customer Id "+customerId+" \n meal name: "+mealName +" time stamp : "+timestamp;
    }
}

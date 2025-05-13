package cafetaria_ordering;

public class OrderManager {
    public static void main(String[] args) {
        Orderqueue queue = new Orderqueue();

        // Sample orders
        Order o1 = new Order(1, 101, "Jollof Rice");
        Order o2 = new Order(2, 102, "Fried Rice");
        Order o3 = new Order(3, 103, "Banku");
        Order o4 = new Order(4, 104, "Pizza");

        // Enqueue operations
        queue.enqueue(o1);
        queue.enqueue(o2);
        queue.enqueue(o3);
        queue.enqueue(o4);

        // Print all orders
        queue.print();

        // Peek at the front order
        Order front = queue.peek();
        System.out.println("Peeked Order: " + front);

        // Dequeue one order
        Order removed = queue.dequeue();
        System.out.println("Dequeued Order: " + removed);

        // Check size
        int size = queue.getSize();
        System.out.println("Current Queue Size: " + size);

        // Print final state
        queue.print();
    }
}

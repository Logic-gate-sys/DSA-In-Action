package GrantsRandk;

public class GrantManager {
    
    public static void main(String[] args){
        GrantRank ranker = new GrantRank();

        // Add sample Grant objects
        ranker.add(new Grant(101, "AI Research", PriorityScore.HIGH, "Dr. Mensah"));
        ranker.add(new Grant(102, "Water Sanitation", PriorityScore.HIGHEST, "Prof. Adjei"));
        ranker.add(new Grant(103, "Youth Literacy", PriorityScore.MEDIUW, "Dr. Asante"));
        ranker.add(new Grant(104, "Food Security", PriorityScore.LOWEST, "Dr. Osei"));
        ranker.add(new Grant(105, "Green Energy", PriorityScore.LOW, "Dr. Boateng"));
        ranker.add(new Grant(106, "Cybersecurity", PriorityScore.HIGH, "Dr. Sarpong"));

        System.out.println("Before Sorting:");
        for(int i=0;i<ranker.size;i++){
            System.out.println(ranker.inner_array[i]);
        }

        // Sort using selectionSort
        ranker.selectionSort();
        System.out.println("\nAfter Selection Sort (by PriorityScore, then Title):");
        for(int i=0;i<ranker.size;i++){
            System.out.println(ranker.inner_array[i]);
        }
        // For comparison, shuffle and sort using insertionSort
        GrantRank ranker2 = new GrantRank();
        ranker2.add(new Grant(101, "AI Research", PriorityScore.HIGH, "Dr. Mensah"));
        ranker2.add(new Grant(102, "Water Sanitation", PriorityScore.HIGHEST, "Prof. Adjei"));
        ranker2.add(new Grant(103, "Youth Literacy", PriorityScore.MEDIUW, "Dr. Asante"));
        ranker2.add(new Grant(104, "Food Security", PriorityScore.LOWEST, "Dr. Osei"));
        ranker2.add(new Grant(105, "Green Energy", PriorityScore.LOW, "Dr. Boateng"));
        ranker2.add(new Grant(106, "Cybersecurity", PriorityScore.HIGH, "Dr. Sarpong"));

        ranker2.insertionSort();
        System.out.println("\nAfter Insertion Sort (by PriorityScore only):");
        for(int i=0;i<ranker.size;i++){
            System.out.println(ranker.inner_array[i]);
        }
    }
    
}

package Alumni_record;

import java.util.Arrays;

public class BinarySearchapp {
    public static void main(String[] args){
        AlumniRecord record = new AlumniRecord();

        // Add sample Alumni records
        record.add(new Alumni(103, "Kwame", "Computer Science", "2020"));
        record.add(new Alumni(101, "Ama", "Business", "2019"));
        record.add(new Alumni(102, "Kojo", "Engineering", "2021"));
        record.add(new Alumni(110, "Esi", "Math", "2018"));
        record.add(new Alumni(105, "Yaw", "Physics", "2022"));
        record.add(new Alumni(120, "Abena", "Chemistry", "2023"));
        record.add(new Alumni(111, "Kofi", "Law", "2020"));
        record.add(new Alumni(108, "Afua", "Medicine", "2021"));
        record.add(new Alumni(107, "Selorm", "Engineering", "2019"));
        record.add(new Alumni(106, "Adwoa", "Nursing", "2022"));
        record.add(new Alumni(115, "James", "Finance", "2023"));
        record.add(new Alumni(112, "Sandra", "Architecture", "2018"));
        record.add(new Alumni(104, "Mawuli", "Computer Science", "2021"));
        record.add(new Alumni(109, "Naana", "Political Science", "2020"));
        record.add(new Alumni(113, "Kwabena", "Agriculture", "2022"));
        record.add(new Alumni(114, "Akosua", "Marketing", "2019"));
        record.add(new Alumni(117, "Yawson", "Philosophy", "2017"));
        record.add(new Alumni(116, "Aba", "Linguistics", "2021"));
        record.add(new Alumni(118, "Cynthia", "Accounting", "2023"));
        record.add(new Alumni(119, "Felix", "Statistics", "2022"));

        // Sort the array to enable binary search
        Arrays.sort(record.arr, 0, 19, record);

        int searchId = 102;

        // Iterative search
        Alumni iterativeResult = record.bsiterative(searchId);
        System.out.println("Iterative Search Result:");
        System.out.println(iterativeResult);

        // Recursive search
        Alumni recursiveResult = record.bsrecursive(0, 19, searchId);
        System.out.println("Recursive Search Result:");
        System.out.println(recursiveResult);

        // Compare both results
        if (iterativeResult != null && recursiveResult != null &&
            iterativeResult.id == recursiveResult.id &&
            iterativeResult.name.equals(recursiveResult.name)) {
            System.out.println("✅ Both methods returned the same Alumni record.");
        } else {
            System.out.println("❌ Mismatch between iterative and recursive search results.");
        }
    }
}
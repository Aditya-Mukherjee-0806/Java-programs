import java.util.Scanner;

public class Array_Search {
    public static int linear_search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }

    public static int binary_search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid])
                return mid;
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms : ");
        int n = sc.nextInt();
        System.out.println("Enter an sorted array : ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println("Enter the no. to search : ");
        int target = sc.nextInt();
        int index = binary_search(arr, target);
        if (index != -1)
            System.out.println("Element found at index " + index + " using binary search");
        else
            System.out.println("Element not found in the array using binary search");
        int idx = linear_search(arr, target);
        if (idx != -1)
            System.out.println("Element found at index " + index + " using linear search");
        else
            System.out.println("Element not found in the array using linear search");
    }
}

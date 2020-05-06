import java.util.Random;

public class QuickSortTest {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(100);
        }
        quickSort(arr, 0, arr.length - 1);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int temp = arr[low];

        //
        while (i < j) {
            while (arr[j] <= temp && i < j) {
                j--;
            }
            while (arr[i] >= temp && i < j) {
                i++;
            }
            if (i < j) {
                int mid = arr[i];
                arr[i] = arr[j];
                arr[j] = mid;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}

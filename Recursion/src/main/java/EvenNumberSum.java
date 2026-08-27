public class EvenNumberSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(sumEven(arr, 0));
    }

    static int sumEven(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int val = sumEven(arr, index + 1);
        if (arr[index] % 2 == 0) {
            return val + arr[index];
        }
        return val;
    }
 }

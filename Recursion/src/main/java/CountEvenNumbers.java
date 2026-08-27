public class CountEvenNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 6, 7};
        System.out.println(countEven(arr, 0));
    }

    static int countEven(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }

        int val = countEven(arr, index + 1);

        if (arr[index] % 2 == 0) {
            return val + 1;
        }

        return val;
    }
}

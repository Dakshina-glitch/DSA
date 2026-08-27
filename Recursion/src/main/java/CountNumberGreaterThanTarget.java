public class CountNumberGreaterThanTarget {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 20, 30, 11};
        System.out.println(countGreater(arr, 0, 4));
    }

    static int countGreater(int[] arr, int index, int target) {
        if (index >= arr.length) {
            return  0;
        }

        int val = countGreater(arr, index + 1, target);

        if (arr[index] > target) {
            return val + 1;
        }
        return val;
    }
}

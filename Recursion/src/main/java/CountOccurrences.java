public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2};
        System.out.println(countOccurrences(arr, 0, 2));
    }

    static int countOccurrences(int[] arr, int index, int target) {
        if (index >= arr.length) {
            return 0;
        }

        int val = countOccurrences(arr, index + 1, target);

        if (arr[index] == target) {
            return val + 1;
        }
        return val;
    }
}

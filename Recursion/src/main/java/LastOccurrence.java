public class LastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 2, 9, 0};
        int n = arr.length - 1;
        System.out.println(lastIndex(arr, 0, 2));
        System.out.println(lastIndex(arr, 0, 7));
        System.out.println(lastIndex(arr, 0, 1));
    }

    static int lastIndex(int[] arr, int index, int target) {
        if (index >= arr.length) {
            return -1;
        }

        int val = lastIndex(arr, index + 1, target);
        if (val != -1) {
            return val;
        }
        if (arr[index] == target) {
            return index;
        }
        return -1;

    }
}

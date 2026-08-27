public class FirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 2, 9};
        System.out.println(firstIndex(arr, 0, 2));
        System.out.println(firstIndex(arr, 0, 9));
        System.out.println(firstIndex(arr, 0, 5));
        System.out.println(firstIndex(arr, 0, 11));
    }

    static int firstIndex(int[] arr, int index, int target) {
        if (index >= arr.length) {
            return -1;
        }

        if (target == arr[index]) {
            return index;
        }
        return firstIndex(arr, index + 1, target);
    }
}

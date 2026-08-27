public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(isSorted(arr, 0));
        int[] arr1 = {6, 1, 2, 3};
        System.out.println(isSorted(arr1, 0));
        int[] arr2 = {1,2};
        System.out.println(isSorted(arr2, 0));
        int[] arr3 = {1};
        System.out.println(isSorted(arr3, 0));
    }

    static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }
        return arr[index] <= arr[index + 1] && isSorted(arr, index + 1);
    }
}

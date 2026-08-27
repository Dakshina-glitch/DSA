public class FindMinimum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 1, 9};
        System.out.println(findMin(arr, 0));
        int[] arr1 = {-1, -2, -3, -10};
        System.out.println(findMin(arr1, 0));
    }

    static int findMin(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index - 1];
        }

        return Math.min(arr[index], findMin(arr, index + 1));
    }
}

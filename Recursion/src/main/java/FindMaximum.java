public class FindMaximum {
    public static void main(String[] args) {
        int[] arr = {2,9,11,22,1};
        System.out.println(findMax(arr, 0));
        int[] arr1 = {-1, -9};
        System.out.println(findMax(arr1, 0));
    }

    static int findMax(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return Math.max(arr[index], findMax(arr, index + 1));
    }
}

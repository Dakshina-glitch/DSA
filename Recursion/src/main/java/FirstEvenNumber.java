public class FirstEvenNumber {
    public static void main(String[] args) {
        int[] arr = {1, 23, 1, 5, 2};
        System.out.println(firstEven(arr, 0));
    }

    static int firstEven(int[] arr, int index) {
        if (index >= arr.length) {
            return -1;
        }

        if (arr[index] % 2 == 0) {
            return index;
        }
        return firstEven(arr, index + 1);
    }
}

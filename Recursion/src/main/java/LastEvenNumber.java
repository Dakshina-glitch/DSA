public class LastEvenNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(lastEven(arr, 0));
    }

    static int lastEven(int[] arr, int index) {
        if (index >= arr.length) {
            return -1;
        }

        int val = lastEven(arr, index + 1);
        if (val != -1) {
            return val;
        }
        if (arr[index] % 2 == 0) {
            return index;
        }
        return -1;
    }
}

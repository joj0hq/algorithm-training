package search;

public class BinarySearch {
    private static int[] array = {1, 3, 5, 6, 7, 9, 11, 15, 16, 21, 54};

    public static void main(String[] args) {
        int searchValue = 9;
        int searchResult = binarySearch(array, searchValue, 0, array.length - 1);
        if (searchResult >= 0) {
            System.out.println("index number :" + searchResult);
        } else {
            System.out.println("not found.");
        }
    }

    private static int binarySearch(int[] arr, int val, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
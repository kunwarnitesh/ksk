package com.ksk.array;

public class ArrayProblem {
    public static void main(String[] args) {
        int[] array = {3, 2, 76, 12, 21};
        int[] array012 = {1, 1, 1, 1, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 1, 1, 1};
        int[] negativeArray = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] largestSumArray = {-2, -3, 4, -1, -2, 1, 5, -3};

//        reverse(array);
//        printArray(array);
//        findMin(array);
//        findMax(array);
//        System.out.println("kth Max " + kthMax(array, 2));
//        System.out.println("Kth Min " + kthMin(array, 2));
//        sort012(array012);
//        moveNegativeToLeft(negativeArray);
//        printArray(array);
//        rotateArrayByOne(array);
//        printArray(array);

        System.out.println("Max Sum Contiguous:  " + largestSumContiguous(largestSumArray));
    }

    /***
     * Kadane Algorithm
     * @param array
     */
    private static int largestSumContiguous(int[] array) {
        int max_so_far = Integer.MIN_VALUE;
        int max_here_end = 0;

        for (int i : array){
            max_here_end = max_here_end +i;
            if (max_so_far<max_here_end){
                max_so_far = max_here_end;
            }
            if (max_here_end<0){
                max_here_end=0;
            }
        }

        return max_so_far;
    }

    private static void rotateArrayByOne(int[] array) {
        int temp = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = temp;
    }

    private static void moveNegativeToLeft(int[] array) {
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            if (array[low] < 0 && array[high] < 0) {
                low++;
            } else if (array[low] > 0 && array[high] < 0) {
                swapArray(array, low, high);
                low++;
                high--;
            } else if (array[low] > 0 && array[high] > 0) {
                high--;
            } else {
                high--;
                low++;
            }
        }
    }

    /***
     * Dutch National Flag Algorithm
     * @param array
     */
    private static void sort012(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int i = 0;
        while (i <= high) {
            if (array[i] == 0) {
                swapArray(array, i, low);
                low++;
                i++;
            } else if (array[i] == 1) {
                i++;
            } else if (array[i] == 2) {
                swapArray(array, i, high);
                high--;
            }
        }
    }

    private static void swapArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static int kthMax(int[] array, int k) {
        int low = findMin(array);
        int high = findMax(array);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countMax(array, mid) < k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private static int countMax(int[] array, int mid) {
        int count = 0;
        for (int i : array) {
            if (i >= mid) {
                count++;
            }
        }

        return count;
    }

    private static int kthMin(int[] array, int k) {
        int low = findMin(array);
        int high = findMax(array);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countMin(array, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int countMin(int[] array, int mid) {
        int count = 0;
        for (int i : array) {
            if (i <= mid) {
                count++;
            }
        }
        return count;
    }


    private static void reverse(int[] array) {
        int i = 0;
        int l = array.length - 1;
        while (i < l) {
            int temp = array[i];
            array[i] = array[l];
            array[l] = temp;
            i++;
            l--;
        }
    }

    private static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            min = Math.min(min, i);
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
        return max;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}

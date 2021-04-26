package Ashley_HW;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 2, 7, 0, 10};
        int[] arr2 = {3, 4, 1, 2, 5};
        System.out.println("A = " + Arrays.toString(arr1) + ", K = 4, the 4 smallest numbers are:");
        System.out.println("From min heap:");
        System.out.println(Arrays.toString(minHeapSort(arr1, 4)));
        System.out.println("From max heap:");
        System.out.println(Arrays.toString(maxHeapSort(arr1, 4)));
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("A = " + Arrays.toString(arr2) + ", K = 3, the 3 smallest numbers are:");
        System.out.println("From min heap:");
        System.out.println(Arrays.toString(minHeapSort(arr2, 3)));
        System.out.println("From max heap:");
        System.out.println(Arrays.toString(maxHeapSort(arr2, 3)));
    }

    // Time Complexity: O(n + k*logn)
    public static int[] minHeapSort(int[] a, int k) {
        // Using the HeapPriorityQueue from Heap Implementation assignment
        HeapPriorityQueue<Integer> heap = new HeapPriorityQueue<Integer>();
       // Assumption: a is not null; k >= 0 and smaller than or equal to size of a

        for(int i : a) {
            heap.add(i);
        }
        
        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = heap.remove();
        }

        return result;
    }

    // Time Complexity: O(k + (n-k)*logk )
    public static int[] maxHeapSort(int[] a, int k) {
        // Using a MaxHeap I made from copying and editing the HeapPriorityQueue to be a max heap instead of a min heap
        MaxHeap<Integer> heap = new MaxHeap<Integer>();

        // Assumption: a is not null; k >= 0 and smaller than or equal to size of a

        for(int i = 0; i < k; i++) {
            heap.add(a[i]);
        }

        for(int i = k; i < a.length; i++) {
            if(a[i] < heap.peek()) {
                heap.remove();
                heap.add(a[i]);
            }
        }

        int[] result = new int[k];

        for(int i = k - 1; i >= 0; i--) {
            result[i] = heap.remove();
        }

        return result;

    }
}

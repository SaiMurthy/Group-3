package Ashley_HW;
import java.util.NoSuchElementException;

// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        elementData = (E[])new Comparable[11];
        size = 0;
    }
    
    // Sai
    // Adds the given element to this queue.
    // Time Complexity: O(height)
    public void add(E value) {
        if(value == null){
            return;
        }
        if(size + 1 >= elementData.length) {
            E[] newElementData = (E[])new Comparable[2 * elementData.length];
            for(int i = 0; i < elementData.length; i++) {
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
        }

        elementData[size + 1] = value;
        int index = size +1;
        boolean found = false;
        while(!found&&hasParent(index)){
            int parent = parent(index);
            if(elementData[parent].compareTo(elementData[index]) > 0){
                swap(elementData, index, parent(index));
                index = parent(index);
            } else{
                found = true;
            }
        }
        size++;
        // TO DO
    }
    
    // Sai
    // Returns true if there are no elements in this queue.
    // Time Complexity: O(1)
    public boolean isEmpty() {
        if(elementData == null || size<=0){
            return true;
        }
    	// TO DO
    	return false;
    }
    
    // Sai
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Time Complexity: O(1)
    public E peek() {
    	// TO DO
        return elementData[1];
    }
    
       // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    // Time Complexity: O(height)
    // Done by: Kevin Masa Nakura-Fan
    public E remove() {
    	// TO DO
        E min = elementData[1];
        elementData[1] = elementData[this.size];
        size--;
        boolean ordered = false;
        int index = 1;
        while (!ordered && hasLeftChild(index)) {
            int left = leftChild(index);
            int swapping = left;
            if (hasRightChild(index) && elementData[rightChild(index)].compareTo(elementData[left]) < 0) {
                swapping = rightChild(index);
            }
            if (elementData[swapping].compareTo(elementData[index]) < 0) {
                swap(elementData, index, swapping);
                index = swapping;
            } else {
                ordered = true;
            }
        }
    	return min;
    }
    
    // Returns the number of elements in the queue.
    // Time Complexity: O(1)
    // Done by: Kevin Masa Nakura-Fan
    public int size() {
    	// TO DO
        return this.size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    // Time Complexity: O(n)
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    // helpers for navigating indexes up/down the tree
    // returns the index of parent
    // Time Complexity: O(1)
    // Done by: Kevin Masa Nakura-Fan
    private int parent(int index) {
    	// TO DO
        return index/2;
    }
    
    // Soleil
    // Time Complexity: O(1)
    // returns index of left child of given index
    private int leftChild(int index) {
    	// TO DO
        return 2*index;
    }
    
    // Soleil
    // Time Complexity: O(1)
    // returns index of right child of given index
    private int rightChild(int index) {
    	// TO DO
        return 2*index + 1;
    }

    // Soleil
    // Time Complexity: O(1)
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
    	// TO DO
        return ((index - 1)/2 != index && elementData[(index - 1)/2] != null) || (index/2 != index && elementData[index/2] != null);
    }
    
    // Ashley
    // Time Complexity: O(1)
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
    	// TO DO
        return size >= 2 * index && elementData[2 * index] != null;
    }
    
    // Ashley
    // Time Complexity: O(1)
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
    	// TO DO
        return size >= 2 * index + 1 && elementData[2 * index + 1] != null;
    }
    
    // Ashley
    // Time Complexity: O(1)
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
    	// TO DO
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}

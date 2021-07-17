package datastructure.customearraylist;

import java.util.Arrays;

class ArrayListCustom<E> {
	 
    // Define INITIAL_CAPACITY, size of elements of custom ArrayList
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private Object elementData[] = {};
 
    /**
     *
     * constructor of custom ArrayList
     */
    public ArrayListCustom() {
           elementData = new Object[INITIAL_CAPACITY];
    }
 
    /**
     * add elements in custom/your own ArrayList
     * Method adds elements in ArrayListCustom.
     */
    public void add(E e) {
           if (size == elementData.length) {
                  ensureCapacity(); // increase current capacity of list, make it
                                                    // double.
           }
           elementData[size++] = e;
    }
 
    /**
     * method returns element on specific index.
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
           // if index is negative or greater than size of size, we throw
           // Exception.
           if (index < 0 || index >= size) {
                  throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                               + index);
           }
           return (E) elementData[index]; // return value on index.
    }
 
    /**
     * remove elements from custom/your own ArrayList method returns
     *
     * removedElement on specific index. else it throws IndexOutOfBoundException
     * if index is negative or greater than size of size.
     */
    public Object remove(int index) {
           // if index is negative or greater than size of size, we throw
           // Exception.
        if (index < 0 || index >= size) {
                  throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                               + index);
           }
 
           Object removedElement = elementData[index];
           for (int i = index; i < size - 1; i++) {
                  elementData[i] = elementData[i + 1];
           }
           size--; // reduce size of ArrayListCustom after removal of element.
 
           return removedElement;
    }
 
    /**
     * Ensure capacity of custom/your own ArrayList.
     *
     * Method increases capacity of list by making it double.
     */
    private void ensureCapacity() {
           int newIncreasedCapacity = elementData.length * 2;
           elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }
 
    /**
     * Display custom/your own ArrayList.
     *
     * Method displays all the elements in list.
     */
    public void display() {
           System.out.print("Displaying list : ");
           for (int i = 0; i < size; i++) {
                  System.out.print(elementData[i] + " ");
           }
    }
 
}
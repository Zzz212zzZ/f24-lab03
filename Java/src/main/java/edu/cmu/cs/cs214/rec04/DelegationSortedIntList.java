package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    private SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    /**
     * Adds the specified int to the list.
     *
     * @param value an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */

    public boolean add(int value) {
        boolean success = false;
        if (list.add(value) == true) {
            totalAdded++;
            success = true;
        }
        return success;
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     * Calls add() on each element of list. Can be overwritten
     * for more specific behavior.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.add(list.get(i));
        }
        return success;
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public int getTotalAdded() {
        return totalAdded;
    }

    /**
     * Returns the integer at the specified position in this list.
     * 
     * @param index index of the element to return
     * @return the element at the specified position
     */

    public int get(int index) {
        return list.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present (optional operation).
     *
     * @param value an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    public boolean remove(int value) {
        return list.remove(value);
    }

    /**
     * Gets the size of the list.
     *
     * @return the number of elements in the list
     * 
     */
    public int size() {
        return list.size();
    }

    /**
     * Removes from the list all of its elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from
     *             the list
     * @return true if the list changed as a result of the call
     */

    public boolean removeAll(IntegerList list) {
        return this.list.removeAll(list);
    }

}
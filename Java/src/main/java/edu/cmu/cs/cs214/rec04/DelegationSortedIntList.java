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
    // Write your implementation below with API documentation
    private SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    public boolean add(int value) {
        boolean success = false;
        if (list.add(value) == true) {
            totalAdded++;
            success = true;
        }
        return success;
    }

    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.add(list.get(i));
        }
        return success;
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    public int get(int index) {
        return list.get(index);
    }

    public boolean remove(int value) {
        return list.remove(value);
    }
    
    public int size() {
        return list.size();
    }

    public boolean removeAll(IntegerList list) {
        return this.list.removeAll(list);
    }

}
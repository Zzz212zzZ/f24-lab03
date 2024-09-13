package edu.cmu.cs.cs214.rec04;
import java.util.ArrayList;

public class SortedIntList extends AbstractIntList {
    private ArrayList<Integer> list;
    private int size;

    public SortedIntList() {
        super();
        list = new ArrayList<>();
    }

    @Override
    public boolean add(int num) {
        int index = 0;
        while (index < size && num < list.get(index)) {
            index++;
        }
        list.add(index, num);
        size++;
        return true;
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.add(list.get(i));
        }
        return success;
    }

    public int get(int index) {
        return list.get(index);
    }

    public boolean remove(int num) {
        for (int i = 0; i < size; i++) {
            if (list.get(i) == num) {
                list.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.remove(list.get(i));
        }
        return success;
    }

    public int size() {
        return size;
    }
    
}
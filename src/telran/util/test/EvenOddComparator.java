package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return (o1 == null) ? 1 : 
               (o2 == null) ? -1 : 
               ((o1 % 2 == 0) == (o2 % 2 == 0)) ? o1.compareTo(o2) :
               (o1 % 2 == 0) ? -1 : 1;
    }
}

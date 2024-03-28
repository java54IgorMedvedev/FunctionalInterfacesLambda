package telran.util.test;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
    	boolean isNum1Even = num1 % 2 == 0;
    	boolean isNum2Even = num2 % 2 == 0;
    	int res = 1;
    	if(isNum1Even && isNum2Even) {
    		res = num1 - num2;
    	} else if (!isNum1Even && isNum2Even) {
    		res = num2 - num1;
    	} else if (isNum1Even) {
    		res = -1;
    	}
    	return res;
    }
}

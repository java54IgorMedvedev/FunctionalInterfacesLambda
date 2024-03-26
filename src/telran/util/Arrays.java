package telran.util;

import java.util.Comparator;

public class Arrays {
	public static <T> int indexOf(T[] array, T element) {
		int index = 0;
		while (index < array.length && !equals(array[index], element)) {
			index++;
		}
		return index == array.length ? -1 : index;
	}

	private static <T> boolean equals(T elem1, T elem2) {
		
		return elem1 == null ? elem1 == elem2 : elem1.equals(elem2);
	}
	public static <T> T min(T[] array, Comparator<T> comp) {
		T res = null;
		if(array != null && array.length > 0) {
			res = array[0];
			for(int i = 1; i < array.length; i++) {
				if(comp.compare(res, array[i]) > 0) {
					res = array[i];
				}
			}
		}
		return res;
	}
	public static <T> void bubbleSort(T[] array, Comparator<T> comp) {
        boolean needNextPass = true;

        for (int k = 1; k < array.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < array.length - k; i++) {
                if (comp.compare(array[i], array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    needNextPass = true; 
                }
            }
        }
    }
}

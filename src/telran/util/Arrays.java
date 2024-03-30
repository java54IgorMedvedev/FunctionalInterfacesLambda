package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;

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
        boolean isUsorted = true;
        int length = array.length;
        while(isUsorted) {
        	length--;
        	isUsorted = false;
        	for(int i = 0; i < length; i++) {
        		if(comp.compare(array[i], array[i + 1]) > 0) {
        			swap(array, i, i + 1);
        			isUsorted = true;
        		}
        	}
        }
     }

	private static <T> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] =tmp;
	}
	public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
		int left = 0;
	    int right = array.length - 1;
	    int result = -1; 
	    
	    while (left <= right) {
	        int middle = left + (right - left) / 2;
	        int comparisonResult = comp.compare(key, array[middle]);
	        
	        if (comparisonResult == 0) {
	            result = middle; 
	            break; 
	        } else if (comparisonResult < 0) {
	            right = middle - 1; 
	        } else {
	            left = middle + 1; 
	        }
	    }
	    
	    return result; 
	}
	public static <T> T[] search(T[] array, Predicate<T> predicate) {
		//Inpossible to allocate memory for generic array
		//Only Arrays.copyOf may be used
		T[] arResult = java.util.Arrays.copyOf(array, array.length);
		int index = 0;
		for(int i = 0; i < array.length; i++) {
			if(predicate.test(array[i])) {
				arResult[index++] = array[i];
			}
		}
		return java.util.Arrays.copyOf(arResult, index);
	}
	public static <T> T[]removeIf(T[] array, Predicate<T> predicate) {
		T[] tempArray = java.util.Arrays.copyOf(array, array.length);
	    int count = 0;
	    for (T element : array) {
	        if (!predicate.test(element)) {
	            tempArray[count++] = element;
	        }
	    }
	    return java.util.Arrays.copyOf(tempArray, count);
	}
}

package org.example.FinalProject;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;

public class Algorithms {

    // Generic Selection Sort (O(n²))
    public static <T> void selectionSort(List<T> list, Comparator<? super T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            T temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
    }

    // Generic Binary Search (O(log n)) - Returns Optional
    public static <T> Optional<T> binarySearch(List<T> list, T target, Comparator<? super T> comparator) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midVal = list.get(mid);
            int cmp = comparator.compare(midVal, target);

            if (cmp == 0) {
                return Optional.of(midVal);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Optional.empty();
    }
}
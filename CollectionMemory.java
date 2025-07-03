package com.day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMemory {
	private static final int ELEMENT_COUNT = 1_000_000; // number of elements to add

    public static void main(String[] args) {
        System.out.println("Measuring memory usage of different collections...\n");

        measureMemoryUsage("ArrayList", () -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                list.add(i);
            } 
        });

        measureMemoryUsage("HashSet", () -> {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                set.add(i);
            }
        });

        measureMemoryUsage("HashMap", () -> {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                map.put(i, i);
            }
        });
    }

    private static void measureMemoryUsage(String collectionName, Runnable collectionCreator) {
        System.gc(); // Hint JVM to run garbage collector
        long beforeUsedMem = getUsedMemory();

        collectionCreator.run(); // Build the collection

        System.gc(); // Hint JVM again
        long afterUsedMem = getUsedMemory();

        long memoryUsed = afterUsedMem - beforeUsedMem;
        System.out.println(collectionName + " used approximately: " + formatMemory(memoryUsed));
    }

    private static long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static String formatMemory(long bytes) {
        long kb = bytes / 1024;
        long mb = kb / 1024;
        return mb + " MB (" + kb + " KB, " + bytes + " bytes)";
    }
}




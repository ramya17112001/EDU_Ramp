package com.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryUsage {
	private static final int ELEMENT_COUNT = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Measuring memory usage of Java Collections\n");

        measureMemoryUsage("ArrayList", () -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                list.add("Element" + i);
            }
        });

        measureMemoryUsage("HashSet", () -> {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                set.add("Element" + i);
            }
        });

        measureMemoryUsage("HashMap", () -> {
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                map.put(i, "Element" + i);
            }
        });
    }

    private static void measureMemoryUsage(String name, Runnable task) throws InterruptedException {
        
        runGC();
        long beforeUsedMem = usedMemory();
        task.run();

        runGC();
        long afterUsedMem = usedMemory();

        long memoryUsed = afterUsedMem - beforeUsedMem;

        System.out.printf("%s used: %.2f MB%n", name, memoryUsed / (1024.0 * 1024.0));
    }

    private static long usedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static void runGC() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            System.gc();
            Thread.sleep(100);
        }
    }    

 
}

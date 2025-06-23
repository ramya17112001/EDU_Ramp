package com.day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Student implements Comparable<Student> {
	    int id;
	    String name;
	    double grade;

	    public Student(int id, String name, double grade) {
	        this.id = id;
	        this.name = name;
	        this.grade = grade;
	    }

	    @Override
	     public int compareTo(Student other) {
	       
	        return Double.compare(other.grade, this.grade);
	    }

	    @Override
	    public String toString() {
	        return id + " - " + name + " (Grade: " + grade + ")";
	    }
	}

	public class StudentExample {
	    public static void main(String[] args) throws InterruptedException {
	        Student s1 = new Student(101, "ramya", 88.5);
	        Student s2 = new Student(102, "chandu", 91.0);
	        Student s3 = new Student(103, "pranali", 85.0);

	        Queue<Student> linkedListQueue = new LinkedList<>();
	        linkedListQueue.add(s1);
	        linkedListQueue.add(s2);
	        linkedListQueue.add(s3);
	        System.out.println("LinkedList Queue:");
	        while (!linkedListQueue.isEmpty()) {
	            System.out.println(linkedListQueue.poll());
	        }

	        Deque<Student> arrayDeque = new ArrayDeque<>();
	        arrayDeque.add(s1);
	        arrayDeque.add(s2);
	        arrayDeque.add(s3);
	        System.out.println("\nArrayDeque:");
	        while (!arrayDeque.isEmpty()) {
	            System.out.println(arrayDeque.poll());
	        }
	        
	        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
	        priorityQueue.add(s1);
	        priorityQueue.add(s2);
	        priorityQueue.add(s3);
	        System.out.println("\nPriorityQueue (by grade):");
	        while (!priorityQueue.isEmpty()) {
	            System.out.println(priorityQueue.poll());
	        }

	        BlockingQueue<Student> blockingQueue = new LinkedBlockingQueue<>();
	        blockingQueue.put(s1);
	        blockingQueue.put(s2);
	        blockingQueue.put(s3);
	        System.out.println("\nBlockingQueue:");
	        while (!blockingQueue.isEmpty()) {
	            System.out.println(blockingQueue.take());
	        }
	        
	        Queue<Student> concurrentQueue = new ConcurrentLinkedQueue<>();
	        concurrentQueue.add(s1);
	        concurrentQueue.add(s2);
	        concurrentQueue.add(s3); 
	        System.out.println("\nConcurrentLinkedQueue:");
	        while (!concurrentQueue.isEmpty()) {
	            System.out.println(concurrentQueue.poll());
	        }
	    }
	} 
	  
	




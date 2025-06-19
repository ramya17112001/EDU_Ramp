package com.day8;

import java.util.concurrent.Semaphore;

class Car extends Thread {
	
	    private String carName;
	    private int washTime;
	    private Semaphore station;

	    public Car(String carName, int washTime, Semaphore station) {
	        this.carName = carName;
	        this.washTime = washTime;
	        this.station = station;
	    }

	    @Override
	    public void run() {
	        try {
	            System.out.println(carName + " is waiting for a free station.");
	            station.acquire();  
	            System.out.println(carName + " started washing. Will take " + washTime + " seconds.");
	            Thread.sleep(2000);  
	            System.out.println(carName + " finished washing.");
	        } catch (InterruptedException e) {
	            System.out.println(carName + " was interrupted.");
	        } finally {
	            station.release();  
	        }
	    }
	}

	public class CarSemaphore {
	    public static void main(String[] args) {
	      
	        Semaphore carWashStations = new Semaphore(2);

	      
	        Car[] cars = {
	            new Car("Car A", 1, carWashStations),
	            new Car("Car B", 2, carWashStations),
	            new Car("Car C", 3, carWashStations),
	            //new Car("Car D", 1, carWashStations),
	            //new Car("Car E", 2, carWashStations)
	        };

	    
	        for (Car car : cars) {
	            car.start();
	        }

	     
	        for (Car car : cars) {
	            try {
	                car.join();
	             } catch (InterruptedException e) {
	                System.out.println("Main thread interrupted.");
	            }
	        }

	        System.out.println("All cars have been washed.");
	    }
	}
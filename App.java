package com.oodpassignment;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		RestaurantApp restaurant = new RestaurantApp();

		restaurant.start();


	}
	
}

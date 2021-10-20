package Application;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;


public class ReservationApp {
    public static void main(String[] args){
        System.out.print(LocalDateTime.now());
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        // Restaurant newRestaurant = new Restaurant(); 
        int sel = 0;
        do{
            System.out.printf("Select an option\n" +
                "(1) do something\n" +
                "(2) \n" +
                "(3) \n" +
                "(4) \n" +
                "(5) \n" +
                "(6) \n" +
                "(-1) Quit\n");

            sel = sc.nextInt();
            switch(sel){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }}while (sel!=-1);
    }
    
}

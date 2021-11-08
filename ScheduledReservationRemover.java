package com.oodpassignment;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledReservationRemover {
    public void scheduleReservationRemover(ArrayList<Reservation> reservations,ReservationLogic reservationLogic){

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<reservations.size();i++){
                    if(System.currentTimeMillis()>=reservations.get(i).getDateandtime().getTimeInMillis()){
                        reservationLogic.removeReservation(reservations.get(i).getTableNumber(),reservations.get(i).getName(),true);
                    }
                }
            }
        };
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(runnable, 15, 15, TimeUnit.MINUTES);
    }
}

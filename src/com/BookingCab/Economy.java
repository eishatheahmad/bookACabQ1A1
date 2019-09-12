package com.BookingCab;

import java.util.Random;

class Economy extends Cab
{
    @Override
    String getType()
    {
        return "Economy";
    }


    //calculates money based on distance randomly
    @Override
    float calculateInvoice(float distance) {
        if(distance <= 20)
        {
            Random rand2 = new Random();
            int temp2= rand2.nextInt(300);

            Random rand = new Random();
            int temp= rand.nextInt(80);
            return (distance*8+distance*temp)+temp2;
            //return distance*5;

        }

        else
        {
            Random rand2 = new Random();
            int temp2= rand2.nextInt(400);
            Random rand = new Random();
            int temp= rand.nextInt(100);
            //return distance*8+distance*temp;
            return (distance*5 + distance*Math.abs(distance-temp))+temp2;
        }
    }

    @Override
    void detailsOfCab() {
        System.out.println("Cab Details:");
        System.out.println("Cab ID: "+getIdOfCab());
        System.out.println("Cab Type: " +getType());
    }
}

package com.BookingCab;

import java.util.Scanner;

//this is the class where all the classes are tested out
class Ride
{
    //calls functions from cab through polymorphism to get invoice. It gets details of customer for
    //invoice as well from customer class
    static void finalInvoiceCalculation(Customer currentCustomer, Driver currentDriver)
    {
        currentCustomer.customerBooking.displayBookingDetails();
        System.out.println("Estimated Money: "+currentDriver.vehicle.calculateInvoice(currentCustomer.customerBooking.getDistance()));

    }

    //checks what type of cabs are available
    // the type and status of all the available cars and displays appropriate message about availability
    static void currentCabsAvailable(Driver[] list, int size, int available)
    {
        for(int i=0; i<size;i++)
        {
            if(!list[i].vehicle.getCabStatus())
            {
                System.out.println(list[i].vehicle.getTypeCab());
                available++;

            }
            else
            {
                System.out.println("No Cab Available.");
            }
        }
    }

    ////this is a final check for finding a cab.
    //checks and changes the status of cab to occupied(true), index here is to store the index of car that has been booked
    static void findCab(Driver[]list, int size, int typeCab, int index)
    {
        boolean flag=false;

        for(int i=0; i<size;i++)
        {
           if( list[i].vehicle.getTypeByUserOfCab()==typeCab &&!list[i].vehicle.getCabStatus() )
           {
               System.out.println("Cab Found.\n");
               list[i].vehicle.hailCab(); //changes cab status to true which means it is no longer available now.
               index=i;
               list[index].vehicle.detailsOfCab();
               flag=true;
               break;

           }
           else
           {
               flag=false;
           }
        }

        if(flag==false)
        {
            System.out.println("No Cab is Available at the moment. Please wait and Try Again.");
        }



    }

    //testing all the methods
    static void testRide()
    {
        final int numberOfCustomers=2;
        final int numberOfDrivers=2;

        Driver [] currentDrivers= new Driver[numberOfDrivers];
        Customer [] currentCustomers = new Customer[numberOfCustomers];

        for(int j=0; j<numberOfDrivers;j++)
        {
            currentDrivers[j]=new Driver();
        }

        currentDrivers[0].setDiver(1,"Ali",1000,false,1);
        currentDrivers[1].setDiver(2,"Ahmad",2000,false,2);


        for(int i=0; i<numberOfCustomers;i++)
        {
            currentCustomers[i]=new Customer();
        }

        //currentCustomers[0].setCustomer(100,"Zain");
        //currentCustomers[1].setCustomer(200,"Shabbir");

        System.out.println("Welcome to Cab Booking System");
        int choice=0;
        int index=0;
        System.out.println("Press 1 to book a cab");
        System.out.println("Press 2 to close application");

        Scanner input= new Scanner(System.in);
        choice=input.nextInt();

        if(choice==1)
        {
            System.out.println("Enter the details:");
            currentCustomers[index].customerBooking= new Booking();
            currentCustomers[index].customerBooking.bookingDetails();
            System.out.println("Loading...\n\n");
            System.out.println("Select your cab type.");
            System.out.println("Currently there is: ");
            int availability = 0;
            currentCabsAvailable(currentDrivers,numberOfDrivers,availability);

            System.out.println("\n\nPress 1 for Economy class");
            System.out.println("Press 2 for Executive class");
            //System.out.println("Press 3 to cancel");
            int typeOfCab=0; int cabIndex=0;
            typeOfCab=input.nextInt();

            findCab(currentDrivers,numberOfDrivers,typeOfCab,cabIndex);

            System.out.println("Please wait...\n");

            System.out.println("\n\nINVOICE:");
            finalInvoiceCalculation(currentCustomers[index],currentDrivers[cabIndex]);

            System.out.println("\n***End Of Ride***\n");
            System.out.println("\nPlease Leave Feedback :)");

            currentDrivers[cabIndex].driverFeedback= new Feedback();
            currentDrivers[cabIndex].driverFeedback.takeFeedBackFromCustomer();


        }

        else if(choice==2)
        {
            System.out.println("Application close.");
        }



    }


}

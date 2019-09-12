package com.BookingCab;

import java.util.Random;
import java.util.Scanner;

//this class manages basically getting the booking details from customer.
class Booking extends Customer
{
    private int bookingId;
    private int pickUpTime;
    private int dropTime;
    private int distance;
    private String pickUpLocation;
    private String dropLocation;

    float invoice;

    protected void displayBookingDetails()
    {
        System.out.println("Name: "+getName());
        System.out.println("ID: "+getId());
        System.out.println("Your Location: " +getPickUpLocation());
        System.out.println("Drop point: " +getDropLocation());
        System.out.println("Distance: "+ calculateDistance(pickUpLocation.charAt(0),dropLocation.charAt(0)) + " kms");
        System.out.println("BookingID: "+ bookingId);
    }

    float getDistance()
    {
        return distance;
    }

    String getDropLocation()
    {
        return this.dropLocation;
    }

    String getPickUpLocation()
    {
        return this.pickUpLocation;
    }

    Booking()
    {
        Random rand = new Random();
        bookingId=rand.nextInt(1000);
        pickUpTime=0;
        dropTime=0;
        distance=0;
        dropLocation=null;
        pickUpLocation=null;
        invoice=0;
    }

    float getInvoice()
    {
        return invoice;
    }

    void setInvoice(float tempInVoice)
    {
        this.invoice=tempInVoice;
    }

    void setBookingId(int id)
    {
        this.bookingId=id;
    }

    void setPickUpTime(int time)
    {
        this.pickUpTime=time;
    }

    void setDropTime(int time)
    {
        this.dropTime=time;
    }

    void setDistance(int distance)
    {
        this.distance=distance;
    }

    void setPickUpLocation(String location)
    {
        this.pickUpLocation=location;
    }

    void setDropLocation(String location)
    {
        this.dropLocation=location;
    }

    // a random function to calculate the distance. It is made just to implement. Works randomly.
    int calculateDistance(char a, char b)
    {
        Random rand = new Random();
        int temp = Math.abs(a-b) * rand.nextInt(10);

        this.distance=temp;
        return temp;
    }


    //this method gets all the details from user and sets it as well.
    void bookingDetails()
    {
        System.out.println("Name:");

        Scanner input= new Scanner(System.in);
        String temp= input.next();
        this.setCustomerName(temp);

        System.out.println("ID:");
        Scanner in= new Scanner(System.in);
        int tempID= in.nextInt();
        this.setCustomerID(tempID);

        System.out.println("Pick Up Time:");
        int tempTime=in.nextInt();
        this.setPickUpTime(tempTime);


        Scanner sc= new Scanner(System.in);
        System.out.println("Current Location:");
        String tempChar = sc.next();
        this.setPickUpLocation(tempChar);

        System.out.println("Drop location:");
        tempChar=sc.next();
        this.setDropLocation(tempChar);

        //System.out.println("Distance:"+ calculateDistance(this.pickUpLocation.charAt(0),this.dropLocation.charAt(0)));

        this.setDistance(calculateDistance(this.pickUpLocation.charAt(0),this.dropLocation.charAt(0)));

    }

}

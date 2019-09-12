package com.BookingCab;

import java.util.Scanner;

//gets feedback for driver
class Feedback
{
    private String feedback;
    private int rating;

    Feedback()
    {
        feedback=null;
        rating=0;
    }

    Feedback(String message, int rate)
    {
        this.feedback=message;
        this.rating=rate;
    }

    void setFeedback(String message, int rate)
    {
        feedback=message;
        rating=rate;
    }

    //takes input for user for Feedback and
    void takeFeedBackFromCustomer()
    {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter feedback: (write your message)");
        String buffer= input.nextLine();

        System.out.println("Rate the ride out of 5");
        int tempRate= input.nextInt() & 5;

        setFeedback(buffer,tempRate);
        System.out.println("THANK YOU FOR YOUR VALUABLE FEEDBACK. GOOD BYE.");

    }
}

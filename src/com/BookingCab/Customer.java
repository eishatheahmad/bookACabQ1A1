package com.BookingCab;

//customer class inherits from User class
class Customer extends User{

    protected Booking customerBooking; //this would include all the booking details like current location, drop location etc


    //overloaded constructor of Customer class
    Customer(String name, int id)
    {
        super();
        customerBooking= new Booking();
    }

    //default constructor
    public Customer() {
        name=null;
        id=0;

    }

    void setCustomer(int customerID, String customerName)
    {
        setCustomerID(customerID);
        setCustomerName(customerName);
    }
    @Override
    String getName()
    {
        return this.name;
    }


    @Override
    int getId() {
        return this.id;
    }

    void setCustomerName(String name)
    {
        this.name=name;
    }

    void setCustomerID(int id)
    {
        this.id=id;
    }

    //returns the status of the cab. False means it is available and True means it is occupied
   boolean findACab(Cab car)
   {
       if(car.isCabAvailable())
       {
           return true;
       }

       else
           return false;

   }

}

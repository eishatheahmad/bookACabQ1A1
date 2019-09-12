package com.BookingCab;

class Driver extends User{

   Cab vehicle; //the car details that is the ID, status of availability and type of car
   Feedback driverFeedback; //to get the message and rating by the customer for the driver


    //helps to set the Driver object by taking all the parameters
   void setDiver(int id, String name, int CarID,boolean carStatus, int type)
   {
       this.id=id;
       this.name=name;

       //if type==1 then Economy, type==2 then executive
       if(type==1)
       {
           vehicle= new Economy();
       }
       else
       {
           vehicle=new Executive();
       }

       this.vehicle.setCab(CarID,carStatus);
       this.vehicle.setType(type);

   }

   //overloaded constructor of Driver
    Driver(String name, int id, int type)
    {
        super();
        driverFeedback=new Feedback();
        if(type == 1 )
        {
            vehicle=new Economy();
        }

        else if(type==2)
            vehicle=new Executive();
        //vehicle.setCab(0,false);
        //driverFeedback.setFeedback();

    }

    //overloaded constructor of driver with different parameters
    Driver(String name,int driverId, int carId, boolean status,int typeCar)
    {
        super();
        if(typeCar==1)
        {
            vehicle=new Economy();
        }
        else if(typeCar==2)
        {
            vehicle=new Executive();
        }
        vehicle.setCab(carId,status);

    }

    Driver() { };

    Feedback getFeedback()
    {
        return driverFeedback;
    }

    void setDriverFeedback(String feedback, int rate)
    {
        driverFeedback.setFeedback(feedback,rate);
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
}

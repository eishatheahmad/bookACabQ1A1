package com.BookingCab;

//abstract class
abstract class User{
     protected String name;
     protected int id;

    //default constructor
    User()
    {
        this.name=null;
        this.id=0;
    }

    //overloaded constructor
    User(String name, int id)
    {
        this.name=name;
        this.id=id;
    }


    //methods to be must overridden by child classes.
    abstract String getName();
    abstract int getId();


}

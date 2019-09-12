package com.BookingCab;

//this class is made abstract and has Economy and Executive classes as child
abstract class Cab
{
    private int cabId;
    private boolean status; //is it available or not
    private int type;

    abstract float calculateInvoice(float distance);
    abstract void detailsOfCab();

    void setType(int typeCab)
    {
        this.type=typeCab;
    }

    int getTypeByUserOfCab(){
        return this.type;
    }

    abstract String getType();

    String getTypeCab()
    {
        if(type==1 && !this.status)
        {
            return "Economy Available.";
        }
        else if(type==2 && !this.status)
            return "Executive Available";

        else if(type ==1 && this.status)
            return "No Economy Cab Available.";
        else if(type ==2 && this.status)
            return "No executive Cab Available.";

        else
            return "No Cab Available";


    }

    Cab(int id, int type)
    {
        this.cabId=id;
        this.status=false;//true would mean available
        this.type=type;
    }

    Cab()
    {
        this.cabId=0;
        this.status=false; //true would mean available
    }

    boolean isCabAvailable()
    {
        return this.status;
    }

    void setCab(int id, boolean status)
    {
        this.cabId=id;
        this.status=status;
    }

    boolean hailCab()
    {
        this.status=true;
        return this.status;

    }

    boolean getCabStatus()
    {
        return this.status;
    }

    int getIdOfCab()
    {
        return this.cabId;
    }
}

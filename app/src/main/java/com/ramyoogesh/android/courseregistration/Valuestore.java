package com.ramyoogesh.android.courseregistration;

/**
 * Created by RamYoogesh on 24/04/17.
 */

public class Valuestore {

    private int Courseallot;
    private int  starttime ;
    private int endtime;


    public Valuestore()
    {

    }
    public Valuestore(int Coallot,int st,int et)
    {
        this.Courseallot=Coallot;
        this.starttime=st;
                this.endtime=et;

    }
public Valuestore(int Ca,int ss)
{
    this.Courseallot=Ca;
    this.starttime=ss;
}

    public int getCourseallot()
    {
        return Courseallot;

    }
    public void setCourseallot(int Coallot)
    {
        this.Courseallot=Coallot;
    }
    public int getStarttime()
    {
        return starttime;
    }
    public int getEndtime()
    {
        return endtime;
    }



}

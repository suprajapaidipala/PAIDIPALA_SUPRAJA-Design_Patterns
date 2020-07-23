package com.supraja.epamtask7_Supraja;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan
{
    protected double rate;
    abstract void getRate();
    public void calculateBill(int unitsRecorded)
    {
        System.out.print("BILL : ");
        System.out.println(unitsRecorded*rate);
    }
}

class SchoolPlan extends Plan
{
    public void getRate()
    {
        rate = 3.75;
    }
}

class CollegePlan extends Plan
{
    public void getRate()
    { 
    	rate = 7.52; 
    }
}

class UniversityPlan extends Plan
{
    public void getRate()
    { 
    	rate = 5.56; 
    }
}

class callPlan
{
    public Plan getPlanType(String planType)
    {
        if(planType==null)
            return null;
        else if(planType.equalsIgnoreCase("School"))
            return new SchoolPlan();
        else if(planType.equalsIgnoreCase("College"))
            return new CollegePlan();
        else if(planType.equalsIgnoreCase("University"))
            return new UniversityPlan();
        else
            return null;
    }
}

public class FactoryMethodPattern
{
    public static void main(String[] args) throws IOException
    {
        callPlan getPlan = new callPlan();
        System.out.println("Choose between School/ College/ University");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planType = br.readLine();
        System.out.println("Enter number of units for bill");
        int units = Integer.parseInt(br.readLine());

        Plan p = getPlan.getPlanType(planType);
        p.getRate();
        p.calculateBill(units);
    }
}

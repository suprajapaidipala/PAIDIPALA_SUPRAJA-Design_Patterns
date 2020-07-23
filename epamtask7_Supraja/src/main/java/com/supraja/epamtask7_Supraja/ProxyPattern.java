package com.supraja.epamtask7_Supraja;

interface OfficeNetAccess
{
    void grantNetAccess();
}

class RealNetAccess implements OfficeNetAccess
{
    private String eName1;
    public RealNetAccess(String empName)
    {
        this.eName1 = empName;
    }
    @Override
    public void grantNetAccess()
    {
        System.out.println("Access granted to the employee " + eName1);
    }
}

class ProxyNetAccess implements OfficeNetAccess
{
    private String eName1;
    public ProxyNetAccess(String eName1)
    {
        this.eName1 = eName1;
    }
    public int getRole(String empName)
    {
        return empName.length();
    }
    @Override
    public void grantNetAccess()
    {
        if(getRole(eName1) > 4)
        {
            RealNetAccess realNetAccess = new RealNetAccess(eName1);
            realNetAccess.grantNetAccess();
        }
        else
            System.out.println("Access not granted. Your job level is below 5...");
    }
}

public class ProxyPattern
{
    public static void main(String[] args)
    {
        OfficeNetAccess officeNetAccess = new ProxyNetAccess("Supraja");
        officeNetAccess.grantNetAccess();
    }
}

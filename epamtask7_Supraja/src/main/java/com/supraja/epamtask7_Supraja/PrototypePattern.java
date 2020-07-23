package com.supraja.epamtask7_Supraja;

import java.util.HashMap;
import java.util.Map;

abstract class Color implements Cloneable
{
    protected String color;
    abstract void addColor();
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
}

class blackColor extends Color
{
    public blackColor()
    {
        this.color="black";
    }
    @Override
    void addColor()
    {
        System.out.println("black color added");
    }
}

class yellowColor extends Color
{
    public yellowColor()
    {
        this.color="yellow";
    }
    @Override
    void addColor()
    {
        System.out.println("yellow color added");
    }
}

class ColorStore
{
    private static Map<String, Color> colorMap = new HashMap<>();
    static
    {
        colorMap.put("black",new blackColor());
        colorMap.put("yellow",new yellowColor());
    }
    public static Color getColor(String colorName)
    {
        return (Color) colorMap.get(colorName).clone();
    }
}

public class PrototypePattern
{
    public static void main(String[] args)
    {
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("yellow").addColor();
        ColorStore.getColor("yellow").addColor();
        ColorStore.getColor("black").addColor();
    }
}

package com.company;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by Student on 3/28/2017.
 */
public class Student implements Serializable
{
    private long ID;
    private char Group;
    private String Name;

    public void Student()
    {
        ID = 0;
        Group = 'A';
        Name = "";
    }

    public void Student(long id, char group, String name)
    {
        ID = id;
        Group = group;
        Name = name;
    }

    public void SetID(long id)
    {
        ID = id;
    }

    public long GetID()
    {
        return ID;
    }

    public void SetGroup(char group)
    {
        Group = group;
    }

    public char GetGroup()
    {
        return Group;
    }

    public void SetName(String name)
    {
        Name = name;
    }

    public String GetName()
    {
        return Name;
    }

    public void read()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("\nStudent Name: ");
        Name = reader.next();

        System.out.print("\nStudent ID: ");
        ID = reader.nextLong();

        System.out.print("\nGroup: ");
        Group = reader.next().charAt(0);
    }

    public void print()
    {
        System.out.print("\nStudent Name: " + Name + "\nGroup: " + Group + "\nStudent ID: " + ID);
    }
}

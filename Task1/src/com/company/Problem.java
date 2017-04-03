package com.company;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by lubu on 3/28/2017.
 */
public class Problem implements Serializable
{
    private long ID;
    private String Requirement;

    public void Problem()
    {
        ID = 0;
        Requirement = "";
    }

    public void Problem(long id, String requirement)
    {
        ID = id;
        Requirement = requirement;
    }

    public void SetID(long id)
    {
        ID = id;
    }

    public long GetID()
    {
        return ID;
    }

    public void SetRequirement(String requirement)
    {
        Requirement = requirement;
    }

    public String GetRequirement()
    {
        return Requirement;
    }

    public void read()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("Problem ID: ");
        ID = reader.nextLong();

        System.out.print("Requirement: ");
        Requirement = reader.next();
    }

    public void print()
    {
        System.out.print("\nProblem ID: " + ID + "\nRequirement: " + Requirement);
    }
}

package com.company;
import java.util.Scanner;

/**
 * Created by lubu on 3/28/2017.
 */
public class Problem
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

    public void read()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("\nProblem ID: ");
        ID = reader.nextLong();

        System.out.print("\nRequirement: ");
        Requirement = reader.nextLine();
    }

    public void print()
    {
        System.out.print("\nProblem ID: " + ID + "\nRequirement: " + Requirement);
    }
}

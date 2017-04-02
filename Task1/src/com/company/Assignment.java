package com.company;
import java.io.Serializable;
import java.util.Scanner;

/**
 * Created by lubu on 3/28/2017.
 */
public class Assignment implements Serializable
{
    private long StudentID, ProblemID;
    private int Grade;

    public void Assignment()
    {
        StudentID = 0;
        ProblemID = 0;
        Grade = 0;
    }

    public void Assignment(long studentid, long problemid, int grade)
    {
        StudentID = studentid;
        ProblemID = problemid;
        Grade = grade;
    }

    public void SetStudentID(long id)
    {
        StudentID = id;
    }

    public long GetStudentID()
    {
        return StudentID;
    }

    public void SetProblemID(long id)
    {
        ProblemID = id;
    }

    public long GetProblemID()
    {
        return ProblemID;
    }

    public void SetGrade(int grade)
    {
        Grade = grade;
    }

    public int GetGrade()
    {
        return Grade;
    }

    public void read()
    {
        Scanner reader = new Scanner(System.in);

        System.out.print("\nStudent ID: ");
        StudentID = reader.nextLong();

        System.out.print("\nProblem ID: ");
        ProblemID = reader.nextLong();

        System.out.print("\nGrade: ");
        Grade = reader.nextInt();
    }

    public void print()
    {
        System.out.print("\nStudent ID: " + StudentID + "\nProblem ID: " + ProblemID + "\nGrade: " + Grade);
    }
}

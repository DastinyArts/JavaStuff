package com.company;

/**
 * Created by lubu on 3/28/2017.
 */
public class Assignment
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

    public void print()
    {
        System.out.print("\nStudent ID: " + StudentID + "\nProblem ID: " + ProblemID + "\nGrade: " + Grade);
    }
}

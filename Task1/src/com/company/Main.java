package com.company;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        long studentid, problemid;
        char group;
        String name, requirement;

        Student student1 = new Student();
        Student student2 = new Student();
        Problem problem1 = new Problem();
        Assignment assignment1 = new Assignment();

        Scanner sc = new Scanner(System.in);


        System.out.print("Problem ID: ");
        problemid = sc.nextLong();

        System.out.print("Requirement: ");
        requirement = sc.next();

        problem1.Problem(problemid, requirement);


        System.out.print("Student Name: ");
        name = sc.next();

        System.out.print("Group: ");
        group = sc.next().charAt(0);

        System.out.print("Student ID: ");
        studentid = sc.nextLong();

        student1.Student(studentid, group, name);
        assignment1.Assignment(studentid, problemid, 3);


        System.out.print("Student Name: ");
        name = sc.next();

        System.out.print("Group: ");
        group = sc.next().charAt(0);

        System.out.print("Student ID: ");
        studentid = sc.nextLong();

        student2.Student(studentid, group, name);
        assignment1.Assignment(studentid, problemid, 10);

    }
}

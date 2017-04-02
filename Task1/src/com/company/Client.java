package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by lubu on 4/1/2017.
 */
public class Client
{
    public static void main(String[] args) throws Exception
    {
        Student student = new Student();
        Problem problem = new Problem();
        Assignment assignment = new Assignment();

        Vector<Student> students = new Vector();
        Vector<Problem> problems = new Vector();
        Vector<Assignment> assignments = new Vector();

        Socket socket = new Socket("localhost", 4141);

        int choice;
        Scanner s = new Scanner(System.in);

        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());


        System.out.print("1.Add a Student\n2.Add a Problem\n3.Add an Assignment\n4.List of Students\n5.List of Problems\n6.List of Assignments\n7.Remove a Student\n8.Remove a Problem\n9.Remove an Assignment\n");

        while(true)
        {
            choice = s.nextInt();
            outputStream.writeInt(choice);
            outputStream.flush();

            switch(choice)
            {
                case 1:
                {
                    student.read();
                    outputStream.writeObject(student);

                    outputStream.flush();
                    student = new Student();
                    break;
                }

                case 2:
                {
                    problem.read();
                    outputStream.writeObject(problem);

                    outputStream.flush();
                    problem = new Problem();
                    break;
                }

                case 3:
                {
                    assignment.read();
                    outputStream.writeObject(assignment);

                    outputStream.flush();
                    assignment = new Assignment();
                    break;
                }

                case 4:
                {
                    students.addAll((Vector<Student>) inStream.readObject());

                    if(students.isEmpty())
                    {
                        System.out.println("\nThere are no Students.");
                        break;
                    }

                    for(int i = 0; i < students.size(); i++)
                    {
                        System.out.print("\nStudent Number " + (i+1));
                        student = students.get(i);
                        student.print();
                    }

                    student = new Student();
                    students.removeAllElements();

                    System.out.print("\n");
                    break;
                }

                case 5:
                {
                    problems.addAll((Vector<Problem>) inStream.readObject());

                    if(problems.isEmpty())
                    {
                        System.out.println("\nThere are no Problems.");
                        break;
                    }

                    for(int i = 0; i < problems.size(); i++)
                    {
                        System.out.print("\nProblem Number " + (i+1));
                        problem = problems.get(i);
                        problem.print();
                    }

                    problem = new Problem();
                    problems.removeAllElements();

                    System.out.print("\n");
                    break;
                }

                case 6:
                {
                    problems.addAll((Vector<Problem>) inStream.readObject());

                    if(assignments.isEmpty())
                    {
                        System.out.println("\nThere are no Assignments.");
                        break;
                    }

                    for(int i = 0; i < assignments.size(); i++)
                    {
                        System.out.print("\nAssignment Number " + (i+1));
                        assignment = assignments.get(i);
                        assignment.print();
                    }

                    assignment = new Assignment();

                    System.out.print("\n");
                    assignments.removeAllElements();

                    break;
                }

                case 7:
                {
                    System.out.print("\nSelect the number of the student you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("\nSuccessfully deleted.\n");

                    break;
                }

                case 8:
                {
                    System.out.print("\nSelect the number of the problem you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("\nSuccessfully deleted.\n");

                    break;
                }

                case 9:
                {
                    System.out.print("\nSelect the number of the assignment you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("\nSuccessfully deleted.\n");

                    break;
                }

                default: System.out.println("\nInvalid option, please select one that is listed above."); break;
            }
        }
    }
}

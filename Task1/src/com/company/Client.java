package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

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

                    System.out.print("Student Successfully Added!\n");

                    break;
                }

                case 2:
                {
                    problem.read();
                    outputStream.writeObject(problem);

                    outputStream.flush();
                    problem = new Problem();

                    System.out.print("Problem Successfully Added!\n");

                    break;
                }

                case 3:
                {
                    assignment.read();
                    outputStream.writeObject(assignment);

                    outputStream.flush();
                    assignment = new Assignment();

                    System.out.print("Assignment Successfully Added!\n");

                    break;
                }

                case 4:
                {
                    int size = inStream.readInt();

                    if(size > 0)
                    {
                        for (int i = 0; i < size; i++)
                        {
                            System.out.print("Student Number " + (i+1) + "\n\nStudent Name: " + inStream.readObject() + "\nStudent ID: " + inStream.readObject() + "\nGroup: " + inStream.readObject() + "\n");
                        }
                    }
                    else
                    {
                        System.out.print("There are no Students.\n");
                    }
                    break;
                }

                case 5:
                {
                    int size = inStream.readInt();

                    if(size > 0)
                    {
                        for (int i = 0; i < size; i++)
                        {
                            System.out.print("Problem Number " + (i+1) + "\n\nProblem ID: " + inStream.readObject() + "\nRequirement: " + inStream.readObject() + "\n");
                        }
                    }
                    else
                    {
                        System.out.print("There are no Problems.\n");
                    }

                    break;
                }

                case 6:
                {
                    int size = inStream.readInt();

                    if(size > 0)
                    {
                        for (int i = 0; i < size; i++)
                        {
                            System.out.print("Assignment Number " + (i+1) + "\n\nStudent ID: " + inStream.readObject() + "\nProblem ID: " + inStream.readObject() + "\nGrade: " + inStream.readObject() + "\n");
                        }
                    }
                    else
                    {
                        System.out.print("There are no Assignments.\n");
                    }

                    break;
                }

                case 7:
                {
                    System.out.print("\nSelect the number of the student you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("Successfully deleted.\n");

                    break;
                }

                case 8:
                {
                    System.out.print("Select the number of the problem you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("Successfully deleted.\n");

                    break;
                }

                case 9:
                {
                    System.out.print("Select the number of the assignment you want to delete: ");
                    outputStream.writeInt(s.nextInt());
                    outputStream.flush();
                    System.out.print("Successfully deleted.\n");

                    break;
                }

                default: System.out.println("Invalid option, please select one that is listed above.\n"); break;
            }
        }
    }
}

package com.company;
import java.io.*;
import java.net.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        //Server Stuff
        ServerSocket serverSocket = new ServerSocket(4141);
        Socket socket = serverSocket.accept();
        ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());


        //Assignment stuff
        ArrayList<Student> students = new ArrayList();
        ArrayList<Problem> problems = new ArrayList();
        ArrayList<Assignment> assignments = new ArrayList();



        while(true)
        {
            int choice = inStream.readInt();

            switch(choice)
            {
                case 1: students.add((Student) inStream.readObject()); break;

                case 2: problems.add((Problem) inStream.readObject()); break;

                case 3: assignments.add((Assignment) inStream.readObject()); break;

                case 4:
                {
                    int size = students.size();

                    outputStream.writeInt(size);
                    outputStream.flush();

                    for(int i = 0; i < size; i++)
                    {
                        outputStream.writeObject(students.get(i).GetName());
                        outputStream.writeObject(students.get(i).GetID());
                        outputStream.writeObject(students.get(i).GetGroup());
                        outputStream.flush();
                    }
                } break;

                case 5:
                {
                    int size = problems.size();

                    outputStream.writeInt(size);
                    outputStream.flush();

                    for(int i = 0; i < size; i++)
                    {
                        outputStream.writeObject(problems.get(i).GetID());
                        outputStream.writeObject(problems.get(i).GetRequirement());
                        outputStream.flush();
                    }
                } break;

                case 6:
                {
                    int size = assignments.size();

                    outputStream.writeInt(size);
                    outputStream.flush();

                    for(int i = 0; i < size; i++)
                    {
                        outputStream.writeObject(assignments.get(i).GetStudentID());
                        outputStream.writeObject(assignments.get(i).GetProblemID());
                        outputStream.writeObject(assignments.get(i).GetGrade());
                        outputStream.flush();
                    }
                } break;

                case 7:
                {
                    if(!students.isEmpty())
                    {
                        int index = inStream.readInt();
                        students.remove(index - 1);
                    }
                } break;

                case 8:
                {
                    if(!problems.isEmpty())
                    {
                        int index = inStream.readInt();
                        problems.remove(index - 1);
                    }
                } break;

                case 9:
                {
                    if(!assignments.isEmpty())
                    {
                        int index = inStream.readInt();
                        assignments.remove(index - 1);
                    }
                } break;

                default: System.out.println("Invalid Option"); break;
            }
        }
    }
}

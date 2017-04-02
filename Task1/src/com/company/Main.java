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
        Vector<Student> students = new Vector();
        Vector<Problem> problems = new Vector();
        Vector<Assignment> assignments = new Vector();

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
                    outputStream.writeObject(students);
                    outputStream.flush();
                } break;

                case 5:
                {
                    outputStream.writeObject(problems);
                    outputStream.flush();
                } break;

                case 6:
                {
                    outputStream.writeObject(assignments);
                    outputStream.flush();
                } break;

                case 7:
                {
                    if(!students.isEmpty())
                    {
                        int index = inStream.readInt();
                        students.removeElementAt(index - 1);
                    }
                } break;

                case 8:
                {
                    if(!problems.isEmpty())
                    {
                        int index = inStream.readInt();
                        problems.removeElementAt(index - 1);
                    }
                } break;

                case 9:
                {
                    if(!assignments.isEmpty())
                    {
                        int index = inStream.readInt();
                        assignments.removeElementAt(index - 1);
                    }
                } break;

                default: System.out.println("Invalid Option"); break;
            }
        }
    }
}

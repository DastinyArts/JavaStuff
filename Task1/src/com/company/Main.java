package com.company;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        Student student = new Student();
        Problem problem = new Problem();
        Assignment assignment = new Assignment();

        Vector<Student> students = new Vector();
        Vector<Problem> problems = new Vector();
        Vector<Assignment> assignments = new Vector();

        System.out.print("1.Add a Student\n2.Add a Problem\n3.Add an Assignment\n4.List of Students\n5.List of Problems\n6.List of Assignments\n");

        while(true)
        {
            switch(reader.nextInt())
            {
                case 1:
                {
                    student.read();
                    students.add(student);
                    student = new Student();
                    break;
                }
                case 2:
                {
                    problem.read();
                    problems.add(problem);
                    problem = new Problem();
                    break;
                }
                case 3:
                {
                    assignment.read();
                    assignments.add(assignment);
                    assignment = new Assignment();
                    break;
                }
                case 4:
                {
                    if(students.isEmpty())
                    {
                        System.out.println("\nThere are no Students.");
                        break;
                    }

                    for(int i = 0; i < students.size(); i++)
                    {
                        System.out.print("\n\nStudent " + (i+1));
                        students.get(i).print();
                    }

                    break;
                }
                case 5:
                {
                    if(problems.isEmpty())
                    {
                        System.out.println("\nThere are no Problems.");
                        break;
                    }

                    for(int i = 0; i < problems.size(); i++)
                    {
                        System.out.print("\n\nProblem " + (i+1));
                        problems.get(i).print();
                    }

                    break;
                }
                case 6:
                {
                    if(assignments.isEmpty())
                    {
                        System.out.println("\n\nThere are no Assignments.");
                        break;
                    }

                    for(int i = 0; i < assignments.size(); i++)
                    {
                        System.out.print("\nAssignment " + (i+1));
                        assignments.get(i).print();
                    }

                    break;
                }

                default: System.out.println("\nInvalid option, please select one that is listed above."); break;
            }
        }

    }
}

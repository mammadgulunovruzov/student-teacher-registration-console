package database;

import entity.Student;
import entity.Teacher;
import utility.FileUtility;

public class DB {

    public static Student[] students;
    public static Teacher[] teachers;


    public static void save(){
        FileUtility.writeObjectToFile(students,"students.obj");
        FileUtility.writeObjectToFile(teachers,"teachers.obj");

    }

    public static void initialize()  {

        try {
            students = (Student[])FileUtility.readObjectFromFile("students.obj");
            teachers = (Teacher[])FileUtility.readObjectFromFile("teachers.obj");

        }catch (Exception e){
            students = new Student[0];
            teachers = new Teacher[0];

        }

    }

}

package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Database implements Serializable {
    ArrayList<Student> database = new ArrayList<Student>();

    public void add() {
        String string;
        int temp;
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.println("Input name of student:(Nnnn N.N.");
        string = scanner.nextLine();
        student.setNameOfStudent(string);
        System.out.println("Input name of Faculty:");
        string = scanner.next();
        student.setNameOfFaculty(string);
        System.out.println("Input rate:(1-6)");
        temp = scanner.nextByte();
        student.setRate(temp);
        student.session.setSession();
        database.add(student);
    }

    public void add(Student student) {
        database.add(student);
    }

    public void printDatabase() {
        for (int i = 0; i < database.size(); i++) {
            System.out.println("Name of student:" + database.get(i).getNameOfStudent() +
                    "\nName of Faculty:" + database.get(i).getNameOfFaculty() +
                    "\nRate:" + database.get(i).getRate());
            database.get(i).session.getSession();

        }
    }

    public void excellentStudentsPrint() {
        System.out.println("excellent students:");
        boolean m = false;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).session.excellentStudents()) {
                System.out.println("Name of student:" + database.get(i).getNameOfStudent() +
                        "\nName of Faculty:" + database.get(i).getNameOfFaculty() +
                        "\nRate:" + database.get(i).getRate());
                database.get(i).session.getSession();
                m = true;
            }
        }
        if (!m) System.out.println("not found");


    }

    public void LosersPrint() {
        System.out.println("Losers:");
        boolean m = false;
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).session.Losers()) {
                System.out.println("Name of student:" + database.get(i).getNameOfStudent() +
                        "\nName of Faculty:" + database.get(i).getNameOfFaculty() +
                        "\nRate:" + database.get(i).getRate());
                database.get(i).session.getSession();
                m = true;
            }

        }
        if (!m) System.out.println("not found");

    }

    public void LosersDelete() {
        boolean m = false;
        for (int i = database.size()-1; i >-1 ; i--) {
            if (database.get(i).session.Losers()) {
                database.remove(i);
                m = true;
            }

        }
        if (!m) System.out.println("Losers not found!");
        else
            System.out.println("Losers deleted!");
    }

    public void theGreatestNumberOfLosers() {
        Study studyes[] = Study.values();

        int quantity[] = new int[studyes.length];
        //считаем сколько двоек по каждому предмету
        for (int i = 0; i <database.size() ; i++) {
            for (int j = 0; j < database.get(i).session.session.size(); j++) {//проходим по всем предметам в сессии

                for (int k = 0; k <studyes.length ; k++) {//проходим по каждому предмету
                    //System.out.println(studyes[i].toString());
                    studyes[k].toString();
                    database.get(i).session.session.get(j).getStudy();


                    if(studyes[k].toString().equals(database.get(i).session.session.get(j).getStudy()))//находим предмет из перечесления, соответствующий записи из сессии
                    {
                        if(database.get(i).session.session.get(j).getRating()<60)//если в записи двойка
                        {
                            quantity[k]++;//прибавляем к количеству двоек этого предмета
                        }

                    }
                }
            }
        }
/*
        for (int i = 0; i <studyes.length ; i++) {
            System.out.println(studyes[i]+" -"+quantity[i]);
        }
*/
    //ищем предмет с наибольшим количеством двоечников
        int max=0;
        int maxI=0;
        boolean m=false;//если по нескольким предметам одинаковое количество двоечников
        for (int i = 0; i < studyes.length; i++) {
            if(quantity[i]>max) {
                max = quantity[i];
                maxI=i;
            }
            else if(quantity[i]==max){
                m=true;
                System.out.println("Losers by"+studyes[maxI]+"("+max+")");
                max = quantity[i];
                maxI=i;
            }
        }
        if(max>0&&!m)
        System.out.println("most Losers by "+studyes[maxI]+"("+max+")");

    }


}

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void test(Database database){
        int testNum=2;
        Study studyes[]=Study.values();
        for (int i = 0; i <testNum ; i++) {
            Student student = new Student();

            student.rate = 3;
            student.nameOfStudent="Testnamestudent N.N. #"+(i+1);
            student.setNameOfFaculty("ICS");
            student.session.sessionIni();
            for (int j = 0; j <5 ; j++) {
                student.session.session.get(j).nameOfLecturer="Testnamelector N.N. #"+(j+1);
                student.session.session.get(j).setRating(55+(i+j)*3);
                student.session.session.get(j).setStudy(studyes[j].toString());
            }

            database.add(student);
        }
    }

    public static void menu() {
        File file=new File();
        Database database = new Database();
        test(database);

        //database.database.get(0).session.setSession();
        int action;
        Scanner scanner = new Scanner(System.in);
        while (true) {
           database.database= file.FromFile();
            System.out.println("case 1:\n" +
                    "atabase.add();\n" +
                    "case 2:\n" +
                    "database.excellentStudentsPrint();\n" +
                    "case 3:\n" +
                    "database.LosersPrint();\n" +
                    "case 4:\n" +
                    "database.LosersDelete();\n" +
                    "case 5:\n" +
                    "database.theGreatestNumberOfLosers();\n" +
                    "case 6:\n" +
                    "database.printDatabase();\n" +

                    "System.out.println();");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    database.add();
                    break;
                case 2:
                    database.excellentStudentsPrint();//работает
                    break;
                case 3:
                    database.LosersPrint();//работает
                    break;
                case 4:
                    database.LosersDelete();//работает
                    break;
                case 5:
                    database.theGreatestNumberOfLosers();//работает
                    break;
                case 6:
                    database.printDatabase();//работает
                    break;
                default:
                    System.out.println();
            }
            file.ToFile(database.database);
            System.out.println("---------------------------------------");
        }

    }
}

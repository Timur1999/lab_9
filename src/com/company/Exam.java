package com.company;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exam implements Serializable {
    String study;//предмет
    String nameOfLecturer;
    int rating;

    public void setExam(){
        String string;
        int a;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input study:");
        string=scanner.nextLine();
        setStudy(string);
        System.out.println("Input Name of Lecturer:");
        string=scanner.nextLine();
        setNameOfLecturer(string);
        System.out.println("Input rating:");
        a=scanner.nextByte();
        setRating(a);


    }

    public void setNameOfLecturer(String nameOfLecturer) {


        Pattern etalon = Pattern.compile("^([A-Z][a-z]+) ([A-Z])[.]([A-Z])[.]$");
        Matcher m = etalon.matcher(nameOfLecturer);

        if(m.matches())
        {
            this.nameOfLecturer=nameOfLecturer;
        }
        else {
            System.out.println("error! Name Format: Aa... A. A.");

        }

    }

    public void setStudy(String study) {
        Study[] studyes=Study.values();
        boolean m = false;
        for (int i = 0; i <studyes.length ; i++) {
            if(studyes[i].toString().equals(study))
            {
                this.study=study;
                m=true;
                break;
            }
        }
        }

    public void setRating(int rating) {
        if(rating>=0&&rating<=100)
        this.rating = rating;

    }


    public String getNameOfLecturer() {
        return this.nameOfLecturer;
    }

    public String getStudy() {
        return this.study;
    }

    public int getRating() {
        return this.rating;
    }
}

enum Study{
    programming,
   // physics,
    maths
}
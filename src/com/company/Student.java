package com.company;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student implements Serializable {
    String nameOfStudent;
    String nameOfFaculty;
    int rate;
    Session session=new Session();
    //region get`еры
    public String getNameOfStudent(){
        return this.nameOfStudent;
    }
    public String getNameOfFaculty(){
        return this.nameOfFaculty;
    }

    public int getRate(){
        return this.rate;
    }

    //endregion
    //region set`ep


    public boolean setNameOfStudent(String nameOfStudent) {

        Pattern etalon = Pattern.compile("^([A-Z][a-z]+) ([A-Z])[.]([A-Z])[.]$");
        Matcher m = etalon.matcher(nameOfStudent);

        if(m.matches())
        {
            this.nameOfStudent=nameOfStudent;
        }
        else {
            System.out.println("error! Name Format: Aa... A. A.");
            return false;
        }
        return true;

    }

    public boolean setNameOfFaculty(String nameOfFaculty) {
        Faculty[] faculty=Faculty.values();
        boolean m=false;
        for (int i = 0; i <faculty.length ; i++) {
            if(faculty[i].toString().equals(nameOfFaculty)){
                m=true;
                break;
            }
        }

        if(m)
        this.nameOfFaculty = nameOfFaculty;
        else return false;

        return true;
    }

    public boolean setRate(int rate) {
        if(rate>=1&&rate<=6)
        this.rate = rate;
        else return false;

        return true;
    }

    //endregion
}

enum Faculty{
    ICS,IMS,IPTDM,IBEIT,GF
}

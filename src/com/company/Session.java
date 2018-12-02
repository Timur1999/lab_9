package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Session implements Serializable {
    final byte numberOfExams=5;
    ArrayList<Exam> session=new ArrayList<Exam>();
    public boolean excellentStudents(){//определяет, является ли владелец сессии отличником
        boolean excellentStudentsFlag=true;
        
        for (int i = 0; i <session.size() ; i++) {
            if (session.get(i).getRating() < 90)
                return false;
        }
        return true;
    }

    public boolean Losers(){//определяет, является ли владелец сессии двоечником
        boolean twinklesFlag=false;

        for (int i = 0; i <session.size() ; i++) {
            if(session.get(i).getRating()<60)
                return true;
        }
        return false;
    }



    public void sessionIni(){

        for (int i = 0; i <numberOfExams ; i++) {
            Exam exam=new Exam();
            session.add(exam);
        }
    }

    public void getSession(){
        for (int i = 0; i < session.size(); i++) {
            System.out.println("Study:"+session.get(i).getStudy()+
            "\nname Of Lecturer:"+session.get(i).getNameOfLecturer()+"\nRating:"+session.get(i).getRating());
        }
    }
    public void setSession(){
        sessionIni();
        for (int i = 0; i <session.size() ; i++) {
            session.get(i).setExam();
        }
    }

}

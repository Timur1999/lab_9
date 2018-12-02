package com.company;

import java.io.*;
import java.util.ArrayList;

public class File implements Serializable {
    public void ToFile(ArrayList database){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DataBase.dat")))
        {
            oos.writeObject(database);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }
    public ArrayList<Student> FromFile(){
        ArrayList<Student> database=null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DataBase.dat")))
        {
            database=(ArrayList) ois.readObject();
            //System.out.printf("Name: %s \t Age: %s \n", AutoBase.get(0);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return database;
    }
}

package com.pluralsight;
import java.io.*;

import java.util.*;
public class Main {
    static void main(){
        try {
            Employee[] employees = new Employee[8];
            FileReader fileReader = new FileReader("src/data/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            bufReader.readLine();
            String input;
            int index = 0;
            while((input = bufReader.readLine())!= null){
                String[] details = input.split("\\|");
                int id = Integer.parseInt(details[0]);
                String name = details[1];
                double hours = Double.parseDouble(details[2]);
                double rate = Double.parseDouble(details[3]);
                employees[index++]= new Employee(id,name,hours,rate);

            }
            System.out.printf("%-7s %-20s %-10s\n","ID","Name","Gross Pay");
            for(int i=0;i<employees.length;i++){

                System.out.printf("%-7d %-20s %-10.2f\n",employees[i].getEmployeeId(),employees[i].getName(),employees[i].getGrossPay());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

package com.pluralsight;
import java.io.*;

import java.util.*;
public class Main {
    static void main(){
        try {
            Employee[] employees = new Employee[8];
            String fileToRead = Console.promptForString("Enter the name of the file employee file to process: ");

            FileReader fileReader = new FileReader("src/data/"+fileToRead);
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
            bufReader.close();
            String fileToWrite = Console.promptForString("Enter the name of the payroll file to create: ");
            FileWriter fileWriter = new FileWriter("src/data/"+fileToWrite);
            String header = String.format("%-7s| %-20s| %-10s\n","ID","Name","Gross Pay");

            fileWriter.write(header);
            for(int i=0;i<employees.length;i++){
                String row = String.format("%-7d| %-20s| %-10.2f\n",employees[i].getEmployeeId(),employees[i].getName(),employees[i].getGrossPay());
                fileWriter.write(row);
            }
            fileWriter.close();
            FileReader fileReader2 = new FileReader("src/data/"+fileToWrite);
            BufferedReader bufferedReader = new BufferedReader(fileReader2);
            String line;
            while((line = bufferedReader.readLine())!= null) {
                System.out.println(line);
            }
            bufferedReader.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

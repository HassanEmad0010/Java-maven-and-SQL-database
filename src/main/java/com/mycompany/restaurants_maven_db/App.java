/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restaurants_maven_db;

import dao.DBMethods;
import java.util.Scanner;


/**
 *
 * @author Hassan Emad
 */
public class App {
    public static void main(String[] args) {
        System.out.println(" <start>");
        Scanner input = new Scanner(System.in);
        DBMethods w = new DBMethods();
     boolean state = true ;
do{
    int x;
        System.out.println("----------------------------------------------------");
        System.out.println("***************WELCOME IN OUR RESTURANR************");
        System.out.println("****** CHOSE WHAT U WANT TO DO!       ***********");
        System.out.println("****** TO enter food data enter 1     ***********");
        System.out.println("****** To search by food id enter 2   ***********");
        System.out.println("****** To search by food name enter 3 ***********");
        System.out.println("****** To search by food cost enter 4 ***********");
        System.out.println("****** To delete by food id enter 5   ***********");
        System.out.println("****** To Show all Data enter 6       ***********");        
        System.out.println("****** To Delete all Data enter 1001  ***********");
        System.out.println("****** To exite enter 0               ********** ");
        System.out.println("----------------------------------------------------");

            
        x=input.nextInt();
        
        switch (x) 
                {
            case 1:
              System.out.println("**Enter the food data please**");
                w.enterFood();
                break;
            case 2 :
              System.out.println("**Enter the id u want to search**");
              int id = input.nextInt();
              w.searchFood(id);
        break;
              
             case 3 :
              System.out.println("**Enter the name u want to search**");
              String name = input.next();
              w.searchFood(name);
        break; 
        
         case 4 :
              System.out.println("**Enter the cost u want to search**");
              double cost = input.nextDouble();
              w.searchFood(cost);
        break;
       
          case 5 :
              System.out.println("**Enter the id u want to delete**");
              int in_id = input.nextInt();
              w.deleteFood(in_id);
        break;
        
          case 6 :
              System.out.println("**Shwoing all data**"); 
              w.printAllData();
        break;
            case 1001 :
              System.out.println("**Deleting all data**");
              w.deleteAllData();
        break;
          case 0:  
       state= false;
       break;
       default:
           System.out.println("error input try again");
        }
               
         
}while (state);
        
        


//w.enterFood();
        //w.searchFood(2021);
      //  w.searchFood("meat");
    //    w.searchFood("rice");
   //w.searchFood(20.0);
 //       System.out.println("******end*****");  
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hassan Emad
 */
public class DBMethods {
    
            Scanner input = new Scanner(System.in);

    
    public Connection testConnection()
    {
    Connection con = DBConnection.getConnection();
		if(con == null) {
		System.out.println("error on connection");
		return null;
		}
		else
		{
			System.out.println("Successfully connected to DATABASE");
			return con;
		}
    }
    
    public void faildConnection()
    {
        
		System.out.println("error on connection");
		
    }
    
    
    public  void enterFood (){
Connection con =testConnection();
        if (con == null )
faildConnection();    
    
        else 
        {
            int in_id=0 ;
            String in_name="defualt";
            Double in_cost=0.0;
            System.out.println("enter food id");
            in_id= input.nextInt();
         System.out.println("enter food name");
            in_name= input.next();
             System.out.println("enter food cost");
            in_cost= input.nextDouble();
            
        
    try {
        String query ="insert into thefood (id, name, cost) values(?,?,?) ";
        
        PreparedStatement preparedstatment_obj= con.prepareStatement(query);
        preparedstatment_obj.setInt(1, in_id);
        preparedstatment_obj.setString(2, in_name);
        preparedstatment_obj.setDouble(3, in_cost);
        preparedstatment_obj.executeUpdate();
        
        
    } catch (SQLException ex) {
        System.out.println("error on enter food methode is "+ ex.getMessage()); ;
    } finally {
    try {
       con.close();
            } catch (SQLException ex) {
             Logger.getLogger(DBMethods.class.getName()).log(Level.SEVERE, null, ex);
            }			
    }
        
        }
    

}
    
    public void searchFood (int id)
    {
        Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "SELECT * FROM thefood WHERE ID = "+id;
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
              //  preparedStatement_obj.setInt(1, id);
                ResultSet resSet = preparedStatement_obj.executeQuery(query);
               
                while (resSet.next())             
                {
                   int out_id= resSet.getInt("ID");
                    String out_name = resSet.getString("NAME");
                    double out_cost = resSet.getDouble("COST");
                    printData(out_id, out_cost, out_name);
                    
                }
                
            } catch (Exception ex) {
                System.out.println("error in search by id is "+ ex.getMessage());
            }
            
            
          
        
            
            
            
        }
            
        
        
    
    }    
    
    
    
   public void searchFood (String name)
    {
     Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "SELECT * FROM thefood WHERE NAME = '" +name+"'"   ;
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
              //  preparedStatement_obj.setInt(1, id);
                ResultSet resSet = preparedStatement_obj.executeQuery(query);
               
                while (resSet.next())             
                {
                   int out_id= resSet.getInt("ID");
                    String out_name = resSet.getString("NAME");
                    double out_cost = resSet.getDouble("COST");
                    printData(out_id, out_cost, out_name);
                    
                }
                
            } catch (Exception ex) {
                System.out.println("error in search by name is "+ ex.getMessage());
            }
            
            
          
        }
        
        
    }  
    
    public void searchFood (double cost)
    {
     Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "SELECT * FROM thefood WHERE COST =" +cost ;
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
                ResultSet resSet = preparedStatement_obj.executeQuery(query);
               
                while (resSet.next())             
                {
                   int out_id= resSet.getInt("ID");
                    String out_name = resSet.getString("NAME");
                    double out_cost = resSet.getDouble("COST");
                    printData(out_id, out_cost, out_name);
                    
                }
                
            } catch (Exception ex) {
                System.out.println("error in search by cost is "+ ex.getMessage());
            }
            
            
          
        }
        
        
    }
    
    public void deleteFood(int in_id)
    {
    Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "DELETE FROM thefood WHERE ID =" +in_id ;
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
               preparedStatement_obj.executeUpdate(query);
                System.out.println("id "+in_id+ " deleted successfully");
                
                
                
            } catch (Exception ex) {
                System.out.println("error in delete by id is "+ ex.getMessage());
            }
            
            
          
        }
        
        
    
    }
    
    public void deleteAllData()
    {
        
    Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "DELETE FROM thefood" ;
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
               preparedStatement_obj.executeUpdate(query);
                System.out.println("Data in the table Food deleted successfully");
                
                
                
            } catch (Exception ex) {
                System.out.println("error in delete by id is "+ ex.getMessage());
            }
            
            
          
        }
        
        
    
    }
   
     public void printAllData ()
    {
     Connection con = testConnection();
        if (con == null)
            faildConnection();
        else
        {
            try {
                String query= "SELECT * FROM thefood ";
                PreparedStatement preparedStatement_obj =con.prepareStatement(query);
                ResultSet resSet = preparedStatement_obj.executeQuery(query);
               
                while (resSet.next())             
                {
                   int out_id= resSet.getInt("ID");
                    String out_name = resSet.getString("NAME");
                    double out_cost = resSet.getDouble("COST");
                    printData(out_id, out_cost, out_name);
                    
                }
                
            } catch (Exception ex) {
                System.out.println("error in search by cost is "+ ex.getMessage());
            }
            
            
          
        }
        
        
    }
    
   public void printData(int id, double cost, String name)
   {
       System.out.println("The id is "+id +" the name is "+ name + " the cost is "+ cost );
   }
    
    
    
}

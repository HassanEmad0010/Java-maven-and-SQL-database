/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Password;

/**
 *
 * @author Hassan Emad
 */
public class DBConnection {
    private final static String DBname="resturant";
    private final static String Username="root";    
    private final static String Pass="1234";
    private final static String host="127.0.0.1";
    
   private static Connection con; 
    public static Connection getConnection()
  {
        try {
            con=DriverManager.getConnection(String.format("jdbc:mysql://%s/%s" ,host,DBname) , Username, Pass);
        } catch (Exception ex) {
                   System.out.println("error on connection is "+ ex.getMessage()); ;

        }
	
              
  return con;
  
  }
    
  
    
    
    
    
}

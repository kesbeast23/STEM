package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import model.*;
import DatabaseConnection.DBConnect;
/**
 *
 * @author Kesego
 */
public class StemControl {
    
    static PreparedStatement ps=null;
    static Connection con =null;
    static ResultSet rs = null;
    
    public static ResultSet loginUsers(String username,String password,String usertype) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "SELECT `username`, `password`,`usertype` FROM `user` WHERE username=? and password=? and usertype=?";
        ps =con.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, usertype);
        rs=ps.executeQuery();
        
        return rs;
    }
     public static ResultSet loginCustomers(int customernumber,String password) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "SELECT `customernumber`,`password` FROM `customer` WHERE customernumber=? and password=?";
        ps =con.prepareStatement(query);
        ps.setInt(1, customernumber);
        ps.setString(2, password);
        rs=ps.executeQuery();
        
        return rs;
     }
    public static void collectCustomerData(int customernumber,String firstname,String lastname,Date date) throws SQLException{
        Customer customer = new Customer(customernumber,date,firstname,lastname);
        addCustomerToDatabase(customer);
       
    }
    public static void addCustomerToDatabase(Customer customer) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "INSERT INTO `customer` (`customernumber`, `firstname`, `surname`, `date`, `password`) VALUES (?, ?, ?, ?, 'password')";
        ps =con.prepareStatement(query);
        ps.setInt(1, customer.getCustomerNumber());
        ps.setString(2, customer.getFirstname());
        ps.setString(3, customer.getLastname());
        ps.setDate(4, customer.getDate());
        ps.executeUpdate();
    }
    public static void updateCustomerData(int customernumber,String firstname,String lastname,Date date) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "update customer set firstname =?,surname=?,date=? where customernumber=?";
        ps =con.prepareStatement(query);
        ps.setString(1,firstname);
        ps.setString(2, lastname);
        ps.setDate(3, date);
        ps.setInt(4, customernumber);
        ps.executeUpdate();
    }
    public static void deleteCustomerData(int customernumber) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "delete from customer where customernumber=?";
        ps =con.prepareStatement(query);
        ps.setInt(1, customernumber);
        ps.executeUpdate();
    }
    
    public static void collectUserData(String username, String firstname, String lastname,String email, String physicalAddress, String usertype) throws SQLException{
        User user = new User(username,firstname,lastname,email,physicalAddress);
        addUserToDatabase(user,usertype);
       
    }
     public static void addUserToDatabase(User user,String usertype) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "INSERT INTO `user` (`username`, `password`, `email`, `firstname`, `surname`, `physicalAddress`, `usertype`) VALUES (?, 'password', ?, ?, ?, ?, ?)";
        ps =con.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getFirstname());
        ps.setString(3, user.getLastname());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPhysicalAddress());
        ps.setString(6, usertype);
        ps.executeUpdate();
    }
     public static void updateUserData(String username, String firstname, String lastname,String email, String physicalAddress, String usertype) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "UPDATE `user` SET `firstname`=?,`surname`=?,`email`=?,`physicalAddress`=?,`usertype`=? WHERE `username`=?";
        ps =con.prepareStatement(query);
        ps.setString(1, firstname);
        ps.setString(2, lastname);
        ps.setString(3,email);
        ps.setString(4, physicalAddress);
        ps.setString(5, usertype);  
        ps.setString(6, username);  
        ps.executeUpdate();
    }
      public static void deleteUserData(String username) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "delete from user where username=?";
        ps =con.prepareStatement(query);
        ps.setString(1, username);
        ps.executeUpdate();
    }
    public static void faciliateLoan(int customernumber,String firstname,String lastname,Double loanAmount,Date loanDate,int noOfDaysDue,int contact,String status) throws SQLException{
        con = DBConnect.getDatabaseConnection();
        String query = "INSERT INTO `loan` (`customernumber`, `firstname`,"
                + " `lastname`, `loanAmount`, `loanDate`, `noOfDaysDue`, `contact`,"
                + " `status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps =con.prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getFirstname());
        ps.setString(3, user.getLastname());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPhysicalAddress());
        ps.setString(6, usertype);
        ps.executeUpdate();
    }
 
}

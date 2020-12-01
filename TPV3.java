/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpv3;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexara
 */
public class TPV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Primero descargamos la libreria de mysql conection 
        
        // TODO code application logic here
        String usuario="root";
        String clave="";
        String url="jdbc:mysql://localhost:3306/tpv";
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TPV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(url,usuario,clave);
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM dependientes");
            while(rs.next()){
                System.out.println(rs.getInt("id_dependiente")+" "+rs.getString("nombre")+" "+rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TPV3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius
 */

public class Conexao {
    private Statement stmt; //executar consultas DML
    private ResultSet rs; //gerenciar consultas DQL
    private Connection c;         

    public Conexao() {
        String Database = "equipamentos";
        String user = "root";
        String password = "";
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/" + Database + "?serverTimezone=UTC";
        
        //Abrir conexão
        try {            
            Class.forName(driver).newInstance();                               
            c = DriverManager.getConnection(url, user, password);            
            stmt = c.createStatement();              
        }
        catch (Exception e) {            
            JOptionPane.showMessageDialog(null, "Erro na conexão MySQL");            
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(null, "A aplicação será finalizada...");
            System.exit(0); //Finalizar a aplicação
        }              
    }    
    
    public boolean SQLExecute(String SQL) {
        try {
            this.stmt.execute(SQL);
            return true;
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }        
    }

    public boolean setResultSet(String Query) {
        try {
            this.rs = this.stmt.executeQuery(Query);
            return true;
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }                
    }             
    
    public ResultSet getResultSet() {
        return rs;
    }       
          
}


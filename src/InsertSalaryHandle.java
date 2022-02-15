import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertSalaryHandle {
    String [] a;
    String SQL;
    public InsertSalaryHandle() {
        try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception e) {
            System.out.print(e);}
    }

    public void setArray(String [] a) {
        this.a =a;
    }

    public void setSql(String sql){ this.SQL=sql;}

    public int startInsert(){
        int m=0;
        Connection con;
        PreparedStatement sql;

        try { String uri="jdbc:sqlserver://127.0.0.1:1433;databaseName=课程设计192-18-刘明;user=liuming;password=521521";
            con= DriverManager.getConnection(uri);
            sql=con.prepareStatement(SQL);
            sql.setString(1,a[0].trim());
            sql.setString(2,a[1].trim());
            sql.setString(3,a[2].trim());
            //sql.setString(4,((Float.valueOf(a[1])+Float.valueOf(a[2]))+"").trim());
            sql.setString(4,null);
            sql.setString(5,a[3].trim());
            m=sql.executeUpdate();
            con.close();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog(null,"插入失败"+exp,"提示", JOptionPane.WARNING_MESSAGE);
        }
        return m;
    }
}

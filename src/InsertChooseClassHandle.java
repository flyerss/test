import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertChooseClassHandle {
    String [] a;
    String SQL;
    public InsertChooseClassHandle() {
        try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception e) {
            System.out.print(e);}
    }

    public void setArray(String [] a) {
        this.a =a;
    }

    public void setSql(String sql){ this.SQL=sql;}

    public int startInsert()throws SQLException{
        int m=0;
        Connection con;
        PreparedStatement sql;
        String uri="jdbc:sqlserver://127.0.0.1:1433;databaseName=课程设计192-18-刘明;user=liuming;password=521521";
        con= DriverManager.getConnection(uri);
        sql=con.prepareStatement(SQL);
        sql.setString(1,a[0].trim());
        sql.setString(2,a[1].trim());
        sql.setString(3,a[2].trim());
        sql.setString(4,a[3].trim());
        sql.setString(5,a[4].trim());
        sql.setString(6,a[5].trim());
        m=sql.executeUpdate();
        con.close();
        return m;
    }

}

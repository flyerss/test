import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommonTool {
    String SQL;
    public CommonTool() {
        try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception e) {
            System.out.print(e);}
    }

    public void setSql(String sql){ this.SQL=sql;}
    public int start(){
        int m=0;
        Connection con;
        PreparedStatement sql;
        try { String uri="jdbc:sqlserver://127.0.0.1:1433;databaseName=课程设计192-18-刘明;user=liuming;password=521521";
            con= DriverManager.getConnection(uri);
            sql=con.prepareStatement(SQL);
            m=sql.executeUpdate();
            con.close();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog
                    (null,"操作失败"+exp,"提示", JOptionPane.WARNING_MESSAGE);
        }
        return m;
    }
}

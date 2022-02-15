import java.sql.*;   
public class PreQuery {
    String SQL;        		//SQL语句
    String [] columnName;  
    String [][] record;    
    public PreQuery() {
      try{  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      }
    catch(Exception e) {
        System.out.print(e);
      }
    }

    public void setSQL(String SQL) {
        this.SQL=SQL.trim();
     }

     public String[] getColumnName() {
         return columnName;
    }

    public String[][] getRecord() {
         return record;
    }

    public void startQuery() {
        Connection con;
        PreparedStatement sql; 
        ResultSet rs;
        try { 
        String uri="jdbc:sqlserver://127.0.0.1:1433;databaseName=课程设计192-18-刘明;user=liuming;password=521521";
        con=DriverManager.getConnection(uri);
        sql=con.prepareStatement(SQL,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        rs=sql.executeQuery();         
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        columnName=new String[columnCount]; 
        for(int i=1;i<=columnCount;i++){
            columnName[i-1]=metaData.getColumnName(i);
        } 
        rs.last(); 
        int recordAmount =rs.getRow();//结果集中的记录
        record = new String[recordAmount][columnCount];
        int i=0;
        rs.beforeFirst();
        while(rs.next()) { 
            for(int j=1;j<=columnCount;j++){
                record[i][j-1]=rs.getString(j)!=null?rs.getString(j).trim():rs.getString(j);
            }
            i++;
        }
        con.close();
    }
        catch(SQLException e) {
        System.out.println("请输入正确的SQL语句"+e);
        }
    } 
}


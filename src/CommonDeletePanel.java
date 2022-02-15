import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommonDeletePanel extends JPanel{
    JTable table;
    String [] head ;
    String [][] a ;
    String TableName;
    String PrimaryKey;
    String PrimaryKey_two;
    JButton QueryAll;
    JTextField PR_TWO;

    public  void init_table(){
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(20);
    }

    public void init_button(JButton button){
        button.setFont(new Font("宋体",Font.BOLD,16));
    }

    CommonDeletePanel(String TableName,String PrimaryKey,String PrimaryKey_two) {
        this.TableName=TableName;
        this.PrimaryKey=PrimaryKey;
        this.PrimaryKey_two=PrimaryKey_two;
        setLayout(null);
        JScrollPane js=new JScrollPane();
        js.setBounds(0,0,1000,2000);
        add(js);
        QueryAll = new JButton("查询全部信息");
        init_button(QueryAll);
        QueryAll.setBounds(1012,10,200,50);
        add(QueryAll);
        QueryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from "+TableName);
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });
        JTextField PR = new JTextField();
        PR.setFont(new Font("宋体",Font.BOLD,16));
        PR.setBounds(1012,70,200,50);
        add(PR);

        if(PrimaryKey_two!=""){
            PR_TWO = new JTextField();
            PR_TWO.setFont(new Font("宋体",Font.BOLD,16));
            PR_TWO.setBounds(1012,120,200,50);
            add(PR_TWO);
        }

        JButton delete = new JButton("删除此编号下的数据");
        init_button(delete);
        delete.setBounds(1222,70,200,50);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommonTool ct =new CommonTool();
                if(PrimaryKey_two==""){
                    ct.setSql("delete from "+TableName+" where "+PrimaryKey+"= '"+PR.getText().trim()+"'");
                }
                else {
                    ct.setSql("delete from "+TableName+" where "+PrimaryKey+"= '"+PR.getText().trim()+"' and "+PrimaryKey_two+"= '"+PR_TWO.getText().trim()+"'");

                }
                int m=ct.start();
                if(m>0) {
                    JOptionPane.showMessageDialog(null,"操作成功","提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });



    }
}

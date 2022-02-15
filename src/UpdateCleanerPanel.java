import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateCleanerPanel extends JPanel{
    JTable table;
    String []head ={"工作人员编号","名字","性别","年龄","电话号码"};
    String [][] a ={{"","","","",""}};
    JButton QueryButton;
    JButton UpdateButton;

    UpdateCleanerPanel() {
        setLayout(null);
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(40);
        QueryButton = new JButton("查询此人员");

        UpdateButton =new JButton("确认更改");

        JScrollPane js=new JScrollPane(table);
        js.setBounds(10,10,800,80);
        add(js);
        add(QueryButton);
        QueryButton.setBounds(900,30,200,50);
        QueryButton.setFont(new Font("宋体",Font.BOLD,16));
        QueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(a[0][0]=="") {
                    JOptionPane.showMessageDialog(null,"请输入编号","提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                PreQuery pre = new PreQuery();
                pre.setSQL("select * from cleaner_info where clnumber ="+"'"+a[0][0].trim()+"'");
                pre.startQuery();
                String temp[][];
                temp=pre.getRecord();
                if(temp.length==0){
                    for(int i=1;i<a[0].length;i++){a[0][i]="";}
                    JOptionPane.showMessageDialog(null,"无此清洁人员","提示", JOptionPane.WARNING_MESSAGE);
                    table =new JTable(a,head);
                    table.setFont(new Font("宋体",Font.BOLD,16));
                    table.setRowHeight(40);
                    js.setViewportView(table);
                    return;
                }
                a=temp;
                table=new JTable(a,head);
                table.setFont(new Font("宋体",Font.BOLD,16));
                table.setRowHeight(40);
                js.setViewportView(table);
            }
        });
        add(UpdateButton);
        UpdateButton.setBounds(1172,30,200,50);
        UpdateButton.setFont(new Font("宋体",Font.BOLD,16));
        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertCleanerHandle handle = new InsertCleanerHandle();
                handle.setSql("update cleaner_info set clnumber=?,clname=?,gender=?,age=?,phonenumber=? where clnumber='"+a[0][0].trim()+"'");
                handle.setArray(a[0]);
                int m =handle.startInsert();
                if(m>0) {
                    JOptionPane.showMessageDialog(null,"修改成功","提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}

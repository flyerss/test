import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateChooseClassPanel extends JPanel {
    JTable table;
    String []head ={"学生编号","开设课编号","选课前成绩","选课后成绩","支付日期","支付金额"};
    String [][] a ={{"","","","","",""}};
    JButton QueryButton;
    JButton UpdateButton;

    UpdateChooseClassPanel() {
        setLayout(null);
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(40);
        QueryButton = new JButton("查询此选课信息");

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
                if(a[0][0]==""||a[0][1]=="") {
                    JOptionPane.showMessageDialog(null,"请输入学生编号和开设课编号","提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                PreQuery pre = new PreQuery();
                pre.setSQL("select * from [dbo].[choose_class_info] where Snumber ="+"'"+a[0][0].trim()+"' and S_number= '"+a[0][1]+"'");
                pre.startQuery();
                String temp[][];
                temp=pre.getRecord();
                if(temp.length==0){
                    for(int i=2;i<a[0].length;i++){a[0][i]="";}
                    JOptionPane.showMessageDialog(null,"无此选课信息","提示", JOptionPane.WARNING_MESSAGE);
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
                InsertChooseClassHandle handle = new InsertChooseClassHandle();
                handle.setSql("update [dbo].[choose_class_info] set Snumber=?,S_number=?,grade_before=?,grade_after=?,pay_date=?,pay_amount=? where Snumber ="+"'"+a[0][0].trim()+"' and S_number= '"+a[0][1]+"'");
                handle.setArray(a[0]);
                int m=0;
                try{
                m =handle.startInsert();
                }
                catch(SQLException EE){JOptionPane.showMessageDialog(null,"修改选课信息失败"+EE,"提示", JOptionPane.WARNING_MESSAGE);}
                if(m>0) {
                    JOptionPane.showMessageDialog(null,"修改选课信息成功","提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}


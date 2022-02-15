import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertSalaryPanel extends JPanel{
    JTable table;
    String []head ={"员工编号","基本工资","奖金","开资日期"};
    String [][] a ={{" "," "," "," "}};
    JButton button;

    InsertSalaryPanel() {
        setLayout(null);
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(40);
        button = new JButton("插入记录");
        JScrollPane js=new JScrollPane(table);
        add(js);
        add(button);
        js.setBounds(10,10,1000,80);
        button.setBounds(1012,30,120,30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertSalaryHandle handle =new InsertSalaryHandle();
                if(a[0][0]==" ") {
                    JOptionPane.showMessageDialog(null,"请输入数据","提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                handle.setArray(a[0]);
                handle.setSql("INSERT INTO [dbo].[salary_info] VALUES(?,?,?,?,?)");
                int show=handle.startInsert();
                if(show>0) {
                    JOptionPane.showMessageDialog(null,"插入成功","提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}

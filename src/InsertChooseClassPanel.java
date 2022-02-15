import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class InsertChooseClassPanel extends JPanel{
    JTable table;
    String []head ={"学生学号(S开头)","已开设课程的课程号（SC）","选课前的成绩","选课后的成绩","付款日期","付款金额"};
    String [][] a ={{" "," "," "," "," "," "}};
    JButton button;

    InsertChooseClassPanel() {
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
                InsertChooseClassHandle handle =new InsertChooseClassHandle();
                if(a[0][0]==" ") {
                    JOptionPane.showMessageDialog(null,"请输入数据","提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                handle.setSql("INSERT INTO choose_class_info VALUES(?,?,?,?,?,?)");
                handle.setArray(a[0]);
                int show=0;
                try{
                    show=handle.startInsert();
                }
                catch(SQLException EE){JOptionPane.showMessageDialog(null,"课容量不足或年级不符合","提示", JOptionPane.WARNING_MESSAGE);
                }
                if(show>0) {
                    JOptionPane.showMessageDialog(null,"插入成功","提示", JOptionPane.WARNING_MESSAGE);

                }
            }
        });

    }

}

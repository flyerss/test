import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateClassRoomPanel extends JPanel{
    JTable table;
    String []head ={"教室号","教师详细地址","负责清理的员工编号","容量","上次消毒日期"};
    String [][] a ={{"","","","",""}};
    JButton QueryButton;
    JButton UpdateButton;

    UpdateClassRoomPanel() {
        setLayout(null);
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(40);
        QueryButton = new JButton("查询此教室");

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
                    JOptionPane.showMessageDialog(null,"请输入教室号","提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                PreQuery pre = new PreQuery();
                pre.setSQL("select * from classroom_info where Rnumber ="+"'"+a[0][0].trim()+"'");
                pre.startQuery();
                String temp[][];
                temp=pre.getRecord();
                if(temp.length==0){
                    for(int i=1;i<a[0].length;i++){a[0][i]="";}
                    JOptionPane.showMessageDialog(null,"无此教室","提示", JOptionPane.WARNING_MESSAGE);
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
                InsertClassRoomHandle handle = new InsertClassRoomHandle();
                handle.setSql("update classroom_info set Rnumber=?,roomaddress=?,clnumber=?,positionnum=?,last_disinfection_date=? where Rnumber='"+a[0][0].trim()+"'");
                handle.setArray(a[0]);
                int m =handle.startInsert();
                if(m>0) {
                    JOptionPane.showMessageDialog(null,"修改教室信息成功","提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}

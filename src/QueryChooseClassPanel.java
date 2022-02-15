import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryChooseClassPanel extends JPanel{
    JTable table;
    JTextField setClassNumber;
    JButton QueryAll;
    JButton QueryFromView;
    JButton QueryStudentView;
    JButton QueryRefund;
    String [] head ;
    String [][] a ;

    public  void init_table(){
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(20);
    }

    public void init_button(JButton button){
        button.setFont(new Font("宋体",Font.BOLD,16));
    }

    QueryChooseClassPanel() {

        setLayout(null);


        JScrollPane js=new JScrollPane();
        js.setBounds(0,0,1000,2000);
        add(js);

        QueryAll = new JButton("查询全部选课信息");
        init_button(QueryAll);
        add(QueryAll);
        QueryAll.setBounds(1012,10,200,50);
        QueryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[choose_class_info]");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
             }
        });

        QueryFromView=new JButton("查看选课情况");
        init_button(QueryFromView);
        add(QueryFromView);
        QueryFromView.setBounds(1222,10,200,50);
        QueryFromView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[EACH_SET_CLASS_PEOPLE_NUM]");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });

        QueryStudentView=new JButton("查看学生选课情况");
        init_button(QueryStudentView);
        add(QueryStudentView);
        QueryStudentView.setBounds(1012,70,200,50);
        QueryStudentView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[EACH_STUDENT_CHOSEN_INFO]");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });

        setClassNumber =new JTextField(10);
        add(setClassNumber);
        setClassNumber.setBounds(1012,130,200,50);
        QueryRefund=new JButton("查看需要退费情况");
        init_button(QueryRefund);
        add(QueryRefund);
        QueryRefund.setBounds(1222,130,200,50);
        QueryRefund.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[CLASS_REFUND_INFO]('"+setClassNumber.getText().trim()+"')");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryClassRoomPanel extends JPanel{
    JTable table;
    String [] head ;
    String [][] a ;
    JButton QueryAll;
    JButton QueryLastCleanDate;

    public  void init_table(){
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(20);
    }
    public void init_button(JButton button){
        button.setFont(new Font("宋体",Font.BOLD,16));
    }

    QueryClassRoomPanel() {

        setLayout(null);
        JScrollPane js=new JScrollPane();
        add(js);
        js.setBounds(0,0,1000,2000);

        QueryAll = new JButton("查看全部教室信息");
        init_button(QueryAll);
        add(QueryAll);
        QueryAll.setBounds(1012,10,200,50);
        QueryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[classroom_info]");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });

        QueryLastCleanDate = new JButton("查看最近消毒日期");
        init_button(QueryLastCleanDate);
        add(QueryLastCleanDate);
        QueryLastCleanDate.setBounds(1222,10,200,50);
        QueryLastCleanDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from [dbo].[LAST_CLEANDATE_EACH_CLASSROOM]");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });

    }
}


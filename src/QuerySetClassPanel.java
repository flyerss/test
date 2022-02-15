import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuerySetClassPanel extends JPanel{
    JTable table;
    String [] head ;
    String [][] a ;
    JButton QueryAll;

    public  void init_table(){
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(20);
    }
    public void init_button(JButton button){
        button.setFont(new Font("宋体",Font.BOLD,16));
    }

    QuerySetClassPanel() {

        setLayout(null);

        JScrollPane js=new JScrollPane();
        add(js);
        js.setBounds(0,0,1000,2000);

        QueryAll = new JButton("查看开设课信息表");
        init_button(QueryAll);
        add(QueryAll);
        QueryAll.setBounds(1012,10,200,50);

        QueryAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreQuery query =new PreQuery();
                query.setSQL("select * from DETAIL_SET_CLASS_INFO");
                query.startQuery();
                a =query.getRecord();
                head=query.getColumnName();
                init_table();
                js.setViewportView(table);
            }
        });

    }
}


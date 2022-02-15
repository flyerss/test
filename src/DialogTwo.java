import java.awt.*;
import javax.swing.*;
public class DialogTwo extends JDialog {
   JTable table;
   String ziduan[];
   String record[][];
   DialogTwo() {
      setTitle("显示记录");
      setBounds(105,140,900,200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   public void setZiduan(String []ziduan){
      this.ziduan=ziduan;
   }
   public void setRecord(String [][]record){
      this.record=record;
   }
   public void init() {
       table = new JTable(record,ziduan);
       add(new JScrollPane(table));
   }
} 
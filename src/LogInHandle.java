import java.awt.event.*;
import javax.swing.*;

public class LogInHandle implements ActionListener{
    PreQuery query;  
    LogInPanel view;
    String name;
    String passWord;

    LogInHandle() {
    query=new PreQuery();
    }	

    public void setView(LogInPanel view){
        this.view  = view;
    }

    public void actionPerformed(ActionEvent e){

       if(e.getSource()==view.handIn){
            name=view.userName.getText().trim();
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "请输入用户名!");
                return; 
            }
            if(!doLookName()){
                JOptionPane.showMessageDialog(null, "用户名不存在!"); 
                return;
            }
            passWord = String.valueOf(view.password.getPassword());
            if(passWord.equals("")){
                JOptionPane.showMessageDialog(null, "请输入密码!"); 
                return;
            } 
            if(!doLookPassword()){
                JOptionPane.showMessageDialog(null, "密码错误请重新输入密码!"); 
                view.password.setText("");
                return;
            } 
            else{
                view.dispose();
                OptionPane op =new OptionPane();


            }
         }	
         if(e.getSource()==view.register) {
            view.dispose();
            RegisterPanel registerPanel =new RegisterPanel();
         }    
         if(e.getSource()==view.forgetPassword){
             name=view.userName.getText().trim();
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null, "请在框中输入用户名后查询!");
                 return; 
              } 
              if(!doLookName()){
                  JOptionPane.showMessageDialog(null, "用户名不存在!"); 
                  return;
            }

            query.setSQL("select * from register_info where users='"+name+"'");
            query.startQuery();
            String [][]record =query.getRecord();
            String ziduan[]=query.getColumnName();
            DialogOne dialog = new DialogOne(); 
            dialog.setZiduan(ziduan);
            dialog.setRecord(record);
            dialog.init(); 
            dialog.setVisible(true);
        }
    }
       
    
    private boolean doLookPassword(){

        query.setSQL("select * from register_info where users='"+name+"'");
        query.startQuery();
        String [][]record =query.getRecord(); 
        if(record.length == 0) return false;
        String realPassword =record[0][1].trim();
        if(passWord.equals(realPassword)) return true;
        return false;
        }
        
    private boolean doLookName(){

        query.setSQL("select * from register_info where users='"+name+"'");
        query.startQuery();
        String [][]record =query.getRecord(); 
        if(record.length == 0) return false;
        String realName =record[0][0].trim();
        if(name.equals(realName)) return true;
        return false;
    }
}

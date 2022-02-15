import java.awt.event.*;
import javax.swing.*;

public class RegisterHandle implements ActionListener{
    PreQuery query;  
    InsertRegisterHandle insertRegisters;
    RegisterPanel view;
    int m;
    String name;
    String passWord;
    String passWordAgain;
    RegisterHandle() {
    query=new PreQuery();
    insertRegisters =new InsertRegisterHandle();
    }	
    public void setView(RegisterPanel view){
        this.view  = view;
    }
    public void actionPerformed(ActionEvent e){
       name=view.userName.getText().trim();
       passWord = String.valueOf(view.password.getPassword());
       passWordAgain = String.valueOf(view.passwordAgain.getPassword());
       if(e.getSource()==view.register){
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "请输入用户名!");
                return; 
            }
            else if(doLookName()){
                JOptionPane.showMessageDialog(null, "用户名已存在!"); 
                return;
            }
            else if(passWord.equals("")){
                JOptionPane.showMessageDialog(null, "请输入密码!"); 
            return;
            } 
            else if(passWordAgain.equals("")){
                JOptionPane.showMessageDialog(null, "请确认密码密码!"); 
                 return;
            } 
            else if(!passWord.equals(passWordAgain)){
                JOptionPane.showMessageDialog(null, "两次密码不相同!"); 
                 return;
            }
            String [] a={name,passWord};
            insertRegisters.setArray(a);
            insertRegisters.setSql("INSERT INTO register_info VALUES(?,?)");
            m= insertRegisters.startInsert();
            if(m>0)JOptionPane.showMessageDialog(null, "注册成功！"); 
            else JOptionPane.showMessageDialog(null, "注册失败!"); 
       }
        if(e.getSource()==view.returnHandIn){

            view.dispose();
            LogInPanel login=new LogInPanel();
        }
        if(e.getSource()==view.checkPeople){

            query.setSQL("select * from register_info");
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
import javax.swing.*;
public class LogInPanel extends JFrame{
    JLayeredPane pane;
    JPanel bottomPanel;
    JLabel bottomLabel, tipsUser, tipsPassword;
    JTextField userName;
    JPasswordField  password;
    JButton handIn,register, forgetPassword;
    ImageIcon image;
    LogInHandle handle;

    public LogInPanel() {
        this.setTitle("欢迎使用，请登录！");
        pane = new JLayeredPane();

        image = new ImageIcon("src//1.jpg");
        bottomLabel = new JLabel(image);
        bottomPanel = (JPanel)this.getContentPane();
        bottomPanel.add(bottomLabel);
        bottomPanel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

        userName = new JTextField(15);
        password=new JPasswordField(15);
        tipsUser = new JLabel("用户名：");
        tipsPassword = new JLabel("密码：");
        handIn = new JButton("登陆");
        register = new JButton("注册");
        forgetPassword = new JButton("忘记密码");

        pane.add(tipsUser,JLayeredPane.MODAL_LAYER);
        tipsUser.setBounds(195, 110, 150, 40);
        pane.add(userName,JLayeredPane.MODAL_LAYER);
        userName.setBounds(250, 110, 200,40);
        pane.add(tipsPassword,JLayeredPane.MODAL_LAYER);
        tipsPassword.setBounds(200, 155, 150, 40);
        pane.add(password,JLayeredPane.MODAL_LAYER);
        password.setBounds(250,155, 200, 40);
        pane.add(handIn, JLayeredPane.MODAL_LAYER);
        handIn.setBounds(250, 200, 100, 40);
        pane.add(register,JLayeredPane.MODAL_LAYER);
        register.setBounds(350, 200, 100, 40);
        pane.add(forgetPassword,JLayeredPane.MODAL_LAYER);
        forgetPassword.setBounds(250, 245, 205, 20);
        pane.add(bottomPanel,JLayeredPane.DEFAULT_LAYER);
        this.setLayeredPane(pane);
        this.setBounds(600, 300,image.getIconWidth(),image.getIconHeight());
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
        validate();
	    handle = new LogInHandle();
	    handIn.addActionListener(handle);
        register.addActionListener(handle) ;
        forgetPassword.addActionListener(handle) ;
        handle.setView(this);
        }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch(Exception ee){
            ee.printStackTrace();
        }
        LogInPanel log =new LogInPanel();
    }

}








import java.awt.*;
import javax.swing.*;
public class OptionPane extends JFrame{
    JTabbedPane underLayer;        //第一层窗格
    JTabbedPane student_info_layer;
    JTabbedPane teacher_info_layer;
    JTabbedPane cleaner_info_layer;
    JTabbedPane classRoom_info_layer;
    JTabbedPane class_info_layer;
    JTabbedPane setClass_info_layer;
    JTabbedPane ChooseClass_info_layer;
    JTabbedPane Salary_info_layer;

    public OptionPane(){
        setTitle("课外培训机构信息管理系统");
        setBounds(100,20,1650,1000);
        setVisible(true);
        underLayer =new JTabbedPane();
        underLayer.setFont(new Font("宋体",Font.BOLD,16));
        student_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        student_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        teacher_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        teacher_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        cleaner_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        cleaner_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        classRoom_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        classRoom_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        class_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        class_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        setClass_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        setClass_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        ChooseClass_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        ChooseClass_info_layer.setFont(new Font("宋体",Font.BOLD,16));
        Salary_info_layer = new JTabbedPane(JTabbedPane.LEFT);
        Salary_info_layer.setFont(new Font("宋体",Font.BOLD,16));

        student_info_layer.add("查询学生信息",new QueryStudentPanel());
        student_info_layer.add("增加学生信息",new InsertStudentPanel());
        student_info_layer.add("删除学生信息",new CommonDeletePanel("[dbo].[student_info]","Snumber",""));
        student_info_layer.add("更改学生信息",new UpdateStudentPanel());

        teacher_info_layer.add("查询教师信息",new QueryTeacherPanel());
        teacher_info_layer.add("增加教师信息",new InsertTeacherPanel());
        teacher_info_layer.add("删除教师信息",new CommonDeletePanel("[dbo].[teacher_info]","Tnumber",""));
        teacher_info_layer.add("更改教师信息",new UpdateTeacherPanel());

        cleaner_info_layer.add("查询员工信息",new QueryCleanerPanel());
        cleaner_info_layer.add("增加员工信息",new InsertCleanerPanel());
        cleaner_info_layer.add("删除员工信息",new CommonDeletePanel("[dbo].[cleaner_info]","clnumber",""));
        cleaner_info_layer.add("更改员工信息",new UpdateCleanerPanel());

        classRoom_info_layer.add("查询教室信息",new QueryClassRoomPanel());
        classRoom_info_layer.add("增加教室信息",new InsertClassRoomPanel());
        classRoom_info_layer.add("删除教室信息",new CommonDeletePanel("[dbo].[classroom_info]","Rnumber",""));
        classRoom_info_layer.add("更改教室信息",new UpdateClassRoomPanel());

        class_info_layer.add("查询课程信息",new QueryClassPanel());
        class_info_layer.add("增加课程信息",new InsertClassPanel());
        class_info_layer.add("删除课程信息",new CommonDeletePanel("[dbo].[class_info]","Cnumber",""));
        class_info_layer.add("更改课程信息",new UpdateClassPanel());

        setClass_info_layer.add("查询开设课程信息",new QuerySetClassPanel());
        setClass_info_layer.add("增加开设课程信息",new InsertSetClassPanel());
        setClass_info_layer.add("删除开设课程信息",new CommonDeletePanel("[dbo].[set_class_info]","S_number",""));
        setClass_info_layer.add("更改开设课程信息",new UpdateSetClassPanel());

        ChooseClass_info_layer.add("查询选课信息",new QueryChooseClassPanel());
        ChooseClass_info_layer.add("添加选课信息",new InsertChooseClassPanel());
        ChooseClass_info_layer.add("删除选课信息",new CommonDeletePanel("[dbo].[choose_class_info]","Snumber","S_number"));
        ChooseClass_info_layer.add("更改选课信息",new UpdateChooseClassPanel());

        Salary_info_layer.add("查看工资情况",new QuerySalaryPanel());
        Salary_info_layer.add("录入工资情况",new InsertSalaryPanel());
        Salary_info_layer.add("删除工资信息",new CommonDeletePanel("salary_info","workernumber","paydate"));

        underLayer.add("学生信息管理",student_info_layer);
        underLayer.add("教师信息管理",teacher_info_layer);
        underLayer.add("清洁工作人员信息管理",cleaner_info_layer);
        underLayer.add("教室信息管理",classRoom_info_layer);
        underLayer.add("课程信息管理",class_info_layer);
        underLayer.add("开设课程管理",setClass_info_layer);
        underLayer.add("课程选修管理",ChooseClass_info_layer);
        underLayer.add("工资管理",Salary_info_layer);

        add(underLayer,BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
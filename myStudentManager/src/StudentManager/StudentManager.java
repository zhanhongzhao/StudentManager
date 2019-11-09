package StudentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            //用输出语句完成主界面的编写
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择：");

            //用Scanner实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            //用switch语句完成操作的选择
            switch (line) {
                case "1":
//                    System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
//                    System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
//                    System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    System.exit(0);
//                    break;

            }
        }
    }
    //添加学生
    public static void addStudent(ArrayList<Student> array) {
        //键盘输入学生对象所需要的数据
        String sid;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入学生学号");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("该学号已经被使用，请重新输入");
            }else {
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地");
        String address = sc.nextLine();

        //创建学生对象，把键盘录入的数据值赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //将学生对象添加到集合中
        array.add(s);

        //给出添加成绩提示
        System.out.println("添加学生成功");

    }
    //查找学生
    public static void findAllStudent(ArrayList<Student> array) {
        //判断集合中是否有信息
        if (array.size()==0) {
            System.out.println("无信息，请先添加信息再查询");
            //为了程序不再往下执行，给出return
            return;
        }

        System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
        for (int i=0;i<array.size();i++) {
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t\t"+s.getAddress());
        }
    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> array) {
        //输入要删除学生学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要删除学生的学号");
        String sid = sc.nextLine();
        //遍历查找要删除学生学号
        int index =-1;
        for(int i = 0;i<array.size();i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("该信息不存在，请重新输入");
        }else {
            array.remove(index);
            System.out.println("删除学生成功！");
        }
    }
    //修改学生
    public static void updateStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号：");
        String sid = sc.nextLine();

        //键盘录入要修改学生的信息
        System.out.println("请输入学生新名字");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //遍历集合，修改对应的学生信息
        for (int i=0;i<array.size();i++) {
            Student student = array.get(i);
            if (student.getSid().equals(sid)) {
                array.set(i,s);
                System.out.println("修改成功!");
            }
        }
    }
    //判断学号是否被使用
    public static boolean isUsed(ArrayList<Student> array,String sid) {
        boolean flag = false;
            for (int i=0;i<array.size();i++) {
                Student s = array.get(i);
                if (s.getSid().equals(sid)) {
                    flag = true;
                    break;
                }
            }
        return flag;
    }
}

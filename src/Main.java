import Model.myClass;
import Model.order;
import Msg.Msginfo;
import Util.DaoTool;
import Util.OperateExcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new DaoTool();
        while (true){
            Msginfo.ShowMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你选择的序号:");
            int i = scanner.nextInt();
            if (i==1){
                System.out.println("请输入消费类型");
                String Type = scanner.next();
                System.out.println("请输入消费金额");
                String money = scanner.next();
                DaoTool.AddData(Type,money);
                System.out.println("添加成功");
            }else if (i==2){
                List<order> orders  = DaoTool.GetAllOrder();
                System.out.println("=====订单列表=====\n");
                System.out.println("Id--消费类型--消费金额--记录时间\n");
                for (order o:orders){
                    System.out.println(o.getId()+"--"+o.getType()+"--"+o.getMoney()+"--"+o.getDate());
                }
            }else if (i==3){
                List<order> orders  = DaoTool.GetAllOrder();
                OperateExcel.writeExcel(orders);
            }else if (i==4){
                System.exit(0);
            }else if (i==5){
                System.out.println("请输入你要添加的课程数量");
                i = scanner.nextInt();
                List<myClass> myClasses = new ArrayList<>();
                for (int a=0;a<i;a++){
                        System.out.println("请输入课程名字和上课周数信息");
                        String ClassName = scanner.next();
                        System.out.println("请输入星期1-星期7课天");
                        int Startline = scanner.nextInt();
                        System.out.println("请输入上午课程还是下午课程上午为1或2 下午为3或4");
                        int dayline =scanner.nextInt();
                        myClasses.add(new myClass(ClassName,Startline,dayline));
                        System.out.println("成功录入"+myClasses.size()+"条数据");


                }
                OperateExcel.AddClass(myClasses);
            }
        }
    }
}

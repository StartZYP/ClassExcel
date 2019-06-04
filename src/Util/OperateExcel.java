package Util;

import Model.myClass;
import Model.order;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class OperateExcel {
    public static void writeExcel(List<order> list){
        //开始写入excel,创建模型文件头
        String[] titleA = {"id", "类型", "开销","日期"};
        //创建Excel文件，B库CD表文件
        File fileA = new File("./TestFile.xls");
        if (fileA.exists()) {
            //如果文件存在就删除
            fileA.delete();
        }
        try {
            fileA.createNewFile();
            //创建工作簿
            WritableWorkbook workbookA = Workbook.createWorkbook(fileA);
            //创建sheet
            WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
            Label labelA = null;
            //设置列名
            for (int i = 0; i < titleA.length; i++) {
                labelA = new Label(i, 0, titleA[i]);
                sheetA.addCell(labelA);
            }
            //获取数据源

            for (int i = 1; i <= list.size(); i++) {
                order order = list.get(i - 1);
                labelA = new Label(0, i, String.valueOf(order.getId()));
                sheetA.addCell(labelA);
                labelA = new Label(1, i, order.getType());
                sheetA.addCell(labelA);
                labelA = new Label(2, i, order.getMoney());
                sheetA.addCell(labelA);
                labelA = new Label(3, i, order.getDate());
                sheetA.addCell(labelA);
            }
            workbookA.write();    //写入数据
            workbookA.close();  //关闭连接
            System.out.println("成功写入文件，请前往查看文件！");

        } catch (Exception e) {
            System.out.println("文件写入失败，报异常...");
        }
    }
    public static void AddClass(List<myClass> listdata){
        List<String> day = new ArrayList<>();
        List<String> morning = new ArrayList<>();
        List<String> afternoon = new ArrayList<>();
        try{
            Class<?> classTable = Class.forName("Model.ClassTable");
            Field[] field02 = classTable.getDeclaredFields();
            for (Field f:field02){
                System.out.println(f.getName());
                if (f.getName().contains("day")){
                    day.add(f.getName());
                }else if (f.getName().contains("afternoon")){
                    afternoon.add(f.getName());
                }else if (f.getName().contains("morning")){
                    morning.add(f.getName());
                }
            }

        }catch (Exception e){

        }

        File fileA = new File("./ClassFile.xls");
        if (fileA.exists()) {
            //如果文件存在就删除
            fileA.delete();
        }
        try {
            fileA.createNewFile();
            //创建工作簿
            WritableWorkbook workbookA = Workbook.createWorkbook(fileA);
            //创建sheet
            WritableSheet sheetA = workbookA.createSheet("sheet1", 0);
            Label labelA = null;
            //设置列名
            for (int i = 1; i <= day.size(); i++) {
                labelA = new Label(i, 0, day.get(i-1));
                sheetA.addCell(labelA);
            }
            //获取数据源

            for (int a=1;a<=morning.size();a++){
                labelA = new Label(0,a,morning.get(a-1));
                sheetA.addCell(labelA);
            }

            labelA = new Label(0,3,afternoon.get(0));
            sheetA.addCell(labelA);
            labelA = new Label(0,4,afternoon.get(1));
            sheetA.addCell(labelA);


            for (int i = 1; i <= listdata.size(); i++) {
                myClass myClass = listdata.get(i - 1);
                labelA = new Label(myClass.getStartDay(), myClass.getDayline(), myClass.getClassName());
                sheetA.addCell(labelA);
            }
            workbookA.write();    //写入数据
            workbookA.close();  //关闭连接
            System.out.println("成功写入文件，请前往查看文件！");

        } catch (Exception e) {
            System.out.println("文件写入失败，报异常...");
        }

    }

}

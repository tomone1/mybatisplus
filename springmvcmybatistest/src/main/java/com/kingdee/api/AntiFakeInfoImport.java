package com.kingdee.api;

import com.diamond.model.dto.KingdeeAntiFakeInfo;
import com.diamond.model.dto.KingdeeProduct;
import com.diamond.services.KingdeeAntiFakeInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author tom
 * @Date 2018-06-12 11:47
 */
@Service
public class AntiFakeInfoImport {
  private static final String path = "E:\\data\\森田\\";
  @Autowired
  private KingdeeAntiFakeInfoServices kingdeeAntiFakeInfoServices;
  public  void  loadFile(){
    List<File> list=getFile();
    if(list.size()>0){
      for (int i = 0; i <list.size() ; i++) {

        readTxtFile(path+list.get(i).getName());
      }
    }
  }
  public  void readTxtFile(String filePath) {

    try {
      String encoding = "GBK";
      File file = new File(filePath);
      if (file.isFile() && file.exists()){ //判断文件是否存在
        InputStreamReader read = new InputStreamReader(
            new FileInputStream(file), encoding);//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int i=0;
        int j=0;
        List list=new ArrayList();
        while ((lineTxt = bufferedReader.readLine()) != null) {
          i++;
          j++;
          KingdeeAntiFakeInfo antiFakeInfo=new KingdeeAntiFakeInfo();
          antiFakeInfo.setDto(lineTxt,i);
          list.add(antiFakeInfo);
          if(j==1000){
            kingdeeAntiFakeInfoServices.save(list);
            kingdeeAntiFakeInfoServices.distinctAntiFakeInfo();
            kingdeeAntiFakeInfoServices.moveAntiFakeInfo();
            list=new ArrayList();
            j=0;
          }
        }
        if(j>0){
          kingdeeAntiFakeInfoServices.save(list);
          kingdeeAntiFakeInfoServices.distinctAntiFakeInfo();
          kingdeeAntiFakeInfoServices.moveAntiFakeInfo();
        }
        read.close();
      } else {
        System.out.println("找不到指定的文件");
      }
    } catch (Exception e) {
      System.out.println("读取文件内容出错");
      e.printStackTrace();
    }
  }

  public List<File> getFile(){
    File file = new File(path);//File类型可以是文件也可以是文件夹
    File[] fileList = file.listFiles();//将该目录下的所有文件放置在一个File类型的数组中
    List<File> wjList = new ArrayList<>();//新建一个文件集合
    for (int i = 0; i < fileList.length; i++) {
      if (fileList[i].isFile()) {//判断是否为文件
        String name=fileList[i].getName();
        if(name.startsWith("CRM_")&& name.endsWith(".txt")){
          wjList.add(fileList[i]);
          System.out.println(fileList[i].getName());
        }

      }
    }
    return  wjList;
  }
}

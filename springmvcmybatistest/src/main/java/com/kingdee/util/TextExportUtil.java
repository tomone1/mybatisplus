package com.kingdee.util;

import com.diamond.model.dto.KingdeeAntiFakeInfo;
import com.kingdee.api.AntiFakeInfoImport;

import java.io.*;

/**
 * @Author tom
 * @Date 2018-06-12 13:38
 */

public class TextExportUtil {

  private static final String path = "E:\\data\\森田\\SKU_201709291553470.txt";

  public static void readTxtFile(String filePath,Object o) {

    try {
      String encoding = "GBK";
      File file = new File(filePath);
      if (file.isFile() && file.exists()){ //判断文件是否存在
        InputStreamReader read = new InputStreamReader(
            new FileInputStream(file), encoding);//考虑到编码格式
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        int i=0;
        while ((lineTxt = bufferedReader.readLine()) != null) {
          i++;
          KingdeeAntiFakeInfo antiFakeInfo=new KingdeeAntiFakeInfo();

          antiFakeInfo.setDto(lineTxt,i);
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

  public static void main(String[] args) throws Exception {
    AntiFakeInfoImport.readTxtFile(path);
  }

}

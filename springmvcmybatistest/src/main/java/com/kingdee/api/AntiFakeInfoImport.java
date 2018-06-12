package com.kingdee.api;

import com.diamond.model.dto.KingdeeAntiFakeInfo;
import com.diamond.model.dto.KingdeeProduct;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Author tom
 * @Date 2018-06-12 11:47
 */
@Service
public class AntiFakeInfoImport {
  private static final String path = "E:\\data\\森田\\SKU_201709291553470.txt";
  public static final String openFileStyle = "r";
  public static final String fieldLimitChar = ",";
  public static final int fieldAllCount = 9;
  private int count;
  public void loadFile() throws Exception{
    String path="";
    String openFileStyle = "r";
    String fieldLimitChar = ",";
    int fieldAllCount = 9;
    RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);
    String line_record = raf.readLine();
    while (line_record != null) {
      parseRecord(line_record);
      line_record = raf.readLine();
    }
    System.out.println("共有合法的记录" + count + "条");
  }
  private void parseRecord(String line_record) throws Exception {
    //拆分记录
    String[] fields = line_record.split(fieldLimitChar);
    if (fields.length == fieldAllCount) {
      count++;
    }
  }
  private String tranStr(String oldstr) {
    String newstr = "";
    try {
      newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return newstr;

  }
  public static void readTxtFile(String filePath) {

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

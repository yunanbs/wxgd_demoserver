package baosight;


import java.io.*;
import java.nio.MappedByteBuffer;
import java.util.Properties;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.nio.channels.FileChannel;

/**
 * Created by YuNan on 2016/9/8.
 */
public class utils {

    //读取Properties文件参数
    //name:参数名称
    //fileURL:配置文件地址
    public static String getpropertieval(String name,String fileURL){
        String result = "";//返回值
        Properties prop = new Properties();//初始化Properties对象

        try(InputStream in = utils.class.getResourceAsStream(fileURL))//获取文件流
        {
            prop.load(in);//加载配置文件流
            result =  prop.getProperty(name);//读取参数并返回
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();//显示异常
        }
        return result;
    }

    //base64字符串转byte[]
    public static byte[] base642byte(String sourcestr){
        byte[] result = null;
        BASE64Decoder decode = new BASE64Decoder();
        try
        {
            result = decode.decodeBuffer(sourcestr);
        }catch (Exception e){

        }
        return  result;
    }

    //byte[]转base64字符串
    public static  String byte2base64(byte[] sourcebyte){
        String result = "";
        BASE64Encoder encoder = new BASE64Encoder();
        try
        {
            result = encoder.encode(sourcebyte);
        }catch (Exception e){

        }
        return  result;
    }

    //文件转byte[]
    public static byte[] file2byte(String filepath){
        byte[] result = null;
        try(FileChannel fc = new RandomAccessFile(filepath, "r").getChannel()) {
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size()).load();
            result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static String byte2file(String filepath,String filename,byte[] sourcebyte) {
        String result = "";

        File file = null;
        String filefullname = filepath + "\\" + filename;//获取文件全名

        File dir = new File(filepath);
        if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
            dir.mkdirs();
        }

        file = new File(filefullname);

        try (
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            bos.write(sourcebyte);
            result = filefullname;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}



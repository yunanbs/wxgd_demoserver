package example;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.*;

import baosight.utils;
import userserver.ResponseMessage;


/**
 * Created by YuNan on 2016/9/8.
 */
public class HelloWorld {
  public String sayHelloWorldFrom(String from) {
    String result = "Hello, world, from " + from;
    System.out.println(result);
    return result;
  }

  public int add(int a,int b) {
    return  a+b;
  }

  public  String test(){
    try
    {

      String _dbname = utils.getpropertieval("s_dbname","dbconfig.properties");
      String _dbuser = utils.getpropertieval("s_dbuser","dbconfig.properties");
      String _dbpassword = utils.getpropertieval("s_dbpassword","dbconfig.properties");
      List<String> sqls = new ArrayList<String>();
      sqls.add("insert into demo values('3','saadfsd','123')");
      sqls.add("delete from demo where id<>'3'");
      JSONObject dbsource =  dbhelpser.Excutesql(_dbname,_dbuser,_dbpassword,null,sqls,null);

      return  dbsource.toString();
    }catch (Exception ex){
      return  "fail";
    }

  }

  public String getuser(){
    String result = "";
    try{
      userserver.GetDataImplServiceLocator server = new userserver.GetDataImplServiceLocator();
      userserver.IGetData client = server.getGetDataImplPort();
      userserver.User user = new userserver.User("","");
      userserver.Message msg = new userserver.Message(1,0,"01933","HRS");
      userserver.RequestMessage params = new userserver.RequestMessage(msg,"allPersonList",user,"Get");
      userserver.ResponseMessage cresult =client.getData(params);


    }catch (Exception ex){
      ex.toString();
    }

    return  result;
  }

  public String testex (String stype,String sop){
    String sourcefilename = "C:\\tmp\\1\\1.jpg";
    String desfilepath = "C:\\tmp\\2";
    String desfilename = "2.jpg";

    byte[] sb = utils.file2byte(sourcefilename);
    String base64str = utils.byte2base64(sb);
    byte[] nsb = utils.base642byte(base64str);
    String result = utils.byte2file(desfilepath,desfilename,nsb);
    return  result;
  }
}

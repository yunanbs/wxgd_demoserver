package baosight;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/11/18.
 */
public class huserverhelper {
    public static String getdbsql(String infotype, String smathname, String sDatastr,String sportname) {
        String result = "";
        //自定义服务名称
        String classname = "";
        String portname =sportname.equals("")?"getBasicDataImplPort":sportname;
        String mathname = smathname;

        switch (infotype)//定义反射对象的类名
        {
            case "sgdd":
                classname = "sgddbasedataserver.BasicDataImplServiceLocator";
                break;

            case "cwpd":
                classname = "";
                break;

            default:
                break;
        }

        if (classname == null || classname == "") {
            return result;//非指定类型 返回null
        }

        Object server = null;//服务对象
        Object client = null;//客户端对象
        Object tmpresult = null;//请求结果

        try {
            server = Class.forName(classname).newInstance();//创建服务对象
            client = server.getClass().getMethod(portname).invoke(server);//获取客户端对象

            tmpresult = client.getClass().getMethod(mathname, Class.forName("java.lang.String")).invoke(client, sDatastr);//调用请求

            result= tmpresult.toString();

        } catch (Exception e) {
            return null;
        }
        return result;
    }
}

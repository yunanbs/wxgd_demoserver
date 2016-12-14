package baosight;

import jobserver.*;
import jobserver.Message;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YuNan on 2016/9/22.
 */
public class remoteserverhelper {

    /*inibasedb()方法用于查询接口或者通知接口,传值后同步双方的库中的数据
	 * infotype:job,org,user
	 * syscode:请求的系统，具体编码参考统一编码表
	 * opertype:操作类型,0 增量（默认） 1 全量
	 * infocode:岗位,组织或人员的编码
	 * userId:用户ID,如果没有就为空
	 * orgId:组织机构ID,如果没有就为空
	 * */
    public static List<String> getdbsql(String infotype, String syscode, int opertype, String infocode, String userId, String orgId) {
        List<String> result = new ArrayList<String>();
        //自定义服务名称
        String classname = "";
        //对方服务中的属性user
        String user = "";
        //对方服务的属性
        String message = "";
        //同上
        String reqmessage = "";
        //数据库的表名
        String tablename = "";

        //RequestMessage中的属性
        String noun = "";
        //岗位,组织或人员的编码
        String obj_code = "";


        switch (infotype)//定义反射对象的类名
        {
            case "job":
                classname = "jobserver.GetDataImplServiceLocator";
                user = "jobserver.User";
                message = "jobserver.Message";
                reqmessage = "jobserver.RequestMessage";
                tablename = "jobtable";

                noun = "allJobList";
                obj_code = "job_code";
                break;

            case "org":
                classname = "orgserver.GetDataImplServiceLocator";
                user = "orgserver.User";
                message = "orgserver.Message";
                reqmessage = "orgserver.RequestMessage";
                tablename = "orgtable";

                noun = "allUnitList";
                obj_code = "org_code";
                break;

            case "user":
                classname = "userserver.GetDataImplServiceLocator";
                user = "userserver.User";
                message = "userserver.Message";
                reqmessage = "userserver.RequestMessage";
                tablename = "usertable";

                noun = "allPersonList";
                obj_code = "psid";
                break;

            case "pic":
                classname = "picserver.GetDataImplServiceLocator";
                user = "picserver.User";
                message = "picserver.Message";
                reqmessage = "picserver.RequestMessage";
                tablename = "usertable";

                noun = "allUserList";
                obj_code = "psnstr";

            case "ssdd":
                classname = "sgddbasedataserver.BasicDataImplServiceLocator";
            default:
                break;
        }

        if (classname == null || classname == "") {
            return null;//非指定类型 返回null
        }

        Object server = null;//服务对象
        Object client = null;//客户端对象
        Object userobj = null;//用户对象
        Object messageobj = null;//消息对象
        Object reqmessageobj = null;//请求对象想
        Object tmpresult = null;//请求结果

        try {
            server = Class.forName(classname).newInstance();//创建服务对象
            client = server.getClass().getMethod("getGetDataImplPort").invoke(server);//获取客户端对象
            userobj = Class.forName(user).newInstance();//创建用户对象
            messageobj = Class.forName(message).newInstance();//创建消息对象
            reqmessageobj = Class.forName(reqmessage).newInstance();//创建请求对象

            reqmessageobj.getClass().getField("verb").set(reqmessageobj, "Get");//动词
            reqmessageobj.getClass().getField("noun").set(reqmessageobj, noun);//名词

            userobj.getClass().getField("userId").set(userobj, userId);//用户编号
            userobj.getClass().getField("orgId").set(userobj, orgId);//组织机构编号
            reqmessageobj.getClass().getField("user").set(reqmessageobj, userobj);//创建用户对象

            if(infotype.equalsIgnoreCase("pic")){
                messageobj.getClass().getField("sysCode").set(messageobj, syscode);//系统编号
            }else{
                messageobj.getClass().getField("syscode").set(messageobj, syscode);//系统编号
            }
            messageobj.getClass().getField("oper_type").set(messageobj, opertype);//操作类型
            messageobj.getClass().getField(obj_code).set(messageobj, infocode);//创建消息对象

            if (infotype.equalsIgnoreCase("user")) {//如果请求用户对象
                messageobj.getClass().getField("ifPhoto").set(messageobj, 0);//设置ifphoto标记 始终未0 东软接口问题
            }

            if (infotype.equalsIgnoreCase("pic")) {//如果请求图片对象
                messageobj.getClass().getField("module_type").set(messageobj, "0");//设置module_type
            }
            reqmessageobj.getClass().getField("message").set(reqmessageobj, messageobj);//设置message


            tmpresult = client.getClass().getMethod("getData", Class.forName(reqmessage)).invoke(client, reqmessageobj);//调用请求

            if (tmpresult.getClass().getField("state").get(tmpresult).toString().equals("-1")) {
                return null;//调用失败 返回null
            }

            Object[] resultlist = (Object[]) tmpresult.getClass().getField("result").get(tmpresult);//获取调用结果

            String str = null;

            if (infotype.equalsIgnoreCase("pic")) {//处理照片类型
                String filename="default.png";//定义默认照片名称
                String filepath = utils.getpropertieval("basefilepath", "pathcfg.properties");//读取文件保存路径
                String fileurl =utils.getpropertieval("basefileurl", "pathcfg.properties");//读取文件发布路径
                String filefullname = "";//文件物理路径全名
                if(resultlist==null||resultlist.length==0||resultlist[0].getClass().getField("photo").get(resultlist[0])==null){//无结果 结果为0 照片不存在 均使用默认图片
                    filefullname = filepath+"/"+filename;//组装图片物理路径
                }else{
                    filename = java.util.UUID.randomUUID().toString().replace("-","")+".png";//生成随机文件名
                    byte[] sourcedata = (byte[])resultlist[0].getClass().getField("photo").get(resultlist[0]);//获取图片字节流
                    filefullname = baosight.utils.byte2file(filepath,filename,sourcedata);//文件落地并返回物理路径
                }
                fileurl = fileurl+filename;//组装文件发布路径
                str = utils.getpropertieval("update", "sqls.properties");//获取更新语句模板
                str = String.format(str,tablename,String.format(" filepath = '%s',fileurl = '%s'",filefullname,fileurl),String.format("psnid = '%s'",infocode));//生成update语句
                result.add(str);//添加update语句
            } else {//非图片接口处理
                for (Object obj : resultlist) {//遍历结果
                    str = utils.getpropertieval("insert", "sqls.properties");//获取insert模板

                    List<String> vals = new ArrayList<String>();//值数组
                    List<String> cols = new ArrayList<String>();//列名数组

                    for (Object p : obj.getClass().getFields()) {//遍历结果对象属性
                        String cname = ((Field) p).getName();//获取属性

                        if (cname.startsWith("_")) {
                            continue;//_开头的属性跳过
                        }

                        if (cname.equalsIgnoreCase("dataHandler")) {//不处理datahandler
                            continue;//处理下一个属性 照片路径在其他接口中进行处理
                        }

                        String tval = obj.getClass().getField(cname).get(obj) == null ? "" : obj.getClass().getField(cname).get(obj).toString();//获取值

                        //验证值是否为时间格式
//					Pattern rex = Pattern.compile("^(((([0-9]{2}(([02468][048])|([13579][26]))))(-)(2|02)(-)(([1-9])|([0][1-9])|([1-2][0-9])))|((([0-9]{2}([02468][123579])|([13579][01345789])))(-)(2|02)(-)(([1-9])|([0][1-9])|([1][0-9])([2][0-8])))|(([0-9]{4})(-)((([0]{0,1}(1|3|5|7|8))|(10|12))(-)(([1-9])|([0][1-9])|([1-2][0-9])|30|31)))|(([0-9]{4})(-)((([0]{0,1}(4|6|9))|11))(-)(([1-9])|([0][1-9])|([1-2][0-9])|30)))\\s(20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$");
                        Pattern rex = Pattern.compile("(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
                        Matcher matcher = rex.matcher(tval);
                        if (matcher.matches()) {
                            if (tval.contains(":")) {
                                tval = String.format("timestamp '%s'", tval);
                            } else {
                                tval = String.format("date '%s'", tval);
                            }
                        } else {
                            tval = String.format("'%s'", tval);//时间格式特殊处理
                        }

                        vals.add(tval);//添加值

                        cname = cname.replace("_", "");//移除列名中的_
                        cols.add(cname);//添加列名
                    }

                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    cols.add("dataoptime");//添加操作时间列
                    cols.add("dataflag");//添加数据标记列

                    vals.add(String.format("timestamp '%s'", df.format(new Date())));//获取系统时间
                    vals.add("'1'");//数据标记 默认1

                    String s_vals = StringUtils.join(vals, ",");//组装值
                    String s_cols = StringUtils.join(cols, ",");//组装列名
                    s_vals = String.format(str, tablename, s_cols, s_vals);//获取insert语句
                    result.add(s_vals);//添加insert语句
                }
            }
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}

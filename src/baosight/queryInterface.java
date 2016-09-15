package baosight;



import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import baosight.dbhelpser;
import baosight.utils;
import com.sun.org.glassfish.gmbal.Description;

import net.sf.json.*;
import userservice.*;
import userservice.RequestMessage;


public class queryInterface {

	public String IniOrg(){
		String sresult="";
		List<String> sqls=inibasedb("org","HRS",1,"","","");
		sqls.add(0, String.format(utils.getpropertieval("sql.delete", "sqls.properties"), "orgtable",""));
		JSONObject dbresult =  dbhelpser.Excutesql(utils.getpropertieval("jdbc.url", "/db.properties"), utils.getpropertieval("jdbc.user", "db.properties"), utils.getpropertieval("jdbc.password", "db.properties"), "", sqls, "");
		if(dbresult.get("data")!=null){
			sresult = dbresult.get("data").toString();
		}else{
			sresult = "-1";
		}
		return sresult;
	}

	public String Test(String infotype,String syscode,int opertype,String infocode,String userid,String orgid){
        List<String> tmp= inibasedb(infotype,syscode,opertype,infocode,userid,orgid);

        return  String.valueOf(tmp.size());
    }


	
	/*inibasedb()方法用于查询接口或者通知接口,传值后同步双方的库中的数据
	 * infotype:job,org,user
	 * syscode:请求的系统，具体编码参考统一编码表
	 * opertype:操作类型,0 增量（默认） 1 全量
	 * infocode:岗位,组织或人员的编码
	 * userId:用户ID,如果没有就为空
	 * orgId:组织机构ID,如果没有就为空
	 * */
	public static List<String> inibasedb(String infotype, String syscode, int opertype, String infocode, String userId, String orgId)
    {
		
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
        
        String nsp = "BS_wxgdserver.";
        //RequestMessage中的属性
        String noun = "";
        //岗位,组织或人员的编码
        String obj_code = "";
        switch (infotype)
        {
            case "job":
                classname = "orgserver.GetDataImplService";
                user = "orgserver.User";
                message = "orgserver.Message";
                reqmessage = "orgserver.RequestMessage";
                tablename = "posttable";

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
                classname = "userservice.GetDataImplServiceLocator";
                user = "userservice.User";
                message = "userservice.Message";
                reqmessage = "userservice.RequestMessage";
                tablename = "usertable";

                noun = "allPersonList";
                obj_code = "psid";
                break;

            default:
                break;
        }
        if(classname==null||classname==""){
        	return null;
        }

        Object server=null;
		Object client=null;
        Object userobj=null;
        Object messageobj=null;
        Object reqmessageobj=null;
        Object tmpresult=null;
        Object ob=null;
        try {

			 server = Class.forName(classname).newInstance();
			 client = server.getClass().getMethod("getGetDataImplPort").invoke(server);
			 userobj=Class.forName(user).newInstance();
			 messageobj=Class.forName(message).newInstance();
			 reqmessageobj=Class.forName(reqmessage).newInstance();

			 reqmessageobj.getClass().getField("verb").set(reqmessageobj, "Get");
			 reqmessageobj.getClass().getField("noun").set(reqmessageobj, noun);
			 
			 userobj.getClass().getField("userId").set(userobj, userId);
			 userobj.getClass().getField("orgId").set(userobj, orgId);
			 reqmessageobj.getClass().getField("user").set(reqmessageobj, userobj);
			 
			 messageobj.getClass().getField("syscode").set(messageobj, syscode);
			 messageobj.getClass().getField("oper_type").set(messageobj, opertype);
			 messageobj.getClass().getField(obj_code).set(messageobj, infocode);
             if(infotype.equalsIgnoreCase("user")){
                 int ifphoto = opertype==1?0:1;
                 messageobj.getClass().getField("ifPhoto").set(messageobj, ifphoto);
             }
			 reqmessageobj.getClass().getField("message").set(reqmessageobj, messageobj);


			 tmpresult=client.getClass().getMethod("getData",Class.forName(reqmessage)).invoke(client, reqmessageobj);
			 
			 ob=tmpresult.getClass().getField("state").get(tmpresult);

        
			if(ob.toString()=="-1"){
				return result;
			}
			
			Object[] resultlist=(Object[])tmpresult.getClass().getField("result").get(tmpresult);

			
			String str=null;	
			for(Object obj:resultlist){
				str=utils.getpropertieval("insert", "sqls.properties");
				
				List<String> vals=new ArrayList<String>();
				List<String> cols=new ArrayList<String>();
				
				for(Object p:obj.getClass().getFields()){
					String cname = ((Field)p).getName();

                    cname = cname.replace("_","");
					cols.add(cname);
					String tval = obj.getClass().getField(cname).get(obj)==null?"":obj.getClass().getField(cname).get(obj).toString();
					Pattern rex = Pattern.compile("^(((([0-9]{2}(([02468][048])|([13579][26]))))(-)(2|02)(-)(([1-9])|([0][1-9])|([1-2][0-9])))|((([0-9]{2}([02468][123579])|([13579][01345789])))(-)(2|02)(-)(([1-9])|([0][1-9])|([1][0-9])([2][0-8])))|(([0-9]{4})(-)((([0]{0,1}(1|3|5|7|8))|(10|12))(-)(([1-9])|([0][1-9])|([1-2][0-9])|30|31)))|(([0-9]{4})(-)((([0]{0,1}(4|6|9))|11))(-)(([1-9])|([0][1-9])|([1-2][0-9])|30)))\\s(20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$");
//					Pattern rex = Pattern.compile("(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)", Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
					Matcher matcher = rex.matcher(tval);
					tval = matcher.matches()?String.format("timestamp '%s'",tval):String.format("'%s'",tval);
					vals.add(tval);
				}

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cols.add("dataoptime");
				cols.add("dataflag");
				cols.add("bsbak1");
				cols.add("bsbak2");

				vals.add("sysdate");
				vals.add("'1'");
				vals.add("''");
				vals.add("''");

				String s_vals=StringUtils.join(vals, ",");
				String s_cols=StringUtils.join(cols, ",");
				s_vals=String.format(str, tablename,s_cols,s_vals);
				result.add(s_vals);
			}
		} catch (Exception e) {

		}
		return result;
    }
}

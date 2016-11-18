package baosight;



import java.lang.reflect.Field;
import java.lang.reflect.*;
import javax.activation.DataHandler;
import javax.mail.*;
import java.sql.Connection;
import java.util.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import baosight.dbhelpser;
import baosight.utils;
import com.sun.org.glassfish.gmbal.Description;

import net.sf.json.*;
import org.apache.commons.lang3.SystemUtils;



public class queryInterface {

	/**
	 *
	 * @param basetype user,job,org
	 * @param basetable 与前一个参数对应，usertable,jobtable,orgtable
	 * @return
	 */
	public String IniBaseData(String basetype,String basetable){
		String sresult="";
		List<String> sqls=remoteserverhelper.getdbsql(basetype,"HRS",1,"","","");

		if(sqls==null){
			return  sresult;
		}

		sqls.add(0, String.format(utils.getpropertieval("delete", "sqls.properties"), basetable,""));//添加删除语句

		/*//全量查询时顺带在tes01,和t_es_user表中插入数据 2016-11-10
		List<String> tmplist = queryRightTes01AndTesuser();
		if(tmplist!=null){
			for (String tmpsql:tmplist
				 ) {
				sqls.add(tmpsql);
			}
		}*/
		//JSONObject dbresult =  dbhelpser.Excutesql("jdbc:oracle:thin:@localhost:1521:orcl", "puyunhe", "tiger", null, sqls, null);
		JSONObject dbresult =  dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), null, sqls, null);//执行数据库操作

		//判断执行结果
		if(dbresult.get("data")!=null){
			sresult = dbresult.get("data").toString();
		}else{
			sresult = "-1";
		}
		return sresult;
	}

	/**
	 * 向tes01和t_es_user表中插入数据
	 * @return
	 */
	/*private List<String> queryRightTes01AndTesuser(){
		List<String> sqls = new ArrayList<String>();
		//String deltes01 = "delete from tes01";
		//String deltesuser = "delete from t_es_user";

		String instes01 = "insert into tes01 select 'admin',to_char(sysdate,'yyyymmddhhmiss'),' ',' ',' ',psnid,psnname,' ',' ','[iplat]',' ' from usertable";
		String instesuser = "insert into t_es_user(name,display_name,coded_password,create_date,expire_date,pwd_expire_date,valid,sort_index) select psnid,psnname,psnid,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),'2100-01-01 00:00:00','2100-01-01 00:00:00','1','0' from usertable";

		//sqls.add(deltes01);
		//sqls.add(deltesuser);
		sqls.add(instes01);
		sqls.add(instesuser);

		//获取所有的psnid
		String querycodedpassword = "select psnid from usertable";
		//执行sql
		JSONObject userpasswd = dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), null, null, querycodedpassword);
		//取出JSONArray
		JSONArray data = userpasswd.getJSONArray("data");
		//遍历
		for (int i = 0; i <data.size() ; i++) {
			JSONObject jsondata = data.getJSONObject(i);
			//获取所有的codedpassword
			String coded_password = jsondata.getString("PSNID");
			//md5加密
			String md5accountid = utils.getMD5(coded_password);
			String updatetesuser=String.format("update t_es_user set coded_password = '%s' where name = '%s'",md5accountid,coded_password);
			sqls.add(updatetesuser);
		}
		return sqls;
	}*/



	/**
	 * 取出所有的coded_password
	 * @return
	 */
	/*public static  List getcodedpasswd(){
		List<String> passwdlist = new ArrayList<String>();
		String coded_password = "";
		String querycodedpassword = "select psnid from usertable";
		//执行sql
		JSONObject userpasswd = dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), null, null, querycodedpassword);
		//取出JSONArray
		JSONArray data = userpasswd.getJSONArray("data");
		//遍历
		for (int i = 0; i <data.size() ; i++) {
			JSONObject jsondata = data.getJSONObject(i);
			coded_password = jsondata.getString("psnid");
			passwdlist.add(coded_password);
		}
		return passwdlist;
	}*/
}

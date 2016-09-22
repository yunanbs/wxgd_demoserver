package baosight;



import java.lang.reflect.Field;
import java.lang.reflect.*;
import javax.activation.DataHandler;
import javax.mail.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import baosight.dbhelpser;
import baosight.utils;
import com.sun.org.glassfish.gmbal.Description;

import net.sf.json.*;
import org.apache.commons.lang3.SystemUtils;



public class queryInterface {

	public String IniBaseData(String basetype,String basetable){
		String sresult="";
		List<String> sqls=remoteserverhelper.getdbsql(basetype,"HRS",1,"","","");

		if(sqls==null){
			return  sresult;
		}

		sqls.add(0, String.format(utils.getpropertieval("delete", "sqls.properties"), basetable,""));//添加删除语句

		JSONObject dbresult =  dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), null, sqls, null);//执行数据库操作

		//判断执行结果
		if(dbresult.get("data")!=null){
			sresult = dbresult.get("data").toString();
		}else{
			sresult = "-1";
		}

		return sresult;
	}


}

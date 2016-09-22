package baosight;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class NoticeInterface {

	public baosight.ResponseMessage SetData(baosight.RequestMessage input) {
		String verb = input.getVerb();
		String noun = input.getNoun();
		Message message = input.getMessage();
		String pstatus = message.getPstatus();
		String syscode = message.getSyscode();
		User user = input.getUser();

		baosight.ResponseMessage result = new baosight.ResponseMessage();
		baosight.ErrorMessage errmsg = null;

		if (!verb.equalsIgnoreCase("CREATE") && !verb.equalsIgnoreCase("DELETE")) {
			errmsg = new baosight.ErrorMessage("301","“动词”有误");
		}

//		 pstatus=1,2,3分别为1：新增2：更新 3：注销

		if (!pstatus.equalsIgnoreCase("1")&& !pstatus.equalsIgnoreCase("2")&& !pstatus.equalsIgnoreCase("3")) {
			if(!noun.equalsIgnoreCase("account")) {
				errmsg = new baosight.ErrorMessage("303","“条件”有误");
			}
		}

		String pkname = "";
		String pkval = "";
		String tablename = "";

		if (!noun .equals(null)&& !noun.equalsIgnoreCase("")) {
			switch (noun) {

				case "user":
					pkname = "psnid";
					pkval = message.getPsid();
					tablename = "usertable";
					break;

				case "job":
					pkname = "jobcode";
					pkval = message.getJob_code();
					tablename = "jobtable";
					break;

				case "org":
					pkname = "orgcode";
					pkval = message.getOrg_code();
					tablename = "orgtable";
					break;

				case "account":
					pkname = "userid";
					pkval = message.getUserId();
					tablename = "accounttable";
					break;

				default:
					errmsg = new baosight.ErrorMessage("302", "“名词”有误");
					break;
			}

			if (errmsg==null) {
				List<String> sqlstodo = new ArrayList<String>();//待执行语句列表
				String str = utils.getpropertieval("delete", "sqls.properties");//获取删除语句
				str = String.format(str, tablename, String.format(" where %s %s '%s'", pkname, "=", pkval));
				if (pstatus.equalsIgnoreCase("1") || pstatus.equalsIgnoreCase("2") ) {//新增或更新时，需要通过增量接口获取用户的详细信息
					sqlstodo = remoteserverhelper.getdbsql(noun, "HRS", 0, pkval, "", "");//获取insert语句

					if(noun.equalsIgnoreCase("user")){//如果更新对象为user，在新增或更新时，同时进行照片文件的处理
						List<String> picup = remoteserverhelper.getdbsql("pic","HRS",0,pkval,"","");//获取照片更新语句
						if(picup!=null){
							for (String upsql:picup) {
								sqlstodo.add(upsql);//添加更新语句
							}
						}
					}
				}

				if (verb.equalsIgnoreCase("CREATE") && noun.equalsIgnoreCase("account")) {//新增账号处理
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取时间

					List<String> cols = new ArrayList<String>();
					List<String> vals = new ArrayList<String>();

					cols.add(pkname);
					cols.add("dataoptime");
					cols.add("dataflag");


					vals.add("'"+pkval+"'");
					vals.add(String.format("timestamp '%s'", df.format(new Date())));//获取系统时间
					vals.add("'1'");//数据标记 默认1
					sqlstodo.add(String.format(utils.getpropertieval("insert", "sqls.properties"), tablename, StringUtils.join(cols, ","), StringUtils.join(vals, ",")));

					List<String> picup = remoteserverhelper.getdbsql("pic","HRS",0,pkval,"","");//新增账号时，同步更新用户的照片信息
					if(picup!=null){
						for (String upsql:picup) {
							sqlstodo.add(upsql);//添加update语句
						}
					}

				}
				sqlstodo.add(0, str);

				JSONObject jsresult = dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), null, sqlstodo, null);
				if (!jsresult.get("error").equals(null) || jsresult.get("data").equals(null)) {
//					result = ResponseMessage.getInstance("310", "服务器内部异常", "-1", "失败");
					errmsg = new baosight.ErrorMessage("310", "服务器内部异常");
				}
			}

		}
		if(errmsg==null){
			/*result.getContent()="成功";
			result.getState()= "0";
			result.=new baosight.ErrorMessage();*/
			result.setContent("成功");
			result.setState("0");
			result.setErrorMessage(new baosight.ErrorMessage());
		}else{
			result.setContent("失败");
			result.setState("-1");
			result.setErrorMessage(errmsg);
		}
		return result;
	}
}


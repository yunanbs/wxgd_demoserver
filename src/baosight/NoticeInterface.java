package baosight;

import java.util.ArrayList;
import java.util.List;

import baosight.dbhelpser;
import baosight.utils;
import baosight.ErrorMessage;
import baosight.Message;
import baosight.RequestMessage;
import baosight.ResponseMessage;
import baosight.User;
import baosight.queryInterface;
import net.sf.json.JSONObject;

public class NoticeInterface {

	public ResponseMessage SetData(RequestMessage input) {
		String verb = input.getVerb();
		String noun = input.getNoun();
		Message message = input.getMessage();
		String pstatus = message.getPstatus();
		String syscode = message.getSyscode();
		User user = input.getUser();

		baosight.ResponseMessage result = new baosight.ResponseMessage();


		if (verb.toUpperCase() != "CREATE" && verb.toUpperCase() != "DELETE") {
			result = ResponseMessage.getInstance("301", "“动词”有误", "-1", "失败");
		} else
			
		/* pstatus=1,2,3分别为1：新增2：更新 3：注销
		 * */
			if (pstatus != "1" && pstatus != "2" && pstatus != "3") {
				result = ResponseMessage.getInstance("303", "“条件”有误", "-1", "失败");
			}

		String pkname = "";
		String pkval = "";
		String tablename = "";

		if (noun != null && noun != "") {
			switch (noun) {

				case "user":
					pkname = "psnid";
					pkval = message.getPsid();
					tablename = "usertable";
					break;

				case "job":
					pkname = "job_code";
					pkval = message.getJob_code();
					tablename = "jobtable";
					break;

				case "org":
					pkname = "org_code";
					pkval = message.getOrg_code();
					tablename = "orgtable";
					break;

				default:
					result = ResponseMessage.getInstance("302", "“名词”有误", "-1", "失败");
					break;
			}

			List<String> sqlstodo = new ArrayList<String>();

			String str = utils.getpropertieval("delete", "sqls.properties");
			StringBuilder sb = new StringBuilder();
			sb.append(" where ");
			sb.append(String.format(" %s %s %s %s ", pkname, "=", pkval, ""));
			str = String.format(str, tablename, sb.toString());

			if (pstatus == "1" || pstatus == "2") {
				sqlstodo = queryInterface.getdbsql(noun, "HRS", 0, pkval, "", "");
			}
			sqlstodo.add(0,str);
			JSONObject jsresult =  dbhelpser.Excutesql(utils.getpropertieval("s_dbname", "dbconfig.properties"), utils.getpropertieval("s_dbuser", "dbconfig.properties"), utils.getpropertieval("s_dbpassword", "dbconfig.properties"), "", sqlstodo, "");
			if(jsresult.get("error")!=null|| jsresult.get("data")==null){
				result = ResponseMessage.getInstance("310", "服务器内部异常", "-1", "失败");
			}else{
				result = ResponseMessage.getInstance("", "", "0", "成功");
			}
		}

		return result;
	}
}


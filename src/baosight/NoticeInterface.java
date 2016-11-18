package baosight;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class NoticeInterface {

	public baosight.ResponseMessage SetData(baosight.RequestMessage input) {
		//create或delete
		String verb = input.getVerb();
		//noun：user,job,org
		String noun = input.getNoun();
		Message message = input.getMessage();
		//pstatus=1,2,3分别为1：新增2：更新 3：注销
		String pstatus = message.getPstatus();
		String syscode = message.getSyscode();
		User user = input.getUser();

		baosight.ResponseMessage result = new baosight.ResponseMessage();
		baosight.ErrorMessage errmsg = null;

		String pkname = "";
		String pkval = "";
		String tablename = "";

		String datastr = "";

		if (!verb.equalsIgnoreCase("CREATE") && !verb.equalsIgnoreCase("DELETE")) {
			errmsg = new baosight.ErrorMessage("301", "“动词”有误");
		}

//		 pstatus=1,2,3分别为1：新增2：更新 3：注销

		if (!pstatus.equalsIgnoreCase("1") && !pstatus.equalsIgnoreCase("2") && !pstatus.equalsIgnoreCase("3")) {
			if (!noun.equalsIgnoreCase("account")) {
				errmsg = new baosight.ErrorMessage("303", "“条件”有误");
			}
		}


		if (!noun.equals(null) && !noun.equalsIgnoreCase("")) {
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
			//由于东软可能会做删除操作，删除之后就拿不到对象了，因此先到库里拿一下 2016.11.2加
			datastr = getobjstr(pkval, tablename, pkname);

			if (errmsg == null) {
				List<String> sqlstodo = new ArrayList<String>();//待执行语句列表
				String str = utils.getpropertieval("delete", "sqls.properties");//获取删除语句
				str = String.format(str, tablename, String.format(" where %s %s '%s'", pkname, "=", pkval));
				if (pstatus.equalsIgnoreCase("1") || pstatus.equalsIgnoreCase("2")) {//新增或更新时，需要通过增量接口获取用户的详细信息
					sqlstodo = remoteserverhelper.getdbsql(noun, "HRS", 0, pkval, "", "");//获取insert语句

					if (noun.equalsIgnoreCase("user")) {//如果更新对象为user，在新增或更新时，同时进行照片文件的处理
						List<String> picup = remoteserverhelper.getdbsql("pic", "HRS", 0, pkval, "", "");//获取照片更新语句
						if (picup != null) {
							for (String upsql : picup) {
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


					vals.add("'" + pkval + "'");
					vals.add(String.format("timestamp '%s'", df.format(new Date())));//获取系统时间
					vals.add("'1'");//数据标记 默认1
					sqlstodo.add(String.format(utils.getpropertieval("insert", "sqls.properties"), tablename, StringUtils.join(cols, ","), StringUtils.join(vals, ",")));

					List<String> picup = remoteserverhelper.getdbsql("pic", "HRS", 0, pkval, "", "");//新增账号时，同步更新用户的照片信息
					if (picup != null) {
						for (String upsql : picup) {
							sqlstodo.add(upsql);//添加update语句
						}
					}

					// 2016-11-09 写IPLAT 用户表
                    List<String> tmplist = iplatrighttablesql(pkval);
					if(tmplist!=null){
						for (String tmpsql:tmplist) {
							sqlstodo.add(tmpsql);//添加语句
						}
					}
				}
					sqlstodo.add(0, str);

					//JSONObject jsresult = dbhelpser.Excutesql("jdbc:oracle:thin:@localhost:1521:orcl", "puyunhe", "tiger", null, sqlstodo, null);
					JSONObject jsresult = dbhelpser.Excutesql(utils.getpropertieval("s_dbname","dbconfig.properties"), utils.getpropertieval("s_dbuser","dbconfig.properties"), utils.getpropertieval("s_dbpassword","dbconfig.properties"), null, sqlstodo, null);
					if (!jsresult.get("error").equals(null) || jsresult.get("data").equals(null)) {
//					result = ResponseMessage.getInstance("310", "服务器内部异常", "-1", "失败");
						errmsg = new baosight.ErrorMessage("310", "服务器内部异常");
					}
				}

			}
			if (errmsg == null) {
			/*result.getContent()="成功";
			result.getState()= "0";
			result.=new baosight.ErrorMessage();*/
				result.setContent("成功");
				result.setState("0");
				result.setErrorMessage(new baosight.ErrorMessage());

				//东软调用我提供的接口成功之后判断一下是否拿到他操作的数据，没有就取一次 2016.11.2
				if (datastr.equals("[]")) {
					datastr = getobjstr(pkval, tablename, pkname);
				}
				//同理，如果已经取到对象了就可以调用华软给的接口返回了。但由于东软的管理账户是create或者delete，因此要做一下判断 2016.11.2
				if (!datastr.equals("")) {
					if (verb.equalsIgnoreCase("CREATE") && noun.equalsIgnoreCase("account")) {
						huaInterface("sgdd",datastr, noun, "1");
					} else if (verb.equalsIgnoreCase("DELETE") && noun.equalsIgnoreCase("account")) {
						huaInterface("sgdd",datastr, noun, "3");
					} else {
						huaInterface("sgdd",datastr, noun, pstatus);
					}
				}
			} else {
				result.setContent("失败");
				result.setState("-1");
				result.setErrorMessage(errmsg);
			}
			return result;
		}



	/**
	 *
	 * @param datastr 东软操作的对象，拿到以后作为中转站再返回给华软
	 * @param objtype user,job,org,account,countdata
	 * @param opflag 1：新增2：更新 3：注销 99：查询
	 * @return
	 */
	public String huaInterface(String sysflag,String datastr, String objtype, String opflag) {
		String logresult = "";//定义取华软的返回消息，成功或者失败
		String hinterfaceresult = "";//虚拟的华软的返回值
		JSONObject errormsg = new JSONObject();//保存错误信息记录到库中
		String IP="";
		String message = "";
		String mathname = "";//定义方法名称
	try {
		//获取调用者IP
		MessageContext mc = MessageContext.getCurrentContext();
		HttpServletRequest request =null;
		request= (HttpServletRequest) mc.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
		 IP=request.getRemoteAddr();



			switch (opflag) {
				case "1":
					mathname = "add";
					break;
				case "2":
					mathname = "update";
					break;
				case "3":
					mathname = "del";
					break;

				default:
					break;
			}

			objtype = objtype.substring(0,1).toUpperCase()+objtype.substring(1).toLowerCase();
			mathname = mathname + objtype;//拼写

		/*
		{"ActionResult":true,"Message":null,"ReturnResult":null,"Tag":null}
		String hinterfaceresult = "";

		 */

			hinterfaceresult = huserverhelper.getdbsql(sysflag,mathname,datastr,"");
			JSONObject jresult = JSONObject.fromObject(hinterfaceresult);

			if (jresult.getString("actionResult").equalsIgnoreCase("true")) {
				logresult = "成功";
			} else {
				logresult = "失败";
			}

			 message = jresult.getString("message");
		} catch (Exception e) {
			errormsg.accumulate("error", e.getMessage());
		}
		//构建log对象
		JSONObject logobj = new JSONObject();
		logobj.accumulate("cusip", IP);
		logobj.accumulate("method", "huaInterface");
		logobj.accumulate("methodparam", datastr + "-" + objtype + "-" + opflag);
		logobj.accumulate("result", logresult);
		logobj.accumulate("error", message);
		logobj.accumulate("errtype", "huaInterface");
		//写log
		utils.createLog(logobj.toString());

		return hinterfaceresult;
	}

	/**
	 * 根据所传的条件获取库中的对象
	 * @param id 获取的主键
	 * @param tablename 表名
	 * @param pkname 数据库列名
	 * @return
	 */
	public String getobjstr(String id,String tablename,String pkname){
		String result = "";
		String searchsql = String.format("select * from %s where %s = '%s'",tablename,pkname,id);
		JSONObject dbresult = dbhelpser.Excutesql(utils.getpropertieval("s_dbname","dbconfig.properties"), utils.getpropertieval("s_dbuser","dbconfig.properties"), utils.getpropertieval("s_dbpassword","dbconfig.properties"), null, null, searchsql);
		//由于bhelpser.Excutesql()方法中的error返回值的关系，这里的判断要做特殊处理。具体见bhelpser.Excutesql()中已注明
		if(dbresult.getString("error").toString().equals("null")){
			result = dbresult.getString("data");
			//System.out.println(dbresult.getString("error").toString());
		}
		//返回JSONArray
		return  result;
	}

	/**
	 * 给表tes01，t_es_user插入指定账户的各种数据 2016-11-9
	 * @param accountid
	 * @return
	 */
	private List<String > iplatrighttablesql(String accountid){
		List<String> result = new ArrayList<String>();

		String deletetes01=String.format("delete from tes01 where user_id = '%s'",accountid);
		String deletetesuser=String.format("delete from t_es_user where name = '%s'",accountid);

		String inserttes01=String.format("insert into tes01 select 'admin',to_char(sysdate,'yyyymmddhhmiss'),' ',' ',' ',psnid,psnname,' ',' ','[iplat]',' ' from usertable where psnid = '%s'",accountid);

		String inserttesuser=String.format("insert into t_es_user(name,display_name,coded_password,create_date,expire_date,pwd_expire_date,valid,sort_index) select psnid,psnname,psnid,to_char(sysdate,'yyyy-mm-dd hh:mi:ss'),'2100-01-01 00:00:00','2100-01-01 00:00:00','1','0' from usertable where psnid = '%s'",accountid);

		//md5加密accountid
		String md5accountid = utils.getMD5(accountid);
		System.out.println(md5accountid);
		String updatetesuser=String.format("update t_es_user set coded_password = '%s' where name = '%s'",md5accountid,accountid);

		result.add(deletetes01);
		result.add(deletetesuser);
		result.add(inserttes01);
		result.add(inserttesuser);
		result.add(updatetesuser);
		return result;

	}

	public static String testmd5(String accountid){
		String result = "";
		result = utils.getMD5(accountid);
		return result;
	}
}


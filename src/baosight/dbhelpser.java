package baosight;



import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Created by YuNan on 2016/9/8.
 */

//数据库操作类
public class dbhelpser {

	/*
    * 数据库操作方法
    * 目前只支持oracle 后续添加其他数据库的支持
    * dbname 数据库连接地址
    * dbuser 数据库连接用户名
    * dbpassword 数据库密码
    * sql 需要单独执行的sql
    * sqls 需要批量执行的sql 失败后回滚
    * datasql 用于查询的sql
    * 返回JSONObject
    * {
    * 	"error":异常信息，如果没有异常则为空
    * 	"data":返回值，执行sql 或者 sqls 返回语句影响的记录数；执行datasql 返回JSONObject数组
    * }
    * */
	public static JSONObject Excutesql(String dbname, String dbuser, String dbpassword, String sql, List<String> sqls, String datasql){

		String _drivername = utils.getpropertieval("s_driverName","/baosight/dbconfig.properties");//获取数据库驱动的类名

		JSONObject result = new JSONObject();//返回对象


		int intresult = 0;//影响记录数

		try {
			Class.forName(_drivername);// 加载Oracle驱动类
		} catch (Exception e1) {
			//加载失败则返回
			try {
				result.accumulate("error", e1.getMessage());
				result.accumulate("data",null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}



		String name = dbname;//数据库连接
		String user = dbuser;// 数据库用户名
		String password = dbpassword;//用户密码


		try(
				Connection con = DriverManager.getConnection(name, user, password);//创建数据库连接
				Statement stmt = con.createStatement()//创建statement对象
		)
		{
			if(sql!=null){
				intresult = stmt.executeUpdate(sql);//执行单条语句
				result.accumulate("error", null);
				result.accumulate("data", String.valueOf(intresult));//返回记录数
			}

			if(sqls!=null){
				try{
					con.setAutoCommit(false);//取消自动提交
					for (String tmpsql : sqls) {//依次提交需要执行的语句
						stmt.addBatch(tmpsql);
					}
					int[] i_results = stmt.executeBatch();//预处理
					int sum = 0;
					for(int r : i_results){//获取总的影响记录数
						sum = sum+r;
					}
					con.commit();//提交数据库
					result.accumulate("error", null);//这里的null不是真正意义上的null，而是给error赋值为null,如果返回给前端就能看见该值。而如果用双引号""就看不见了
					result.accumulate("data", sum);//返回操作结果

				}catch(Exception e2){
					con.rollback();//操作失败回滚
					result.accumulate("error", e2.getMessage());//返回异常信息
					result.accumulate("data", null);
				}
			}

			if(datasql!=null){
				ResultSet dbresult = stmt.executeQuery(datasql);//获取查询结果
				JSONArray l_data = dbhelpser.extractJSONArray(dbresult);//resultset转json对象
				result.accumulate("error", null);
				result.accumulate("data", l_data);//返回查询结果
			}
		}
		catch (Exception e)
		{

			try {
				result.accumulate("error", e.getMessage());//返回异常信息
				result.accumulate("data", null);


			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		/*JSONObject logobj = new JSONObject();
		try {
			logobj.accumulate("cusip","");
			logobj.accumulate("method","db.Excutesql");
			logobj.accumulate("methodparam",sql+"-"+sqls+"-"+datasql);
			logobj.accumulate("result", result.has("error") ? "失败" : "成功");
			logobj.accumulate("error",result.has("error")?result.getString("error"):"");
			logobj.accumulate("errtype","db.Excutesql");
			//创建日志到数据库
			utils.createLog(logobj.toString());*//*
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return result;
	}

	/**
	 * 通用取结果方案,返回JSONArray
	 */
	public static JSONArray extractJSONArray(ResultSet rs){
		try{
			ResultSetMetaData md = rs.getMetaData();//获取数据集和元数据结构
			int num = md.getColumnCount();//获取总的列数
			JSONArray array = new JSONArray();//创建json数组
			while (rs.next()) {//读取一条记录
				JSONObject mapOfColValues = new JSONObject();//创建json对象
				for (int i = 1; i <= num; i++) {
					if(rs.getObject(i)!=null) {
						if(rs.getObject(i).getClass().toString().contains("Timestamp")||rs.getObject(i).getClass().toString().contains("Date")){
							DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							mapOfColValues.put(md.getColumnName(i).toLowerCase(), sdf.format(rs.getObject(i)));//获取每列的名称及值，组装json对象
						}else{
							mapOfColValues.put(md.getColumnName(i).toLowerCase(), rs.getObject(i).toString());//获取每列的名称及值，组装json对象
						}
					}else
					{
						mapOfColValues.put(md.getColumnName(i).toLowerCase(),rs.getObject(i));//获取每列的名称及值，组装json对象
					}
				}
				array.add(mapOfColValues);//向数组添加json对象
			}
			return array;//返回数组
		}catch(Exception e){
			return null;//异常时返回空
		}finally {
			try{
				rs.close();//关闭resultset对象
			}catch (Exception e1){

			}

		}
	}
}

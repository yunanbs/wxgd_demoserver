package baosight;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sgddbasedataserver.BasicDataImplServiceLocator;
import sgddbasedataserver.IbasicData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/5.
 * 该接口用于从华软那查询员工的待办已办事项，返回值给东软
 */
public class ResDongMsg {
    /**
     * @param
     * @return
     */
    public  ResponseMessage tmpDongData(PendingMessage pendingMessage){
        //调用华工软的数据
        String todolist = todolist(pendingMessage);
        //转成json
        JSONObject jsonObject = JSONObject.fromObject(todolist);
        //获取"data","error"
        String data = jsonObject.getString("data");
        String error = jsonObject.getString("error");
        String state = "0";
        String content = "成功";
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessage(error);
        ResponseMessage responseMessage = new ResponseMessage();

        Result result = new Result();
        List<Result> resultList = new ArrayList<Result>();
        try {
            JSONArray jsonArray = JSONArray.fromObject(data);
            String pkind = "";
            String ptitle = "";
            String pdate = "";
            String purl = "";
            String pcode = "";
            String pprincipal = "";
            String pstatus = "";
            //待办类别
            String ptype = "待办";
            //应用系统编号
            String pscode = "";
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject array2json = jsonArray.getJSONObject(i);
                //待办公文类型
                pkind = array2json.getString("type");
                //待办标题
                ptitle = array2json.getString("title");
                //待办时间
                pdate = array2json.getString("begintime");
                //url地址
                purl = array2json.getString("url");
                //待办编码
                pcode = array2json.getString("id");
                //代办人标识
                pprincipal = array2json.getString("userAccount");
                //待办状态
                pstatus = array2json.getString("status");

                result.setPcode(pcode);
                result.setPdate(pdate);
                result.setPkind(pkind);
                result.setPprincipal(pprincipal);
                result.setPstatus(pstatus);
                result.setPtitle(ptitle);
                result.setPtype(ptype);
                result.setPscode(pscode);
                result.setPurl(purl);

                resultList.add(result);
            }

        }catch (Exception e){
            errorMessage.setMessage(e.getMessage());
            state = "-1";
            content = "失败";
        }
        responseMessage.setState(state);
        responseMessage.setContent(content);
        responseMessage.setErrorMessage(errorMessage);
        responseMessage.setResultList(resultList);
        return responseMessage;
    }

    //查询待办列表，获取华工软的返回值 /始建于2016-12-1
    public String todolist(PendingMessage pendingMessage){
        //查询名
        String userid = pendingMessage.getPprincipal();
        //查询类型
        String listtype = pendingMessage.getPstatus();
        //查询大小
        String listsize= pendingMessage.getNumlimit();
        //查询类型做一下处理
        if(listtype.equals("2")){
            listtype.replaceAll("2","1");
        }
        JSONObject json = new JSONObject();
        json.accumulate("userid",userid);
        json.accumulate("listsize",listsize);
        json.accumulate("listtype",listtype);
        String jsonString = json.toString();

        JSONObject jsonresult = new JSONObject();
        String result = "";
        try {
            //创建服务
            //BasicDataImplServiceSoapBindingStub server = new BasicDataImplServiceSoapBindingStub();
            BasicDataImplServiceLocator server = new BasicDataImplServiceLocator();
            IbasicData client = server.getBasicDataImplPort();
            result = client.toDoList(jsonString);
            //将取到结果转成JSON
            JSONObject jsonObject = JSONObject.fromObject(result);
            String resultstr = jsonObject.getString("returnResult");
            if(resultstr == null||resultstr.equals("null")){
                jsonresult.accumulate("data","");
                jsonresult.accumulate("error","没有取到结果！");
                result = jsonresult.toString();
            }else {
                //取出JSONArray
                JSONArray returnResult = JSONArray.fromObject(resultstr);

                JSONObject jresult = null;
                String status = "";
                //遍历转换成JSON后取出status
                for (int i = 0; i < returnResult.size(); i++) {
                    jresult = returnResult.getJSONObject(i);
                    status = jresult.getString("status");
                }

                String cstatus = "";
                switch (status) {
                    case "0":
                        cstatus = "待办";
                        break;
                    case "1":
                        cstatus = "已办";
                        break;
                    default:
                        break;
                }
                //jresult.remove("status");
                jresult.put("status", cstatus);
                jsonresult.accumulate("data",returnResult);
                jsonresult.accumulate("error","");
                result = jsonresult.toString();
            }
        } catch (Exception e) {
            try {
                e.getMessage();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }
}

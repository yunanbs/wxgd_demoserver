package baosight;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/1.
 */
public class PendingMessage implements Serializable {
    //待办人标识
    private String pprincipal;
    //待办状态
    private String pstatus;
    //查询条数
    private String numlimit;
    //应用系统编号
    private String pscode;

    public String getPprincipal() {
        return pprincipal;
    }

    public void setPprincipal(String pprincipal) {
        this.pprincipal = pprincipal;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getNumlimit() {
        return numlimit;
    }

    public void setNumlimit(String numlimit) {
        this.numlimit = numlimit;
    }

    public String getPscode() {
        return pscode;
    }

    public void setPscode(String pscode) {
        this.pscode = pscode;
    }
}

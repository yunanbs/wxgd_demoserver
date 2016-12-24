package baosight;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/1.
 */
public class Result implements Serializable {
    //待办编码
    private String pcode;
    //待办公文类型
    private String pkind;
    //待办标题
    private String ptitle;
    //待办时间
    private String pdate;
    //待办人标识
    private String pprincipal;
    //URL地址
    private String purl;
    //待办状态
    private String pstatus;
    //待办类别
    private String ptype;
    //应用系统编号
    private String pscode;

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPkind() {
        return pkind;
    }

    public void setPkind(String pkind) {
        this.pkind = pkind;
    }

    public String getPtitle() {
        return ptitle;
    }

    public void setPtitle(String ptitle) {
        this.ptitle = ptitle;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPprincipal() {
        return pprincipal;
    }

    public void setPprincipal(String pprincipal) {
        this.pprincipal = pprincipal;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPscode() {
        return pscode;
    }

    public void setPscode(String pscode) {
        this.pscode = pscode;
    }
}

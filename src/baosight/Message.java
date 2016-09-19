package baosight;

import java.io.Serializable;

public class Message implements Serializable {
	private String syscode;
	private String psid;
	private String pstatus;
	private String org_code;
	private String job_code;
	private String userId;

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	public String getPsid() {
		return psid;
	}

	public void setPsid(String psid) {
		this.psid = psid;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getJob_code() {
		return job_code;
	}

	public void setJob_code(String job_code) {
		this.job_code = job_code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

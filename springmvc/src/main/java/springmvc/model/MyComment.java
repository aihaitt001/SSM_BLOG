package springmvc.model;

import java.sql.Timestamp;

public class MyComment {
	private Integer id;

	private Integer parentid;

	private String body;

	private Integer userid;

	private Timestamp committime;

	private String isdelete;

	private String istop;

	private Integer upnum;

	private Integer downnum;

	private String ps;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body == null ? null : body.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Timestamp getCommittime() {
		return committime;
	}

	public void setCommittime(Timestamp committime) {
		this.committime = committime;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete == null ? null : isdelete.trim();
	}

	public String getIstop() {
		return istop;
	}

	public void setIstop(String istop) {
		this.istop = istop == null ? null : istop.trim();
	}

	public Integer getUpnum() {
		return upnum;
	}

	public void setUpnum(Integer upnum) {
		this.upnum = upnum;
	}

	public Integer getDownnum() {
		return downnum;
	}

	public void setDownnum(Integer downnum) {
		this.downnum = downnum;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps == null ? null : ps.trim();
	}

	@Override
	public String toString() {
		return "{id:" + id + ",parentid：" + parentid + ",body:" + body + ",userid:" + userid + ",comittime:"
				+ committime.toString() + ",isdelete:" + isdelete + ",istop:" + istop + ",upnum:" + upnum + ",downnum:"
				+ downnum + ",ps:" + ps + "}";
	}

}
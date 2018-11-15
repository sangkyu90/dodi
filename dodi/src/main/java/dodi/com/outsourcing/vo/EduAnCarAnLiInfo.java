package dodi.com.outsourcing.vo;

import org.apache.ibatis.type.Alias;

@Alias("ecl")
public class EduAnCarAnLiInfo {
	private Integer ecnum;
	private Integer membernum;
	private char ectype;
	private String ectitle;
	private String ecstdate;
	private String ecenddate;
	public EduAnCarAnLiInfo() {}
	public EduAnCarAnLiInfo(Integer ecnum, Integer membernum, char ectype, String ectitle, String ecstdate,
			String ecenddate) {
		super();
		this.ecnum = ecnum;
		this.membernum = membernum;
		this.ectype = ectype;
		this.ectitle = ectitle;
		this.ecstdate = ecstdate;
		this.ecenddate = ecenddate;
	}
	public Integer getEcnum() {
		return ecnum;
	}
	public void setEcnum(Integer ecnum) {
		this.ecnum = ecnum;
	}
	public Integer getMembernum() {
		return membernum;
	}
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	public char getEctype() {
		return ectype;
	}
	public void setEctype(char ectype) {
		this.ectype = ectype;
	}
	public String getEctitle() {
		return ectitle;
	}
	public void setEctitle(String ectitle) {
		this.ectitle = ectitle;
	}
	public String getEcstdate() {
		return ecstdate;
	}
	public void setEcstdate(String ecstdate) {
		this.ecstdate = ecstdate;
	}
	public String getEcenddate() {
		return ecenddate;
	}
	public void setEcenddate(String ecenddate) {
		this.ecenddate = ecenddate;
	}
	@Override
	public String toString() {
		return "EduAnCarAnLi [ecnum=" + ecnum + ", membernum=" + membernum + ", ectype=" + ectype + ", ectitle="
				+ ectitle + ", ecstdate=" + ecstdate + ", ecenddate=" + ecenddate + "]";
	}
	
	
	
}

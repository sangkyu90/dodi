package dodi.com.outsourcing.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Alias("ci")
@Component
public class ClientInfo {

	private Integer membernum;
	private String companyname;
	private String companyregistrationnumber;
	private String companyaddress;
	private String companytype;
	private String businessvariety;
	private String companysite;
	
	public ClientInfo() {}
	public ClientInfo(Integer membernum, String companyname, String companyregistrationnumber, String companyaddress,
			String companytype, String businessvariety, String companysite) {
		super();
		this.membernum = membernum;
		this.companyname = companyname;
		this.companyregistrationnumber = companyregistrationnumber;
		this.companyaddress = companyaddress;
		this.companytype = companytype;
		this.businessvariety = businessvariety;
		this.companysite = companysite;
	}
	public Integer getMembernum() {
		return membernum;
	}
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyregistrationnumber() {
		return companyregistrationnumber;
	}
	public void setCompanyregistrationnumber(String companyregistrationnumber) {
		this.companyregistrationnumber = companyregistrationnumber;
	}
	public String getCompanyaddress() {
		return companyaddress;
	}
	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}
	public String getCompanytype() {
		return companytype;
	}
	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}
	public String getBusinessvariety() {
		return businessvariety;
	}
	public void setBusinessvariety(String businessvariety) {
		this.businessvariety = businessvariety;
	}
	public String getCompanysite() {
		return companysite;
	}
	public void setCompanysite(String companysite) {
		this.companysite = companysite;
	}
	@Override
	public String toString() {
		return "ClientInfo [membernum=" + membernum + ", companyname=" + companyname + ", companyregistrationnumber="
				+ companyregistrationnumber + ", companyaddress=" + companyaddress + ", companytype=" + companytype
				+ ", businessvariety=" + businessvariety + ", companysite=" + companysite + "]";
	}
	

}

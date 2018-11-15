package dodi.com.outsourcing.vo;

import org.apache.ibatis.type.Alias;

@Alias("mi")
public class MemberInfo {
	private Integer membernum;
	private char membertype;
	private String memberid;
	private String memberpw;
	private String membername;
	private String memberemail;
	private String memberphone;
	private String memberaddress;
	
	public MemberInfo() {
		
	}
	public MemberInfo(Integer membernum, char membertype, String memberid, String memberpw, String membername,
			String memberemail, String memberphone, String memberaddress) {
		super();
		this.membernum = membernum;
		this.membertype = membertype;
		this.memberid = memberid;
		this.memberpw = memberpw;
		this.membername = membername;
		this.memberemail = memberemail;
		this.memberphone = memberphone;
		this.memberaddress = memberaddress;
	}
	public Integer getMembernum() {
		return membernum;
	}
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	public char getMembertype() {
		return membertype;
	}
	public void setMembertype(char membertype) {
		this.membertype = membertype;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMemberpw() {
		return memberpw;
	}
	public void setMemberpw(String memberpw) {
		this.memberpw = memberpw;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberemail() {
		return memberemail;
	}
	public void setMemberemail(String memberemail) {
		this.memberemail = memberemail;
	}
	public String getMemberphone() {
		return memberphone;
	}
	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	public String getMemberaddress() {
		return memberaddress;
	}
	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}
	@Override
	public String toString() {
		return "MemberInfo [membernum=" + membernum + ", membertype=" + membertype + ", memberid=" + memberid
				+ ", memberpw=" + memberpw + ", membername=" + membername + ", memberemail=" + memberemail
				+ ", memberphone=" + memberphone + ", memberaddress=" + memberaddress + "]";
	}	
}
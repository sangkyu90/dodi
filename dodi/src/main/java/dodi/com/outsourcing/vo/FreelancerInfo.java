package dodi.com.outsourcing.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Alias("fi")
@Component
public class FreelancerInfo {
	private Integer membernum;
	private Integer skillnum;
	private String abilitytag;
	private List<EduAnCarAnLiInfo> ecl;
	public FreelancerInfo() {}
	public FreelancerInfo(Integer membernum, Integer skillnum, String abilitytag, List<EduAnCarAnLiInfo> ecl) {
		super();
		this.membernum = membernum;
		this.skillnum = skillnum;
		this.abilitytag = abilitytag;
		this.ecl = ecl;
	}
	public Integer getMembernum() {
		return membernum;
	}
	public void setMembernum(Integer membernum) {
		this.membernum = membernum;
	}
	public Integer getSkillnum() {
		return skillnum;
	}
	public void setSkillnum(Integer skillnum) {
		this.skillnum = skillnum;
	}
	public String getAbilitytag() {
		return abilitytag;
	}
	public void setAbilitytag(String abilitytag) {
		this.abilitytag = abilitytag;
	}
	public List<EduAnCarAnLiInfo> getEcl() {
		return ecl;
	}
	public void setEcl(List<EduAnCarAnLiInfo> ecl) {
		this.ecl = ecl;
	}
	@Override
	public String toString() {
		return "FreelancerInfo [membernum=" + membernum + ", skillnum=" + skillnum + ", abilitytag=" + abilitytag
				+ ", ecl=" + ecl + "]";
	}
	
	
}

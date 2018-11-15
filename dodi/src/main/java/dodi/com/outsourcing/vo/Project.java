package dodi.com.outsourcing.vo;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("pr")
public class Project {
	private Integer pjnum;
	private Integer membernum;
	private Integer btype;
	private String ptitle;
	private Integer ppay;
	private String pdate;
	private String puploaddate;
	private String ptype;
	private Integer getpartnum;
	private Integer getpermember;
	private String pdesc;
	private String pstayarea;
	private String uploaddate;
	private List<FileList> filelist;
}

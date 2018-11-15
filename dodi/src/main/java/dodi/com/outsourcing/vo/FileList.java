package dodi.com.outsourcing.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Data
@Alias("fl")
public class FileList {
	private Integer fnum;
	private Integer pnum;
	private String fname;
	private String ptype;
}

package dodi.com.outsourcing.dao;

import dodi.com.outsourcing.vo.MemberInfo;

public interface MeminfoDAO {
	public Integer loginSelect(MemberInfo memInfo);
	public Integer join(MemberInfo memInfo);
}

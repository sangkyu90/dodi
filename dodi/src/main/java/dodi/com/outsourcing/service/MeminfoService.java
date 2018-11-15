package dodi.com.outsourcing.service;

import dodi.com.outsourcing.vo.MemberInfo;

public interface MeminfoService {
	public Integer loginGet(MemberInfo memInfo);
	public Integer join(MemberInfo memInfo);
}

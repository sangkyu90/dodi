package dodi.com.outsourcing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dodi.com.outsourcing.dao.MeminfoDAO;
import dodi.com.outsourcing.service.MeminfoService;
import dodi.com.outsourcing.vo.MemberInfo;

@Service
public class MeminfoServiceImpl implements MeminfoService {

	@Autowired
	private MeminfoDAO sdao;

	@Override
	public Integer loginGet(MemberInfo memInfo) {
		int cnt = -1;
		if (memInfo != null && memInfo.getMemberid() != null && memInfo.getMemberpw() != null) {
			cnt = sdao.loginSelect(memInfo);
		}
		return cnt;
	}

	@Override
	public Integer join(MemberInfo memInfo) {
		if (memInfo == null || !(memInfo.getMembertype() == '1' || memInfo.getMembertype() == '2')
				|| (memInfo.getMemberemail().indexOf("@") == -1 || memInfo.getMemberemail().indexOf(".") == -1)) {
			return -1; // 올바르지않은 입력정보
		}
		return sdao.join(memInfo);
	}

}

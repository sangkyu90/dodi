package dodi.com.outsourcing.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dodi.com.outsourcing.dao.ClientAnFreeDAO;
import dodi.com.outsourcing.service.ClientAnFreeService;
import dodi.com.outsourcing.vo.ClientInfo;
import dodi.com.outsourcing.vo.FreelancerInfo;

@Service
public class ClientAnFreeServiceImpl implements ClientAnFreeService {

	@Autowired
	private ClientInfo ci;
	@Autowired
	private FreelancerInfo fi;
	@Autowired
	private ClientAnFreeDAO cfdao;

	@Override
	public Integer cfInsert(Map<String, String> m) throws IllegalAccessException, InvocationTargetException {
		int suc = 0;
		try {
			Character type = cfdao.getMemType(Integer.parseInt(m.get("membernum")));
			if (type.equals('1')) {
				BeanUtils.populate(ci, m);
				suc = cfdao.clientInsert(ci);
			} else if (type.equals('2')) {
				BeanUtils.populate(fi, m);
				if (cfdao.chSkill(fi.getSkillnum()) == 0) {
					return -1;
				}
				suc = cfdao.freeInsert(fi);
			} else {
				suc = -1;
			}
		} catch (Exception e) {
			return -1;
		}
		return suc;
	}

	@Override
	public Integer cfUpdate(Map<String, String> m) throws IllegalAccessException, InvocationTargetException {
		int suc = 0;
		try {
			Character type = cfdao.getMemType(Integer.parseInt(m.get("membernum")));
			if (type.equals('1')) {
				BeanUtils.populate(ci, m);
				suc = cfdao.clientUpdate(ci);
			} else if (type.equals('2')) {
				BeanUtils.populate(fi, m);
				if (cfdao.chSkill(fi.getSkillnum()) == 0) {
					return -1;
				}
				suc = cfdao.freeUpdate(fi);
			} else {
				suc = -1;
			}
		} catch (Exception e) {
			return -1;
		}
		return suc;
	}


	@Override
	public Map<String, String> cfGet(Integer memberNum) {
		Character type = cfdao.getMemType(memberNum);
		if (type.equals('1')) {
			return cfdao.clientSelect(memberNum);
		} else if (type.equals('2')) {
			return cfdao.freeSelect(memberNum);
		} else {
			return null;
		}
	}
}

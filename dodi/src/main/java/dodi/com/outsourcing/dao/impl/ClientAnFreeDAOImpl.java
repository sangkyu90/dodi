package dodi.com.outsourcing.dao.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import dodi.com.outsourcing.dao.ClientAnFreeDAO;
import dodi.com.outsourcing.vo.ClientInfo;
import dodi.com.outsourcing.vo.FreelancerInfo;

@Slf4j
@Repository
public class ClientAnFreeDAOImpl implements ClientAnFreeDAO {

	@Autowired
	private SqlSession ss;

	@Override
	public Integer clientInsert(ClientInfo ci) {
		// TODO Auto-generated method stub
		return ss.insert("SQL.CLIENTANFREE.inClient", ci);
	}

	@Override
	public Integer freeInsert(FreelancerInfo fi) {
		// TODO Auto-generated method stub
		return ss.insert("SQL.CLIENTANFREE.inFree", fi);
	}

	@Override
	public Integer clientUpdate(ClientInfo ci) {
		// TODO Auto-generated method stub
		return ss.update("SQL.CLIENTANFREE.upClient", ci);
	}

	@Override
	public Integer freeUpdate(FreelancerInfo fi) {
		// TODO Auto-generated method stub
		return ss.update("SQL.CLIENTANFREE.upFree", fi);
	}

	@Override
	public Map<String, String> clientSelect(Integer memberNum) {
		// TODO Auto-generated method stub
		return ss.selectOne("SQL.CLIENTANFREE.selClient", memberNum);
	}

	@Override
	public Map<String, String> freeSelect(Integer memberNum) {
		// TODO Auto-generated method stub
		Map<String, String> m =ss.selectOne("SQL.CLIENTANFREE.selFree", memberNum);
		return m;
	}

	@Override
	public Character getMemType(Integer memberNum) {
		String type = ss.selectOne("SQL.CLIENTANFREE.getType", memberNum);
		return type.charAt(0);
	}

	@Override
	public Integer chSkill(Integer skillNum) {
		// TODO Auto-generated method stub
		return ss.selectOne("SQL.CLIENTANFREE.chSkill", skillNum);
	}
}

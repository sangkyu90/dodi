package dodi.com.outsourcing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dodi.com.outsourcing.dao.ProjectDAO;
import dodi.com.outsourcing.service.ProjectService;
import dodi.com.outsourcing.vo.Project;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO pdao;

	@Override
	public List<Project> selectProjectList(Project pr) {
		return pdao.selectProjectList(pr);
	}

	@Override
	public Project selectProject(Project pr) {
		return pdao.selectProject(pr);
	}

	@Override
	public int updateProject(Project pr) {
		return pdao.updateProject(pr);
	}

	@Override
	public int insertProject(Project pr) {
		return pdao.insertProject(pr);
	}

	@Override
	public int deleteProject(Project pr) {
		return pdao.deleteProject(pr);
	}

}

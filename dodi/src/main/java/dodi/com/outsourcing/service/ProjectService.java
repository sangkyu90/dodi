package dodi.com.outsourcing.service;

import java.util.List;

import dodi.com.outsourcing.vo.Project;

public interface ProjectService {
	public List<Project> selectProjectList(Project pr);
	public Project selectProject(Project pr);
	public int updateProject(Project pr);
	public int insertProject(Project pr);
	public int deleteProject(Project pr);
}

package dodi.com.outsourcing.dao;

import java.util.List;

import dodi.com.outsourcing.vo.Project;

public interface ProjectDAO {
	public List<Project> selectProjectList(Project pr);
	public Project selectProject(Project pr);
	public int updateProject(Project pr);
	public int insertProject(Project pr);
	public int deleteProject(Project pr);
}

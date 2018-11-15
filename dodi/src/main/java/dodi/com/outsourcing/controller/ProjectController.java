package dodi.com.outsourcing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dodi.com.outsourcing.service.ProjectService;
import dodi.com.outsourcing.vo.Project;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService pService;
	
	@ResponseBody
	@RequestMapping(value="/project", method=RequestMethod.GET) //조회
	public List<Project> selectProjectList(@RequestBody Project pr){
		return pService.selectProjectList(pr);
	}
	
	@ResponseBody
	@RequestMapping(value="/project/{path}", method=RequestMethod.GET) //조회
	public Project selectProject(@PathVariable int pjnum,@RequestBody Project pr){
		Project project = new Project();
		project.setPjnum(pjnum);
		return pService.selectProject(project);
	}
	
	@ResponseBody
	@RequestMapping(value="/project", method=RequestMethod.POST) //입력
	public int insertProject(@RequestBody Project pr) {
		return pService.insertProject(pr);
	}
	
	@ResponseBody
	@RequestMapping(value="/project", method=RequestMethod.PUT) //수정
	public int updateProject(@RequestBody Project pr) {
		return pService.updateProject(pr);
	}
	
	@ResponseBody
	@RequestMapping(value="/project", method=RequestMethod.DELETE) //삭제
	public int deleteProject(@RequestBody Project pr) {
		return pService.deleteProject(pr);
	}
}

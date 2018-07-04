package com.kyler.space.sys.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kyler.space.common.Criteria;
import com.kyler.space.common.pojo.RestResult;
import com.kyler.space.sys.pojo.Project;
import com.kyler.space.sys.service.ProjectService;

/**
 * 项目
 */
@RestController
public class ProjectRestController {

   @Autowired
	public ProjectService projectService;
   
    @RequestMapping(method = RequestMethod.GET, value = "/projects/{projectSid}")
	@ResponseBody
    private RestResult findProjectById(@PathVariable Long projectSid){
		Project project = this.projectService.selectByPrimaryKey(projectSid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		project.setStartTimeDesc(sdf.format(project.getProjectStartTime()));
		project.setEndTimeDesc(sdf.format(project.getProjectEndTime()));
		return new RestResult(RestResult.SUCCESS, "",project);
	}
	
	@GetMapping("/projects")
	public List<Project> selectProjects(){
		Criteria example = new Criteria();
		List<Project> project = this.projectService.selectByParams(example);
		
		if(null != project){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for (Project project2 : project) {
				project2.setStartTimeDesc(sdf.format(project2.getProjectStartTime()));
				project2.setEndTimeDesc(sdf.format(project2.getProjectEndTime()));

			}
			System.out.println(project.size());
		}
		return project;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/projects")
    @ResponseBody
    private RestResult insertproject(Project project, HttpServletRequest request){
		int result = 0;
		if(null != project){
			result = this.projectService.insertSelective(project);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"项目添加成功");
		}else{
			return new RestResult(RestResult.FAILURE,"项目添加失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/projects/{projectSid}")
    @ResponseBody
    private RestResult updateProject(@PathParam("projectSid")int projectSid,Project project, HttpServletRequest request){
		int result = 0;
		if(null != project){
			result = this.projectService.updateByPrimaryKey(project);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"项目更新成功");
		}else{
			return new RestResult(RestResult.FAILURE,"项目更新失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/projects/{projectSid}")
    @ResponseBody
    private RestResult deleteProject(@PathVariable Long projectSid){
		int result = this.projectService.deleteByPrimaryKey(projectSid);
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"项目删除成功");
		}else{
			return new RestResult(RestResult.FAILURE,"项目删除失败");
		}
	}
}

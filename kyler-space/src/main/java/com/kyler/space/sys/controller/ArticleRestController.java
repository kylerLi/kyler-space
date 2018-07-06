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
import com.kyler.space.sys.pojo.Article;
import com.kyler.space.sys.service.ArticleService;

/**
 * 项目
 */
@RestController("/articles")
public class ArticleRestController {

   @Autowired
	public ArticleService articleService;
   
    @RequestMapping(method = RequestMethod.GET, value = "/{articleSid}")
	@ResponseBody
    private RestResult findArticleById(@PathVariable String articleSid){
    	Article article = this.articleService.selectByPrimaryKey(articleSid);
		return new RestResult(RestResult.SUCCESS, "", article);
	}
	
	@GetMapping("/list")
	public List<Article> selectArticles(){
		Criteria example = new Criteria();
		List<Article> article = this.articleService.selectByParams(example);
		
		return article;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/")
    @ResponseBody
    private RestResult insertArticle(Article article, HttpServletRequest request){
		int result = 0;
		if(null != article){
			result = this.articleService.insertSelective(article);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"文章添加成功");
		}else{
			return new RestResult(RestResult.FAILURE,"文章添加失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{articleSid}")
    @ResponseBody
    private RestResult updateArticle(@PathParam("articleSid")int articleSid,Article article, HttpServletRequest request){
		int result = 0;
		if(null != article){
			result = this.articleService.updateByPrimaryKey(article);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"项目更新成功");
		}else{
			return new RestResult(RestResult.FAILURE,"项目更新失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{articleSid}")
    @ResponseBody
    private RestResult deleteArticle(@PathVariable String articleSid){
		int result = this.articleService.deleteByPrimaryKey(articleSid);
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"项目删除成功");
		}else{
			return new RestResult(RestResult.FAILURE,"项目删除失败");
		}
	}
}

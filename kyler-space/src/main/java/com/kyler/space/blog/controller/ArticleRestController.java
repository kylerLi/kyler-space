package com.kyler.space.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyler.space.common.Criteria;
import com.kyler.space.common.pojo.RestResult;
import com.kyler.space.common.util.WebUtil;
import com.kyler.space.blog.pojo.Article;
import com.kyler.space.blog.service.ArticleService;

/**
 * 文章
 */
@Controller
public class ArticleRestController {

   @Autowired
	public ArticleService articleService;
   
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{articleSid}")
	@ResponseBody
    private RestResult findArticleById(@PathVariable String articleSid){
    	if(null != articleSid){
    		Article article = this.articleService.selectByPrimaryKey(articleSid);
    		return new RestResult(RestResult.SUCCESS, "", article);
    	}
    	return new RestResult(RestResult.FAILURE, "没有查询到信息", null);
	}
	
	@GetMapping("/articles")
	@ResponseBody
	public List<Article> selectArticles(HttpServletRequest request){
		Criteria example = new Criteria();
		List<Article> articles = this.articleService.selectByParams(example);
		return articles;
	}
	
	/**
	 * 查詢概要信息列表
	 * @param request
	 * @return
	 */
	@GetMapping("/articles/summarylists")
	@ResponseBody
	public List<Article> selectArticlesList(HttpServletRequest request){
		Criteria example = new Criteria();
		List<Article> articles = this.articleService.selectSummaryByParams(example);
		return articles;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/articles")
    @ResponseBody
    private RestResult saveArticle(Article article, HttpServletRequest request){
		int result = 0;
		if(null != article){
			WebUtil.prepareInsertParams(article);
			result = this.articleService.insertSelective(article);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"文章添加成功");
		}else{
			return new RestResult(RestResult.FAILURE,"文章添加失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/articles/update")
    @ResponseBody
    private RestResult updateArticle(Article article, HttpServletRequest request){
		int result = 0;
		if(null != article){
			WebUtil.prepareUpdateParams(article);
			result = this.articleService.updateByPrimaryKey(article);
		}
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"文章更新成功");
		}else{
			return new RestResult(RestResult.FAILURE,"文章更新失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/articles/{articleSid}")
    @ResponseBody
    private RestResult deleteArticle(@PathVariable String articleSid){
		int result = this.articleService.deleteByPrimaryKey(articleSid);
		if(result ==1){
			return new RestResult(RestResult.SUCCESS,"文章删除成功");
		}else{
			return new RestResult(RestResult.FAILURE,"文章删除失败");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/articles/edit/{id}")
    public String article_edit(@PathVariable String id,HttpServletRequest request) {
		if(null != id){
    		Article article = this.articleService.selectByPrimaryKey(id);
    		request.setAttribute("article", article);
    	}
		
        return "markdown/article_edit";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/articles/preview/{id}")
    public String article_preview(@PathVariable String id,HttpServletRequest request) {
		if(null != id){
    		Article article = this.articleService.selectByPrimaryKey(id);
    		request.setAttribute("article", article);
    	}
		
        return "markdown/article_preview";
	}
}

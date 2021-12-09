package com.ahzc.stu.controller;

import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.entity.News;
import com.ahzc.stu.service.INewsService;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 22:53
 * @desc
 */
@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    /**
     * 新闻管理列表
     * @param model 视图
     * @param news 新闻
     * @return string
     */
    @GetMapping("list")
    public String newsList(Model model, News news){
        List<News> newList = newsService.queryAll(news);
        model.addAttribute("newList",newList);
        return "news/new-list";
    }

    @GetMapping("del/{id}")
    @ResponseBody
    public ResultBean delType(@PathVariable("id") Integer id){
        return newsService.del(id);
    }

    @GetMapping("delMany")
    @ResponseBody
    public ResultBean typeDelMany(String ids){
        return newsService.delMany(ids);
    }

    @GetMapping("addHtml")
    public String addHtml(Model model){
        return "news/news-add";
    }

    @GetMapping("add")
    @ResponseBody
    public ResultBean add(News news){
        return newsService.add(news);
    }

    @GetMapping("editHtml")
    public String editHtml(Model model,Integer id){
        News type = newsService.queryById(id);
        model.addAttribute("list",type);
        return "news/news-edit";
    }

    @GetMapping("edit")
    @ResponseBody
    public ResultBean edit(News movie){
        return newsService.edit(movie);
    }

}

package com.ponking.pblog.controller;

import com.ponking.pblog.model.entity.Link;
import com.ponking.pblog.model.vo.*;
import com.ponking.pblog.service.IArticleService;
import com.ponking.pblog.service.ICategoryService;
import com.ponking.pblog.service.ILinkService;
import com.ponking.pblog.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;

import java.util.List;

/**
 * @author Ponking
 * @ClassName BaseController
 * @date 2020/4/8--14:24
 **/
public class BaseController {
    @Autowired
    protected IArticleService articleService;

    @Autowired
    protected ICategoryService categoryService;

    @Autowired
    protected ITagService tagService;

    @Autowired
    protected ILinkService linkService;


    @Value("${pblog.author-name}")
    private String authorName;

    @Value("${pblog.author-location}")
    private String authorLocation;


    @Value("${pblog.author-title}")
    private String authorTitle;

    @Value("${pblog.author-avatar}")
    private String authorAvatar;


    /**
     * 左右侧栏信息
     * @param model
     * @return
     */
    protected Model getBlogInfoModel(Model model){
        List<CategoryColumnVO> categoryColumnVOS = categoryService.listCategoryColumnInfo();
        List<TagColumnVO> tagColumnVOS = tagService.listTagColumnInfo();
        List<ArchiveColumnVO> archiveColumnVOS = articleService.listArchiveColumnInfo();
        List<ArticleTopColumnVO> articleTopColumnVOS = articleService.listArticleTopColumn();
        List<Link> links = linkService.list();

        String name = authorName;
        String city = authorLocation;
        String title = authorTitle;
        String avatar = authorAvatar;
        /**
         * 统计信息
         */
        int articleCount = articleService.count();
        int tagCount = tagService.count();
        int cateCount = categoryService.count();
        PersonInfoVO person = new PersonInfoVO(name,city,avatar,title,articleCount,tagCount,cateCount);

        model.addAttribute("info",person);
        model.addAttribute("categories",categoryColumnVOS);
        model.addAttribute("tags",tagColumnVOS);
        model.addAttribute("archives",archiveColumnVOS);
        model.addAttribute("newArticles",articleTopColumnVOS);
        model.addAttribute("links",links);
        return model;
    }
}

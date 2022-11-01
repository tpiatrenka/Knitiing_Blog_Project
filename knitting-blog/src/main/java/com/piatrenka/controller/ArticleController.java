package com.piatrenka.controller;

import com.piatrenka.dto.ArticleDto;
import com.piatrenka.dto.ArticleGetDto;
import com.piatrenka.service.ArticleGetService;
import com.piatrenka.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final ArticleGetService articleGetService;

    public ArticleController(ArticleService articleService, ArticleGetService articleGetService) {
        this.articleService = articleService;
        this.articleGetService = articleGetService;
    }


    @PostMapping("/add")
    public long addArticle(@RequestBody ArticleDto articleDto) throws Exception {
        return articleService.addArticle(articleDto);
    }

    @GetMapping("/all")
    public List<ArticleGetDto> findAll() {
        return articleGetService.findAll();
    }

}

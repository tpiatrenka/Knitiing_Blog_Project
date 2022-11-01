package com.piatrenka.converter;

import com.piatrenka.dto.ArticleDto;
import com.piatrenka.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleConverter {
    public Article toLocal(ArticleDto dto) {
        if (dto == null) {
            return null;
        }
        Article article = new Article();
        article.setHeader(dto.header());
        article.setText(dto.text());

        return article;
    }

    public ArticleDto toFront(Article article) {
        if (article == null) {
            return null;
        }

        return new ArticleDto(article.getUser().getId(), article.getHeader(), article.getText());
    }

    public List<Article> toLocal(List<ArticleDto> articleDtos) {
        if (articleDtos == null) {
            return null;
        }

        return articleDtos.stream()
                .map(dto -> toLocal(dto))
                .toList();
    }

    public List<ArticleDto> toFront(List<Article> articles) {
        if (articles == null) {
            return null;
        }

        return articles.stream()
                .map(this::toFront)
                .toList();
    }
}

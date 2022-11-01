package com.piatrenka.converter;

import com.piatrenka.dto.ArticleGetDto;
import com.piatrenka.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleGetConverter {
    public ArticleGetDto toFront(Article article) {
        if (article == null) {
            return null;
        }

        return new ArticleGetDto(article.getUser().getName(), article.getDate(), article.getHeader(), article.getText());
    }

    public List<ArticleGetDto> toFront(List<Article> articles) {
        if (articles == null) {
            return null;
        }

        return articles.stream()
                .map(this::toFront)
                .toList();
    }

}

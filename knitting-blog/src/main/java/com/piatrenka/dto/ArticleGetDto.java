package com.piatrenka.dto;

import java.util.Date;

public record ArticleGetDto(String name,
                            Date date,
                            String header,
                            String text) {

}

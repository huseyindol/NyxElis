package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoPage {
    private String title;
    private String description;
    private String content;
    private String slug;
    private Boolean isActive;
    private DtoSeoInfo seoInfo;
}

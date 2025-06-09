package com.nyxelis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoSeoInfo {
    private String title;

    private String description;

    private String keywords;

    private String canonicalUrl;
}

package com.nyxelis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoSeoInfo {
    private String title;

    private String description;

    private String keywords;

    private String canonicalUrl;
}

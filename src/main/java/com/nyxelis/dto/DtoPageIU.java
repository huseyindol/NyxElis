package com.nyxelis.dto;

import com.nyxelis.entity.SeoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoPageIU {
    private String title;

    private String slug;

    private Boolean isActive;

    private DtoSeoInfo seoInfo;
}

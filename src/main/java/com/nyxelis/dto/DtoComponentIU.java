package com.nyxelis.dto;

import com.nyxelis.enums.ComponentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoComponentIU {
    private String name;

    private String title;

    private String content;

    private ComponentType type;

    private Boolean isActive;
}

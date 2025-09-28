package com.nyxelis.dto;

import com.nyxelis.enums.ComponentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoComponent {
    private Long id;
    private String name;
    private String title;
    private String content;
    private ComponentType type;
    private Boolean isActive;
    private Integer orderIndex; // Component'in sayfa içindeki sırası
    private List<DtoBanner> banners; // Component içindeki banner'lar
}

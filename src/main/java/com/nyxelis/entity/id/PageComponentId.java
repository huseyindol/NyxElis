package com.nyxelis.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageComponentId implements Serializable {

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "component_id")
    private Long componentId;
}

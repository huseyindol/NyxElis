package com.nyxelis.entity.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageComponentId implements Serializable {

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "component_id")
    private Long componentId;
}

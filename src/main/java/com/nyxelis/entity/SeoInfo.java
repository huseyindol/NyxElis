package com.nyxelis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "seo_info",
        indexes = {
                @Index(name = "id_seoinfo_title", columnList = "title"),
                @Index(name = "id_seoinfo_canonical_url", columnList = "canonicalUrl")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeoInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String keywords;
    private String canonicalUrl;
    private String noIndex;
    private String noFollow;

    @OneToOne(mappedBy = "seoInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Page page;
}

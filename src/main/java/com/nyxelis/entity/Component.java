package com.nyxelis.entity;

import com.nyxelis.enums.ComponentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "components",
        indexes = {
                // Tek kolonlu indexler
                @Index(name = "idx_name", columnList = "name"),
                @Index(name = "idx_type", columnList = "type"),

                @Index(name = "idx_type_active", columnList = "type, isActive"),
                @Index(name = "idx_type_name", columnList = "type, name")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Component extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    @Pattern(regexp = "WIDGET|BANNER", message = "Type must be either 'WIDGET' or 'BANNER'")
    private ComponentType type;

    private Boolean isActive;

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PageComponent> pageComponents = new ArrayList<>();

    @OneToMany(mappedBy = "component", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComponentBanner> componentBanners = new ArrayList<>();
}

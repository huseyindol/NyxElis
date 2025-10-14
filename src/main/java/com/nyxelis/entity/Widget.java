package com.nyxelis.entity;

import com.nyxelis.enums.WidgetType;
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
  name = "widgets",
  indexes = {
    // Tek kolonlu indexler
    @Index(name = "id_widget_name", columnList = "name"),
    @Index(name = "id_widget_type", columnList = "type"),

    @Index(name = "id_widget_type_active", columnList = "type, isActive"),
    @Index(name = "id_widget_type_name", columnList = "type, name")
  }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Widget extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String content;
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  @Pattern(regexp = "POST|BANNER", message = "Type must be either 'POST' or 'BANNER'")
  private WidgetType type;

  private Boolean isActive;
  private Integer orderIndex;

  @OneToMany(mappedBy = "widget", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WidgetPost> widgetPosts = new ArrayList<>();

  @OneToMany(mappedBy = "widget", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<WidgetBanner> widgetBanners = new ArrayList<>();
}

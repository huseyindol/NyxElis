package com.nyxelis.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyxelis.dto.*;
import com.nyxelis.entity.*;
import com.nyxelis.entity.id.ComponentBannerId;
import com.nyxelis.entity.id.PageComponentId;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

  private final PageRepository pageRepository;
  private final ComponentRepository componentRepository;
  private final BannerRepository bannerRepository;
  private final ComponentBannerRepository componentBannerRepository;
  private final PageComponentRepository pageComponentRepository;
  private final PostRepository postRepository;
  private final CustomerRepository customerRepository;
  private final WidgetRepository widgetRepository;

  @Override
  public void run(String... args) throws Exception {
    if (pageRepository.count() == 0) {
      log.info("Page Database is empty, initializing with mock data...");
      loadMockData();
      log.info("Page Mock data initialization completed.");
    } else {
      log.info("Page Database already contains data, skipping initialization.");
    }
    if (componentRepository.count() == 0) {
      log.info("Component Database is empty, initializing with mock data...");
      loadMockComponentData();
      log.info("Component Mock data initialization completed.");
    } else {
      log.info("Component Database already contains data, skipping initialization.");
    }
    if (pageRepository.count() > 0 && componentRepository.count() > 0 && pageComponentRepository.count() == 0) {
      log.info("PageComponent Database is empty, initializing with mock data...");
      loadMockPageComponentData();
      log.info("PageComponent Mock data initialization completed.");
    } else {
      log.info("PageComponent Database already contains data or prerequisites not met, skipping initialization.");
    }
    if (postRepository.count() == 0) {
      log.info("Post Database is empty, initializing with mock data...");
      loadMockPostData();
      log.info("Post Mock data initialization completed.");
    } else {
      log.info("Post Database already contains data, skipping initialization.");
    }
    if (widgetRepository.count() == 0) {
      log.info("Widget Database is empty, initializing with mock data...");
      loadMockWidgetData();
      log.info("Widget Mock data initialization completed.");
    } else {
      log.info("Widget Database already contains data, skipping initialization.");
    }
  }

  private void loadMockData() {
    try {
      List<DtoPage> pageList = loadPageData();

      for (DtoPage dtoPage : pageList) {
        // DTO'dan Entity'e manuel mapping
        Page page = new Page();
        page.setTitle(dtoPage.getTitle());
        page.setSlug(dtoPage.getSlug());
        page.setDescription(dtoPage.getDescription());
        page.setContent(dtoPage.getContent());
        page.setIsActive(dtoPage.getIsActive());

        // SeoInfo mapping
        if (dtoPage.getSeoInfo() != null) {
          SeoInfo seoInfo = new SeoInfo();
          DtoSeoInfo dtoSeoInfo = dtoPage.getSeoInfo();
          seoInfo.setTitle(dtoSeoInfo.getTitle());
          seoInfo.setDescription(dtoSeoInfo.getDescription());
          seoInfo.setKeywords(dtoSeoInfo.getKeywords());
          seoInfo.setCanonicalUrl(dtoSeoInfo.getCanonicalUrl());
          seoInfo.setNoIndex(dtoSeoInfo.getNoIndex());
          seoInfo.setNoFollow(dtoSeoInfo.getNoFollow());

          page.setSeoInfo(seoInfo);
          seoInfo.setPage(page);
        }

        pageRepository.save(page);
        log.info("Successfully created page: {}", page.getTitle());
      }

      log.info("Successfully loaded {} pages with SEO info", pageList.size());

    } catch (Exception e) {
      log.error("Error loading mock data: ", e);
    }
  }

  private List<DtoPage> loadPageData() throws IOException {
    log.info("Loading page mock data...");

    ClassPathResource resource = new ClassPathResource("mock-data/page.json");
    InputStream inputStream = resource.getInputStream();

    ObjectMapper objectMapper = new ObjectMapper();
    List<DtoPage> pageList = objectMapper.readValue(
      inputStream,
      new TypeReference<List<DtoPage>>() {
      });

    log.info("Loaded {} page records", pageList.size());
    return pageList;
  }

  private void loadMockComponentData() {
    try {
      List<DtoComponent> componentList = loadComponentData();

      for (DtoComponent dtoComponent : componentList) {
        System.out.println("Processing component: " + dtoComponent.getType());
        System.out.println("Processing component: " + ComponentType.BANNER);

        // Component entity için fully qualified name kullan
        com.nyxelis.entity.Component component = new com.nyxelis.entity.Component();
        component.setName(dtoComponent.getName());
        component.setTitle(dtoComponent.getTitle());
        component.setContent(dtoComponent.getContent());
        component.setType(dtoComponent.getType());
        component.setIsActive(dtoComponent.getIsActive());

        com.nyxelis.entity.Component savedComponent = componentRepository.save(component);
        log.info("Successfully created component: {}", savedComponent.getName());

        // Banner'ları işle
        if (dtoComponent.getBanners() != null && !dtoComponent.getBanners().isEmpty()) {
          int orderIndex = 1;
          for (DtoBanner dtoBanner : dtoComponent.getBanners()) {
            // Banner oluştur
            Banner banner = new Banner();
            banner.setTitle(dtoBanner.getTitle());
            banner.setDescription(dtoBanner.getDescription());
            banner.setImageUrl(dtoBanner.getImageUrl());
            banner.setLink(dtoBanner.getLink());
            banner.setAltText(dtoBanner.getAltText());
            banner.setIsActive(dtoBanner.getIsActive());

            Banner savedBanner = bannerRepository.save(banner);
            log.info("Successfully created banner: {}", savedBanner.getTitle());

            // ComponentBanner ilişkisi oluştur
            ComponentBanner componentBanner = new ComponentBanner();

            ComponentBannerId id = new ComponentBannerId();
            id.setComponentId(savedComponent.getId());
            id.setBannerId(savedBanner.getId());
            componentBanner.setId(id);

            componentBanner.setComponent(savedComponent);
            componentBanner.setBanner(savedBanner);
            componentBanner.setOrderIndex(
              dtoBanner.getOrderIndex() != null ? dtoBanner.getOrderIndex() : orderIndex);

            componentBannerRepository.save(componentBanner);
            log.info("Successfully created component-banner relationship");
            orderIndex++;
          }
        }
      }

      log.info("Successfully loaded {} components with banners", componentList.size());

    } catch (Exception e) {
      log.error("Error loading component mock data: ", e);
    }
  }

  private List<DtoComponent> loadComponentData() throws IOException {
    log.info("Loading component mock data...");

    ClassPathResource resource = new ClassPathResource("mock-data/component.json");
    InputStream inputStream = resource.getInputStream();

    ObjectMapper objectMapper = new ObjectMapper();
    List<DtoComponent> componentList = objectMapper.readValue(
      inputStream,
      new TypeReference<List<DtoComponent>>() {
      });

    log.info("Loaded {} component records", componentList.size());
    return componentList;
  }

  private void loadMockPageComponentData() {
    try {

      Long idNumber = 1L;
      Page page = pageRepository.findById(idNumber).orElse(null);
      com.nyxelis.entity.Component component = componentRepository.findById(idNumber).orElse(null);

      if (page != null && component != null) {
        PageComponent pageComponent = new PageComponent();

        // Composite key oluştur
        PageComponentId id = new PageComponentId();
        id.setPageId(page.getId());
        id.setComponentId(component.getId());
        pageComponent.setId(id);

        pageComponent.setPage(page);
        pageComponent.setComponent(component);
        pageComponent.setOrderIndex(1);

        pageComponentRepository.save(pageComponent);
        log.info("Successfully created page-component relationship for page: {} and component: {}",
          page.getTitle(), component.getName());
      } else {
        log.warn("Skipping PageComponent creation. Page or Component not found for IDs - Page ID: 1, " +
          "Component ID: 1");
      }

      log.info("Successfully loaded {} page-component relationships", 1);
    } catch (Exception e) {
      log.error("Error loading page-component mock data: ", e);
    }
  }

  private List<DtoPostIU> loadPostData() throws IOException {
    log.info("Loading post mock data...");

    ClassPathResource resource = new ClassPathResource("mock-data/post.json");
    InputStream inputStream = resource.getInputStream();

    ObjectMapper objectMapper = new ObjectMapper();
    List<DtoPostIU> postList = objectMapper.readValue(
      inputStream,
      new TypeReference<List<DtoPostIU>>() {
      });

    log.info("Loaded {} post records", postList.size());
    return postList;
  }

  private void loadMockPostData() {
    try {
      List<DtoPostIU> postList = loadPostData();

      for (DtoPostIU dtoPost : postList) {
        Customer author = customerRepository.findById(dtoPost.getAuthorId())
          .orElseThrow(() -> new RuntimeException("Author not found with ID: " + dtoPost.getAuthorId()));

        Post post = new Post();
        post.setTitle(dtoPost.getTitle());
        post.setContent(dtoPost.getContent());
        post.setSlug(dtoPost.getSlug());
        post.setAuthor(author);
        post.setIsActive(dtoPost.getIsActive());
        post.setOrderIndex(dtoPost.getOrderIndex());

        postRepository.save(post);
        log.info("Successfully created post: {}", post.getTitle());
      }

      log.info("Successfully loaded {} posts", postList.size());

    } catch (Exception e) {
      log.error("Error loading post mock data: ", e);
    }
  }

  private List<DtoWidgetIU> loadWidgetData() throws IOException {
    log.info("Loading widget mock data...");

    ClassPathResource resource = new ClassPathResource("mock-data/widget.json");
    InputStream inputStream = resource.getInputStream();

    ObjectMapper objectMapper = new ObjectMapper();
    List<DtoWidgetIU> widgetList = objectMapper.readValue(
      inputStream,
      new TypeReference<List<DtoWidgetIU>>() {
      });

    log.info("Loaded {} widget records", widgetList.size());
    return widgetList;
  }

  private void loadMockWidgetData() {
    try {
      List<DtoWidgetIU> widgetList = loadWidgetData();

      for (DtoWidgetIU dtoWidget : widgetList) {
        Widget widget = new Widget();
        widget.setName(dtoWidget.getName());
        widget.setContent(dtoWidget.getContent());
        widget.setDescription(dtoWidget.getDescription());
        widget.setType(dtoWidget.getType());
        widget.setIsActive(dtoWidget.getIsActive());
        widget.setOrderIndex(dtoWidget.getOrderIndex());

        widgetRepository.save(widget);
        log.info("Successfully created widget: {}", widget.getName());
      }

      log.info("Successfully loaded {} widgets", widgetList.size());

    } catch (Exception e) {
      log.error("Error loading widget mock data: ", e);
    }
  }
}

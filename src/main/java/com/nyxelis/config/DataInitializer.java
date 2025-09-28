package com.nyxelis.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nyxelis.dto.DtoBanner;
import com.nyxelis.dto.DtoComponent;
import com.nyxelis.dto.DtoPage;
import com.nyxelis.dto.DtoSeoInfo;
import com.nyxelis.entity.Banner;
import com.nyxelis.entity.ComponentBanner;
import com.nyxelis.entity.Page;
import com.nyxelis.entity.SeoInfo;
import com.nyxelis.entity.id.ComponentBannerId;
import com.nyxelis.enums.ComponentType;
import com.nyxelis.repository.ComponentRepository;
import com.nyxelis.repository.PageRepository;
import com.nyxelis.repository.BannerRepository;
import com.nyxelis.repository.ComponentBannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final PageRepository pageRepository;
    private final ComponentRepository componentRepository;
    private final BannerRepository bannerRepository;
    private final ComponentBannerRepository componentBannerRepository;

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
}

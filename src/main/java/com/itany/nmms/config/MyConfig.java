package com.itany.nmms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    //配置直接访问视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/showLogin").setViewName("backend/login");
        registry.addViewController("/showMain").setViewName("backend/main");
        registry.addViewController("/showProductTypeManager").setViewName("backend/productTypeManager");
        registry.addViewController("/showDeptManager").setViewName("backend/deptManager");
        registry.addViewController("/showProductManager").setViewName("backend/productManager");
        registry.addViewController("/showStaffManager").setViewName("backend/staffManager");
        registry.addViewController("/showUserManager").setViewName("backend/userManager");
    }

}

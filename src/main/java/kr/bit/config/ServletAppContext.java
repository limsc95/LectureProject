package kr.bit.config;

import kr.bit.mapper.UserMapper;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.dao")
@ComponentScan("kr.bit.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {

    @Value("${db.classname}")
    private String db_classname;

    @Value("${db.url}")
    private String db_url;

    @Value("${db.username}")
    private String db_username;

    @Value("${db.password}")
    private String db_password;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName(db_classname);
        source.setUrl(db_url);
        source.setUsername(db_username);
        source.setPassword(db_password);

        return source;
    }

    @Bean
    public SqlSessionFactory factory(BasicDataSource source) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(source);

        SqlSessionFactory factory = factoryBean.getObject();
        return factory;
    }

    @Bean
    public MapperFactoryBean<UserMapper> user_mapper(SqlSessionFactory factory) throws Exception {
        MapperFactoryBean<UserMapper> fac = new MapperFactoryBean<>(UserMapper.class);
        fac.setSqlSessionFactory(factory);
        return fac;
    }

//    // 인터셉터 등록
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
//
//        TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService,loginBean);
//        InterceptorRegistration registration1 = registry.addInterceptor(topMenuInterceptor);
//        registration1.addPathPatterns("/**"); // 모든 경로를 매핑해도 다 뜨도록 .. 컨트롤 전에 preHandle
//
//        // 로그인 여부 알아내서 로그인이 안되어있으면 user/not_login으로 강제이동
//        LoginInterceptor loginInterceptor = new LoginInterceptor(loginBean);
//        InterceptorRegistration registration2 = registry.addInterceptor(loginInterceptor);
//        registration2.addPathPatterns("/user/modify","/user/logout","/board/*");
//        registration2.excludePathPatterns("/board/main");
//
//        WriterInterceptor writerInterceptor = new WriterInterceptor(loginBean,boardService);
//        InterceptorRegistration registration3 = registry.addInterceptor(writerInterceptor);
//        registration3.addPathPatterns("/board/delete","/board/modify");
//    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    // properties 파일에 있는 값을 뷰에 출력하기 위해
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource res=new ReloadableResourceBundleMessageSource();
        res.setDefaultEncoding("UTF-8");
        res.setBasenames("/WEB-INF/properties/error");
        return res;
    }
}



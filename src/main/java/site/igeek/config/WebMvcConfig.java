package site.igeek.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import site.igeek.utils.GsonUtils;

import java.util.List;


/**
 * Created by jacobdong on 16/1/12.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        //registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(createGsonHttpMessageConverter());
        super.configureMessageConverters(converters);
        //LOGGER.info("# 添加GSON 支持结束");
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public static GsonHttpMessageConverter createGsonHttpMessageConverter() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonUtils.GSON);
        return converter;
    }
}

package com.lzc.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lzc 2018/11/11
 * 配置生成swagger API
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     */
    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/
    @Bean
    public Docket createRestApi() {
        /**
         * 定义相应响信息
         */
        Map<String, Header> headerMap = new HashMap<>();
        //400为错误码，要在swagger显示错误码和错误信息
        headerMap.put("X-Error-Code", new Header("错误码", "", new ModelRef("String")));
        headerMap.put("X-Error-Message", new Header("错误消息", "", new ModelRef("String")));
        //有疑问？？？
        List<ResponseMessage> messages = Lists.newArrayList(
                new ResponseMessage(200, "OK", new ModelRef("void"), Collections.emptyMap(), Collections.emptyList()),
                new ResponseMessage(400, "Bad Request", new ModelRef("void"), headerMap, Collections.emptyList())
        );
        return new Docket(DocumentationType.SWAGGER_2)//swagger版本
                .select()//启动一个用于api选择的构建器
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//如果用Api.class则是配置要权限的swagger
                .build()//对于有Api注解的所有类生成swagger
                .ignoredParameterTypes(groovy.lang.MetaClass.class)//对于grovvy类不生成swagger
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, messages)//为特定的api操作设置特定的响应消息
                .globalResponseMessage(RequestMethod.POST, messages)//为特定的api操作设置特定的响应消息
                .globalResponseMessage(RequestMethod.PUT, messages)//为特定的api操作设置特定的响应消息
                .globalResponseMessage(RequestMethod.DELETE, messages)//为特定的api操作设置特定的响应消息*/
                .apiDescriptionOrdering(new Ordering<ApiDescription>() {
                    @Override
                    public int compare(ApiDescription left, ApiDescription right) {
                        return left.getDescription().compareTo(right.getDescription());
                    }
                })//对于api描述的排序
                //.securitySchemes(Lists.newArrayList(new ApiKey("X-Auth-Token", "X-Auth-Token", "header")))//权限
                .apiInfo(apiInfo());
        /*return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();*/
    }

    private ApiInfo apiInfo() {

        return new ApiInfo("TEST API",
                "提供给前端的接口",
                "",
                "",
                new Contact("", "", ""),
                "",
                "",
                Collections.emptyList());
    }
}

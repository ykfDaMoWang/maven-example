package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
* @Api()用于类:表示标识这个类是swagger的资源       value–路径值  tags–如果设置这个值、value的值会被覆盖
* @ApiOperation()用于方法:表示一个http请求的操作   value–路径值   notes用于提示内容   tags可以重新分组（视情况而用） 
* @ApiParam()用于方法，参数，字段说明:表示对参数的添加元数据（说明或是否必填等）  name–参数名 value–参数说明  required–是否必填
* @ApiModel()用于类 :表示对类进行说明，用于参数用实体类接收  value–表示对象名  description–描述 
* @ApiModelProperty()用于方法，字段 :表示对model属性的说明或者数据操作更改  value–字段说明  name–重写属性名字  dataType–重写属性类型  required–是否必填  example–举例说明  hidden–隐藏
* @ApiIgnore()用于类，方法，方法参数 :表示这个方法或者类被忽略 
* @ApiImplicitParam() 用于方法 :表示单独的请求参数 
* @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam  name–参数ming  value–参数说明  dataType–数据类型  paramType–参数类型  example–举例说明
*/
/*重要！如果你的项目引入junit测试，此处需要使用@WebAppConfiguration，如果没有使用junit使用@Configuration(很多的博客都没有注明这个问题，为此我花了非常多的时间解决问题)*/
@WebAppConfiguration
@EnableSwagger2//重要！
@EnableWebMvc
@ComponentScan(basePackages = "com.web.control")//扫描control所在的package请修改为你control所在package
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
    	Contact contact=new Contact("ykf",
    	          "http://www.jianshu.com/u/f192766abeab","547255628@qq.com");
        return new ApiInfoBuilder()
                .title("XXX项目接口文档")//大标题
                .description("XXX项目接口测试")//小标题
                .version("1.0.0")//版本号
                .contact(contact)
                .build();//
    }
}
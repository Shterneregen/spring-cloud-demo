package random.guestservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class GuestServicesApplication {

    private static final String CONTACT_NAME = "shterneregen";
    private static final String GROUP_NAME = "Guest";
    private static final String BASE_PACKAGE = "random.guestservices";
    private static final String API_INFO_TITLE = "Guest Services";
    private static final String API_INFO_DESCRIPTION = "A set of services to provide data access to guests";
    private static final String API_INFO_VERSION = "1.0.0";

    @Bean
    public Docket api() {
        Contact contact = new Contact(CONTACT_NAME, null, null);
        return new Docket(DocumentationType.SWAGGER_2).groupName(GROUP_NAME).select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(any()).build().apiInfo(new ApiInfo(API_INFO_TITLE, API_INFO_DESCRIPTION, API_INFO_VERSION,
                        null, contact, null, null, new ArrayList<>()));
    }

    public static void main(String[] args) {
        SpringApplication.run(GuestServicesApplication.class, args);
    }
}

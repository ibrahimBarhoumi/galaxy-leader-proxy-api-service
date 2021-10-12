package fr.lovotech.galaxy.leader.proxy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = "com.lovotech.fr.gxld.core.bean.cra.domain")
@EnableZuulProxy
@EnableSwagger2
@EnableJpaAuditing
public class ProxyApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApiServiceApplication.class, args);
    }

}

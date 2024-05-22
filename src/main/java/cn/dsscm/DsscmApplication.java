package cn.dsscm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("cn.dsscm.dao")
public class DsscmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsscmApplication.class, args);
	}

}

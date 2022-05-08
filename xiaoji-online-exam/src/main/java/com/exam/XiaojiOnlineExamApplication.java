package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class XiaojiOnlineExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaojiOnlineExamApplication.class, args);
    }

}


package com.example.demo;

import com.user.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads(){
        System.out.println();
    }

}

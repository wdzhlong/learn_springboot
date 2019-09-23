package com.learn.springboot;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpringbootLearnApplicationTests {



    @Test
    public void contextLoads() {

    }


}

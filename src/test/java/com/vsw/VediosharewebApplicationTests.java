package com.vsw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VediosharewebApplicationTests {

    @Test
    public void contextLoads() {
        String originalName = "WechatIMG10.png";

        int index = originalName.lastIndexOf(".");


        String resetName = originalName.substring(0, index);

        String suffix = originalName.substring(index);

        String realName = resetName.hashCode() + suffix;
        System.out.println(realName);

    }

}

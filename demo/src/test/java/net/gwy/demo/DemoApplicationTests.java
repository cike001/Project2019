package net.gwy.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

         RestResponse s =  get();


        Integer st = 0;


    }

    public RestResponse get() {
        RestResponse rr = new RestResponse();
        rr.setStatus(EnumStatus.FAILURE);
        return rr;
    }

}

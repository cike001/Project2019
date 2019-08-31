package net.gwy.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author gwy
 * @time 2019-08-28 17:57
 * @desc TODO
 **/
@Service
public class BusiService{

    @Autowired
    RateLimiterService rateLimiterService;


    public void show(){

        if(rateLimiterService.tryAcquire()){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = new Random().nextInt(100);
            System.out.println(num);
        }else {
            System.out.println("error......");
        }

    }

}

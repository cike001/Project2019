package net.gwy.ratelimiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author gwy
 * @time 2019-08-28 17:49
 * @desc 限流
 **/
@RestController
@RequestMapping("/rateLimiter")
public class TestController {

    @Autowired
    BusiService busiService;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @RequestMapping("/info")
    public void info(){
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    busiService.show();
                }
            });
        }
        executorService.shutdown();
    }
}

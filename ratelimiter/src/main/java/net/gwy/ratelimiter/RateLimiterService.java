package net.gwy.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

/**
 * @author gwy
 * @time 2019-08-28 17:46
 * @desc TODO
 **/
@Service
public class RateLimiterService {

    RateLimiter limiter = RateLimiter.create(5);

    public boolean tryAcquire(){
        return limiter.tryAcquire();
    }



}

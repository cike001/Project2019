package net.gwy.docker.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gwy
 * @time 2019-08-25 18:17
 * @desc TODO
 **/
@RestController
@RequestMapping("/docker")
public class DockerController {

    @RequestMapping("/info")
    public String info(){
        System.out.println("======");
        return "hello docker";
    }

}

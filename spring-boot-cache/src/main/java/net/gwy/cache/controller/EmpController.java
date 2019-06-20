package net.gwy.cache.controller;

import lombok.extern.slf4j.Slf4j;
import net.gwy.cache.domain.Employee;
import net.gwy.cache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiyang
 * @date 2019-05-04
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/emp/get/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        log.info("getEmp:{}",id);
        return empService.getEmpById(id);
    }


}

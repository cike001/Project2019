package net.gwy.cache.service;

import net.gwy.cache.domain.Employee;
import net.gwy.cache.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author guoweiyang
 * @date 2019-05-04
 */
@Service
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    @Cacheable(value = "emp",key = "#id")
    public Employee getEmpById(Integer id){
        System.out.println("getEmpById:"+id);
        return empMapper.getEmpById(id);
    }

}


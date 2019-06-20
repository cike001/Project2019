package net.gwy.cache.mapper;

import net.gwy.cache.domain.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author guoweiyang
 * @date 2019-05-04
 */

@Mapper
public interface EmpMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

}

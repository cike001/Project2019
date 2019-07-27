package net.gwy.mybatisplusgenerator.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-07-27
 */
@Component
public class AutoGeneratorBean implements InitializingBean {

    @Autowired
    AutoGeneratorConfigFactoryBean autoGeneratorConfigFactoryBean;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("代码生成已开始执行。。。。");
        AutoGenerator object = autoGeneratorConfigFactoryBean.getObject();
        object.execute();
        System.out.println("代码生成已执行完毕。。。。");
    }
}

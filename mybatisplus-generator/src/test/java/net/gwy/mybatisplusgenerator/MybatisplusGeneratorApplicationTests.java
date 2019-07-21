package net.gwy.mybatisplusgenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusGeneratorApplicationTests {

    @Test
    public void contextLoads() {

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setFileOverride(true)
                .setAuthor("guoweiyang")
                .setOutputDir("E:\\project\\Project2019\\mybatisplus-generator\\src\\main\\java")
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.AUTO)
                .setSwagger2(true)
                .setServiceName("%sService");

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root")
                .setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel)
                .setCapitalMode(true)
                .setTablePrefix("tb_")
                .setInclude("tb_user");

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("net.gwy.mybatisplusgenerator")
                .setController("controller")
                .setService("service")
                .setMapper("mapper")
                .setEntity("model")
                .setXml("mapper");

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };


        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        autoGenerator.setCfg(cfg);
        autoGenerator.execute();


    }

}

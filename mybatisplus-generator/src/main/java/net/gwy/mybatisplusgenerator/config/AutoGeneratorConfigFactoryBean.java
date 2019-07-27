package net.gwy.mybatisplusgenerator.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import net.gwy.mybatisplusgenerator.bean.GeneratorBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guoweiyang
 * @date 2019-07-27
 */
@Component
public class AutoGeneratorConfigFactoryBean implements FactoryBean<AutoGenerator> {

    @Autowired
    GeneratorBean generatorBean;

    @Override
    public AutoGenerator getObject() throws Exception {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setFileOverride(true)
                .setAuthor(generatorBean.getAuthor())
                .setOutputDir(generatorBean.getOutputDir())
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setIdType(IdType.AUTO)
                .setSwagger2(true)
                .setServiceName("%sService");

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        DbType dbType = DbType.MYSQL;
        if("mysql".equals(generatorBean.getDbType())){
            dbType = DbType.MYSQL;
        }
        else if("mariadb".equals(generatorBean.getDbType())){
            dbType = DbType.MARIADB;
        }
        else if("oracle".equals(generatorBean.getDbType())){
            dbType = DbType.ORACLE;
        }
        else if("db2".equals(generatorBean.getDbType())){
            dbType = DbType.DB2;
        }
        else if("h2".equals(generatorBean.getDbType())){
            dbType = DbType.H2;
        }
        else if("hsql".equals(generatorBean.getDbType())){
            dbType = DbType.HSQL;
        }
        else if("sqlite".equals(generatorBean.getDbType())){
            dbType = DbType.SQLITE;
        }
        else if("postgresql".equals(generatorBean.getDbType())){
            dbType = DbType.POSTGRE_SQL;
        }
        else if("sqlserver2005".equals(generatorBean.getDbType())){
            dbType = DbType.SQL_SERVER2005;
        }
        else if("sqlserver".equals(generatorBean.getDbType())){
            dbType = DbType.SQL_SERVER;
        }
        dataSourceConfig.setDbType(dbType)
                .setDriverName(generatorBean.getDriverName())
                .setUsername(generatorBean.getUsername())
                .setPassword(generatorBean.getPassword())
                .setUrl(generatorBean.getUrl());


        String tables = generatorBean.getInclude();
        String[] arrTable = tables.split(",");


        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel)
                .setCapitalMode(true)
                .setTablePrefix(generatorBean.getTablePrefix())
                .setInclude(arrTable);

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(generatorBean.getBasePackage())
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
        return autoGenerator;
    }

    @Override
    public Class<?> getObjectType() {
        return AutoGenerator.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}

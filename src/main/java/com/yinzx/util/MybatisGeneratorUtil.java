package com.yinzx.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorUtil {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        try(InputStream is = MybatisGeneratorUtil.class.getResourceAsStream("/generatorConfig.xml")){
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(is);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            for(String warning : warnings)
                System.out.println(warning);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

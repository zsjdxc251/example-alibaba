package com.lesson.alibaba.cloud.nacos.config.provider.environment;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

/**
 * @author zhengshijun
 * @version created on 2018/11/20.
 */
@Repository
public class CustomEnvironmentRepository implements EnvironmentRepository {







    @Override
    public Environment findOne(String application, String profile, String label) {

        StringBuilder fileBuilder = new StringBuilder(application);

        if (StringUtils.isNotBlank(profile)){
            fileBuilder.append("-").append(profile);
        }
        fileBuilder.append(".properties");
        Resource resource = new ClassPathResource(fileBuilder.toString());


        Properties properties = new Properties();
        try {
            // 如果是文本 new StringReader();
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Environment environment = new Environment(application,profile);
        environment.add(new PropertySource(fileBuilder.toString(),properties));


        return environment;
    }
}

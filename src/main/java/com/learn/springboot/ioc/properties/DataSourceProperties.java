package com.learn.springboot.ioc.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: zhenghailong
 * @date: 2019/9/20 17:50
 * @modified By:
 * @description:
 * @
 */

/**
 * @ConfigurationProperties:读取属性文件，其valur与bean定义的属性名称组个属性文件的名字
 * 需要结合@EnableConfigurationProperties一起使用
 */
@Component
@ConfigurationProperties(value = "datasource")
public class DataSourceProperties {
    /**
     * @Value用于读取属性文件配置的值
     */
    //@Value("${datasource.url}")
    private String url;

    //@Value("${datasource.username}")
    private String username;

    //@Value("${datasource.password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println(username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println(password);
        this.password = password;
    }
}

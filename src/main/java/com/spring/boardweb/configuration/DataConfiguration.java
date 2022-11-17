package com.spring.boardweb.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
gsdfgerqwt235234erdfg
//�씠 �겢�옒�뒪瑜� �꽕�젙�뙆�씪濡� �씫�뼱�뱶由щ뒗 �뼱�끂�뀒�씠�뀡
@Configuration
//�꽕�젙�궡�슜�쓣 �뼱�뒓 �뙆�씪�뿉�꽌 �씫�뼱�삱 寃껋씤吏� 寃곗젙
//classpath: src/main/resource
@PropertySource("classpath:/application.properties")
public class DataConfiguration {
	//Bean媛앹껜濡� �깮�꽦�빐二쇰뒗 �뼱�끂�뀒�씠�뀡
	@Bean
	//applictaion.properties �뙆�씪�뿉�꽌 spring.datasource.hikari濡� �떆�옉�븯�뒗 �꽕�젙�뱾留� �씫�뼱�삤�뒗 �꽕�젙
	@ConfigurationProperties(prefix="spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
	@Bean
	@ConfigurationProperties(prefix="spring.jpa")
	public Properties hibernateConfig() {
		return new Properties();
	}
}

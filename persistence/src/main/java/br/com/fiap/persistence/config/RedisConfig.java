package br.com.fiap.persistence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;
import java.util.List;

@Configuration
@EnableCaching
public class RedisConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        System.out.println("------------------ configureMessageConverters");
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.indentOutput(true);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        System.out.println("------------------ redisConnectionFactory");
        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
        redisConf.setHostName(env.getProperty("redis.host"));
        redisConf.setPort(Integer.parseInt(env.getProperty("redis.port")));
        redisConf.setPassword(RedisPassword.of(env.getProperty("redis.password")));
        return new JedisConnectionFactory(redisConf);
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        System.out.println("------------------ cacheManager");
        RedisCacheManager rcm = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(RedisCacheConfiguration
                        .defaultCacheConfig()
                        .prefixCacheNameWith("fi.app-")
                        .entryTtl(Duration.ofSeconds(60)))
                .build();
        rcm.setTransactionAware(true);
        return rcm;
    }

}

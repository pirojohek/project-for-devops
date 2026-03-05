//package by.pirog.project_for_devops.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//import java.time.Duration;
//import java.util.Map;
//
//@Configuration
//public class CacheConfig {
//
//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory cf) {
//        RedisCacheConfiguration cfg = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
//                        new GenericJackson2JsonRedisSerializer()))
//                .entryTtl(Duration.ofMinutes(10))
//                .disableCachingNullValues();
//        return RedisCacheManager.builder(cf).cacheDefaults(cfg).build();
//    }
//}

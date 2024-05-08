package com.example.distributeddatabase.Config;


import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
//
//@Configuration
//@EnableScheduling
//public class CacheConfig {
//
//    /**
//     * Defines a bean method to configure a Hazelcast instance and cache.
//     *
//     * @return A Config object containing Hazelcast configuration.
//     */
//    @Bean
//    public Config configure() {
//        return new Config()
//                // Set the name of the Hazelcast instance (helpful for identification)
//                .setInstanceName("hazelcast-instance")
//                .addMapConfig(new MapConfig()
//                        // Set the name of the cache
//                        .setName("userCache")
//                        // Set maximum size as a percentage of free heap memory
//                        .setEvictionConfig(new EvictionConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
//                                // Set eviction policy to Least Recently Used (LRU)
//                                .setEvictionPolicy(EvictionPolicy.LRU)
//                                // Set initial size estimate for the cache (number of entries)
//                                .setSize(200))
//                        // Set Time To Live for cache entries (seconds)
//                        .setTimeToLiveSeconds(2000));
//    }
//}


@Configuration
@EnableScheduling
public class CacheConfig {

    @Bean
    public Config configure() {
        Config config = new Config()
                .setInstanceName("hazelcast-instance");

        // User Cache Configuration
        config.addMapConfig(new MapConfig()
                .setName("userCache")
                .setEvictionConfig(new EvictionConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        .setSize(200)));
//                .setTimeToLiveSeconds(2000));

        // Student Cache Configuration
//        config.addMapConfig(new MapConfig()
//                .setName("studentCache")
//                .setEvictionConfig(new EvictionConfig().setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE)
//                        .setEvictionPolicy(EvictionPolicy.LRU)
//                        .setSize(500))
//                .setTimeToLiveSeconds(70));

        return config;
    }
}


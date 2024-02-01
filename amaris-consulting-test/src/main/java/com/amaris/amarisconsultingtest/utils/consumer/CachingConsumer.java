package com.amaris.amarisconsultingtest.utils.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class CachingConsumer {

    private final CacheManager cacheManager;
    private final ApiConsumer apiConsumer;

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws InterruptedException {
        apiConsumer.getAllEmployees();
        log.info("Cache loaded");
    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void updateCharacterCaching() throws InterruptedException {
        log.info("Cleaning cache");
        cacheManager.getCache("employees").clear();
        init();
    }
}

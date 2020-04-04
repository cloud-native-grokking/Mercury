package com.cloudnative.grokking.mercury;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;

import javax.annotation.PostConstruct;
import java.util.Arrays;


/**
 * @author nghiatn
 */


@Slf4j
@SpringBootApplication // scan all components in the same package with MavenResearch
@PropertySource(ignoreResourceNotFound = true, value = "classpath:git.properties")
public class Mercury {

    @Value("${git.commit.id:UNKNOWN}")
    private String commitId;
    @Value("${git.build.version:UNKNOWN}")
    private String buildVersion;
    @Value("${git.tags:NONE}")
    private String tags;

    @PostConstruct
    protected void logGitInfo() {
        log.info("========================================================");
        log.info("  APP VERSION: {}", buildVersion);
        log.info("  GIT VERSION: {}", commitId);
        log.info("      GIT TAG: {}", tags);
        log.info("========================================================");
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        final Environment env = event.getApplicationContext().getEnvironment();
        log.info("========================================================");
        log.info("  ACTIVE PROFILES");
        log.info("  {}", Arrays.toString(env.getActiveProfiles()));
        log.info("========================================================");
        log.info("  APP PROPERTIES ");
        log.info("========================================================");
        final MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        log.info("========================================================");
    }

    public static void main(String[] args) {
        SpringApplication.run(Mercury.class, args);
        log.info("MERCURY IS LAUNCHED!!!!!!!");
    }
}

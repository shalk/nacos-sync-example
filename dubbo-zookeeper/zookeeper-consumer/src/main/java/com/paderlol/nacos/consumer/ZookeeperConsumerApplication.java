package com.paderlol.nacos.consumer;

import com.paderlol.nacos.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author paderlol
 */
@SpringBootApplication
public class ZookeeperConsumerApplication implements ApplicationRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ZookeeperConsumerApplication.class);

    @Reference(version = "${demo.service.version}", group = "${demo.service.group}")
    private DemoService nacosDemoService;

    public static void main(String[] args) {
        SpringApplication.run(ZookeeperConsumerApplication.class).close();
    }

    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 20; i++) {
            LOG.info(nacosDemoService.sayHello("This is from Nacos to Zookeeper Sync !"));
        }
    }
}

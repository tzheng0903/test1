package cn.evun.kafka.t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
@RestController
public class T1Application {

    public static void main(String[] args) {
        SpringApplication.run(T1Application.class, args);
    }

//    @Autowired
//    private KafkaTemplate kafkaTemplate;

    @GetMapping("/test")
    public Object test() {


        return "OK";
    }

}

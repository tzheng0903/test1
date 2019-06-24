package cn.evun.kafka.t1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
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

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/test")
    public Object test() throws InterruptedException, ExecutionException {

        Executor executor = Executors.newFixedThreadPool(100);
        CountDownLatch cdl = new CountDownLatch(100);
        for(int i = 0;i<100;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for(int i = 0 ;i<1000;i++){
                        ListenableFuture send = kafkaTemplate.send("my-topic", "data:" + System.currentTimeMillis());
                    }
                }
            });
            cdl.countDown();
        }
        return "OK";
    }

}

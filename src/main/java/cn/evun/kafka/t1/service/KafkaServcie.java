package cn.evun.kafka.t1.service;

//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class KafkaServcie {

    AtomicInteger i = new AtomicInteger(0);

//    @KafkaListener(topics = "my-topic")
    public void listnerMethod(String content){
        i.incrementAndGet();
        System.out.println( i +content);
    }

}

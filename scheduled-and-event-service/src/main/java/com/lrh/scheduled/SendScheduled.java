package com.lrh.scheduled;

import com.lrh.support.SendEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class SendScheduled {

    private Map<String, String> sendMaps = new ConcurrentHashMap<>();

    @EventListener(classes = SendEvent.class)
    public void addSender(SendEvent sendEvent){
        sendMaps.put(sendEvent.getSender(), sendEvent.getSender());
    }


    @Scheduled(fixedDelay = 1000)
    public void  getSend(){
        if(sendMaps.isEmpty()){
            return;
        }else{
            sendMaps.forEach((k,v)->{
                log.info("sender is {}",v);
                sendMaps.remove(k);});
        }



    }




}

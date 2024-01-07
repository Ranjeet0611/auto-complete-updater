package com.autocompleteupdater.scheduler;


import com.autocompleteupdater.model.CompleteSearch;
import com.autocompleteupdater.repository.AutoCompleteRepository;
import com.autocompleteupdater.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class MapJobScheduler {

    @Autowired
    private AutoCompleteRepository autoCompleteRepository;

    @Autowired
    private MapService mapService;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${spring.kafka.topic}")
    private String topic;
    @Scheduled(cron = "0 */2 * * * *")
    public void createPrefixMap(){
        try{
            log.info("Start createPrefixMap");
            List<CompleteSearch> completeSearchOfTwentyFourHours = autoCompleteRepository.getCompleteSearchOfTwentyFourHours();
            if(CollectionUtils.isEmpty(completeSearchOfTwentyFourHours)){
                return;
            }
            Map<String, String> prefixMap = mapService.createPrefixMap(completeSearchOfTwentyFourHours);
            kafkaTemplate.send(topic,prefixMap);
        }
        catch (Exception e){
            log.error("Exception occurred while createPrefixMap :{}",e.getMessage(),e);
        }
    }
}

package com.minami.timeoff.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.minami.timeoff.event.model.EventDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final WebClient webClient;

    @Value("${api-key}")
    private String apiKey;

    public List<EventDto> getEventByAreaCode(String areaCode) throws JsonProcessingException {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String json = webClient.get().uri(uriBuilder -> uriBuilder.path("/searchFestival1")
                        .queryParam("_type", "json")
                        .queryParam("MobileOS", "ETC")
                        .queryParam("MobileApp", "TimeOff")
                        .queryParam("eventStartDate", today)
                        .queryParam("eventEndDate", today)
                        .queryParam("areaCode", areaCode)
                        .queryParam("arrange", "C")
                        .queryParam("numOfRows", 100)
                        .queryParam("serviceKey", apiKey)
                        .build()
                ).retrieve().bodyToMono(String.class)
                .block();

        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jsonNode = om.readTree(json);

        List<EventDto> eventList = om.convertValue(jsonNode.at("/response/body/items/item"), new TypeReference<>() {});
        eventList.sort(Comparator.comparing(EventDto::getStartDate).reversed());
        eventList.forEach(eventDto -> log.info("e: {}", eventDto));

        if (eventList.size() > 4) {
            eventList = eventList.subList(0, 4);
        }
        return eventList;
    }
}

package com.minami.timeoff.recoEvent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.minami.timeoff.recoEvent.model.EventDto;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("reco-event")
public class RecoEventController {
    private final RecoEventService service;

    @GetMapping("{areaCode}")
    public List<EventDto> getEventByAreaCode(@PathVariable @Parameter(description = "지역코드", example = "1") String areaCode) throws JsonProcessingException, UnsupportedEncodingException {
        return service.getEventByAreaCode(areaCode);
    }
}

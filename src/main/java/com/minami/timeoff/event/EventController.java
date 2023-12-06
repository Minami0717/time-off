package com.minami.timeoff.event;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.minami.timeoff.event.model.EventDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("event")
public class EventController {
    private final EventService service;

    @Operation(summary = "지역별 진행 중인 행사 목록")
    @GetMapping("{areaCode}")
    public List<EventDto> getEventByAreaCode(@PathVariable @Parameter(description = "지역코드", example = "1") String areaCode) throws Exception {
        return service.getEventByAreaCode(areaCode);
    }
}

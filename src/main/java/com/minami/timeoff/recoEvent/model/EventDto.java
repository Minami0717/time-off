package com.minami.timeoff.recoEvent.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class EventDto {
    private String title;
    private String startDate;
    private String endDate;
    private String address;
    private String img;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("eventstartdate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("eventenddate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("addr1")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("firstimage")
    public void setImg(String img) {
        this.img = img;
    }
}

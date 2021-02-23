package com.coursedash.client.repository.filter;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class LacamentFilter {
    private String describe;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataVencFrom;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private LocalDate dataVencAt;

    public String getDescribe() {
        return this.describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public LocalDate getDataVencFrom() {
        return this.dataVencFrom;
    }

    public void setDataVencFrom(LocalDate dataVencFrom) {
        this.dataVencFrom = dataVencFrom;
    }

    public LocalDate getDataVencAt() {
        return this.dataVencAt;
    }

    public void setDataVencAt(LocalDate dataVencAt) {
        this.dataVencAt = dataVencAt;
    }

}

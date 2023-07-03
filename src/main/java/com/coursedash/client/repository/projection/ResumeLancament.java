package com.coursedash.client.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.coursedash.client.enumerate.TypeLancament;

public class ResumeLancament {

    public ResumeLancament(Long id, String desc, LocalDate datevenc, LocalDate datepay, BigDecimal value, TypeLancament type, String category, String person) {
        this.id = id;
        this.desc = desc;
        this.datevenc = datevenc;
        this.datepay = datepay;
        this.value = value;
        this.type = type;
        this.category = category;
        this.person = person;
    }

    private Long id;
    private String desc;
    private LocalDate datevenc;
    private LocalDate datepay;
    private BigDecimal value;
    private TypeLancament type;
    private String category;
    private String person;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDatevenc() {
        return this.datevenc;
    }

    public void setDatevenc(LocalDate datevenc) {
        this.datevenc = datevenc;
    }

    public LocalDate getDatepay() {
        return this.datepay;
    }

    public void setDatepay(LocalDate datepay) {
        this.datepay = datepay;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public TypeLancament getType() {
        return this.type;
    }

    public void setType(TypeLancament type) {
        this.type = type;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPerson() {
        return this.person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    
}

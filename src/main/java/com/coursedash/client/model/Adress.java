package com.coursedash.client.model;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {
    private String city;
    private String statey;
    private String zipcode;
    private String housenumber;
    private String logradouro;
    private String neiberhood;
    private String complement;

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatey() {
        return this.statey;
    }

    public void setStatey(String statey) {
        this.statey = statey;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHousenumber() {
        return this.housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNeiberhood() {
        return this.neiberhood;
    }

    public void setNeiberhood(String neiberhood) {
        this.neiberhood = neiberhood;
    }

}

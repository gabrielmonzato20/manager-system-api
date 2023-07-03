package com.coursedash.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "ROLES")
public class Role {
@Id
private Long id;

@Column(name = "NAMEROLE")
private String description;




public Long getId() {
    return this.id;
}

public void setId(Long id) {
    this.id = id;
}


public String getDescription() {
    return this.description;
}

public void setDescription(String description) {
    this.description = description;
}

}

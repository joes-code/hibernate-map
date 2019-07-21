package com.joe.example.hibernate_map.test.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "asset_detail")
public class AssetDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssetDetailId id;

    @Column(name = "description", length = 35)
    private String description;

    public AssetDetailId getId() {
        return id;
    }

    public void setId(AssetDetailId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

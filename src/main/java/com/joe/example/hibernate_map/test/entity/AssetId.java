package com.joe.example.hibernate_map.test.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssetId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "asset_id", nullable = false)
    private Integer assetId;

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AssetId assetId1 = (AssetId) o;
        return assetId.equals(assetId1.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId);
    }
}

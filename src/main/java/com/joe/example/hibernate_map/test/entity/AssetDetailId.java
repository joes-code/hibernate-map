package com.joe.example.hibernate_map.test.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssetDetailId implements Serializable {

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
        AssetDetailId that = (AssetDetailId) o;
        return assetId.equals(that.assetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetId);
    }
}

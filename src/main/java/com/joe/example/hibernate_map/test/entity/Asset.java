package com.joe.example.hibernate_map.test.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "asset")
public class Asset implements Serializable  {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AssetId id;

    @Column(name = "asset_cost")
    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_detail_id", referencedColumnName = "asset_id",  insertable = false,foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private AssetDetail assetDetail;

    public AssetDetail getAssetDetail() {
        return assetDetail;
    }

    public void setAssetDetail(AssetDetail assetDetail) {
        this.assetDetail = assetDetail;
    }

    public AssetId getId() {
        return id;
    }

    public void setId(AssetId id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}

package com.cg.model;

import com.cg.model.dto.LocationRegionDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Table(name = "location_region")
@Entity
@Data
@Accessors(chain = true)
public class LocationRegion {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String provinceName;

    @Column(nullable = false)
    private String districtId;

    @Column(nullable = false)
    private String districtName;

    @Column(nullable = false)
    private String wardId;

    @Column(nullable = false)
    private String wardName;

    @Column(nullable = false)
    private String address;


    @OneToOne(mappedBy = "locationRegion")
    private Customer customer;


    @Override
    public String toString() {
        return "LocationRegion{" +
                "id=" + id +
                ", provinceId='" + provinceId + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", districtId='" + districtId + '\'' +
                ", districtName='" + districtName + '\'' +
                ", wardId='" + wardId + '\'' +
                ", wardName='" + wardName + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }

    public LocationRegionDTO toLocationRegionDTO() {
        return new LocationRegionDTO().setId(id)
                .setProvinceId(provinceId)
                .setProvinceName(provinceName)
                .setDistrictId(districtId)
                .setDistrictName(districtName)
                .setWardId(wardId)
                .setWardName(wardName)
                .setAddress(address);
    }
}

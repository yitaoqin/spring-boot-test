package com.example.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clinic")
public class Clinic extends BaseEntity{
    @Id  private String id;
    private String clinicName;
    private String province;

    @Column(name = "city")
    private String city;
    private String county;
    private String status;
    //@JSONField(name="birthday",format="yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;
    private Date lastUpdated;
    private String doseRemind;
    private String longitude;
    private String latitude;
    private String promotionAttend;
    private String surplus;
    private String isShowPrice;
    private String image;
    private String codeUrl;
    private String notice;
    private String negativeStock;
    private String initChineseCommodityFlag;
    private String experience;
    private String partnerReceiving;
    private String printTemplateType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return (Date)dateCreated.clone();
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDoseRemind() {
        return doseRemind;
    }

    public void setDoseRemind(String doseRemind) {
        this.doseRemind = doseRemind;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPromotionAttend() {
        return promotionAttend;
    }

    public void setPromotionAttend(String promotionAttend) {
        this.promotionAttend = promotionAttend;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public String getIsShowPrice() {
        return isShowPrice;
    }

    public void setIsShowPrice(String isShowPrice) {
        this.isShowPrice = isShowPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getNegativeStock() {
        return negativeStock;
    }

    public void setNegativeStock(String negativeStock) {
        this.negativeStock = negativeStock;
    }

    public String getInitChineseCommodityFlag() {
        return initChineseCommodityFlag;
    }

    public void setInitChineseCommodityFlag(String initChineseCommodityFlag) {
        this.initChineseCommodityFlag = initChineseCommodityFlag;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPartnerReceiving() {
        return partnerReceiving;
    }

    public void setPartnerReceiving(String partnerReceiving) {
        this.partnerReceiving = partnerReceiving;
    }

    public String getPrintTemplateType() {
        return printTemplateType;
    }

    public void setPrintTemplateType(String printTemplateType) {
        this.printTemplateType = printTemplateType;
    }
}

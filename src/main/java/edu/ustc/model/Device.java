package edu.ustc.model;

public class Device {
    private Integer id;

    private String model;

    private String version;

    private Integer androidVersion;

    private String imei;

    private String androidId;

    private String cpu;

    private Long totalInternalMemory;

    private Long availExternalMemory;

    private Long totalExternalMemory;

    private String displayMetrics;

    private String brand;

    private String manufacture;

    private String product;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(Integer androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Long getTotalInternalMemory() {
        return totalInternalMemory;
    }

    public void setTotalInternalMemory(Long totalInternalMemory) {
        this.totalInternalMemory = totalInternalMemory;
    }

    public Long getAvailExternalMemory() {
        return availExternalMemory;
    }

    public void setAvailExternalMemory(Long availExternalMemory) {
        this.availExternalMemory = availExternalMemory;
    }

    public Long getTotalExternalMemory() {
        return totalExternalMemory;
    }

    public void setTotalExternalMemory(Long totalExternalMemory) {
        this.totalExternalMemory = totalExternalMemory;
    }

    public String getDisplayMetrics() {
        return displayMetrics;
    }

    public void setDisplayMetrics(String displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Device [id=" + id + ", model=" + model + ", version=" + version + ", androidVersion=" + androidVersion
				+ ", imei=" + imei + ", androidId=" + androidId + ", cpu=" + cpu + ", totalInternalMemory="
				+ totalInternalMemory + ", availExternalMemory=" + availExternalMemory + ", totalExternalMemory="
				+ totalExternalMemory + ", displayMetrics=" + displayMetrics + ", brand=" + brand + ", manufacture="
				+ manufacture + ", product=" + product + ", userId=" + userId + "]";
	}
    
    
    
}
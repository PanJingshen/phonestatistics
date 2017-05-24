package edu.ustc.model;

public class UsageStats {
    private Integer id;

    private String packageName;

    private Integer count;

    private Long totalTimeInForeground;

    private Integer deviceId;

    private Boolean hasWakeLock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getTotalTimeInForeground() {
        return totalTimeInForeground;
    }

    public void setTotalTimeInForeground(Long totalTimeInForeground) {
        this.totalTimeInForeground = totalTimeInForeground;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Boolean getHasWakeLock() {
        return hasWakeLock;
    }

    public void setHasWakeLock(Boolean hasWakeLock) {
        this.hasWakeLock = hasWakeLock;
    }

	@Override
	public String toString() {
		return "UsageStats [id=" + id + ", packageName=" + packageName + ", count=" + count + ", totalTimeInForeground="
				+ totalTimeInForeground + ", deviceId=" + deviceId + ", hasWakeLock=" + hasWakeLock + "]";
	}
    
    
}
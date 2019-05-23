package com.ebupt.dto.ebupt.pojo;


/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:42
 * @Description:
 */

public class GroupResourceQuotaEntry {

    private String resourceName;
    private IntValue assignedQuota;
    private IntValue usedQuota;

    @Override
    public String toString() {
        return "GroupResourceQuotaEntry{" +
                "resourceName='" + resourceName + '\'' +
                ", assignedQuota=" + assignedQuota +
                ", usedQuota=" + usedQuota +
                '}';
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public IntValue getAssignedQuota() {
        return assignedQuota;
    }

    public void setAssignedQuota(IntValue assignedQuota) {
        this.assignedQuota = assignedQuota;
    }

    public IntValue getUsedQuota() {
        return usedQuota;
    }

    public void setUsedQuota(IntValue usedQuota) {
        this.usedQuota = usedQuota;
    }
}

package com.ebupt.pojo;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/22 13:37
 * @Description:
 */
public class ServiceQuotaItem {
    private List<ServiceQuota> item;

    @Override
    public String toString() {
        return "ServiceQuotaItem{" +
                "item=" + item +
                '}';
    }

    public List<ServiceQuota> getItem() {
        return item;
    }

    public void setItem(List<ServiceQuota> item) {
        this.item = item;
    }
}

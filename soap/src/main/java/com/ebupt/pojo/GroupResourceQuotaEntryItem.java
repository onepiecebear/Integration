package com.ebupt.pojo;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/22 11:57
 * @Description:
 */
public class GroupResourceQuotaEntryItem {
    private List<GroupResourceQuotaEntry> item;


    @Override
    public String toString() {
        return "GroupResourceQuotaEntryItem{" +
                "item=" + item +
                '}';
    }

    public List<GroupResourceQuotaEntry> getItem() {
        return item;
    }

    public void setItem(List<GroupResourceQuotaEntry> item) {
        this.item = item;
    }
}

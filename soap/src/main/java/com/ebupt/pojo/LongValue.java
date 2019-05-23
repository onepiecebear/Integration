package com.ebupt.pojo;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:32
 * @Description:
 */
public class LongValue {
    private long value;

    @Override
    public String toString() {
        return "LongValue{" +
                "value=" + value +
                '}';
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

package com.ebupt.dto.ebupt.pojo;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 17:43
 * @Description:
 */
public class IntValue {

    private int value;

    @Override
    public String toString() {
        return "IntValue{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

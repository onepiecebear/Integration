package com.ebupt.context;

import com.ebupt.strategy.PayStrategy;
import com.ebupt.strategy.impl.WxPayStrategy;
import com.ebupt.utils.SpringUtils;
import org.springframework.stereotype.Component;

/**
 * @Author: yushibo
 * @Date: 2019/5/12 0012 22:39
 * @Description:
 */
@Component
public class PayContextStrategy {
    public String toPayHtml(String payCode){
        if(payCode == null){
            return "payCode不能为空";
        }
        //通过数据库获得该条数据对象
//        PayMentChannelEntity payMentChannel = p.getp(payCode);
//       String strategyBeanId = payMentChannel.getStrategyBeanID();
         String strategyBeanId = "aliPayStrategy";
        PayStrategy bean = SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        PayStrategy bean1 = (PayStrategy)SpringUtils.getBean(strategyBeanId);
        PayStrategy bean2 = SpringUtils.getBean(WxPayStrategy.class);
        System.out.println(bean.getClass().getName());
        System.out.println(bean1.getClass().getName());
        System.out.println(bean2.getClass().getName());

        return  bean.toPay();
    }
}

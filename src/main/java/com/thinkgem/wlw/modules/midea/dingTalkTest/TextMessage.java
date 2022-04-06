package com.thinkgem.wlw.modules.midea.dingTalkTest;

import com.alibaba.fastjson.JSON;
import com.thinkgem.wlw.common.utils.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhouhe
 * @Date: 2019/6/20 17:25
 */
public class TextMessage {
    private String text;
    private List<String> atMobiles;
    private boolean isAtAll;

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(List<String> atMobiles) {
        this.atMobiles = atMobiles;
    }

    public boolean isAtAll() {
        return isAtAll;
    }

    public void setIsAtAll(boolean isAtAll) {
        this.isAtAll = isAtAll;
    }

    public String toJsonString() {
        Map<String, Object> items = new HashMap();
        items.put("msgtype", "text");

        Map<String, String> textContent = new HashMap();
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("text should not be blank");
        }
        textContent.put("content", text);
        items.put("text", textContent);

        Map<String, Object> atItems = new HashMap();
        if (atMobiles != null && !atMobiles.isEmpty()) {
            atItems.put("atMobiles", atMobiles);
        }
        if (isAtAll) {
            atItems.put("isAtAll", isAtAll);
        }
        items.put("at", atItems);

        return JSON.toJSONString(items);
    }
}
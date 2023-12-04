package com.vikadata.social.feishu.card.objects;

import com.vikadata.social.feishu.card.CardComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Field Component.
 * </p>
 *
 * @author Shawn Deng
 */
public class Field implements CardComponent {

    private boolean isShort;

    private Text text;

    public Field() {
    }

    public Field(Text text, boolean isShort) {
        this.isShort = isShort;
        this.text = text;
    }

    @Override
    public Object toObj() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("is_short", isShort);
        map.put("text", text.toObj());
        return map;
    }
}


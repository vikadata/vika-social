package com.vikadata.social.feishu.event;

import com.vikadata.social.feishu.annotation.FeishuEvent;
import com.vikadata.social.feishu.event.app.*;
import com.vikadata.social.feishu.event.bot.*;

import java.util.HashMap;
import java.util.Map;

/**
 * event parser
 */
public class FeishuEventParser {

    /**
     * The FeishuEvent event name is used as the key, the parser corresponding to each event content,
     * here are all Jackson library conversions
     */
    private static final Map<String, EventParser> EVENT_PARSER_MAP;

    static {
        EVENT_PARSER_MAP = new HashMap<>(16);
        // application event
        registerClassEventParser(AppTicketEvent.class);
        registerClassEventParser(AppOpenEvent.class);
        registerClassEventParser(AppStatusChangeEvent.class);
        registerClassEventParser(AppUninstalledEvent.class);
        registerClassEventParser(OrderPaidEvent.class);

        registerClassEventParser(P2pChatCreateEvent.class);
        registerClassEventParser(AddBotEvent.class);
        BotMessageEventParser parser = new BotMessageEventParser();
        parser.registerTypes(
                TextMessageEvent.class,
                PostMessageEvent.class,
                ImageMessageEvent.class,
                MergeForwardMessageEvent.class,
                FileMessageEvent.class
        );
        registerEventParser(BaseMessageEvent.class.getAnnotation(FeishuEvent.class), parser);
    }

    public static FeishuEventParser create() {
        return new FeishuEventParser();
    }

    private static void registerClassEventParser(Class<? extends BaseEvent> eventClass) {
        FeishuEvent annotation = eventClass.getAnnotation(FeishuEvent.class);
        registerEventParser(annotation, new Jackson2ClassEventParser(eventClass));
    }

    private static void registerEventParser(FeishuEvent eventAnnotation, EventParser eventParser) {
        if (eventAnnotation != null) {
            EVENT_PARSER_MAP.put(eventAnnotation.value(), eventParser);
        }
    }

    public BaseEvent parseEvent(String type, Map<String, Object> data) {
        EventParser parser = EVENT_PARSER_MAP.get(type);
        if (parser == null) {
            return null;
        }
        return parser.parse(data);
    }
}

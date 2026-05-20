package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class LabelModule {
    private final WeChatBotClient client;

    public LabelModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse addLabel(String labelName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("labelName", labelName);
        return client.request("/addLabel", token, payload);
    }

    public ApiResponse listLabel(String token) {
        return client.request("/listLabel", token, new HashMap<>());
    }

    public ApiResponse deleteLabel(String labelIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("labelIds", labelIds);
        return client.request("/deleteLabel", token, payload);
    }

    public ApiResponse modifyFriendLabel(String labelIds, List<String> wxIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("labelIds", labelIds);
        payload.put("wxIds", wxIds);
        return client.request("/modifyMemberList", token, payload);
    }
}

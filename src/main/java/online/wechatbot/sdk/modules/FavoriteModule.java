package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.HashMap;
import java.util.Map;

public class FavoriteModule {
    private final WeChatBotClient client;

    public FavoriteModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse syncFavorite(String syncKey, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("syncKey", syncKey);
        return client.request("/syncFavorite", token, payload);
    }

    public ApiResponse getFavorite(int favId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("favId", favId);
        return client.request("/getFavorite", token, payload);
    }

    public ApiResponse deleteFavorite(int favId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("favId", favId);
        return client.request("/deleteFavorite", token, payload);
    }
}

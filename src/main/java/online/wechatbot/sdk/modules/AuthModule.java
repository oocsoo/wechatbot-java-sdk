package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.HashMap;
import java.util.Map;

public class AuthModule {
    private final WeChatBotClient client;

    public AuthModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse getQrcode(String token) {
        return getQrcode(token, "", "");
    }

    public ApiResponse getQrcode(String token, String deviceType, String aid) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("type", deviceType);
        payload.put("aid", aid);
        return client.request("/getLoginQrCode", token, payload);
    }

    public ApiResponse refreshStatus(String uuid, String token) {
        return refreshStatus(uuid, token, "");
    }

    public ApiResponse refreshStatus(String uuid, String token, String capCode) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("uuid", uuid);
        payload.put("auto_sliding", "false");
        payload.put("cap_code", capCode);
        return client.request("/refreshStatus", token, payload);
    }

    public ApiResponse dialogLogin(String token) {
        return client.request("/dialogLogin", token, new HashMap<>());
    }

    public ApiResponse reconnection(String token) {
        return client.request("/reconnection", token, new HashMap<>());
    }

    public ApiResponse logout(String token) {
        return client.request("/logout", token, new HashMap<>());
    }

    public ApiResponse checkStatus(String token) {
        return client.request("/checkOnline", token, new HashMap<>());
    }
}

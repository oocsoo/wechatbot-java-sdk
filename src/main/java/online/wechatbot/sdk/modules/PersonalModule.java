package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.HashMap;
import java.util.Map;

public class PersonalModule {
    private final WeChatBotClient client;

    public PersonalModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse getInfo(String token) {
        return client.request("/getPersonalInfo", token, new HashMap<>());
    }

    public ApiResponse getQrcode(String token) {
        return client.request("/getQrCode", token, new HashMap<>());
    }

    public ApiResponse getDeviceRecord(String token) {
        return client.request("/getSafetyInfo", token, new HashMap<>());
    }

    public ApiResponse privacySettings(boolean open, int option, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("open", open);
        payload.put("option", option);
        return client.request("/privacySettings", token, payload);
    }

    public ApiResponse updateInfo(String city, String country, String nickName, String province, int sex, String signature, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("city", city);
        payload.put("country", country);
        payload.put("nickName", nickName);
        payload.put("province", province);
        payload.put("sex", sex);
        payload.put("signature", signature);
        return client.request("/updatePersonalInfo", token, payload);
    }

    public ApiResponse updateHeadImg(String headImgUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("headImgUrl", headImgUrl);
        return client.request("/updateHeadImg", token, payload);
    }
}

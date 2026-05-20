package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class ContactModule {
    private final WeChatBotClient client;

    public ContactModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse contactsList(String token) {
        return client.request("/fetchContactsList", token, new HashMap<>());
    }

    public ApiResponse contactsListCache(String token) {
        return client.request("/fetchContactsListCache", token, new HashMap<>());
    }

    public ApiResponse briefInfo(List<String> wxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        return client.request("/getBriefInfo", token, payload);
    }

    public ApiResponse detailInfo(List<String> wxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        return client.request("/getDetailInfo", token, payload);
    }

    public ApiResponse searchFriend(String contactsInfo, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("contactsInfo", contactsInfo);
        return client.request("/search", token, payload);
    }

    public ApiResponse addContacts(int scene, String content, String v4, String v3, int option, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("scene", scene);
        payload.put("content", content);
        payload.put("v4", v4);
        payload.put("v3", v3);
        payload.put("option", option);
        return client.request("/addContacts", token, payload);
    }

    public ApiResponse deleteFriend(String wxid, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxid", wxid);
        return client.request("/deleteFriend", token, payload);
    }

    public ApiResponse setFriendPermissions(String wxid, boolean onlyChat, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxid", wxid);
        payload.put("onlyChat", onlyChat);
        return client.request("/setFriendPermissions", token, payload);
    }

    public ApiResponse setFriendRemark(String wxid, String remark, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxid", wxid);
        payload.put("remark", remark);
        return client.request("/setFriendRemark", token, payload);
    }

    public ApiResponse getPhoneList(String token, List<String> phones) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("phones", phones);
        return client.request("/getPhoneAddressList", token, payload);
    }

    public ApiResponse uploadPhoneList(List<String> phones, int opType, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("phones", phones);
        payload.put("opType", opType);
        return client.request("/uploadPhoneAddressList", token, payload);
    }

    public ApiResponse imSearch(int scene, String content, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("scene", scene);
        payload.put("content", content);
        return client.request("/imSearch", token, payload);
    }

    public ApiResponse addImFriends(String v3, String v4, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("v3", v3);
        payload.put("v4", v4);
        return client.request("/imAddFriends", token, payload);
    }

    public ApiResponse syncImFriends(String token) {
        return client.request("/imSyncFriends", token, new HashMap<>());
    }

    public ApiResponse detailImFriends(String toUserName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toUserName", toUserName);
        return client.request("/imDetailFriends", token, payload);
    }

    public ApiResponse checkRelation(List<String> wxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        return client.request("/checkRelation", token, payload);
    }
}

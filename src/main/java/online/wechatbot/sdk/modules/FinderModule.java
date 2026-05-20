package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class FinderModule {
    private final WeChatBotClient client;

    public FinderModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse createFinder(String proxyIp, String signature, String headImg, String nickName, int sex, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("signature", signature);
        payload.put("headImg", headImg);
        payload.put("nickName", nickName);
        payload.put("sex", sex);
        return client.request("/createFinder", token, payload);
    }

    public ApiResponse getProfile(String token) {
        return getProfile(token, "");
    }

    public ApiResponse getProfile(String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        return client.request("/getProfile", token, payload);
    }

    public ApiResponse getQrCode(String myUserName, int myRoleType, String token) {
        return getQrCode(myUserName, myRoleType, token, "");
    }

    public ApiResponse getQrCode(String myUserName, int myRoleType, String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        return client.request("/finderGetQrCode", token, payload);
    }

    public ApiResponse finderSearch(String content, String token) {
        return finderSearch(content, token, "", 1, 0, 0, "", "", 0);
    }

    public ApiResponse finderSearch(String content, String token, String proxyIp, int category, int filter, int page, String cookie, String searchId, int offset) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("content", content);
        payload.put("category", category);
        payload.put("filter", filter);
        payload.put("page", page);
        payload.put("cookie", cookie);
        payload.put("searchId", searchId);
        payload.put("offset", offset);
        return client.request("/finderSearch", token, payload);
    }

    public ApiResponse follow(String myUserName, int myRoleType, int opType, String toUserName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("opType", opType);
        payload.put("toUserName", toUserName);
        Map<String, String> searchInfo = new HashMap<>();
        searchInfo.put("cookies", "");
        searchInfo.put("searchId", "");
        searchInfo.put("docId", "");
        payload.put("searchInfo", searchInfo);
        return client.request("/follow", token, payload);
    }

    public ApiResponse followList(String myUserName, int myRoleType, String token) {
        return followList(myUserName, myRoleType, token, "", "");
    }

    public ApiResponse followList(String myUserName, int myRoleType, String token, String proxyIp, String lastBuffer) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("myUserName", myUserName);
        payload.put("lastBuffer", lastBuffer);
        payload.put("myRoleType", myRoleType);
        return client.request("/followList", token, payload);
    }

    public ApiResponse searchFollow(String myUserName, int myRoleType, String toUserName, String keyword, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("toUserName", toUserName);
        payload.put("keyword", keyword);
        return client.request("/searchFollow", token, payload);
    }

    public ApiResponse userPage(String toUserName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("lastBuffer", "");
        payload.put("toUserName", toUserName);
        payload.put("maxId", 0);
        return client.request("/userPage", token, payload);
    }

    public ApiResponse browse(String myUserName, String objectNonceId, String sessionBuffer, long objectId, int myRoleType, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("objectNonceId", objectNonceId);
        payload.put("sessionBuffer", sessionBuffer);
        payload.put("objectId", objectId);
        payload.put("myRoleType", myRoleType);
        return client.request("/browse", token, payload);
    }

    public ApiResponse comment(String myUserName, int opType, String objectNonceId, String sessionBuffer, long objectId, int myRoleType, String content, String commentId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("opType", opType);
        payload.put("objectNonceId", objectNonceId);
        payload.put("sessionBuffer", sessionBuffer);
        payload.put("objectId", objectId);
        payload.put("myRoleType", myRoleType);
        payload.put("content", content);
        payload.put("commentId", commentId);
        payload.put("replyUserName", "");
        payload.put("refCommentId", 0);
        payload.put("rootCommentId", 0);
        return client.request("/comment", token, payload);
    }

    public ApiResponse commentList(String sessionBuffer, String objectId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("rootCommentId", 0);
        payload.put("refCommentId", 0);
        payload.put("objectNonceId", "");
        payload.put("sessionBuffer", sessionBuffer);
        payload.put("lastBuffer", "");
        payload.put("objectId", objectId);
        return client.request("/commentList", token, payload);
    }

    public ApiResponse publishFinderWeb(String title, String videoUrl, String thumbUrl, String description, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", title);
        payload.put("videoUrl", videoUrl);
        payload.put("thumbUrl", thumbUrl);
        payload.put("description", description);
        return client.request("/publishFinderWeb", token, payload);
    }

    public ApiResponse uploadFinderVideo(String videoUrl, String coverImgUrl, String token) {
        return uploadFinderVideo(videoUrl, coverImgUrl, token, "");
    }

    public ApiResponse uploadFinderVideo(String videoUrl, String coverImgUrl, String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("videoUrl", videoUrl);
        payload.put("coverImgUrl", coverImgUrl);
        return client.request("/uploadFinderVideo", token, payload);
    }

    public ApiResponse publishFinderCdn(String myUserName, int myRoleType, String description, Map<String, Object> videoCdn, String token) {
        return publishFinderCdn(myUserName, myRoleType, description, videoCdn, token, "", Collections.emptyList());
    }

    public ApiResponse publishFinderCdn(String myUserName, int myRoleType, String description, Map<String, Object> videoCdn, String token, String proxyIp, List<String> topic) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("topic", topic);
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("description", description);
        payload.put("videoCdn", videoCdn);
        return client.request("/publishFinderCdn", token, payload);
    }

    public ApiResponse mentionList(String myUserName, int myRoleType, int reqScene, String token) {
        return mentionList(myUserName, myRoleType, reqScene, token, "");
    }

    public ApiResponse mentionList(String myUserName, int myRoleType, int reqScene, String token, String lastBuff) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("myUserName", myUserName);
        payload.put("lastBuff", lastBuff);
        payload.put("myRoleType", myRoleType);
        payload.put("reqScene", reqScene);
        return client.request("/mentionList", token, payload);
    }

    public ApiResponse likeFavList(String myUserName, int myRoleType, int flag, String token) {
        return likeFavList(myUserName, myRoleType, flag, token, "", "");
    }

    public ApiResponse likeFavList(String myUserName, int myRoleType, int flag, String token, String proxyIp, String lastBuffer) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("myUserName", myUserName);
        payload.put("lastBuffer", lastBuffer);
        payload.put("myRoleType", myRoleType);
        payload.put("flag", flag);
        return client.request("/likeFavList", token, payload);
    }

    public ApiResponse idFav(String myUserName, int opType, String objectNonceId, String sessionBuffer, long objectId, String toUserName, int myRoleType, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("opType", opType);
        payload.put("objectNonceId", objectNonceId);
        payload.put("sessionBuffer", sessionBuffer);
        payload.put("objectId", objectId);
        payload.put("toUserName", toUserName);
        payload.put("myRoleType", myRoleType);
        return client.request("/idFav", token, payload);
    }

    public ApiResponse idLike(String myUserName, int opType, String objectNonceId, String sessionBuffer, long objectId, String toUserName, int myRoleType, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("opType", opType);
        payload.put("objectNonceId", objectNonceId);
        payload.put("sessionBuffer", sessionBuffer);
        payload.put("objectId", objectId);
        payload.put("toUserName", toUserName);
        payload.put("myRoleType", myRoleType);
        return client.request("/idLike", token, payload);
    }

    public ApiResponse finderOpt(String myUserName, int myRoleType, String toUserName, int opType, String id, int remain, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("toUserName", toUserName);
        payload.put("opType", opType);
        payload.put("id", id);
        payload.put("remain", remain);
        return client.request("/finderOpt", token, payload);
    }

    public ApiResponse syncPrivateLetterMsg(String token) {
        return syncPrivateLetterMsg(token, "", "");
    }

    public ApiResponse syncPrivateLetterMsg(String token, String proxyIp, String keyBuff) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("keyBuff", keyBuff);
        return client.request("/syncPrivateLetterMsg", token, payload);
    }

    public ApiResponse contactList(String myUserName, String queryInfo, int myRoleType, String token) {
        return contactList(myUserName, queryInfo, myRoleType, token, "");
    }

    public ApiResponse contactList(String myUserName, String queryInfo, int myRoleType, String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("myUserName", myUserName);
        payload.put("queryInfo", queryInfo);
        payload.put("myRoleType", myRoleType);
        return client.request("/contactList", token, payload);
    }

    public ApiResponse postPrivateLetter(String content, String msgSessionId, String myUserName, String toUserName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("content", content);
        payload.put("msgSessionId", msgSessionId);
        payload.put("myUserName", myUserName);
        payload.put("toUserName", toUserName);
        return client.request("/postPrivateLetter", token, payload);
    }

    public ApiResponse postPrivateLetterImg(String imgUrl, String msgSessionId, String myUserName, String toUserName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("imgUrl", imgUrl);
        payload.put("msgSessionId", msgSessionId);
        payload.put("myUserName", myUserName);
        payload.put("toUserName", toUserName);
        return client.request("/postPrivateLetterImg", token, payload);
    }

    public ApiResponse scanBrowse(String myUserName, int myRoleType, String qrContent, long objectId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("qrContent", qrContent);
        payload.put("objectId", objectId);
        return client.request("/scanBrowse", token, payload);
    }

    public ApiResponse scanComment(String myUserName, int myRoleType, String qrContent, long objectId, String commentContent, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("qrContent", qrContent);
        payload.put("objectId", objectId);
        payload.put("commentContent", commentContent);
        payload.put("replyUsername", "");
        payload.put("refCommentId", 0);
        payload.put("rootCommentId", 0);
        return client.request("/scanComment", token, payload);
    }

    public ApiResponse scanFav(String myUserName, int myRoleType, String qrContent, long objectId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("qrContent", qrContent);
        payload.put("objectId", objectId);
        return client.request("/scanFav", token, payload);
    }

    public ApiResponse scanLike(String myUserName, int myRoleType, String qrContent, long objectId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("qrContent", qrContent);
        payload.put("objectId", objectId);
        return client.request("/scanLike", token, payload);
    }

    public ApiResponse scanLoginChannels(String qrContent, String token) {
        return scanLoginChannels(qrContent, token, "");
    }

    public ApiResponse scanLoginChannels(String qrContent, String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("qrContent", qrContent);
        return client.request("/scanLoginChannels", token, payload);
    }

    public ApiResponse scanQrCode(String myUserName, int myRoleType, String qrContent, String token) {
        return scanQrCode(myUserName, myRoleType, qrContent, token, "");
    }

    public ApiResponse scanQrCode(String myUserName, int myRoleType, String qrContent, String token, String proxyIp) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", proxyIp);
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("qrContent", qrContent);
        return client.request("/scanQrCode", token, payload);
    }

    public ApiResponse sendFinderMsg(String toWxid, long id, String username, String nickname, String headUrl, String nonceId, String mediaType, String width, String height, String url, String thumbUrl, String thumbUrlToken, String description, String videoPlayLen, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("proxyIp", "");
        payload.put("toWxid", toWxid);
        payload.put("id", id);
        payload.put("username", username);
        payload.put("nickname", nickname);
        payload.put("headUrl", headUrl);
        payload.put("nonceId", nonceId);
        payload.put("mediaType", mediaType);
        payload.put("width", width);
        payload.put("height", height);
        payload.put("url", url);
        payload.put("thumbUrl", thumbUrl);
        payload.put("thumbUrlToken", thumbUrlToken);
        payload.put("description", description);
        payload.put("videoPlayLen", videoPlayLen);
        return client.request("/sendFinderMsg", token, payload);
    }

    public ApiResponse updateProfile(String myUserName, int myRoleType, String token, Map<String, Object> options) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("myUserName", myUserName);
        payload.put("myRoleType", myRoleType);
        payload.put("proxyIp", options.getOrDefault("proxyIp", ""));
        if (options.containsKey("signature")) payload.put("signature", options.get("signature"));
        if (options.containsKey("headImg")) payload.put("headImg", options.get("headImg"));
        if (options.containsKey("nickName")) payload.put("nickName", options.get("nickName"));
        if (options.containsKey("sex")) payload.put("sex", options.get("sex"));
        if (options.containsKey("city")) payload.put("city", options.get("city"));
        if (options.containsKey("province")) payload.put("province", options.get("province"));
        if (options.containsKey("country")) payload.put("country", options.get("country"));
        return client.request("/updateProfile", token, payload);
    }
}

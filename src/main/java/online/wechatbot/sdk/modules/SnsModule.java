package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class SnsModule {
    private final WeChatBotClient client;

    public SnsModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse snsList(long maxId, boolean decrypt, String firstPageMd5, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("maxId", maxId);
        payload.put("decrypt", decrypt);
        payload.put("firstPageMd5", firstPageMd5);
        return client.request("/snsList", token, payload);
    }

    public ApiResponse friendsSnsList(long maxId, boolean decrypt, String wxid, String firstPageMd5, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("maxId", maxId);
        payload.put("decrypt", decrypt);
        payload.put("wxid", wxid);
        payload.put("firstPageMd5", firstPageMd5);
        return client.request("/contactsSnsList", token, payload);
    }

    public ApiResponse snsDetails(long snsId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsId", snsId);
        return client.request("/snsDetails", token, payload);
    }

    public ApiResponse snsLike(long snsId, int operType, String wxid, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsId", snsId);
        payload.put("operType", operType);
        payload.put("wxid", wxid);
        return client.request("/likeSns", token, payload);
    }

    public ApiResponse snsComment(long snsId, int operType, String wxid, int commentId, String content, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsId", snsId);
        payload.put("operType", operType);
        payload.put("wxid", wxid);
        payload.put("commentId", commentId);
        payload.put("content", content);
        return client.request("/commentSns", token, payload);
    }

    public ApiResponse snsDelete(long snsId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsId", snsId);
        return client.request("/delSns", token, payload);
    }

    public ApiResponse snsScope(int option, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("option", option);
        return client.request("/snsVisibleScope", token, payload);
    }

    public ApiResponse snsVisibilityEnable(boolean enabled, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("enabled", enabled);
        return client.request("/strangerVisibilityEnabled", token, payload);
    }

    public ApiResponse snsSetStatus(long snsId, boolean open, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsId", snsId);
        payload.put("open", open);
        return client.request("/snsSetPrivacy", token, payload);
    }

    public ApiResponse snsDownloadVideo(String snsXml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("snsXml", snsXml);
        return client.request("/downloadSnsVideo", token, payload);
    }

    public ApiResponse snsSendText(List<String> allowWxIds, List<String> atWxIds, List<String> disableWxIds, String content, boolean privacy, List<Integer> allowTagIds, List<Integer> disableTagIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("allowWxIds", allowWxIds);
        payload.put("atWxIds", atWxIds);
        payload.put("disableWxIds", disableWxIds);
        payload.put("content", content);
        payload.put("privacy", privacy);
        payload.put("allowTagIds", allowTagIds);
        payload.put("disableTagIds", disableTagIds);
        return client.request("/sendTextSns", token, payload);
    }

    public ApiResponse snsSendImg(List<String> allowWxIds, List<String> atWxIds, List<String> disableWxIds, String content, String fileUrl, String thumbUrl, String fileMd5, long length, int width, int height, boolean privacy, List<Integer> allowTagIds, List<Integer> disableTagIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("allowWxIds", allowWxIds);
        payload.put("atWxIds", atWxIds);
        payload.put("disableWxIds", disableWxIds);
        payload.put("content", content);
        Map<String, Object> imgInfo = new HashMap<>();
        imgInfo.put("fileUrl", fileUrl);
        imgInfo.put("thumbUrl", thumbUrl);
        imgInfo.put("fileMd5", fileMd5);
        imgInfo.put("length", length);
        imgInfo.put("width", width);
        imgInfo.put("height", height);
        payload.put("imgInfos", Collections.singletonList(imgInfo));
        payload.put("privacy", privacy);
        payload.put("allowTagIds", allowTagIds);
        payload.put("disableTagIds", disableTagIds);
        return client.request("/sendImgSns", token, payload);
    }

    public ApiResponse snsUploadImage(List<String> imgUrls, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("imgUrls", imgUrls);
        return client.request("/uploadSnsImage", token, payload);
    }

    public ApiResponse snsSendVideo(List<String> allowWxIds, List<String> atWxIds, List<String> disableWxIds, String content, String fileUrl, String thumbUrl, String fileMd5, long length, boolean privacy, List<Integer> allowTagIds, List<Integer> disableTagIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("allowWxIds", allowWxIds);
        payload.put("atWxIds", atWxIds);
        payload.put("disableWxIds", disableWxIds);
        payload.put("content", content);
        Map<String, Object> videoInfo = new HashMap<>();
        videoInfo.put("fileUrl", fileUrl);
        videoInfo.put("thumbUrl", thumbUrl);
        videoInfo.put("fileMd5", fileMd5);
        videoInfo.put("length", length);
        payload.put("videoInfo", videoInfo);
        payload.put("privacy", privacy);
        payload.put("allowTagIds", allowTagIds);
        payload.put("disableTagIds", disableTagIds);
        return client.request("/sendVideoSns", token, payload);
    }

    public ApiResponse snsUploadVideo(String thumbUrl, String videoUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("thumbUrl", thumbUrl);
        payload.put("videoUrl", videoUrl);
        return client.request("/uploadSnsVideo", token, payload);
    }

    public ApiResponse snsSendUrl(List<String> allowWxIds, List<String> atWxIds, List<String> disableWxIds, String content, String description, String title, String linkUrl, String thumbUrl, boolean privacy, List<Integer> allowTagIds, List<Integer> disableTagIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("allowWxIds", allowWxIds);
        payload.put("atWxIds", atWxIds);
        payload.put("disableWxIds", disableWxIds);
        payload.put("content", content);
        payload.put("description", description);
        payload.put("title", title);
        payload.put("linkUrl", linkUrl);
        payload.put("thumbUrl", thumbUrl);
        payload.put("privacy", privacy);
        payload.put("allowTagIds", allowTagIds);
        payload.put("disableTagIds", disableTagIds);
        return client.request("/sendUrlSns", token, payload);
    }

    public ApiResponse snsForward(List<String> allowWxIds, List<String> atWxIds, List<String> disableWxIds, String snsXml, boolean privacy, List<Integer> allowTagIds, List<Integer> disableTagIds, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("allowWxIds", allowWxIds);
        payload.put("atWxIds", atWxIds);
        payload.put("disableWxIds", disableWxIds);
        payload.put("snsXml", snsXml);
        payload.put("privacy", privacy);
        payload.put("allowTagIds", allowTagIds);
        payload.put("disableTagIds", disableTagIds);
        return client.request("/forwardSns", token, payload);
    }
}

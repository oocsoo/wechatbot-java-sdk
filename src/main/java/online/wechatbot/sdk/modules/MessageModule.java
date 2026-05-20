package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class MessageModule {
    private final WeChatBotClient client;

    public MessageModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse sendText(String toWxid, String content, String token) {
        return sendText(toWxid, content, token, Collections.emptyList());
    }

    public ApiResponse sendText(String toWxid, String content, String token, List<String> atList) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("content", content);
        payload.put("atWxidList", atList);
        return client.request("/sendTextMessage", token, payload);
    }

    public ApiResponse sendImage(String toWxid, String imageUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("imgUrl", imageUrl);
        return client.request("/sendImageMessage", token, payload);
    }

    public ApiResponse sendVoice(String toWxid, String silkUrl, int voiceDuration, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("voiceUrl", silkUrl);
        payload.put("voiceDuration", voiceDuration);
        return client.request("/sendVoiceMessage", token, payload);
    }

    public ApiResponse sendVideo(String toWxid, String videoUrl, String thumbUrl, int videoDuration, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("videoUrl", videoUrl);
        payload.put("thumbUrl", thumbUrl);
        payload.put("videoDuration", videoDuration);
        return client.request("/sendVedioMessage", token, payload);
    }

    public ApiResponse sendFile(String toWxid, String fileName, String fileUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("fileName", fileName);
        payload.put("fileUrl", fileUrl);
        return client.request("/sendFileMessage", token, payload);
    }

    public ApiResponse sendLink(String toWxid, String title, String desc, String linkUrl, String thumbUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("title", title);
        payload.put("desc", desc);
        payload.put("linkUrl", linkUrl);
        payload.put("thumbUrl", thumbUrl);
        return client.request("/sendLinkMessage", token, payload);
    }

    public ApiResponse sendCard(String toWxid, String nickname, String nameCardWxid, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("nickName", nickname);
        payload.put("nameCardWxid", nameCardWxid);
        return client.request("/sendCardMessage", token, payload);
    }

    public ApiResponse sendEmoji(String toWxid, String emojiMd5, int emojiSize, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("emojiMd5", emojiMd5);
        payload.put("emojiSize", emojiSize);
        return client.request("/sendEmojiMessage", token, payload);
    }

    public ApiResponse sendApp(String toWxid, String appmsg, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("appmsg", appmsg);
        return client.request("/sendAppMessage", token, payload);
    }

    public ApiResponse sendMiniapp(String toWxid, String miniAppId, String userName, String title, String coverImgUrl, String pagePath, String displayName, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("miniAppId", miniAppId);
        payload.put("userName", userName);
        payload.put("title", title);
        payload.put("coverImgUrl", coverImgUrl);
        payload.put("pagePath", pagePath);
        payload.put("displayName", displayName);
        return client.request("/sendMiniappMessage", token, payload);
    }

    public ApiResponse sendLocation(String toWxid, String content, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("content", content);
        return client.request("/sendLocationMessage", token, payload);
    }

    public ApiResponse revokeMsg(String toWxid, String msgId, String newMsgId, long createTime, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("msgId", msgId);
        payload.put("newMsgId", newMsgId);
        payload.put("createTime", createTime);
        return client.request("/sendRevokeMessage", token, payload);
    }

    public ApiResponse forwardFile(String toWxid, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("xml", xml);
        return client.request("/sendForwardFileMessage", token, payload);
    }

    public ApiResponse forwardImage(String toWxid, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("xml", xml);
        return client.request("/sendForwardImageMessage", token, payload);
    }

    public ApiResponse forwardVideo(String toWxid, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("xml", xml);
        return client.request("/sendForwardVideoMessage", token, payload);
    }

    public ApiResponse forwardLink(String toWxid, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("xml", xml);
        return client.request("/sendForwardUrlMessage", token, payload);
    }

    public ApiResponse forwardMiniapp(String toWxid, String xml, String coverImgUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("toWxid", toWxid);
        payload.put("xml", xml);
        payload.put("coverImgUrl", coverImgUrl);
        return client.request("/sendForwardMiniAppMessage", token, payload);
    }
}

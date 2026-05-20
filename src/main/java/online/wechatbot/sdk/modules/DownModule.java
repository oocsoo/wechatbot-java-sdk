package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class DownModule {
    private final WeChatBotClient client;

    public DownModule(WeChatBotClient client) {
        this.client = client;
    }

    public boolean downloadSilkBase64(String base64Data, String savePath) throws Exception {
        byte[] data = Base64.getDecoder().decode(base64Data);
        try (FileOutputStream fos = new FileOutputStream(savePath)) {
            fos.write(data);
        }
        return true;
    }

    public ApiResponse downloadSilkRequest(String msgId, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("msgId", msgId);
        payload.put("xml", xml);
        return client.request("/downloadVoice", token, payload);
    }

    public ApiResponse downloadFile(String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("xml", xml);
        return client.request("/downloadFile", token, payload);
    }

    public ApiResponse downloadImage(int type, String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("type", type);
        payload.put("xml", xml);
        return client.request("/downloadImage", token, payload);
    }

    public ApiResponse downloadVideo(String xml, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("xml", xml);
        return client.request("/downloadVideo", token, payload);
    }

    public ApiResponse downloadEmoji(String emojiMd5, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("emojiMd5", emojiMd5);
        return client.request("/downloadEmoji", token, payload);
    }

    public ApiResponse downloadCdn(String aesKey, String totalSize, String type, String fileId, String suffix, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("aesKey", aesKey);
        payload.put("totalSize", totalSize);
        payload.put("type", type);
        payload.put("fileId", fileId);
        payload.put("suffix", suffix);
        return client.request("/downloadCdn", token, payload);
    }
}

package online.wechatbot.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import online.wechatbot.sdk.modules.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;

public class WeChatBotClient {
    private final String baseUrl;
    private final HttpClient http;
    private final ObjectMapper mapper = new ObjectMapper();

    public final AuthModule auth;
    public final MessageModule message;
    public final GroupModule group;
    public final ContactModule contact;
    public final PersonalModule personal;
    public final FavoriteModule favorite;
    public final LabelModule label;
    public final DownModule download;
    public final SnsModule sns;
    public final FinderModule finder;

    public static class Builder {
        private String baseUrl = "http://124.221.45.58";
        private Duration timeout = Duration.ofSeconds(30);

        public Builder baseUrl(String url) { this.baseUrl = url; return this; }
        public Builder timeout(Duration t) { this.timeout = t; return this; }
        public WeChatBotClient build() { return new WeChatBotClient(this); }
    }

    private WeChatBotClient(Builder b) {
        this.baseUrl = b.baseUrl;
        this.http = HttpClient.newBuilder().connectTimeout(b.timeout).build();
        this.auth = new AuthModule(this);
        this.message = new MessageModule(this);
        this.group = new GroupModule(this);
        this.contact = new ContactModule(this);
        this.personal = new PersonalModule(this);
        this.favorite = new FavoriteModule(this);
        this.label = new LabelModule(this);
        this.download = new DownModule(this);
        this.sns = new SnsModule(this);
        this.finder = new FinderModule(this);
    }

    public ApiResponse request(String endpoint, String token, Map<String, Object> payload) {
        try {
            String body = mapper.writeValueAsString(payload);
            HttpRequest.Builder reqBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + endpoint))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body));
            if (token != null && !token.isEmpty()) {
                reqBuilder.header("AUTHORIZATION", token);
            }
            HttpResponse<String> resp = http.send(reqBuilder.build(), HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(resp.body(), ApiResponse.class);
        } catch (Exception e) {
            ApiResponse err = new ApiResponse();
            err.setRet(-1);
            err.setMsg("系统或网络异常: " + e.getMessage());
            return err;
        }
    }
}

package online.wechatbot.sdk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private int ret;
    private String msg;
    private JsonNode data;

    public ApiResponse() {}

    public ApiResponse(int ret, String msg, JsonNode data) {
        this.ret = ret;
        this.msg = msg;
        this.data = data;
    }

    public int getRet() { return ret; }
    public void setRet(int ret) { this.ret = ret; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public JsonNode getData() { return data; }
    public void setData(JsonNode data) { this.data = data; }

    public boolean isSuccess() { return ret == 200; }

    @Override
    public String toString() {
        return "ApiResponse{ret=" + ret + ", msg='" + msg + "', data=" + data + "}";
    }
}

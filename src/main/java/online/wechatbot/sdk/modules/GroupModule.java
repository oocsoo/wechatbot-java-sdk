package online.wechatbot.sdk.modules;

import online.wechatbot.sdk.ApiResponse;
import online.wechatbot.sdk.WeChatBotClient;

import java.util.*;

public class GroupModule {
    private final WeChatBotClient client;

    public GroupModule(WeChatBotClient client) {
        this.client = client;
    }

    public ApiResponse createGroup(List<String> wxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        return client.request("/createGroup", token, payload);
    }

    public ApiResponse modifyGroupName(String chatroomName, String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomName", chatroomName);
        payload.put("chatroomId", chatroomId);
        return client.request("/modifyGroupName", token, payload);
    }

    public ApiResponse modifyGroupRemark(String chatroomRemark, String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomRemark", chatroomRemark);
        payload.put("chatroomId", chatroomId);
        return client.request("/modifyGroupRemark", token, payload);
    }

    public ApiResponse modifySelfNicknameInGroup(String nickName, String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("nickName", nickName);
        payload.put("chatroomId", chatroomId);
        return client.request("/modifyGroupNickNameForSelf", token, payload);
    }

    public ApiResponse inviteGroupMember(String wxids, String chatroomId, String reason, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        payload.put("chatroomId", chatroomId);
        payload.put("reason", reason);
        return client.request("/inviteMember", token, payload);
    }

    public ApiResponse removeGroupMember(String wxids, String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("wxids", wxids);
        payload.put("chatroomId", chatroomId);
        return client.request("/removeMember", token, payload);
    }

    public ApiResponse quitGroup(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/quitGroup", token, payload);
    }

    public ApiResponse disbandGroup(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/disbandGroup", token, payload);
    }

    public ApiResponse groupInfo(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/getGroupInfo", token, payload);
    }

    public ApiResponse groupMember(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/getGroupMemberList", token, payload);
    }

    public ApiResponse groupMemberDetail(String chatroomId, List<String> memberWxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("memberWxids", memberWxids);
        return client.request("/getGroupMemberDetail", token, payload);
    }

    public ApiResponse getAnnouncement(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/getGroupAnnouncement", token, payload);
    }

    public ApiResponse setAnnouncement(String chatroomId, String content, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("content", content);
        return client.request("/setGroupAnnouncement", token, payload);
    }

    public ApiResponse agreeJoinGroup(String url, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("url", url);
        return client.request("/agreeJoinGroup", token, payload);
    }

    public ApiResponse addGroupMemberAsFriend(String chatroomId, String content, String memberWxid, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("content", content);
        payload.put("memberWxid", memberWxid);
        return client.request("/addGroupMemberAsFriend", token, payload);
    }

    public ApiResponse getGroupQr(String chatroomId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        return client.request("/getGroupQrCode", token, payload);
    }

    public ApiResponse saveContractList(String chatroomId, int operType, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("operType", operType);
        return client.request("/saveContractList", token, payload);
    }

    public ApiResponse adminOperate(String chatroomId, int operType, List<String> wxids, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("operType", operType);
        payload.put("wxids", wxids);
        return client.request("/adminOperate", token, payload);
    }

    public ApiResponse pinnedChat(String chatroomId, boolean top, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("top", top);
        return client.request("/pinnedChat", token, payload);
    }

    public ApiResponse setMsgSilence(String chatroomId, boolean silence, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("silence", silence);
        return client.request("/setMsgSilence", token, payload);
    }

    public ApiResponse joinGroupByQr(String qrUrl, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("qrUrl", qrUrl);
        return client.request("/joinGroupUsingQRCode", token, payload);
    }

    public ApiResponse applyGroupApprove(String chatroomId, String msgContent, String newMsgId, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("chatroomId", chatroomId);
        payload.put("msgContent", msgContent);
        payload.put("newMsgId", newMsgId);
        return client.request("/groupAccessApplyCheckApprove", token, payload);
    }
}

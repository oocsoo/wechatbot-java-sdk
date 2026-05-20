# wechatbot-java-sdk

基于WeChatBot开放平台API封装的 Java SDK，提供简洁易用的接口调用方式。

## 特性

- 基于 Java 11 内置 HttpClient，无额外 HTTP 依赖
- Builder 模式构造客户端，支持自定义服务地址和超时
- 10 个功能模块完整覆盖平台所有 API
- Jackson 序列化，响应数据可灵活解析
- 线程安全，可在多线程环境下共享同一客户端实例

## 环境要求

- Java >= 11
- Jackson Databind >= 2.17.0

## Maven 引入

```xml
<dependency>
    <groupId>online.wechatbot</groupId>
    <artifactId>wechatbot-java-sdk</artifactId>
    <version>0.2.0</version>
</dependency>
```

## Gradle 引入

```groovy
implementation 'online.wechatbot:wechatbot-java-sdk:0.2.0'
```

## 快速开始

```java
import online.wechatbot.sdk.WeChatBotClient;
import online.wechatbot.sdk.ApiResponse;

// 创建客户端（默认配置）
WeChatBotClient client = new WeChatBotClient.Builder().build();
String token = "your_token";

// 获取登录二维码
ApiResponse qr = client.auth.getQrcode(token);
System.out.println(qr);

// 发送文本消息
ApiResponse res = client.message.sendText("wxid_xxxxx", "Hello!", token);
System.out.println(res);
```

## 自定义配置

```java
import java.time.Duration;

WeChatBotClient client = new WeChatBotClient.Builder()
    .baseUrl("http://your-server-ip")
    .timeout(Duration.ofSeconds(60))
    .build();
```

## 响应处理

所有接口返回 `ApiResponse` 对象：

```java
ApiResponse resp = client.auth.checkStatus(token);

if (resp.isSuccess()) {
    // ret == 200 表示成功
    JsonNode data = resp.getData();
    System.out.println("在线状态: " + data);
} else {
    System.out.println("错误: " + resp.getMsg());
}
```

## 功能模块总览

| 模块 | 属性 | 说明 |
|------|------|------|
| AuthModule | `client.auth` | 登录认证（扫码/重连/登出/状态检查） |
| MessageModule | `client.message` | 消息收发（文本/图片/语音/视频/文件/链接/名片/小程序/撤回/转发） |
| GroupModule | `client.group` | 群聊管理（创建/邀请/踢人/公告/管理员/置顶/免打扰） |
| ContactModule | `client.contact` | 联系人管理（通讯录/搜索/加删好友/企微） |
| PersonalModule | `client.personal` | 个人信息（资料/二维码/隐私设置/修改头像） |
| FavoriteModule | `client.favorite` | 收藏夹（同步/获取/删除） |
| LabelModule | `client.label` | 标签管理（增删改查） |
| DownModule | `client.download` | 资源下载（图片/视频/文件/语音/表情/CDN） |
| SnsModule | `client.sns` | 朋友圈（发布/点赞/评论/转发/隐私设置） |
| FinderModule | `client.finder` | 视频号（发布/互动/扫码/私信/关注） |

## Token 获取

请访问官网 [www.wechatbot.online](http://www.wechatbot.online) 获取 Token。

---

## 详细用法示例

### 登录认证

```java
// 获取登录二维码
ApiResponse qr = client.auth.getQrcode(token);
String uuid = qr.getData().get("uuid").asText();

// 轮询登录状态（用户扫码后调用）
ApiResponse status = client.auth.refreshStatus(uuid, token);

// 检查是否在线
ApiResponse online = client.auth.checkStatus(token);

// 已登录过的微信二次弹窗登录
client.auth.dialogLogin(token);

// 断线重连
client.auth.reconnection(token);

// 退出登录
client.auth.logout(token);
```

### 消息收发

```java
String to = "wxid_xxxxx";

// 发送文本
client.message.sendText(to, "你好", token);

// 发送文本（群聊中@某人）
client.message.sendText(to, "大家好", token, Arrays.asList("wxid_aaa"));

// 发送图片
client.message.sendImage(to, "https://example.com/pic.jpg", token);

// 发送语音（silk格式）
client.message.sendVoice(to, "https://example.com/voice.silk", 5000, token);

// 发送视频
client.message.sendVideo(to, "https://example.com/video.mp4", "https://example.com/thumb.jpg", 15, token);

// 发送文件
client.message.sendFile(to, "report.pdf", "https://example.com/report.pdf", token);

// 发送链接卡片
client.message.sendLink(to, "文章标题", "文章描述", "https://example.com/article", "https://example.com/thumb.jpg", token);

// 发送名片
client.message.sendCard(to, "张三", "wxid_zhangsan", token);

// 发送小程序
client.message.sendMiniapp(to, "miniAppId", "userName", "标题", "https://cover.jpg", "/pages/index", "显示名", token);

// 撤回消息（需要发送接口返回的 msgId、newMsgId、createTime）
client.message.revokeMsg(to, "msg_id", "new_msg_id", 1700000000L, token);

// 转发文件（xml 从回调消息中获取）
client.message.forwardFile(to, "<xml>...</xml>", token);
```

### 群聊管理

```java
String roomId = "xxxxx@chatroom";

// 创建群聊（至少3人）
client.group.createGroup(Arrays.asList("wxid_aaa", "wxid_bbb", "wxid_ccc"), token);

// 修改群名
client.group.modifyGroupName("新群名", roomId, token);

// 修改群备注
client.group.modifyGroupRemark("内部测试群", roomId, token);

// 修改我在群内的昵称
client.group.modifySelfNicknameInGroup("管理员", roomId, token);

// 邀请好友进群（多个wxid用逗号隔开）
client.group.inviteGroupMember("wxid_ddd,wxid_eee", roomId, "欢迎加入", token);

// 移出群成员
client.group.removeGroupMember("wxid_ddd", roomId, token);

// 获取群信息
ApiResponse info = client.group.groupInfo(roomId, token);

// 获取群成员列表
ApiResponse members = client.group.groupMember(roomId, token);

// 获取群成员详情
ApiResponse detail = client.group.groupMemberDetail(roomId, Arrays.asList("wxid_aaa", "wxid_bbb"), token);

// 设置群公告
client.group.setAnnouncement(roomId, "本群规则：...", token);

// 管理员操作（1:添加管理 2:删除管理 3:转让群主）
client.group.adminOperate(roomId, 1, Arrays.asList("wxid_aaa"), token);

// 聊天置顶 / 消息免打扰
client.group.pinnedChat(roomId, true, token);
client.group.setMsgSilence(roomId, true, token);

// 群保存到通讯录（3:保存 2:移除）
client.group.saveContractList(roomId, 3, token);

// 扫码进群
client.group.joinGroupByQr("https://qr-url", token);
```

### 联系人管理

```java
// 获取通讯录（缓存版本更快）
ApiResponse contacts = client.contact.contactsListCache(token);

// 获取好友简要信息（最大20个）
ApiResponse brief = client.contact.briefInfo(Arrays.asList("wxid_aaa", "wxid_bbb"), token);

// 获取好友详细信息
ApiResponse detail = client.contact.detailInfo(Arrays.asList("wxid_aaa"), token);

// 搜索好友（微信号、手机号）
ApiResponse result = client.contact.searchFriend("13800138000", token);

// 添加好友（scene: 3微信号 4QQ 8群聊 15手机号；option: 2添加 3同意 4拒绝）
client.contact.addContacts(3, "你好，我是xxx", "v4_value", "v3_value", 2, token);

// 设置好友备注
client.contact.setFriendRemark("wxid_aaa", "张三-同事", token);

// 设置好友仅聊天
client.contact.setFriendPermissions("wxid_aaa", true, token);

// 检测好友关系（最多20个）
client.contact.checkRelation(Arrays.asList("wxid_aaa", "wxid_bbb"), token);

// 删除好友
client.contact.deleteFriend("wxid_aaa", token);
```

### 个人信息

```java
// 获取个人资料
ApiResponse info = client.personal.getInfo(token);

// 获取自己的二维码
ApiResponse qr = client.personal.getQrcode(token);

// 修改个人资料
client.personal.updateInfo("Shanghai", "CN", "新昵称", "Shanghai", 1, "个性签名", token);

// 修改头像
client.personal.updateHeadImg("https://example.com/avatar.jpg", token);

// 隐私设置（option: 4加我验证 7推荐通讯录 8手机号 25微信号 38群聊 39二维码 40名片）
client.personal.privacySettings(true, 4, token);
```

### 收藏夹

```java
// 同步收藏夹（首次传空，翻页传返回的 syncKey）
ApiResponse favs = client.favorite.syncFavorite("", token);

// 获取某条收藏内容
ApiResponse content = client.favorite.getFavorite(12345, token);

// 删除收藏
client.favorite.deleteFavorite(12345, token);
```

### 标签管理

```java
// 添加标签
client.label.addLabel("同事", token);

// 获取标签列表
ApiResponse labels = client.label.listLabel(token);

// 给好友打标签（多个标签ID逗号分隔）
client.label.modifyFriendLabel("1,2", Arrays.asList("wxid_aaa", "wxid_bbb"), token);

// 删除标签
client.label.deleteLabel("1,2", token);
```

### 资源下载

```java
// 下载图片（type: 1高清 2常规 3缩略图，xml从回调消息获取）
ApiResponse img = client.download.downloadImage(1, "<xml>...</xml>", token);

// 下载视频
ApiResponse video = client.download.downloadVideo("<xml>...</xml>", token);

// 下载文件
ApiResponse file = client.download.downloadFile("<xml>...</xml>", token);

// 下载表情
ApiResponse emoji = client.download.downloadEmoji("emoji_md5_value", token);

// CDN下载（type: 1高清图 2常规图 3缩略图 4视频 5文件）
ApiResponse cdn = client.download.downloadCdn("aes_key", "1024000", "4", "file_id", "mp4", token);

// 语音Base64解码保存到本地
client.download.downloadSilkBase64("base64_string", "./voice.silk");
```

### 朋友圈

```java
// 获取我的朋友圈（首次 maxId=0，翻页传返回的 maxId）
ApiResponse sns = client.sns.snsList(0, true, "", token);

// 获取指定好友的朋友圈
ApiResponse friendSns = client.sns.friendsSnsList(0, true, "wxid_aaa", "", token);

// 获取某条朋友圈详情
ApiResponse detail = client.sns.snsDetails(123456, token);

// 发送文字朋友圈
client.sns.snsSendText(List.of(), List.of(), List.of(), "今天天气真好！", false, List.of(), List.of(), token);

// 上传朋友圈图片（1-9张）
ApiResponse upload = client.sns.snsUploadImage(Arrays.asList("https://example.com/photo.jpg"), token);

// 发送链接朋友圈
client.sns.snsSendUrl(List.of(), List.of(), List.of(), "推荐一篇文章", "文章描述", "文章标题", "https://example.com/article", "https://example.com/thumb.jpg", false, List.of(), List.of(), token);

// 点赞（operType: 1点赞 2取消）
client.sns.snsLike(123456, 1, "wxid_aaa", token);

// 评论（operType: 1评论 2删除评论）
client.sns.snsComment(123456, 1, "wxid_aaa", 0, "写得真好！", token);

// 设置朋友圈可见范围（1全部 2半年 3一个月 4三天）
client.sns.snsScope(1, token);

// 是否允许陌生人查看朋友圈
client.sns.snsVisibilityEnable(false, token);
```

### 视频号

```java
// 获取我的视频号信息
ApiResponse profile = client.finder.getProfile(token);

// 获取我的视频号二维码
client.finder.getQrCode("my_username", 3, token);

// 搜索视频号（category: 1全部 2账号）
ApiResponse results = client.finder.finderSearch("人民日报", token);

// 获取用户主页
ApiResponse page = client.finder.userPage("v2_xxx@finder", token);

// 关注（opType: 1关注 2取消关注）
client.finder.follow("my_username", 3, 1, "v2_target@finder", token);

// 获取关注列表
ApiResponse follows = client.finder.followList("my_username", 3, token);

// 浏览视频
client.finder.browse("my_username", "nonce_id", "session_buffer", 14195037502970006000L, 3, token);

// 评论（opType: 0评论 1删除评论）
client.finder.comment("my_username", 0, "nonce_id", "session_buffer", 14195037502970006000L, 3, "评论内容", "", token);

// 根据id点赞（opType: 1点赞 2取消）
client.finder.idFav("my_username", 1, "nonce_id", "session_buffer", 14195037502970006000L, "v2_target@finder", 3, token);

// 发布视频（需ipad协议）
client.finder.publishFinderWeb("视频标题", "https://video_url", "https://thumb_url", "#话题", token);

// 上传CDN视频 + 发布（适合多号批量发布）
ApiResponse cdnInfo = client.finder.uploadFinderVideo("https://video_url", "https://cover_url", token);
// 用返回的 cdn 信息发布
// client.finder.publishFinderCdn("my_username", 3, "视频描述", cdnData, token, "", Arrays.asList("#话题1", "#话题2"));

// 获取消息列表（reqScene: 3点赞 4评论 5关注）
ApiResponse mentions = client.finder.mentionList("my_username", 3, 4, token);

// 私信功能
ApiResponse contact = client.finder.contactList("my_username", "v2_target@finder", 3, token);
client.finder.postPrivateLetter("你好", "session_id", "my_username", "v2_target@finder", token);

// 扫码操作
client.finder.scanBrowse("my_username", 3, "https://weixin.qq.com/sph/xxx", 14195037502970006000L, token);
client.finder.scanFav("my_username", 3, "https://weixin.qq.com/sph/xxx", 14195037502970006000L, token);
```

---

## 注意事项

- 朋友圈相关接口建议上号 1-3 天后再使用
- 通讯录列表接口（`contactsList`）为长耗时接口，建议使用缓存版本（`contactsListCache`）
- 批量查询接口（`briefInfo`、`detailInfo`、`checkRelation`）单次最多 20 个
- 视频号部分接口（`publishFinderWeb`、`syncPrivateLetterMsg`）需使用 iPad 协议登录

## 项目结构

```
src/main/java/online/wechatbot/sdk/
├── WeChatBotClient.java      主客户端（Builder模式）
├── ApiResponse.java           统一响应类型
└── modules/
    ├── AuthModule.java        登录认证
    ├── MessageModule.java     消息收发
    ├── GroupModule.java       群聊管理
    ├── ContactModule.java     联系人管理
    ├── PersonalModule.java    个人信息
    ├── FavoriteModule.java    收藏夹
    ├── LabelModule.java       标签管理
    ├── DownModule.java        资源下载
    ├── SnsModule.java         朋友圈
    └── FinderModule.java      视频号
```

## 许可证

[MIT License](LICENSE)

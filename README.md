# AndroidTrojan
This is a project of a Trojan in Android.

&nbsp;

## 贡献者

guaiyt、Qin、Alioth007、lasestrellas0、androidbigold

### 项目思路

首先开发出一款含有木马的app，在靶机（A）中下载安装。
木马拥有自启动和隐藏进程功能，能够读取A的数据（联系人等）。
由另一台手机（B）服务端控制木马，当需要读取A的数据时，B向A中微信账户发送特定指令。木马读取微信，并在收到特定联系人的消息时自动回复图片，将数据隐写在图片当中，然后删除聊天记录。（如数据过大则需发送多张图片）。

#### 待确定项

含有木马的app的功能
所发送图片的内容
读取A中的何种数据
微信账户

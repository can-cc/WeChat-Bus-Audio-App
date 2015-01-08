# TyanWeChatBusAudio

微信交通英语听力学习应用

起因：之前有一段时间每天都要坐很久的公交车，公交车上不喜欢玩手机，对眼睛不好，而且很吵，很不喜欢，所以我会下载一音乐来听，久了之后音乐也腻了，而且觉得这时间用来听听英语听力也好，但是每天晚上都有点忙，都会忘记下载一些听力音频到手机上。然后突然想到，不如做一个微信订阅号吧，文字控制，推送出听力的url，随时也能。

环境：架构在SAE之上，在本地测试良好，没有放上去SAE，后来也不用每天公交了，加上觉得要维护起来挺麻烦的，加上现在也挺忙，遂没有上线，只是在本地跑了几把。

required：mencached，mysql，spring framework，spring jdbc，maven，junit等等

概述：
有web和wechat两个前端实现，后端api统一。

用spring security框架做的验证和安全验证，只留了一个admi帐号，因为本应用不需要用户登陆，属于轻应用，需要用户登陆会引反感。而微信端的cached用微信的uid。

微信端的message用工厂设计模式，应用层用Spring的IoC，遵循开闭原则。

admin后台CURD目录和音频，数据库还留了权限设计。储存方面，如果在SAE只需要改动设置就可以上传到Storage。用spring jdbc实现DAO层，service层做了进一步的封装（这里承认设计繁琐了，用java就容易这个毛病），上传后用开源工具计算出音频长度，bitrate。

控制层用spring mvc（现在springmvc真是越来越好了）。

web端做得比较传统，微信端用文字操作（像不像shell？微信订阅号让人们都返祖了^_^），用memcached记录，没有考虑缓存算法（以后得补，不过memcached已经实现了）。

junit半测试驱动。

Todo：
加入音频的译文。
缓存记录进一步处理。
推荐算法。
热门音频列表。

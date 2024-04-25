# 开放玩具控制器
 [![](https://img.shields.io/badge/-TelegramChat-f2f3f4?style=flat-square&logo=Telegram&logoColor=2ca5e0)](https://t.me/dglabfun)
## 支持的玩具
- 郊狼2.0 & 3.0
- JEUSN扣动毒龙钻扣动AI款 (开发测试优化中)
   
## 游戏连接教程
- 连接设备
- 本app中启动娱乐模式
- 启动第三方软件
	- 部分支持自动连接本地 (需要本控制器和游戏在同一台设备上运行)
 	- 部分需要输入ip地址 (连接wifi后启动娱乐模式会有显示)

### [请为接下来要适配的小玩具投票>>](https://jinshuju.net/f/tptsRE)
[控制器下载](https://github.com/open-toys-controller/open-DGLAB-controller/releases/latest) (请挂梯子)

## API接口简单示例: 设置波形和强度
你可以使用python/网页等几乎所有编程语言控制玩具  
[查阅完整API](api.md)  
WebSocket连接`ws://127.0.0.1:60536/1`  
- 为什么使用WebSocket
	- 支持掉线检测, 尽早发现掉线
	- 支持浏览器和小程序

这里ip是开启了娱乐模式的手机  
`/1`代表API版本号为1, 照着填就好. 老版本api已做兼容处理  
连接以后, 将以下dictionary转换为json并发送  
```
{  
    "cmd": "set_pattern",  
    "pattern_name": "经典",  
    "intensity":100,  
    "ticks": -1  
}
```

| key | type | 解释 |
| ---- | ---- | ---- |
| cmd | str | 指令类型, set_pattern设置波形 |
| pattern_name | str | app内能够看到的波形名称, 没有则输出"经典"波形 |
| intensity | int | 0≤强度≤100 |
| ticks | int | 持续时间   0:完整播放一遍波形后停止, -1:循环, 正整数:执行0.1 * ticks秒 |


# Awesome open-DGLAB-controller
### 恶魔轮盘赌郊狼版
![17103997466612](https://github.com/open-toys-controller/open-DGLAB-controller/assets/163114276/e37361f9-3186-4f3e-8a3e-e5b0a13b1d69)

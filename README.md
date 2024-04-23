# 开放郊狼控制器
 [![](https://img.shields.io/badge/-TelegramChat-f2f3f4?style=flat-square&logo=Telegram&logoColor=2ca5e0)](https://t.me/dglabfun)
## 支持2.0 & 3.0
2.0目前存在bug正在修复  
   
## 使用教程
- 连接郊狼
- 启动娱乐模式
- 启动第三方软件

### [请为接下来要适配的小玩具投票>>](https://jinshuju.net/f/tptsRE)
[控制器下载](https://github.com/open-toys-controller/open-DGLAB-controller/releases/latest)

## API示例: 设置波形和强度
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


# 更多API
### 停止输出波形
```
{  
    "cmd": "stop_pattern"
}
```

### 防止掉线
websocket的优势之一就是能够通过onClose回调尽早发现掉线, 检测到连接断开以后应尝试重连并告知用户  
对于长时间不会有消息传输的使用情况, 可以每分钟向服务器发送非法消息用来保持连接 例如`ping`

# API NEXT
**以下api还没有实现且可能被大改**  
也许会在未来不久实现, 如果你需要, 请**发issue或直接联系**. 否则我可能会鸽很久:D  
### api自定义波形
```
{  
    "cmd": "set_pattern",  
    "pattern_units": [
        {pattern_intensity:50, frequency:100},
        {pattern_intensity:80, frequency:100},
        {pattern_intensity:100, frequency:100},
    ],  
    "intensity":100,  
    "ticks": -1
}
```
实际强度 = (pattern_intensity / 100.0) * (intensity / 100.0) * app中设置的最大强度

### 背景波形设置
优先执行"set_pattern", 在没有"set_pattern"指令执行的情况下输出背景波形
```
{  
    "cmd": "set_background_pattern",  
    "pattern_units": [
        {intensity:50, frequency:100},
        {intensity:80, frequency:100},
        {intensity:100, frequency:100},
    ],  
    "intensity":60,  
    "ticks": -1
}
```

### api修改强度上限
需要在app中允许程序修改强度上限
```
{  
    "cmd": "change_max_intensity",  
    "delta_intensity":10,  
}
```
| key | type | 解释 |
| ---- | ---- | ---- |
| delta_intensity | int 可为负数 | 强度上限变化值 |














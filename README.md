# 开放郊狼控制器
## 支持2.0 & 3.0
 [![](https://img.shields.io/badge/-TelegramChat-f2f3f4?style=flat-square&logo=Telegram&logoColor=2ca5e0)](https://t.me/dglabfun)
   
## 使用教程
- 连接郊狼
- 启动娱乐模式
- 启动第三方软件

### [请为接下来要适配的小玩具投票>>](https://jinshuju.net/f/tptsRE)
[控制器下载](https://github.com/open-toys-controller/open-DGLAB-controller/releases/latest)

## API示例: 设置波形和强度
WebSocket连接`ws://127.0.0.1:60536`  
这里ip是连接了郊狼并且开启了娱乐模式的手机  
连接以后, 将以下dictionary转换为json发送到设备  
```
{  
    "version": 1,  
    "cmd": "set_pattern",  
    "pattern_name": "经典",  
    "intensity":100,  
    "ticks": -1  
}
```

| key | type | 解释 |
| ---- | ---- | ---- |
| version | int | api版本号, 填1就好 |
| cmd | str | 指令类型, set_pattern设置波形 |
| pattern_name | str | app内能够看到的波形名称 |
| intensity | int | 0≤强度≤100 |
| ticks | int | 持续时间   0完整播放一遍波形, -1循环, 正整数:每个tick代表执行0.1秒 |

# Awesome open-DGLAB-controller
### 恶魔轮盘赌郊狼版
![17103997466612](https://github.com/open-toys-controller/open-DGLAB-controller/assets/163114276/e37361f9-3186-4f3e-8a3e-e5b0a13b1d69)


















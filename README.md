# 开放郊狼控制器
## 支持2.0 & 3.0
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























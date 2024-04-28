TIPS: V1.2.0 以后版本可以点游戏模式左侧的那个游戏手柄图标快速启动服务器, 无需连接设备
## WebSocket 服务器地址和 API版本号
设置 api 版本号的目的是防止游戏使用新的 api , 但是控制器并不支持的情况. 对于V1.2.0 以后的控制器, 当 api 不受支持时会自动弹窗告知用户更新. **请选择正确的 API 版本号**, 否则在低版本控制器上无法正常运行

**当前文档除特殊标注，默认API 版本号为「 1 」**

API 版本号在连接 websocket 时提交, 控制器启动娱乐模式后自动在手机创建服务器, OTC 控制器作为 websocket服务端, 你的游戏作为 websocket 客户端, 连接地址为:  `ws://控制器所在的IP地址:60536/api版本号`   
api 版本号应取最大值, 例如, 游戏使用了某 2个 api 且文中分别注明了"最低 api 版本: 0"和"最低 api 版本: 1", 则api 版本号应使用 1, 如果没有特别注明最低 api 版本, 则为上面"「」"中的的默认版本, 若此时控制器与游戏在同一台设备上运行, 那么应创建的 websocket 连接为: `ws://127.0.0.1:60536/1`  
## 波形 / 强度
**示例**  
通过 app 内置名称指定波形
```
{  
    "cmd": "set_pattern",  
    "pattern_name": "经典",  
    "intensity":100,  
    "ticks": -1  
}
```

自定义波形
```
{  
    "cmd": "set_pattern",  
    "pattern_units": [  //波形总共0.3秒
        {"pattern_intensity":50, "frequency":100},  //0.1秒
        {"pattern_intensity":80, "frequency":100},  //0.1秒
        {"pattern_intensity":100, "frequency":100}, //0.1秒
    ],  
    "intensity":100,  
    "ticks": 66  //循环执行波形6.6秒
}
```

修改强度
```
{  
    "cmd": "set_pattern",  
    "intensity":100 //将AB通道强度都设置为100%
}
```

**解释**  
"可选"代表可以选择性的传递一个或多个参数 (可以单独设置强度)  

| key           | 数据类型                    | 解释                                                     |
| ------------- | ----------------------- | ------------------------------------------------------ |
| cmd           | string                  | 指令类型，填set_pattern 代表本指令为设置波形和强度                        |
| pattern_name  | string(可选)              | 通过指定波形名称，同时修改 AB 通道的波形。波形名需要能够在 app 内看到, 名称错误则输出"经典"波形 |
| pattern_units | obj(可选)                 | 自定义波形, 见下文说明                                           |
| intensity     | int (可选)                | 0≤强度≤100                                               |
| ticks         | int (仅设置波形时必填, 设置强度时可选) | 波形持续时间。   0 代表完整播放一遍波形后停止。 -1：循环。正整数：执行0.1 * ticks秒    |

**pattern_units解释**  
一个数组array (python中称之为列表list) 里面套字典. 没看明白的看上面的例子

| key               | type | 解释         |
| ----------------- | ---- | ---------- |
| pattern_intensity | int  | 0≤波形强度≤100 |
| frequency         | int  | 0≤波形频率≤100 |

`实际强度 = (波形强度 / 100.0) * (intensity / 100.0) * app中设置的最大强度`


### 分通道设置
| key             | 数据类型           | 解释             |
| --------------- | -------------- | -------------- |
| A_pattern_name  | string (可选)    | 同上，但是单独设置 A 通道 |
| B_pattern_name  | string (可选)    | 同上，但是单独设置 B 通道 |
| A_pattern_units | obj (可选)       | 同上，但是单独设置 A 通道 |
| B_pattern_units | obj (可选)       | 同上，但是单独设置 B 通道 |
| A_intensity     | int (可选)       | 同上，但是单独设置 A 通道 |
| B_intensity     | int (可选)       | 同上，但是单独设置 B 通道 |
| A_ticks  <br>   | int (仅设置波形时必填) | 同上，但是单独设置 A 通道 |
| B_ticks         | int (仅设置波形时必填) | 同上，但是单独设置 B 通道 |

单独设置 B 通道
```
{ 
    "cmd": "set_pattern",  
    "B_pattern_name": "经典",  
    "intensity": 100, //双通道都设置为100% 
    "B_ticks": 5  
}
```

单独设置 AB 通道
```
{ 
    "cmd": "set_pattern",  
    "pattern_units": [
		{"pattern_intensity":50, "frequency":100},
  		{"pattern_intensity":80, "frequency":100},
  		{"pattern_intensity":100, "frequency":100},
    ], 
    "B_pattern_name": "经典",//分通道设置的优先级更高, A通道依然使用"pattern_units"定义的波形,B通道采用"经典", 强度和持续时间的设置同理
    "intensity": 100, //双通道都设置为100% 
    "ticks": 50,//pattern_units对应ticks, A_ticks对pattern_units无效
    "B_ticks": 5  
}
```

## 读取 app 内设置的强度上限
这个能够用于 "最大强度必须大于多少" 的惩罚场景?  
客户端发送请求
```
{  
    "cmd": "get_max_intensity"
}
```

回复 (示例)
```
{
	"type": "max_intensity",
	"A_max": 100,
	"B_max": 292
}
```
## 停止输出波形
```
{  
    "cmd": "stop_pattern"
}
```

## 防止掉线
websocket的优势之一就是能够通过onClose回调尽早发现掉线, 检测到连接断开以后应尝试重连并告知用户  
部分编程语言连接后长时间无消息可能导致websocket关闭, 对此, 可以每30秒向服务器发送非法消息用来保持连接例如 `ping`






.  
.  
.  
.  
.  
# API NEXT 欢迎提建议
**以下api均未实现, 如果有需要请发 issue 或直接联系. 否则我可能会鸽很久:D**  
聊天群 425392074

### 多玩具控制

| 玩具分类     | 解释  | 包含的玩具            |
| -------- | --- | ---------------- |
| estim    | 电击类 | 郊狼 2.0 & 3.0     |
| vibrator | 震动类 | jeusn 毒龙钻扣动 AI 版 |
|          | 飞机杯 |                  |
|          | 灌肠类 |                  |
|          | 炮机  |                  |

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

| key             | type     | 解释      |
| --------------- | -------- | ------- |
| delta_intensity | int 可为负数 | 强度上限变化值 |

## 设置波形和强度
通过app内置名称指定波形
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
    "pattern_units": [
        {pattern_intensity:50, frequency:100},
        {pattern_intensity:80, frequency:100},
        {pattern_intensity:100, frequency:100},
    ],  
    "intensity":100,  
    "ticks": -1
}
```
解释

| key           | type    | 解释                                              |
| ------------- | ------- | ----------------------------------------------- |
| cmd           | str     | 指令类型, set_pattern设置波形                           |
| pattern_name  | str(可选) | app内能够看到的波形名称, 名称错误则输出"经典"波形                    |
| pattern_units | obj(可选) | 见下文说明                                           |
| intensity     | int     | 0≤强度≤100                                        |
| ticks         | int     | 持续时间   0:完整播放一遍波形后停止, -1:循环, 正整数:执行0.1 * ticks秒 |

pattern_units解释  
一个数组array (python中称之为列表list) 里面套字典. 没看明白的看上面的例子

| key               | type | 解释         |
| ----------------- | ---- | ---------- |
| pattern_intensity | int  | 0≤波形强度≤100 |
| frequency         | int  | 0≤波形频率≤100 |


`实际强度 = (波形强度 / 100.0) * (intensity / 100.0) * app中设置的最大强度`

## 停止输出波形
```
{  
    "cmd": "stop_pattern"
}
```

## 防止掉线
websocket的优势之一就是能够通过onClose回调尽早发现掉线, 检测到连接断开以后应尝试重连并告知用户  
对于长时间不会有消息传输的使用情况, 可以每分钟向服务器发送非法消息用来保持连接 例如`ping`

## api版本检测
连接以后控制器自动发送`{'api_version': api版本号}`, 此处版本号为int, 每次更新api递增, 对于文档中明确标明了最低api版本的新api, 请做好校验
.  
.  
.  
.  
.  
.  
# API NEXT
**以下api均未实现, 如果有需要请发pr或直接联系. 否则我可能会鸽很久:D**
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

# 开放玩具控制器 (OTC控制器)
 [![](https://img.shields.io/badge/-TelegramChat-f2f3f4?style=flat-square&logo=Telegram&logoColor=2ca5e0)](https://t.me/dglabfun)
## 支持的玩具
- 郊狼2.0 & 3.0
- JEUSN扣动毒龙钻扣动AI款 (开发测试优化中)
   
## 游戏连接教程
- 连接设备
- 本app中启动娱乐模式
- 启动第三方软件
	- 支持自动连接本地 (需要本控制器和游戏在同一台设备上运行)
 	- 控制器与游戏不在同一台设备需要输入ip地址 (连接wifi后启动娱乐模式会有显示)

### [请为接下来要适配的小玩具投票>>](https://jinshuju.net/f/tptsRE)
### [控制器下载](https://github.com/open-toys-controller/open-DGLAB-controller/releases/latest) (请挂梯子)
### 现有项目展示见本页面末尾

## API接口简单示例: 设置波形和强度
你可以使用python/网页等**任意编程语言**控制多款玩具  
[查阅完整API](api.md)  
WebSocket连接`ws://127.0.0.1:60536/1`  
- 为什么使用WebSocket
	- 支持掉线检测, 尽早发现掉线
	- 支持浏览器和小程序

这里ip是进入娱乐模式的本控制器所在的ip地址  
`/1`代表API版本号为1, 照着填就好. 老版本api已做兼容处理  
连接以后, 将以下内容转换为json并发送  
```
{  
    "cmd": "set_pattern",  
    "pattern_name": "经典",  
    "intensity":100,  
    "ticks": -1  
}
```
切换波形为"经典", 强度100%, 循环执行, 直到停止指令


# Awesome open-DGLAB-controller
在此添加你的项目请直接pr,issue也行
## 恶魔轮盘赌郊狼版
[下载链接(挂梯子)](https://www.mediafire.com/file/95rregr8n15wrnf/main_game.apk/file)  
![17103997466612](https://github.com/open-toys-controller/open-DGLAB-controller/assets/163114276/e37361f9-3186-4f3e-8a3e-e5b0a13b1d69)

## DGLabMouseListener
[github仓库](https://github.com/lxyddice/DGLabMouseListener)  
郊狼好玩喵  
监听鼠标事件进行电击，可自定义配置强度和时间，来进行一些奇奇怪怪的play吧

1, Runtimer主线程

    1.1，EventBusListener/SPI
    订阅事件，转发
        EventBusOnRocketMQListener
        Queue

    1.2 Filter&Transformer
        EventRuleTransfer
        CPU

    1.3 EventTargetPusher
        IO

TODO:
OpenMessage as base
Record

    MVP edition

    Run mvp demo

    next meeting: next weekly, 3.5 20:00

TODO:
metrics, logger, exception
detail

3.10 Note
本次会议纪要：
1、runtimer配置从DB加载；
2、任务配置的命名：targetRunner；
3、更新任务配置：从Service修改成API+存储 Watch；
4、EventBusListener： 不能出现RMQ&Message，只能围绕Connect Recorded；
5、EventBusListener：支持位点提交；

下次会议时间：3月14日，下周二 19:00






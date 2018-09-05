test-zuul-bug:
	这是用于在项目发现以为是bug而专门创建的工程,就是当我在Zuul创建接口/auth/brand/all 接口的时候,其他服务调用会发现url变成了/brand/all 丢失了/auth...突然间被蠢哭,zuul @EnableZuulProxy的特性,具有路由转发的特性,而我服务注册中有auth...so thats clear

rabbitmq-test:
	用于回顾下rabbitmq,有发送消息确认,是失败的callback

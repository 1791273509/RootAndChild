maven父工程模块
1、注意父工程的pom.xml必须打包成pom才能运行插件。
子工程之间相互引用可能导致父工程clean失败
2、子模块的parent引入父工程的gav即可
3、子模块一般类路径在父的启动类下面这样spring启动的时候
就可以放入容器中了
4、可以使用@PropertySource(value = {"classpath:application-demo1-dev.properties", "classpath:application.properties"})
来引入子模块的配置文件
其他待添加
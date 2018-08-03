# SpringCloudConfig  分布式配置中心
在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。在spring cloud config 组件中，分两个角色，一是config server，二是config client。

### 构建Config Server
需要在程序的配置文件application.properties文件配置以下：

spring.application.name=config-server

server.port=8888

#配置git仓库地址<br>
spring.cloud.config.server.git.uri=https://github.com/IvanHost/SpringCloudConfig

#配置仓库路径<br>
spring.cloud.config.server.git.searchPaths=resp

#配置仓库的分支名称<br>
spring.cloud.config.label=master

#访问git仓库的用户名<br>
spring.cloud.config.server.git.username=

#访问git仓库的用户密码<br>
spring.cloud.config.server.git.password=


### 构建一个Config Client
需要在程序的配置文件application.properties文件配置以下：

server.port=8881

#配置应用名称，通常是业务系统名称<br>
spring.application.name=config-client

#配置仓库的分支名称<br>
spring.cloud.config.label=master

#配置环境标识（区分开发、测试、UAT和生产环境）<br>
spring.cloud.config.profile=dev

#配置中心服务端地址<br>
spring.cloud.config.uri= http://localhost:8888/

#通过注解读取配置项的内容 <br/>
@Value("${attr}")

#v1.0.0
> 初始化项目机构

```
.
├── README.md
├── pom.xml
├── spring-boot-seed.iml
├── spring-boot-seed.log
└── src
    ├── main
    │   ├── java
    │   │   └── site
    │   │       └── igeek
    │   │           ├── ApplicationLauncher.java
    │   │           ├── config
    │   │           ├── controller
    │   │           │   └── UserController.java
    │   │           ├── convert
    │   │           │   └── PaginationDataConvert.java
    │   │           ├── exception
    │   │           │   └── ControllerError.java
    │   │           ├── model
    │   │           │   ├── common
    │   │           │   │   ├── JsonResponse.java
    │   │           │   │   ├── Pagination.java
    │   │           │   │   └── PaginationData.java
    │   │           │   └── po
    │   │           │       └── User.java
    │   │           ├── repository
    │   │           │   └── UserRepository.java
    │   │           └── service
    │   │               └── UserService.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── site
                └── igeek
                    └── repository
                        └── UserRepositoryTest.java


```
#v1.0.1R20160505
>

- 添加服务监控 actuator
- 添加序列化和反序列化 忽略字段(Gson)
- 添加简单的权限拦截
- 添加项目上下文路径
- 添加监控上下文路径


#v1.0.2R20160614

> 添加方法监控

```
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : =============================================
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 类名为:site.igeek.controller.UserController
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 方法名字为:getAllUser
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 形参类型[int, int, java.lang.String, boolean]
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 形参名称[pageIndex, pageSize, orderBy, asc]
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 实参内容[1, 10, account, false]
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 方法耗时:957
2016-06-14 15:34:18.369  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : 方法耗时:957
2016-06-14 15:34:18.370  INFO 18745 --- [nio-8080-exec-1] site.igeek.monitor.ExecuteAspect         : =============================================
```
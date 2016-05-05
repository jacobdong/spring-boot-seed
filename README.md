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
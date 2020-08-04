
## 说明

- component // 组件库
- document // 文档库
- base  // 技术代码库
- common    // 业务代码库
- support   // 非公共性质的不同版本代码库
- support-v1 // 兼容库
- support-v2 // 兼容库
- utils     // 工具库


## 仓库

### 镜像仓库

- https://maven.aliyun.com/mvn/guide

### 查询仓库

- https://maven.aliyun.com/mvn/search

```Django
group-id: com.android.support
artifact-id: support-annotations
version: xxx
```

## 依赖

参考如下命令:

```Django
// 参考地址:
https://blog.csdn.net/DovSnier/article/details/91875631

// 单节点
./gradlew -q :app:dependencies --configuration implementation > dependencies.txt
./gradlew -q :library:base:dependencies --configuration implementation > dependencies.txt
./gradlew -q :library:common:dependencies --configuration implementation > dependencies.txt
./gradlew -q :support:support:dependencies --configuration implementation > dependencies.txt
./gradlew -q :support:support_v2:dependencies --configuration implementation > dependencies.txt
./gradlew -q :tools:utils:dependencies --configuration implementation > dependencies.txt

// 完整性
./gradlew -q :app:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :library:base:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :library:common:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :support:support:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :support:support_v2:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :tools:utils:dependencies --configuration debugCompileClasspath > dependencies.txt

// Android dependencies
./gradlew -q --warning-mode all androidDependencies > dependencies.txt
./gradlew -q :app:dependencies > dependencies.txt
./gradlew -q :app:dependencies --configuration debugCompileClasspath > dependencies.txt
./gradlew -q :app:dependencies :library:base:dependencies :library:common:dependencies --configuration debugCompileClasspath > dependencies.txt

// component recyclerview-v7
./gradlew -q :app:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :app:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :library:base:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :library:common:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :support:support:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :support:support_v2:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt
./gradlew -q :tools:utils:dependencyInsight --configuration debugCompileClasspath --dependency recyclerview-v7 > dependencies.txt


    :app
    :document
    :library:base
    :library:common
    :support:support
    :support:support_v2
    :tools:utils
    :tools:template
    :java:javaKit
```  

### 举例

脚本参考:

```
    ./gradlew :app:dependencies :document:dependencies :library:base:dependencies :library:common:dependencies :support:support:dependencies :support:support_v2:dependencies :tools:utils:dependencies :tools:template:dependencies --configuration debugCompileClasspath > dependencies.txt
    
    ./gradlew :app:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :document:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :library:base:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :library:common:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :support:support:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :support:support_v2:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :tools:utils:dependencies --configuration debugCompileClasspath > dependencies.txt 
    ./gradlew :tools:template:dependencies --configuration debugCompileClasspath > dependencies.txt
```
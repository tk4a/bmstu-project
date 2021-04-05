package bmstu.configuration;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0092\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lbmstu/configuration/AppConfig;", "Lorg/springframework/boot/ApplicationRunner;", "homeServiceImpl", "Lbmstu/service/impl/HomeServiceImpl;", "busStopServiceImpl", "Lbmstu/service/impl/BusStopServiceImpl;", "homeDtoServiceImpl", "Lbmstu/service/impl/HomeDtoServiceImpl;", "(Lbmstu/service/impl/HomeServiceImpl;Lbmstu/service/impl/BusStopServiceImpl;Lbmstu/service/impl/HomeDtoServiceImpl;)V", "run", "", "args", "Lorg/springframework/boot/ApplicationArguments;", "service"})
@org.springframework.context.annotation.Configuration()
public class AppConfig implements org.springframework.boot.ApplicationRunner {
    private final bmstu.service.impl.HomeServiceImpl homeServiceImpl = null;
    private final bmstu.service.impl.BusStopServiceImpl busStopServiceImpl = null;
    private final bmstu.service.impl.HomeDtoServiceImpl homeDtoServiceImpl = null;
    
    @java.lang.Override()
    public void run(@org.jetbrains.annotations.Nullable()
    org.springframework.boot.ApplicationArguments args) {
    }
    
    public AppConfig(@org.jetbrains.annotations.NotNull()
    bmstu.service.impl.HomeServiceImpl homeServiceImpl, @org.jetbrains.annotations.NotNull()
    bmstu.service.impl.BusStopServiceImpl busStopServiceImpl, @org.jetbrains.annotations.NotNull()
    bmstu.service.impl.HomeDtoServiceImpl homeDtoServiceImpl) {
        super();
    }
}
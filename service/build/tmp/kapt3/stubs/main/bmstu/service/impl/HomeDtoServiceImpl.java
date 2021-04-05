package bmstu.service.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u001b\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u0002H\u000eH\u0016\u00a2\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lbmstu/service/impl/HomeDtoServiceImpl;", "Lbmstu/service/DtoService;", "Lbmstu/dto/Home;", "homeDtoRepository", "Lbmstu/repository/HomeDtoRepository;", "(Lbmstu/repository/HomeDtoRepository;)V", "getAll", "", "getHomeByBusStop", "id", "", "getOne", "save", "", "T", "obj", "(Ljava/lang/Object;)V", "saveAll", "", "list", "service"})
@org.springframework.stereotype.Service()
public class HomeDtoServiceImpl implements bmstu.service.DtoService<bmstu.dto.Home> {
    private final bmstu.repository.HomeDtoRepository homeDtoRepository = null;
    
    @java.lang.Override()
    public <T extends java.lang.Object>void save(T obj) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public bmstu.dto.Home getOne(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<bmstu.dto.Home> getAll() {
        return null;
    }
    
    @java.lang.Override()
    public <T extends java.lang.Object>void saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public bmstu.dto.Home getHomeByBusStop(long id) {
        return null;
    }
    
    public HomeDtoServiceImpl(@org.jetbrains.annotations.NotNull()
    bmstu.repository.HomeDtoRepository homeDtoRepository) {
        super();
    }
}
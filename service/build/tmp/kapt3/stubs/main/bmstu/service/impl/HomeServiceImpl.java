package bmstu.service.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001b\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000fH\u0016\u00a2\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u000e\"\b\b\u0000\u0010\u000f*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lbmstu/service/impl/HomeServiceImpl;", "Lbmstu/service/DtoService;", "Lbmstu/dto/entity/HomeFromDb;", "homeRepository", "Lbmstu/repository/HomeRepository;", "(Lbmstu/repository/HomeRepository;)V", "getHomeRepository", "()Lbmstu/repository/HomeRepository;", "getAll", "", "getOne", "id", "", "save", "", "T", "obj", "(Ljava/lang/Object;)V", "saveAll", "", "list", "service"})
@org.springframework.stereotype.Service()
public class HomeServiceImpl implements bmstu.service.DtoService<bmstu.dto.entity.HomeFromDb> {
    @org.jetbrains.annotations.NotNull()
    private final bmstu.repository.HomeRepository homeRepository = null;
    
    @java.lang.Override()
    public <T extends java.lang.Object>void save(T obj) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<bmstu.dto.entity.HomeFromDb> getAll() {
        return null;
    }
    
    @java.lang.Override()
    public <T extends java.lang.Object>void saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public bmstu.dto.entity.HomeFromDb getOne(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public bmstu.repository.HomeRepository getHomeRepository() {
        return null;
    }
    
    public HomeServiceImpl(@org.jetbrains.annotations.NotNull()
    bmstu.repository.HomeRepository homeRepository) {
        super();
    }
}
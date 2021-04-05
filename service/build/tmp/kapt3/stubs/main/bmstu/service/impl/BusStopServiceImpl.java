package bmstu.service.impl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0097\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\u001b\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00172\u0006\u0010\u0018\u001a\u0002H\u0017H\u0016\u00a2\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u0016\"\b\b\u0000\u0010\u0017*\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000fH\u0016J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001e"}, d2 = {"Lbmstu/service/impl/BusStopServiceImpl;", "Lbmstu/service/DtoService;", "Lbmstu/dto/entity/BusStopFromDb;", "busStopRepository", "Lbmstu/repository/BusStopRepository;", "(Lbmstu/repository/BusStopRepository;)V", "getBusStopRepository", "()Lbmstu/repository/BusStopRepository;", "component1", "copy", "equals", "", "other", "", "getAll", "", "getOne", "id", "", "hashCode", "", "save", "", "T", "obj", "(Ljava/lang/Object;)V", "saveAll", "list", "toString", "", "service"})
@org.springframework.stereotype.Service()
public class BusStopServiceImpl implements bmstu.service.DtoService<bmstu.dto.entity.BusStopFromDb> {
    @org.jetbrains.annotations.NotNull()
    private final bmstu.repository.BusStopRepository busStopRepository = null;
    
    @java.lang.Override()
    public <T extends java.lang.Object>void save(T obj) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<bmstu.dto.entity.BusStopFromDb> getAll() {
        return null;
    }
    
    @java.lang.Override()
    public <T extends java.lang.Object>void saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public bmstu.dto.entity.BusStopFromDb getOne(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public bmstu.repository.BusStopRepository getBusStopRepository() {
        return null;
    }
    
    public BusStopServiceImpl(@org.jetbrains.annotations.NotNull()
    bmstu.repository.BusStopRepository busStopRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final bmstu.repository.BusStopRepository component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final bmstu.service.impl.BusStopServiceImpl copy(@org.jetbrains.annotations.NotNull()
    bmstu.repository.BusStopRepository busStopRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}
package bmstu.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H&J\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u00020\n\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u000b\u001a\u0002H\u0001H&\u00a2\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\n\"\b\b\u0001\u0010\u0001*\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H&\u00a8\u0006\u000f"}, d2 = {"Lbmstu/service/DtoService;", "T", "", "getAll", "", "getOne", "id", "", "(J)Ljava/lang/Object;", "save", "", "obj", "(Ljava/lang/Object;)V", "saveAll", "list", "service"})
public abstract interface DtoService<T extends java.lang.Object> {
    
    public abstract <T extends java.lang.Object>void save(T obj);
    
    public abstract T getOne(long id);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<?> getAll();
    
    public abstract <T extends java.lang.Object>void saveAll(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> list);
}
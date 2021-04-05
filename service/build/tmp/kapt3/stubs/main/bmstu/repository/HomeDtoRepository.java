package bmstu.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H&\u00a8\u0006\u0006"}, d2 = {"Lbmstu/repository/HomeDtoRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lbmstu/dto/Home;", "", "getByBusStop", "id", "service"})
@org.springframework.stereotype.Repository()
public abstract interface HomeDtoRepository extends org.springframework.data.jpa.repository.JpaRepository<bmstu.dto.Home, java.lang.Long> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract bmstu.dto.Home getByBusStop(long id);
}
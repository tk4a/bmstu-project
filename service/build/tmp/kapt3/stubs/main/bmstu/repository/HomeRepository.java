package bmstu.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lbmstu/repository/HomeRepository;", "Lorg/springframework/data/jpa/repository/JpaRepository;", "Lbmstu/dto/entity/HomeFromDb;", "", "findAllByDistrict", "", "district", "", "service"})
@org.springframework.stereotype.Repository()
public abstract interface HomeRepository extends org.springframework.data.jpa.repository.JpaRepository<bmstu.dto.entity.HomeFromDb, java.lang.Long> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<bmstu.dto.entity.HomeFromDb> findAllByDistrict(@org.jetbrains.annotations.NotNull()
    java.lang.String district);
}
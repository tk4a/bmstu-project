package bmstu.dto.entity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002Bs\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010#\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010%\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0092\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00102\u001a\u000203H\u00d6\u0001J\t\u00104\u001a\u00020\u0006H\u00d6\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001f\u00a8\u00065"}, d2 = {"Lbmstu/dto/entity/BusStopFromDb;", "", "()V", "global_id", "", "street", "", "admArea", "district", "routeNumbers", "stationName", "pavilion", "operatingOrgName", "entryState", "x", "", "y", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "getAdmArea", "()Ljava/lang/String;", "getDistrict", "getEntryState", "getGlobal_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOperatingOrgName", "getPavilion", "getRouteNumbers", "getStationName", "getStreet", "getX", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getY", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)Lbmstu/dto/entity/BusStopFromDb;", "equals", "", "other", "hashCode", "", "toString", "service"})
@javax.persistence.Table(name = "bus_stop_details")
@javax.persistence.Entity()
public final class BusStopFromDb {
    @org.jetbrains.annotations.Nullable()
    @javax.persistence.Id()
    private final java.lang.Long global_id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String street = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String admArea = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String district = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String routeNumbers = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String stationName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String pavilion = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String operatingOrgName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String entryState = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double x = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double y = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getGlobal_id() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStreet() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAdmArea() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDistrict() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRouteNumbers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStationName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPavilion() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOperatingOrgName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEntryState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getX() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getY() {
        return null;
    }
    
    public BusStopFromDb(@org.jetbrains.annotations.Nullable()
    java.lang.Long global_id, @org.jetbrains.annotations.Nullable()
    java.lang.String street, @org.jetbrains.annotations.Nullable()
    java.lang.String admArea, @org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    java.lang.String routeNumbers, @org.jetbrains.annotations.Nullable()
    java.lang.String stationName, @org.jetbrains.annotations.Nullable()
    java.lang.String pavilion, @org.jetbrains.annotations.Nullable()
    java.lang.String operatingOrgName, @org.jetbrains.annotations.Nullable()
    java.lang.String entryState, @org.jetbrains.annotations.Nullable()
    java.lang.Double x, @org.jetbrains.annotations.Nullable()
    java.lang.Double y) {
        super();
    }
    
    public BusStopFromDb() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final bmstu.dto.entity.BusStopFromDb copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long global_id, @org.jetbrains.annotations.Nullable()
    java.lang.String street, @org.jetbrains.annotations.Nullable()
    java.lang.String admArea, @org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    java.lang.String routeNumbers, @org.jetbrains.annotations.Nullable()
    java.lang.String stationName, @org.jetbrains.annotations.Nullable()
    java.lang.String pavilion, @org.jetbrains.annotations.Nullable()
    java.lang.String operatingOrgName, @org.jetbrains.annotations.Nullable()
    java.lang.String entryState, @org.jetbrains.annotations.Nullable()
    java.lang.Double x, @org.jetbrains.annotations.Nullable()
    java.lang.Double y) {
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
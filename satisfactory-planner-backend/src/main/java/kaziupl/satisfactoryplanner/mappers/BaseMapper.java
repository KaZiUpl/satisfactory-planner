package kaziupl.satisfactoryplanner.mappers;

public interface BaseMapper<Dto,Base> {
    Dto toDto(Base base);
    Base toBase(Dto dto);
}

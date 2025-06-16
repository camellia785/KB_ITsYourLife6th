package org.scoula.mapper;
import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    // 어노테이션으로 sql문 사용하는 방법
    @Select("SELECT sysdate()")
    public String getTime();

    public String getTime2();
    // TimeMapper.xml에 sql문 있는 것 실행시키는 방법
}
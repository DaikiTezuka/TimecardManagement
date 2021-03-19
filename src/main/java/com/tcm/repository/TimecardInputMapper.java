package com.tcm.repository;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tcm.dto.timecardinput.TimecardInputSqlDto;

@Mapper
public interface TimecardInputMapper {

	/**
	 * @return
	 */
	@Select("select * from work_day where user_id = #{id} and to_char(work_day, 'YYYYMM') = #{targetMonth} order by work_day")
	List<TimecardInputSqlDto> select(@Param("id") String id, @Param("targetMonth") String targetMonth);

	@Update("update"
			+" work_day"
			+" set"
			+" work_from = #{from},"
			+" work_to = #{to},"
			+" update_date = #{update}"
			+" where"
			+" work_day_id = #{id}")
	void updateWorkDay(@Param("id") String id, @Param("from") Timestamp from,
							@Param("to") Timestamp to, @Param("update") Timestamp update);
}

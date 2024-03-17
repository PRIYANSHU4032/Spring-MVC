package com.zig.first;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zig.first.Model.Alien;

public interface AlienRepo extends JpaRepository<Alien,String> {

	//List<Alien> findByAnameOrderByAidDesc(String aname);
	@Query("from Alien where aname= :name")
	List<Alien> find(@Param("name")String anme);

	boolean existsByAidAndAname(String aid, String aname);
	
}

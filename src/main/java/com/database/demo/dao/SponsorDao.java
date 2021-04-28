package com.database.demo.dao;

import com.database.demo.dao.provider.SponsorDynaSQLProvider;
import com.database.demo.entity.Sponsor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface SponsorDao {
    @Select("select * from zl_sponsor")
    List<Sponsor> get_list();

    @SelectProvider(type= SponsorDynaSQLProvider.class,method="insert_sponsor")
    void insert_sponsor(Sponsor sponsor);

    @SelectProvider(type= SponsorDynaSQLProvider.class,method="update_sponsor")
    void update_sponsor(Sponsor sponsor);

    @Delete("delete from zl_sponsors where sid = #{sid}")
    int delete_sponsor(int sid);
}

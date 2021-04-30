package com.database.demo.service;

import com.database.demo.dao.SponsorDao;
import com.database.demo.entity.Sponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {
    @Autowired
    SponsorDao sponsorDao;

    public List<Sponsor> select_sponsors(){
        return sponsorDao.get_list();
    }

    public int insert_sponsor(Sponsor sponsor){
        if(sponsor.getSid()==null)
            return -1;
        sponsorDao.insert_sponsor(sponsor);
        return 0;
    }

    public void update_sponsor(Sponsor sponsor){
        sponsorDao.update_sponsor(sponsor);
    }

    public int delete_sponsor(int sid){
        return sponsorDao.delete_sponsor(sid);
    }
}

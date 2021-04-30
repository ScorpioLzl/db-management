package com.database.demo.service;

import com.database.demo.dao.CopyDao;
import com.database.demo.dao.CopyDao;
import com.database.demo.entity.Copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService {
    @Autowired
    CopyDao copyDao;

    public List<Copy> select_copies(){
        return copyDao.get_list();
    }

    public String countCopy(String bid){
        return copyDao.countCopy(bid);
    }

    public int insert_copy(Copy copy){
        if(copy.getCopyid()==null)
            return -1;
        copyDao.insert_copy(copy);
        return 0;
    }

    public void update_copy(Copy copy){
        copyDao.update_copy(copy);
    }

    public int delete_copy(int copyid){
        return copyDao.delete_copy(copyid);
    }
}

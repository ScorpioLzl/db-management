package com.database.demo.service;

import com.database.demo.dao.EventDao;
import com.database.demo.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    EventDao eventDao;

    public List<Event> select_events(){
        return eventDao.get_list();
    }

    public int insert_event(Event event){
        if(event.getEid()==null)
            return -1;
        eventDao.insert_event(event);
        return 0;
    }

    public void update_event(Event event){
        eventDao.update_event(event);
    }

    public int delete_event(int eid){
        return eventDao.delete_event(eid);
    }
}

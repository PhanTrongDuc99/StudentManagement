/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TimeKeepingDao;
import dao.TimeKeepingDaoImpl;
import entities.Teacher;
import entities.TimeKeeping;
import java.util.List;

/**
 *
 * @author USER
 */
public class TimeKeepingServiceImpl implements TimeKeepingService {

    private TimeKeepingDao tkDao;

    public TimeKeepingServiceImpl() {
        tkDao = new TimeKeepingDaoImpl();
    }

    @Override
    public TimeKeeping getTimeKeeping(String id) {
        return tkDao.getTimeKeeping(id);
    }

    @Override
    public List<TimeKeeping> getAll() {
        return tkDao.getAll();
    }

    @Override
    public void insertTimeKeeping(TimeKeeping timeKeeping) {
        tkDao.insertTimeKeeping(timeKeeping);
    }

}

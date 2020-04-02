/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ResultDao;
import dao.ResultDaoImpl;
import entities.Result;

/**
 *
 * @author SMILE ^^
 */
public class ResultServiceImpl implements ResultService {

    private ResultDao resultDao;

    public ResultServiceImpl() {
        resultDao = new ResultDaoImpl();
    }

    @Override
    public Result getResult(String id) {
        return resultDao.getResult(id);
    }

    @Override
    public boolean insertResult(Result result) {
        return resultDao.insertResult(result);
    }

    @Override
    public boolean deleteResultById(String id) {
        return resultDao.deleteResultById(id);
    }

}

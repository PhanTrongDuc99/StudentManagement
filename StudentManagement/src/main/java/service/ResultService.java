/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Result;

/**
 *
 * @author SMILE ^^
 */
public interface ResultService {

    public Result getResult(String id);

    public boolean insertResult(Result result);
}

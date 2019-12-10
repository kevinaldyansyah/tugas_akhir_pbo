/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokosepeda.backend;

import java.util.ArrayList;

/**
 *
 * @author Dharma
 */
public interface IGetResult {
    Object getById(int id);
    ArrayList<Object> getAll();
    ArrayList<Object> search(String keyword);
    void save();
    void delete();
}

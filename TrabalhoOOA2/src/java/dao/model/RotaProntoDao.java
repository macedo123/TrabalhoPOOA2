/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.model;

import dao.BaseDao;
import java.util.List;
import javax.persistence.Query;
import model.Rotapronta;

/**
 *
 * @author aluno
 */
public class RotaProntoDao extends BaseDao<Rotapronta>{
    public List<Rotapronta> findAll(){
        open();
        try{
            Query q = em.createNamedQuery("Rotapronta.findAll");
            return q.getResultList();
        }finally{
            close();
        }
    }
}

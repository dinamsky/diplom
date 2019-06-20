package com.restik.mydiplom.dao;

import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.entity.Tables;
import com.restik.mydiplom.exception.ProjException;
import com.restik.mydiplom.repositories.TablesRep;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TableDAO{
    @Autowired
    TablesRep tablesRep;

    public TableDAO(){

    }

    public Tables create(int tableNo, Restaurant restaurant)
    {


            Tables restTable = new Tables();

            restTable.setTableNo(tableNo);
            restTable.setTableStatus("vacant");
            restTable.setRestaurant(restaurant);
            //restAdmin.setRestaurant(rest);

            //getSession().merge(restAdmin);
            tablesRep.save(restTable);

            return restTable;

    }



//    public int update(int tableNo,String tableStatus, Restaurant rest)
//             {
//
//
//            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
//            q.setParameter("tableStatus",tableStatus);
//            q.setParameter("tableNo", tableNo);
//            int result = q.executeUpdate();
//
//
//
//            return result;
//
//
//    }
//
//    public int updateVacancy(int tableNo,String tableStatus, Restaurant rest)
//            throws ProjException {
//        try {
//            begin();
//
//
//            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
//            q.setString("tableStatus",tableStatus);
//            q.setInteger("tableNo", tableNo);
//            int result = q.executeUpdate();
//
//
//            //RestaurantTable restTable = restTable.getTableNo();
//            //getSession().delete(restTable);
//
//            commit();
//            return result;
//
//        } catch (HibernateException e) {
//            rollback();
//            throw new ProjException("Could not update table occupancy " , e);
//
//        }
//    }
//
//    public int updateUserTable(int tableNo,String tableStatus, Restaurant rest)
//            throws ProjException {
//        try {
//            begin();
//
//
//            Query q = getSession().createQuery("update RestaurantTable set tableStatus =:tableStatus where tableNo =:tableNo");
//            q.setParameter("tableStatus",tableStatus);
//            q.setParameter("tableNo",tableNo);
//            int result = q.executeUpdate();
//
//
//            //RestaurantTable restTable = restTable.getTableNo();
//            //getSession().delete(restTable);
//
//            commit();
//            return result;
//
//        } catch (HibernateException e) {
//            rollback();
//            throw new ProjException("Could not update table occupancy " , e);
//
//        }
//    }
//
//    public Tables fetchMyRestaurantTable(int tableNo)
//    {
//        try {
//            begin();
//            Query q = getSession().createQuery("from RestaurantTable where tableNo=:tableNo");
//            q.setParameter("tableNo",tableNo);
//            Tables restaurantTable =(Tables) q.uniqueResult();
//            commit();
//            return restaurantTable;
//
//        } catch (HibernateException e) {
//            rollback();
//            // throw new ProjException("Could not find match " + e.getMessage());
//            return null;
//
//        }
//
//    }

}

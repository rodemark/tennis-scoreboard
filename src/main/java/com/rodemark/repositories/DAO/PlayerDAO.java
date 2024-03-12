package com.rodemark.repositories.DAO;

import com.rodemark.models.Player;
import com.rodemark.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlayerDAO {
    public Player findById(Long id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Player.class, id);
    }
    public List<Player> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "FROM Player ";
        Query<Player> query = session.createQuery(hql, Player.class);
        return query.list();
    }

    public void save(Player player){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(player);
        transaction.commit();
        session.close();
    }

    public void update(Player player){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(player);
        transaction.commit();
        session.close();
    }

    public void delete(Player player){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(player);
        transaction.commit();
        session.close();
    }
}

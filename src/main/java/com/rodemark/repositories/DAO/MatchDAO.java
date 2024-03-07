package com.rodemark.repositories.DAO;

import com.rodemark.models.Match;
import com.rodemark.models.Player;
import com.rodemark.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MatchDAO {
    public Match findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Match.class, id);
    }
    public List<Match> findAll(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "FROM Match";
        Query<Match> query = session.createQuery(hql, Match.class);
        return query.list();
    }

    public List<Match> findMatchesByPlayer(Player player){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String hql = "FROM Match match WHERE match.player1 = :player1_ID OR match.player2 = :player2_ID";
        Query<Match> query = session.createQuery(hql, Match.class);
        query.setParameter("player1_ID", player.getID());
        return query.list();
    }


    public void save(Match match){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(match);
        transaction.commit();
        session.close();
    }

    public void update(Match match){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(match);
        transaction.commit();
        session.close();
    }

    public void delete(Match match){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(match);
        transaction.commit();
        session.close();
    }
}
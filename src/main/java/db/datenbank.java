package db;

import data.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class datenbank {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
    private static EntityManager em = emf.createEntityManager();

    public static void einfügen(Object kandiat){
        em.getTransaction().begin();
        em.persist(kandiat);
        em.getTransaction().commit();
    }

    public static Schmuck schmuckAbrufen(int nummer,String Art){
       Schmuck schmuck = null;
       em.getTransaction().begin();
       schmuck =  (Schmuck) em.find(giveObjekt(Art).getClass(),nummer);
       em.getTransaction().commit();
       return schmuck;
    }

    public static void update(Object object){
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public static void remove(Object object){
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
    }

    public static List tabelleAbrufen(String tabelle){
        em.getTransaction().begin();
        List List = em.createNativeQuery("SELECT * FROM "+tabelle,giveObjekt(tabelle).getClass()).getResultList();
        em.getTransaction().commit();
        return List;
    }

    private static Object giveObjekt(String klasse){
        switch (klasse){
            case("KUNDE"): return new Kunde();

            case("WARENKORB"): return new Warenkorb();

            case("SCHMUCK"): return new Schmuck();

            case("KETTE"): return new Kette();

            case("UHR"): return new Uhr();

            case("RING"): return new Ring();


        }
        return null;
    }

    }


package com.home.repository;

import com.home.model.Animal;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalRepository {
    private Session session = null;
    private CriteriaBuilder cb = null;

    public AnimalRepository() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        cb = session.getCriteriaBuilder();
    }

    // нахождение всех животных
    public List<Animal> findAllAnimal(){
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal>  root = criteriaQuery.from(Animal.class);
        criteriaQuery.select(root);
        return session.createQuery(criteriaQuery).getResultList();
    }

    // нахождение животных по id
    public Animal findAnimalById(Long id){
        try{
         CriteriaQuery<Animal> create = cb.createQuery(Animal.class);
         Root<Animal> root = create.from(Animal.class);
         create.select(root).where(cb.equal(root.get("id"),id));
         return session.createQuery(create).getSingleResult();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    //создание животного
    public boolean createAnimal(Animal animal){
        try {
            session.getTransaction().begin();
            session.persist(animal);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    //обновление
    public boolean updateAnimal(Animal animal){
        try {
            session.getTransaction().begin();
            session.merge(animal);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }

    //удаление животного
    public Boolean deleteAnimal(Long id){
        try {
            session.getTransaction().begin();
            session.remove(session.get(Animal.class,id));
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return false;
    }
}

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // insert
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);

//            // update - em.persist() 안해줘도 JPA가 알아서 다 해줌
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//
//            // delete
//            em.remove(findMember);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

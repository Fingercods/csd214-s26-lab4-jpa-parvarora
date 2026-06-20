package bookstore.jpa;

import bookstore.entities.GamingKeyboardEntity;
import bookstore.entities.GamingMouseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.UUID;

public class JpaGamingAccessoryApp {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("bookstore-pu");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("\n[step 1] create gaming mouse");

            em.getTransaction().begin();

            GamingMouseEntity mouse = new GamingMouseEntity(
                    "Logitech",
                    79.99,
                    16000
            );
            mouse.setProductId(UUID.randomUUID().toString());

            em.persist(mouse);

            em.getTransaction().commit();

            System.out.println("saved mouse id: " + mouse.getId());

            System.out.println("\n[step 2] read gaming mice");

            List<GamingMouseEntity> mice = em.createQuery(
                    "SELECT m FROM GamingMouseEntity m",
                    GamingMouseEntity.class
            ).getResultList();

            for (GamingMouseEntity m : mice) {
                System.out.println(m);
            }

            System.out.println("\n[step 3] update mouse dpi");

            em.getTransaction().begin();

            GamingMouseEntity savedMouse =
                    em.find(GamingMouseEntity.class, mouse.getId());

            if (savedMouse != null) {
                savedMouse.setDpi(20000);
            }

            em.getTransaction().commit();

            System.out.println("updated mouse: " + savedMouse);

            System.out.println("\n[step 4] create keyboard too");

            em.getTransaction().begin();

            GamingKeyboardEntity keyboard = new GamingKeyboardEntity(
                    "Razer",
                    129.99,
                    "Mechanical"
            );
            keyboard.setProductId(UUID.randomUUID().toString());

            em.persist(keyboard);

            em.getTransaction().commit();

            System.out.println("saved keyboard id: " + keyboard.getId());

            System.out.println("\n[step 5] delete mouse");

            em.getTransaction().begin();

            GamingMouseEntity deleteMouse =
                    em.find(GamingMouseEntity.class, mouse.getId());

            if (deleteMouse != null) {
                em.remove(deleteMouse);
            }

            em.getTransaction().commit();

            System.out.println("mouse deleted");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
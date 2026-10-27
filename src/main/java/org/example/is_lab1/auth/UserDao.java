package org.example.is_lab1.auth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

@ApplicationScoped
public class UserDao {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    public User create(User user) {
        em.persist(user);
        return user;
    }

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(em.find(User.class, username));
    }

    public void update(User user) {
        em.merge(user);
    }

    public Optional<User> findBySessionToken(String sessionToken) {
        if (sessionToken == null || sessionToken.isBlank()) {
            return Optional.empty();
        }
        try {
            User user = em.createQuery("SELECT u FROM User u WHERE u.sessionToken = :token", User.class)
                    .setParameter("token", sessionToken)
                    .getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

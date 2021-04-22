package ru.geekbrains.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}

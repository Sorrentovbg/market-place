package ru.geekbrains.marketplace.mpproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.marketplace.mpproduct.models.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}

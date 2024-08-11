package com.task.tracker.repository;

import com.task.tracker.model.Task;
import com.tasktracker.exercise.model.Task;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    default List<Task> findByCategoryAndStatus(Task.Category category, Task.Status status) {
        Specification<Task> specification = Specification.where(null);

        if (category != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category"), category));
    }

        if (status != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("status"), status));
        }

        return findAll(specification);
    }

    public List<Task> findByTitle(String title);
}

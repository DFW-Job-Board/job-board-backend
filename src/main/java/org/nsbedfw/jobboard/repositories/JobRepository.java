package org.nsbedfw.jobboard.repositories;

import org.nsbedfw.jobboard.domain.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface JobRepository extends MongoRepository<Job, UUID> {

}

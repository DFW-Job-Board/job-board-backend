package org.nsbedfw.jobboard.repositories;

import org.nsbedfw.jobboard.domain.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String> {

}

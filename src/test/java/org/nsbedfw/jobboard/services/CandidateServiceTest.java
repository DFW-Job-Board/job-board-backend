package org.nsbedfw.jobboard.services;

import org.junit.jupiter.api.Test;
import org.nsbedfw.jobboard.domain.Candidate;
import org.nsbedfw.jobboard.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.nsbedfw.jobboard.testUtilities.DummyData.dummyCandidate;

@SpringBootTest
class CandidateServiceTest {

    @MockBean
    private CandidateRepository repository;

    @Autowired
    private CandidateService candidateService;
    @Test
    void shouldSaveCandidate() {
        Candidate candidate = dummyCandidate();
        candidateService.addCandidate(candidate);

        verify(repository, times(1)).save(candidate);
    }

    @Test
    void shouldRetrieveAllCandidates() {
        List<Candidate> expectedCandidates = singletonList(dummyCandidate());
        when(repository.findAll()).thenReturn(expectedCandidates);

        List<Candidate> allCandidates = candidateService.getAllCandidates();

        assertThat(allCandidates).isEqualTo(expectedCandidates);
    }

    @Test
    void shouldRemoveCandidate() {
        Candidate candidate = dummyCandidate();
        when(repository.findById("id")).thenReturn(Optional.of(candidate));

        candidateService.delete("id");
        verify(repository, times(1)).delete(candidate);
    }
}
package org.nsbedfw.jobboard.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nsbedfw.jobboard.domain.Candidate;
import org.nsbedfw.jobboard.repositories.CandidateRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.nsbedfw.jobboard.testUtilities.DummyData.dummyCandidate;

@SpringBootTest
class CandidateServiceTest {

    @Mock
    private CandidateRepository repository;

    @InjectMocks
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

        assertThat(allCandidates)
                .usingElementComparatorIgnoringFields("id")
                .containsExactly(dummyCandidate());
    }

    @Test
    void shouldRemoveCandidate() {
        UUID uuid = UUID.randomUUID();

        candidateService.delete(uuid.toString());

        verify(repository, times(1)).deleteById(uuid);
    }
}
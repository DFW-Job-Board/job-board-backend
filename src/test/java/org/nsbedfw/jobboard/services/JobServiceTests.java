package org.nsbedfw.jobboard.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nsbedfw.jobboard.domain.Job;
import org.nsbedfw.jobboard.repositories.JobRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.nsbedfw.jobboard.testUtilities.DummyData.dummyJob;

@SpringBootTest
public class JobServiceTests {
    @Mock
    private JobRepository repository;

    @InjectMocks
    private JobService jobService;

    @Test
    void shouldSaveJob() {
        Job job = dummyJob();
        jobService.addJob(job);

        verify(repository, times(1)).save(job);
    }

    @Test
    void shouldRetrieveAllJobs() {
        List<Job> expectedJobs = singletonList(dummyJob());
        when(repository.findAll()).thenReturn(expectedJobs);

        List<Job> allJobs = jobService.getAllJobs();

        assertThat(allJobs)
                .usingElementComparatorIgnoringFields("id")
                .containsExactly(dummyJob());
    }

    @Test
    void shouldRemoveJob() {
        UUID uuid = UUID.randomUUID();

        jobService.delete(uuid.toString());

        verify(repository, times(1)).deleteById(uuid);
    }
}

package xm.cryptorecommendation.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xm.cryptorecommendation.service.CryptoDataService;


/**
 * <h1>Batch scheduler configurations</h1>
 *
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */

@Component
public class BatchScheduler {
    private final JobLauncher jobLauncher;
    private final Job job;
    private final CryptoDataService cryptoDataService;

    /**
     * Injection of necessary dependencies
     *
     * @param jobLauncher
     * @param job
     * @param cryptoDataService
     */
    public BatchScheduler(JobLauncher jobLauncher, Job job, CryptoDataService cryptoDataService) {
        this.jobLauncher = jobLauncher;
        this.job = job;
        this.cryptoDataService = cryptoDataService;
    }

    /**
     * Cron job that clears database table and reload data into it
     *
     * @throws Exception
     */
    @Scheduled(cron = "${batch.job.cron}")
    public void performJob() throws Exception {
        clearOldData();
        runJobLauncher();
    }


    private String generateJobId() {
        return String.valueOf(System.currentTimeMillis());
    }

    private JobParameters getJobParameters() {
        return new JobParametersBuilder().addString("JobID", generateJobId()).toJobParameters();
    }

    private void clearOldData() {
        cryptoDataService.clear();
    }

    private void runJobLauncher() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        jobLauncher.run(job, getJobParameters());
    }
}

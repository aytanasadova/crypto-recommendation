package xm.cryptorecommendation.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xm.cryptorecommendation.service.CryptoDataService;

@Component
public class BatchScheduler {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    CryptoDataService cryptoDataService;
//
//    @Scheduled(cron = "0 */1 * * * ?")

    @Scheduled(cron = "59 * * * * ?")
    public void perform() throws Exception
    {
        cryptoDataService.clear();
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}

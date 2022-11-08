package xm.cryptorecommendation.config;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class Listener extends JobExecutionListenerSupport {

   private  final  CacheService cacheService;

    public Listener(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            cacheService.evictAllCacheValues();

        }
    }


}
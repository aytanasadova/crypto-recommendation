package xm.cryptorecommendation.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;
import xm.cryptorecommendation.service.CacheService;


/**
 * @author Aytan Asadova
 * @version 1.0
 * @since 2022-11-08
 */
@Component
public class CustomJobExecutionListener extends JobExecutionListenerSupport {
   private  final CacheService cacheService;
    public CustomJobExecutionListener(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * To listen jobs and perform based on statuses
     * @param jobExecution the current {@link JobExecution}
     */
    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            cacheService.evictAllCacheValues();

        }
    }


}
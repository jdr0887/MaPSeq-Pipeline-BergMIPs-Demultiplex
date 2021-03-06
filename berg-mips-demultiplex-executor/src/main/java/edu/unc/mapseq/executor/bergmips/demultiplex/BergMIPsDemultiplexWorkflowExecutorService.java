package edu.unc.mapseq.executor.bergmips.demultiplex;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BergMIPsDemultiplexWorkflowExecutorService {

    private static final Logger logger = LoggerFactory.getLogger(BergMIPsDemultiplexWorkflowExecutorService.class);

    private final Timer mainTimer = new Timer();

    private BergMIPsDemultiplexWorkflowExecutorTask task;

    private Long period = 5L;

    public BergMIPsDemultiplexWorkflowExecutorService() {
        super();
    }

    public void start() throws Exception {
        logger.info("ENTERING start()");
        long delay = 1 * 60 * 1000; // 1 minute
        mainTimer.scheduleAtFixedRate(task, delay, period * 60 * 1000);
    }

    public void stop() throws Exception {
        logger.info("ENTERING stop()");
        mainTimer.purge();
        mainTimer.cancel();
    }

    public BergMIPsDemultiplexWorkflowExecutorTask getTask() {
        return task;
    }

    public void setTask(BergMIPsDemultiplexWorkflowExecutorTask task) {
        this.task = task;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

}

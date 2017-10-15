package com.ghoss.android.rappitest.domain.executor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by roberto on 10/15/17.
 */
public class JobExecutorTest {

    JobExecutor jobExecutor;

    @Before
    public void setUp() {
        jobExecutor = JobExecutor.getInstance();
    }

    @Test
    public void checkNotNull() {
        assertNotNull(jobExecutor);
    }
}
package com.db.challenge.test.medium;

import com.db.challenge.TradingApplication;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TradingApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class AbstractMediumTests {

    public final Logger LOG = LoggerFactory.getLogger(AbstractMediumTests.class);
    public final String HEADER_NAME = "db-Auth";
    public final String HEADER_VALUE = "db_secret";

    @Before
    public void setupClass() {
        LOG.info("executing integration tests");
    }
}

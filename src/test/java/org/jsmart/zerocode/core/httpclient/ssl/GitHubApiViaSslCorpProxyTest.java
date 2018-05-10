package org.jsmart.zerocode.core.httpclient.ssl;

import org.jsmart.zerocode.core.domain.MorePlaceHolders;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.domain.UseHttpClient;
import org.jsmart.zerocode.core.placeholders.MyCustomPlaceHolders;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

//@MorePlaceHolders(MyCustomPlaceHolders.class)
@UseHttpClient(SslTrustHttpClient.class)
@TargetEnv("github_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class GitHubApiViaSslCorpProxyTest {

    @Test
    @JsonTestCase("01_verification_test_cases/22_github_get_api.json")
    public void testASmartTestCase_createUpdate() throws Exception {

    }
}
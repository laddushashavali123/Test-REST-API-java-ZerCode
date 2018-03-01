package org.jsmart.zerocode.core.engine.mocker;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.lang.StringUtils;
import org.jsmart.zerocode.core.domain.MockSteps;
import org.jsmart.zerocode.core.engine.executor.JsonServiceExecutorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class RestEndPointMocker {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonServiceExecutorImpl.class);

    public static WireMockServer wireMockServer;

    public static void createWithWireMock(MockSteps mockSteps) {

        restartWireMock(8888);

//        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8888)); //<-- Strange
//        wireMockServer.start();
//        WireMock.configureFor("localhost", 8888); //<-- Repetition of PORT

        // TODO - Check wiremock APIs to whether it supports method as a paramater or direct JSON
        mockSteps.getMocks().forEach(mockStep -> {
            String jsonBodyRequest = mockStep.getResponse().get("body").toString();

            if("GET".equals(mockStep.getOperation())){
                LOGGER.info("*****WireMock- Mocking the GET endpoint");
                givenThat(WireMock.get(urlEqualTo(mockStep.getUrl()))
                        .willReturn(aResponse()
                                .withStatus(mockStep.getResponse().get("status").asInt())
                                .withHeader("Content-Type", APPLICATION_JSON)
                                .withBody(jsonBodyRequest)));
                LOGGER.info("WireMock- Mocking the GET endpoint -done- *****");
            }
            else if("POST".equals(mockStep.getOperation())){
                LOGGER.info("*****WireMock- Mocking the POST endpoint");
                givenThat(WireMock.post(urlEqualTo(mockStep.getUrl()))
                        .willReturn(aResponse()
                                .withStatus(mockStep.getResponse().get("status").asInt())
                                .withHeader("Content-Type", APPLICATION_JSON)
                                .withBody(jsonBodyRequest)));
                LOGGER.info("WireMock- Mocking the POST endpoint -done-*****");
            }
            else if("PUT".equals(mockStep.getOperation())){
                LOGGER.info("*****WireMock- Mocking the PUT endpoint");
                givenThat(WireMock.put(urlEqualTo(mockStep.getUrl()))
                        .willReturn(aResponse()
                                .withStatus(mockStep.getResponse().get("status").asInt())
                                .withHeader("Content-Type", APPLICATION_JSON)
                                .withBody(jsonBodyRequest)));
                LOGGER.info("WireMock- Mocking the PUT endpoint -done-*****");
            }
        });
    }

    /*
     * This is working code, whenever you put the virtuoso dependency here, you can uncomment this block.
     */
    public static int createWithVirtuosoMock(String endPointJsonApi) {
//        if(StringUtils.isNotEmpty(endPointJsonApi)){
//            ApiSpec apiSpec = SimulatorJsonUtils.deserialize(endPointJsonApi);
//            apiSpec.getApis().stream()
//                    .forEach(api -> {
//                        int status = aVirtuosoRestMocker()
//                                .url(api.getUrl())
//                                .operation(api.getOperation())
//                                .willReturn(
//                                        aResponse()
//                                                .status(api.getResponse().getStatus())
//                                                .body(api.getResponse().getBody())
//                                                .build()
//                                );
//
//                        if(200 != status){
//                            logbuilder.info("Mocking virtuoso end point failed. Status: " + status);
//                            throw new RuntimeException("Mocking virtuoso end point failed. Status: " + status + ". Check tunnel etc.");
//                        }
//                    });
//        }

        return 200;
    }

    public static int createWithLocalMock(String endPointJsonApi) {
        if(StringUtils.isNotEmpty(endPointJsonApi)){
            // read this json into virtuoso.
        }

        return 200;
    }

    public static void restartWireMock(int dynamicPort) {
        wireMockServer = new WireMockServer(wireMockConfig().port(dynamicPort)); // <-- Strange
        /*
         * Stop the wireMock server if it is running previously due to any other IPT feature tests.
         */
        wireMockServer.stop();
        wireMockServer.start();
        WireMock.configureFor("localhost", dynamicPort); // <-- Repetition of PORT
    }
}
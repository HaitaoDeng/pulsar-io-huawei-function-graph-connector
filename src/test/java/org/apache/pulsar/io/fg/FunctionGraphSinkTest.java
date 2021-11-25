/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.io.fg;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hezhangjian
 */
@Slf4j
public class FunctionGraphSinkTest {

    @Test
    public final void loadFromYamlFileTest() throws IOException {
        File yamlFile = getFile("function_graph_sink_config.yaml");
        final FunctionGraphConfig config = FunctionGraphConfig.load(yamlFile.getAbsolutePath());
        Assert.assertNotNull(config);
        Assert.assertEquals(config.getRegion(), "test-region");
        Assert.assertEquals(config.getFunctionGraphEndpoint(), "https://functiongraph.com");
        Assert.assertEquals(config.getProjectId(), "test-projectId");
        Assert.assertEquals(config.getAk(), "test-ak");
        Assert.assertEquals(config.getSk(), "test-sk");
        Assert.assertEquals(config.getFunctionUrn(), "test-function-urn");
    }

    private File getFile(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(name).getFile());
    }

}

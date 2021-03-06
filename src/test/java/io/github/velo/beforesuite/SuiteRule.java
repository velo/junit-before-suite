/**
 * Copyright (C) 2016 Marvin Herman Froeder (marvin@marvinformatics.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.velo.beforesuite;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class SuiteRule implements TestRule {

    public static final SuiteRule INSTANCE = new SuiteRule();

    private final AtomicBoolean initialized = new AtomicBoolean();

    @Override
    public Statement apply(Statement base, Description description) {
        if (!initialized.get()) {
            beforeSuite(description);
            initialized.set(true);
        }

        return base;
    }

    protected void beforeSuite(Description description) {
        System.out.println("Before suite");
    }

}

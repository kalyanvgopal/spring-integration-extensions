/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.hazelcast.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.integration.config.IntegrationConfigurationInitializer;
import org.springframework.integration.hazelcast.common.HazelcastLocalInstanceRegistrar;

/**
 * The Hazelcast Integration infrastructure {@code beanFactory} initializer.
 *
 * @author Eren Avsarogullari
 * @since 1.0.0
 */
public class HazelcastIntegrationConfigurationInitializer implements IntegrationConfigurationInitializer {

	private static final String HAZELCAST_LOCAL_INSTANCE_REGISTRAR_BEAN_NAME =
			HazelcastLocalInstanceRegistrar.class.getName();

	@Override
	public void initialize(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
		if (!beanDefinitionRegistry.containsBeanDefinition(HAZELCAST_LOCAL_INSTANCE_REGISTRAR_BEAN_NAME)) {
			beanDefinitionRegistry.registerBeanDefinition(HAZELCAST_LOCAL_INSTANCE_REGISTRAR_BEAN_NAME,
					new RootBeanDefinition(HazelcastLocalInstanceRegistrar.class));
		}
	}

}

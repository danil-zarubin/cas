/*
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
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
package org.jasig.cas.validation;

/**
 * Validation specification for the CAS 2.0 protocol. This specification extends
 * the Cas20ProtocolValidationSpecification, checking for the presence of
 * renew=true and if requested, succeeding only if ticket validation is
 * occurring from a new login. Additionally, this specification will not accept
 * proxied authentications.
 *
 * @author Scott Battaglia
 * @since 3.0
 */
public class Cas20WithoutProxyingValidationSpecification extends AbstractCasProtocolValidationSpecification {

    /**
     * Instantiates a new cas20 without proxying validation specification.
     */
    public Cas20WithoutProxyingValidationSpecification() {
        super();
    }

    /**
     * Instantiates a new cas20 without proxying validation specification.
     *
     * @param renew the renew
     */
    public Cas20WithoutProxyingValidationSpecification(final boolean renew) {
        super(renew);
    }

    @Override
    protected boolean isSatisfiedByInternal(final Assertion assertion) {
        return (assertion.getChainedAuthentications().size() == 1);
    }
}

/**
 * Copyright © 2016-2020 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.entityprofile;

import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasTenantId;
import org.thingsboard.server.common.data.entityprofile.BaseProfile;
import org.thingsboard.server.common.data.entityprofile.EntityProfile;
import org.thingsboard.server.common.data.entityprofile.HasEntityProfileId;
import org.thingsboard.server.common.data.id.EntityProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;

public interface EntityProfileService {

    PageData<EntityProfile> findEntityProfilesByTenantId(TenantId tenantId, PageLink pageLink);

    PageData<EntityProfile> findEntityProfilesByTenantIdAndType(TenantId tenantId, EntityType entityType, PageLink pageLink);

    default PageData<EntityProfile> findTenantProfiles(PageLink pageLink) {
        return findEntityProfilesByTenantIdAndType(TenantId.SYS_TENANT_ID, EntityType.TENANT, pageLink);
    }

    EntityProfile findById(TenantId tenantId, EntityProfileId id);

    EntityProfile save(EntityProfile entityProfile);

    void delete(TenantId tenantId, EntityProfileId id);

    <T extends HasEntityProfileId & HasTenantId, P extends BaseProfile> P findProfile(T obj, Class<P> clazz);
}
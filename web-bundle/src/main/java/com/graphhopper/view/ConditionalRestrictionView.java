/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.graphhopper.view;

import com.graphhopper.TimeDependentAccessRestriction;
import org.locationtech.jts.geom.Coordinate;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConditionalRestrictionView {

    public long osmid;
    public Map<String, Object> tags;
    public Coordinate from;
    public Coordinate to;
    private TimeDependentAccessRestriction timeDependentAccessRestriction;

    public ConditionalRestrictionView(TimeDependentAccessRestriction timeDependentAccessRestriction) {
        this.timeDependentAccessRestriction = timeDependentAccessRestriction;
    }

    public List<TimeDependentAccessRestriction.ConditionalTagData> getRestrictionData() {
        return restrictionData;
    }

    public List<TimeDependentAccessRestriction.ConditionalTagData> restrictionData;

    public Optional<Boolean> accessible(Instant linkEnterTime) {
        return timeDependentAccessRestriction.accessible(tags, linkEnterTime);
    }

}
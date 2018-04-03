/*
 * Copyright 2017 The Hyve
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.radarbase.passive.template;

import android.support.annotation.NonNull;

import org.radarcns.android.device.AbstractDeviceManager;
import org.radarcns.android.device.DeviceStatusListener;
import org.radarcns.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.regex.Pattern;

public class TemplateDeviceManager extends AbstractDeviceManager<TemplateDeviceService, TemplateDeviceStatus> {
    private static final Logger logger = LoggerFactory.getLogger(TemplateDeviceManager.class);

    private Pattern[] acceptableIds;

    TemplateDeviceManager(TemplateDeviceService service) {
        super(service);

        synchronized (this) {
            this.acceptableIds = null;
        }
        updateStatus(DeviceStatusListener.Status.READY);
    }

    @Override
    public void start(@NonNull final Set<String> accepTopicIds) {
        logger.info("Template searching for device.");

        synchronized (this) {
            this.acceptableIds = Strings.containsPatterns(accepTopicIds);
        }
    }

    @Override
    protected void updateStatus(DeviceStatusListener.Status status) {
        synchronized (this) {
            super.updateStatus(status);
        }
    }

    @Override
    protected void registerDeviceAtReady() {
        // custom at device
    }

    @Override
    public void close() {
        if (isClosed()) {
            return;
        }

        updateStatus(DeviceStatusListener.Status.DISCONNECTED);
    }
}

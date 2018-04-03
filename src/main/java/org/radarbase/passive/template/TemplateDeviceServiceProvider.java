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

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.radarcns.android.RadarConfiguration;
import org.radarcns.android.device.DeviceServiceProvider;

import java.util.Arrays;
import java.util.List;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.BLUETOOTH;
import static android.Manifest.permission.BLUETOOTH_ADMIN;

public class TemplateDeviceServiceProvider extends DeviceServiceProvider<TemplateDeviceStatus> {
    private static final String TEMPLATE_PREFIX = "org.radarcns.passive.template.";

    private static final String TEMPLATE_SETTING = "setting_template";
    private static final int TEMPLATE_SETTING_DEFAULT = 25;

    public static final String TEMPLATE_SETTING_KEY = TEMPLATE_PREFIX + TEMPLATE_SETTING;

    @Override
    public String getDescription() {
        return getRadarService().getString(org.radarbase.passive.template.R.string.templateDescription);
    }

    @Override
    public Class<?> getServiceClass() {
        return TemplateDeviceService.class;
    }

    @Override
    public boolean hasDetailView() {
        return true;
    }

    @Override
    public List<String> needsPermissions() {
        return Arrays.asList(ACCESS_COARSE_LOCATION, BLUETOOTH, BLUETOOTH_ADMIN);
    }

    @NonNull
    @Override
    public String getDeviceProducer() {
        return "template producer";
    }

    @NonNull
    @Override
    public String getDeviceModel() {
        return "template model";
    }

    @NonNull
    @Override
    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getDisplayName() {
        return getRadarService().getString(org.radarbase.passive.template.R.string.templateLabel);
    }

    @Override
    protected void configure(Bundle bundle) {
        super.configure(bundle);
        RadarConfiguration config = getConfig();
        bundle.putInt(TEMPLATE_SETTING_KEY, config.getInt(TEMPLATE_SETTING, TEMPLATE_SETTING_DEFAULT));
    }
}

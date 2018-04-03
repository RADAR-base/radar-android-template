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

import android.os.Parcel;

import org.radarcns.android.device.BaseDeviceState;

public class TemplateDeviceStatus extends BaseDeviceState {
    private float batteryLevel = Float.NaN;

    @Override
    public synchronized void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeFloat(this.batteryLevel);
    }

    public void updateFromParcel(Parcel in) {
        super.updateFromParcel(in);
        batteryLevel = in.readFloat();
    }

    /*
     * getters
     */

    public float getBatteryLevel() { return batteryLevel; }

    /*
     * setters
     */

    public void setBatteryLevel(float level) {
        this.batteryLevel = level;
    }

}

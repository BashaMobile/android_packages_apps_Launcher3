/*
 * Copyright (C) 2025 AxionOS
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
package com.android.launcher3.util

import android.util.Log
import com.android.launcher3.LauncherState
import com.android.launcher3.LauncherState.*

object LauncherStatesHelper {

    private const val TAG = "LauncherStatesHelper"

    private var currentState: LauncherState = NORMAL

    @JvmStatic
    fun setLauncherState(state: LauncherState) {
        currentState = state
        Log.d(TAG, "Launcher state updated: $currentState")
    }

    @JvmStatic
    fun getLauncherState(): LauncherState {
        Log.d(TAG, "Current launcher state: $currentState")
        return currentState
    }

    @JvmStatic
    fun shouldHideHomeElements(): Boolean {
        val hide = when (currentState) {
            OVERVIEW, OVERVIEW_SPLIT_SELECT, HINT_STATE,
            HINT_STATE_TWO_BUTTON, ALL_APPS, BACKGROUND_APP -> true
            else -> false
        }
        Log.d(TAG, "shouldHideHomeElements: $hide (state=$currentState)")
        return hide
    }

    @JvmStatic
    fun isNormal(): Boolean = currentState == NORMAL

    @JvmStatic
    fun isAllApps(): Boolean = currentState == ALL_APPS

    @JvmStatic
    fun isOverview(): Boolean =
        currentState == OVERVIEW || currentState == OVERVIEW_SPLIT_SELECT

    @JvmStatic
    fun isHintState(): Boolean =
        currentState == HINT_STATE || currentState == HINT_STATE_TWO_BUTTON
}

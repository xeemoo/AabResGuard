/*
 * Copyright (C) 2018 The Android Open Source Project
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
 * limitations under the License
 */
package com.bytedance.android.aabresguard.testing;

import com.android.tools.build.bundletool.androidtools.Aapt2Command;
import com.android.tools.build.bundletool.androidtools.CommandExecutor;
import com.android.tools.build.bundletool.androidtools.DefaultCommandExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ObjectArrays;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/** Helper for tests using aapt2. */
public final class Aapt2Helper {

  public static final String AAPT2_PATH =
      System.getenv("AAPT2_PATH");

  public static Aapt2Command getAapt2Command() {
    return Aapt2Command.createFromExecutablePath(Paths.get(AAPT2_PATH));
  }

  public static void convertBinaryApkToProtoApk(Path binaryApk, Path protoApk) {
    runAapt2(
        "convert", "--output-format", "proto", "-o", protoApk.toString(), binaryApk.toString());
  }

  private static void runAapt2(String... command) {
    new DefaultCommandExecutor().execute(
            ImmutableList.copyOf(ObjectArrays.concat(AAPT2_PATH, command)),
            CommandExecutor.CommandOptions.builder().build()
    );
  }

  private Aapt2Helper() {}
}

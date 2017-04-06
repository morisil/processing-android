/* -*- mode: java; c-basic-offset: 2; indent-tabs-mode: nil -*- */

/*
  Part of the Processing project - http://processing.org

  Copyright (c) 2016 The Processing Foundation

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation, version 2.1.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General
  Public License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA  02111-1307  USA
*/

package processing.vr;

import com.google.vr.sdk.base.GvrActivity;
import com.google.vr.sdk.base.Eye;

import android.util.DisplayMetrics;
import processing.android.AppComponent;
import processing.android.ServiceEngine;
import processing.core.PApplet;

// http://pastebin.com/6wPgFYhq
public class PVR extends GvrActivity implements AppComponent {
  public static final String STEREO = "processing.vr.PGraphicsVRStereo";
  public static final String MONO = "processing.vr.PGraphicsVRMono";

  public static final int LEFT      = Eye.Type.LEFT;
  public static final int RIGHT     = Eye.Type.RIGHT;
  public static final int MONOCULAR = Eye.Type.MONOCULAR;

  static public final int VR = 3;

  private DisplayMetrics metrics;
  private PApplet sketch;

  public PVR() {

  }

  public PVR(PApplet sketch) {
    this.sketch = sketch;
  }

  public void initDimensions() {
    metrics = getResources().getDisplayMetrics();
  }

  public int getDisplayWidth() {
    return metrics.widthPixels;
  }

  public int getDisplayHeight() {
    return metrics.heightPixels;
  }

  public float getDisplayDensity() {
    return metrics.density;
  }

  public int getKind() {
      return VR;
  }

  public void dispose() {
  }

  public void onPermissionsGranted() {

  }

  public void setSketch(PApplet sketch) {
    this.sketch = sketch;
    if (sketch != null) {
      sketch.initSurface(PVR.this, null);
    }
  }

  public PApplet getSketch() {
    return sketch;
  }

  public ServiceEngine getEngine() {
    return null;
  }

  /*
   * Called with the activity is first created.
   */
//  @SuppressWarnings("unchecked")
//  @Override
//  public void onCreate(Bundle savedInstanceState) {
//     super.onCreate(savedInstanceState);
//
//  }

  @Override
  public void onResume() {
    super.onResume();
    sketch.onResume();
  }


  @Override
  public void onPause() {
    super.onPause();
    sketch.onPause();
  }


  @Override
  public void onDestroy() {
    super.onDestroy();
    sketch.onDestroy();
  }


  @Override
  public void onStart() {
    super.onStart();
    sketch.onStart();
  }


  @Override
  public void onStop() {
    super.onStop();
    sketch.onStop();
  }

  public void requestDraw() {
  }

  public boolean canDraw() {
    return true;
  }

  @Override
  public void onRequestPermissionsResult(int requestCode,
                                         String permissions[],
                                         int[] grantResults) {
    if (sketch == null) {
      sketch.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
  }
}
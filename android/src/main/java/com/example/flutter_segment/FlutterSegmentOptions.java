package com.example.flutter_segment;

import android.os.Bundle;

import java.util.HashMap;

public class FlutterSegmentOptions {
    private final String writeKey;
    private final Boolean trackApplicationLifecycleEvents;
    private final Boolean amplitudeIntegrationEnabled;
    private final Boolean webEngageIntegrationEnabled;
    private final Boolean debug;

    public FlutterSegmentOptions(String writeKey, Boolean trackApplicationLifecycleEvents, Boolean amplitudeIntegrationEnabled, Boolean webEngageIntegrationEnabled, Boolean debug) {
        this.writeKey = writeKey;
        this.trackApplicationLifecycleEvents = trackApplicationLifecycleEvents;
        this.amplitudeIntegrationEnabled = amplitudeIntegrationEnabled;
        this.webEngageIntegrationEnabled = webEngageIntegrationEnabled;
        this.debug = debug;
    }

    public String getWriteKey() {
        return writeKey;
    }

    public Boolean getTrackApplicationLifecycleEvents() {
        return trackApplicationLifecycleEvents;
    }

    public Boolean isAmplitudeIntegrationEnabled() {
        return amplitudeIntegrationEnabled;
    }

    public Boolean isWebEngageIntegrationEnabled() {
        return webEngageIntegrationEnabled;
    }

    public Boolean getDebug() {
        return debug;
    }

    static FlutterSegmentOptions create(Bundle bundle) {
        String writeKey = bundle.getString("com.claimsforce.segment.WRITE_KEY");
        Boolean trackApplicationLifecycleEvents = bundle.getBoolean("com.claimsforce.segment.TRACK_APPLICATION_LIFECYCLE_EVENTS");
        Boolean isAmplitudeIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_AMPLITUDE_INTEGRATION", false);
        Boolean isWebEngageIntegrationEnabled = bundle.getBoolean("com.claimsforce.segment.ENABLE_WEBENGAGE_INTEGRATION", false);
        Boolean debug = bundle.getBoolean("com.claimsforce.segment.DEBUG", false);
        return new FlutterSegmentOptions(writeKey, trackApplicationLifecycleEvents, isAmplitudeIntegrationEnabled, isWebEngageIntegrationEnabled, debug);
    }

    static FlutterSegmentOptions create(HashMap<String, Object> options) {
        String writeKey = (String) options.get("writeKey");
        Boolean trackApplicationLifecycleEvents = (Boolean) options.get("trackApplicationLifecycleEvents");
        Boolean isAmplitudeIntegrationEnabled = orFalse((Boolean) options.get("amplitudeIntegrationEnabled"));
        Boolean isWebEngageIntegrationEnabled = orFalse((Boolean) options.get("webEngageIntegrationEnabled"));
        Boolean debug = orFalse((Boolean) options.get("debug"));
        return new FlutterSegmentOptions(writeKey, trackApplicationLifecycleEvents, isAmplitudeIntegrationEnabled, isWebEngageIntegrationEnabled, debug);
    }

    private static Boolean orFalse(Boolean value) {
        return value == null ? false : value;
    }
}

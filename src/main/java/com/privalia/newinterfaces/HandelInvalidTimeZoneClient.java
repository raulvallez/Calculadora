package com.privalia.newinterfaces;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface HandelInvalidTimeZoneClient extends TimeClient {

	default public ZonedDateTime getZonedDateTime(String zoneString) {
		try {
			return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
		}
		catch (DateTimeException e) {
			System.err.println("Invalid zone ID: " + zoneString + "; using the default itme zone instead.");
			return ZonedDateTime.of(getLocalDateTime(), zone)
		}
	}
}

package java8.timeDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeDate {

	public static void timeDateJ8() {

		
		LocalTime localtime = LocalTime.now();
		System.out.println("localtime: "+localtime);
		
		LocalDate localdate = LocalDate.now();
		System.out.println("localdate: "+localdate);
		
		LocalDateTime localdatetime = LocalDateTime.now();
		System.out.println("localdatetime: "+localdatetime);
		
		ZonedDateTime zonedatetime = ZonedDateTime.now();
		System.out.println("zonedatetime: "+zonedatetime);
		System.out.println("Current zone: "+zonedatetime.getZone());
		System.out.println("zonedatetime: "+zonedatetime);
		
		ZoneId zoneid = ZoneId.of("America/New_York");
		ZonedDateTime zoneddatetime2 = ZonedDateTime.now(zoneid);
		System.out.println("zoneddatetime2: "+zoneddatetime2);
		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		int i=0;
		
		for(String zoneId : allZoneIds) {
			if(zoneId.contains("Asia")) {
				System.out.println("zoneId: "+(i++)+". "+zoneId);
			}
		}
	}
	
}

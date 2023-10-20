package th.co.pt.ptgapp.utils;

public final class CalendarUtils {

	public static final String convertToDayOfWeek(int oldDay){
		String result = "";
		
		return result;
	}

	public static final String convertToMonthName(int MonthNo){
		String result = "";
		if ( MonthNo == 1 ) {
			result = "มกราคม";
		} else if ( MonthNo == 2 ) {
			result = "กุมภาพันธ์";
		} else if ( MonthNo == 3 ) {
			result = "มีนาคม";
		} else if ( MonthNo == 4 ) {
			result = "เมษายน";
		} else if ( MonthNo == 5 ) {
			result = "พฤษภาคม";
		} else if ( MonthNo == 6 ) {
			result = "มิถุนายน";
		} else if ( MonthNo == 7 ) {
			result = "กรกฎาคม";
		} else if ( MonthNo == 8 ) {
			result = "สิงหาคม";
		} else if ( MonthNo == 9 ) {
			result = "กันยายน";
		} else if ( MonthNo == 10 ) {
			result = "ตุลาคม";
		} else if ( MonthNo == 11 ) {
			result = "พฤศจิกายน";
		} else if ( MonthNo == 12 ) {
			result = "ธันวาคม";
		} 
		return result;
	}
	
}

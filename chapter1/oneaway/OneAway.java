public class OneAway {
	
	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple"));
		System.out.println(isOneAway("pale", "pales"));
		System.out.println(isOneAway("pale", "bale"));
		System.out.println(isOneAway("pale", "bake"));
		System.out.println(isOneAway("a", "b"));
		System.out.println(isOneAway("", "a"));
	}
	
	public static boolean isOneAway(String shorter, String longer) {
		if (Math.abs(shorter.length() - longer.length()) > 1) {
			return false;
		}
		
		if (shorter.length() > longer.length()) {
			String temp = shorter;
			shorter = longer;
			longer = temp;
		}
		
		boolean edited = false;
		
		int i = 0, j = 0;
		
		while(i < shorter.length()) {
			if(shorter.charAt(i) == longer.charAt(j)) {
				i++;
				j++;
			} else {
				edited = true;
				if(shorter.length() == longer.length())
					i++;
				j++;
				break;
			}
		}
		
		if(!edited)
			return true;
		
		while(i < shorter.length()) {
			if(shorter.charAt(i) == longer.charAt(j)) {
				i++;
				j++;
			} else {
				return false;
			}
		}
		return true;
	}
}
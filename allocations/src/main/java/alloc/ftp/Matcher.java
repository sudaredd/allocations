package alloc.ftp;

import org.springframework.util.AntPathMatcher;

public class Matcher {

	public static void main(String[] args) {

		final AntPathMatcher matcher = new AntPathMatcher();

		System.out.println(matcher.match("*.{csv,txt}", "hello.csv"));
	}

}

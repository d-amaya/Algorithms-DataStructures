package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectTheDomainName {
	
	private static String detectDomains(String html) {
		Pattern pattern = Pattern.compile("(http\\:\\/\\/|https\\:\\/\\/)([w\\d?\\.]{4})?([0-9a-z\\.-]+\\.[a-z]+)(\\/|\\?)?");
		Matcher matcher = pattern.matcher(html);
		
		Set<String> uniqueDomains = new HashSet<String>();
		StringBuilder domains = new StringBuilder();
		while (matcher.find()) {
			String protocol = matcher.group(1);
			String www = matcher.group(2);
			int endIndex = matcher.group().length() - (matcher.group(4) == null ? 0 : 1);
			int startIndex = (protocol == null ? 0 : protocol.length()) + (www == null ? 0 : www.length());
			String domain = matcher.group().substring(startIndex, endIndex);
			uniqueDomains.add(domain);
		}
		
		List<String> domainList = new ArrayList<String>();
		domainList.addAll(uniqueDomains);
		Collections.sort(domainList);
		
		for (String domain : domainList) {
			domains.append(domain + ";");
		}
		domains.setLength(domains.length() - 1);
		
		return domains.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		
		StringBuilder html = new StringBuilder();
		for (int i = 0; i < n; i++) {
			html.append(in.nextLine());
		}
		
		System.out.println(detectDomains(html.toString()));
		in.close();
	}
}

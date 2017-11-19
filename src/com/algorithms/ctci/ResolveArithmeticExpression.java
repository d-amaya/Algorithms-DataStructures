package com.algorithms.ctci;

public class ResolveArithmeticExpression {
	
	public static void main(String[] args) {
		System.out.println(resolveExpression("a+b+c+d+e+f-g"));
		System.out.println(resolveExpression("a+b-(c+d)+e+f-g"));
		System.out.println(resolveExpression("a+b-(c+d)+e-(-f-g)"));
		System.out.println(resolveExpression("a+b-((c-d)-(-e-f))-g"));
		System.out.println(resolveExpression("-(a+b-((c-d)-(-e-f))-g)"));
		System.out.println(resolveExpression("-(-(a+b-((c-d)-(-e-f))-g))"));
	}
	
	public static String resolveExpression(String s) {
		StringBuilder sb = new StringBuilder();
		resolveExpression(s, 0, '+', sb);
		return sb.toString();
	}

	private static int resolveExpression(String s, int i, char sign, StringBuilder sb) {
		if (s.length() <= i) return sb.length() - 1;
		
		for (; i < s.length() && s.charAt(i) != ')'; i++) {
			char c = s.charAt(i);
			if (isSign(c)) {
				sb.append((c == sign) ? "+" : "-");
				
			} else if (c == '(') {
				char newSign = sign;
				StringBuilder sbn = new StringBuilder();
				
				if (sb.length() > 0) {
					char last = sb.charAt(sb.length() - 1);
					if (isSign(last)) {
						sb.deleteCharAt(sb.length() - 1);
						newSign = last;
					} 
				}
				
				i = resolveExpression(s, i + 1, newSign, sbn);
				if (sbn.length() > 0 && !isSign(sbn.charAt(0))) sb.append(newSign);
				sb.append(sbn.toString());
				
			} else {
				if (sb.length() == 0) {
					sb.append(c);
				} else {
					char last = sb.charAt(sb.length() - 1);
					sb.append((last == '+' || last == '-') ? c : ("+" + c));
				}
			}
		}
		
		return i;
	}
	
	private static boolean isSign(char c) {
		return c == '+' || c == '-'; 
	}
}

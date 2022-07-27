
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here

class HalfIntegerTransformer implements MyTransformer<Integer> {
	public Integer transformElement(Integer num) {
		return num / 2;
	}
}

class HalfStringTransformer implements MyTransformer<String> {
	public String transformElement(String str) {
		return str.substring(0, str.length() / 2);
	}
}
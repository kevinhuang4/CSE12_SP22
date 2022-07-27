
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

// Add your choosers here

class EvenIntChooser implements MyChooser<Integer> {
	@Override
	public boolean chooseElement(Integer num) {
		return num % 2 == 0;
	}
}

class UpperCaseChooser implements MyChooser<String> {
	@Override
	public boolean chooseElement(String str) {
		return str.toUpperCase().equals(str);
	}
}
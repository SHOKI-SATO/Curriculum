package check;

import constants.Constants;


public class Check {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		
		String fullName = printName(firstName, lastName);
		
		System.out.println("printNameメソッド → " + fullName);
		

		Pet pet = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		pet.introduce();
		
		RobotPet roboPet = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		roboPet.introduce();
	}
	private static String firstName = "勝基";
	private static String lastName = "佐藤";
	
	private static String printName(String firstName, String lastName) {
		return lastName + firstName ;
	}
			
	
}

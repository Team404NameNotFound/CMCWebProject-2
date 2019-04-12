import cmc.entity.University;
import cmc.functionality.AccountController;
import cmc.interaction.AccountInteraction;

public class Zhang_Mendel_Driver {
	public static void main() {

		AccountInteraction user = new AccountInteraction();

		System.out.println("Successful login (user):");
		System.out.println("-------------------------");
		String userUsername = "juser";
		String userPassword = "user";
		user.login(userUsername, userPassword);

		String[] emphases = new String[1];
		emphases[0] = "emphasis";

		University uni = new University("name", "state", "location", "control", "enrollment", "percentFemale",
				"satVerbal", "satMath", "cost", "percentFinAid", "percentEnrolled", "applicants", "percentAdmitted",
				"academicScale", "socialScale", "qualityOfLife", emphases);
	}
}

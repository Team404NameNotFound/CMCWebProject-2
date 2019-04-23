import cmc.entity.University;
import cmc.functionality.AccountController;
import cmc.interaction.AccountInteraction;

public class Zhang_Mendel_Driver {
	public static void main() {

		AccountController ac = new AccountController();
		ac.setAccount("ajheroux@csbsju.edu");
		ac.viewSavedSchools();
	}
}

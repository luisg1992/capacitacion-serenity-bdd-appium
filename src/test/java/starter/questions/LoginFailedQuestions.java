package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.ui.LoggedInAreaView;
import starter.ui.LoginView;

public class LoginFailedQuestions implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return LoginView.ERROR_MESSAGE.resolveFor(actor).getText();
    }

    public static Question<String> value(){
        return new LoginFailedQuestions();
    }


}

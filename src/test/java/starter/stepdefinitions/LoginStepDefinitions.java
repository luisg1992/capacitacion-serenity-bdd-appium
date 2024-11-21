package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.questions.LoggedInQuestions;
import starter.questions.LoginFailedQuestions;
import starter.questions.StaticQuestions;
import starter.tasks.Login;
import starter.tasks.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    @Before
    public void set_the_page (){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("{string} desea crear una nueva publicacion")
    public void deseaCrearUnaNuevaPublicacion(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.login());
    }

    @Cuando("ella ingresa sus credenciales {string} {string}")
    public void ellaIngresaSusCredenciales(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(Login.withAdminUser(user, pass));
    }

    @Entonces("ella deberia ver el dashboard con el siguiente mensaje {string}")
    public void ellaDeberiaVerElDashboardConElSiguienteMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(seeThat("the welcome text", LoggedInQuestions.value(),
                equalTo(mensajeEsperado)));
        theActorInTheSpotlight().should(
                seeThat("the title text", StaticQuestions.getTitle(),
                equalTo("Secret Area")),
                seeThat("the logout text", StaticQuestions.getLogoutText(),
                        equalTo("Logout"))
                );
    }

    @Entonces("el recibe el {string} que significa que no logro ingresar")
    public void elRecibeElQueSignificaQueNoLogroIngresar(String mensaje) {
        theActorInTheSpotlight().should(seeThat("Error text", LoginFailedQuestions.value(),
                equalTo(mensaje)));
    }
}

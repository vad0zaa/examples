package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 28.07.2016.
 */
public class VadimNachinaetRabotat {

    @Given("^Ja prishel na rabotu$")
    public void Ja_prishel_na_rabotu(){
        System.out.println("Ja prishel na rabotu");
    }

    @When("^Ja vkljuchaju komp$")
    public void Ja_vkljuchaju_komp(){
        System.out.println("Ja vkljuchaju komp");
    }


    @And("^komp tormozit$")
    public void komp_tormozit(){
        System.out.println("komp opjat tormozit");
    }

    @And ("^Rjadom est drugoi komp$")
    public void rjadom_est_drugoi_komp(){
        System.out.println("Rjadom est drugoi komp");
    }

    @And ("^On bystryi i ne zanjat$")
    public void on_bystryi_i_ne_zanjat(){
        System.out.println("On bystryi i ne zanjat");
    }

    @Then("^Ja vkljuchaju ego rabotaju i radujus$")
    public void ja_vkljuchaju_ego_rabotaju_i_radujus(){
        System.out.println("Ja vkljuchaju ego rabotaju i radujus");
    }

}

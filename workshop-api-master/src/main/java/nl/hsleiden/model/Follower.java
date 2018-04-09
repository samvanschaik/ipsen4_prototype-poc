package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.NotEmpty;

public class Follower {

    @NotEmpty
    @JsonView(View.Public.class)
    int totalFollowers;


    public Follower() {
    }


    public int getTotalFollowers() {
        return totalFollowers;
    }

    public void setTotalFollowers(int totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

}



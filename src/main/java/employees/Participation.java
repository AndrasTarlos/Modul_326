package employees;

import company.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Participation {
    private JobFunction function = new JobFunction();
    private Team team = new Team();

    public Participation() {}
}
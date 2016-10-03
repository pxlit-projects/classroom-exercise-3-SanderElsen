package be.pxl.mockitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static be.pxl.mockitis.RaidersTestBuilder.aRaiders;
import static be.pxl.mockitis.SettlementTestBuilder.aSettlement;
import static be.pxl.mockitis.SettlerTestBuilder.aSettler;
@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(1)
                .build();

        Settler defender = aSettler()
                .withState(Settler.SettlerState.DEFENDER)
                .build();

        Settler farmer = aSettler()
                .withState(Settler.SettlerState.DEFENDER)
                .build();

        Settler clerk = aSettler()
                .withState(Settler.SettlerState.WORKER)
                .build();

        List<Settler> settlers = Arrays.asList(defender,farmer,clerk);

        Settlement settlement = aSettlement()
                .withSettlers(settlers)
                .build();

        settlement.defend(raiders);

        assertThat(settlement.getAlivePopulation()>0).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(2)
                .build();

        Settler defender = aSettler()
                .withState(Settler.SettlerState.DEFENDER)
                .build();

        Settler farmer = aSettler()
                .withState(Settler.SettlerState.DEFENDER)
                .build();

        Settler clerk = aSettler()
                .withState(Settler.SettlerState.WORKER)
                .build();

        List<Settler> settlers = Arrays.asList(defender,farmer,clerk);

        Settlement settlement = aSettlement()
                .withSettlers(settlers)
                .build();

        settlement.defend(raiders);

        assertThat(settlement.getAlivePopulation()>0).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(2)
                .build();


        Settler defender = aSettler()
                .withState(Settler.SettlerState.DEFENDER)
                .build();

        Settler farmer = aSettler()
                .withState(Settler.SettlerState.WORKER)
                .build();

        Settler clerk = aSettler()
                .withState(Settler.SettlerState.WORKER)
                .build();

        List<Settler> settlers = Arrays.asList(defender,farmer,clerk);

        Settlement settlement = aSettlement()
                .withSettlers(settlers)
                .build();

        settlement.defend(raiders);

        assertThat(settlement.getAlivePopulation()==0).isTrue();
    }
}

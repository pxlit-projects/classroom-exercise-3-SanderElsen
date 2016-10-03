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
@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(1)
                .build();

        Settlement settlement = aSettlement()
                .withDefenders(1)
                .withNonDefenders(2)
                .build();

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(2)
                .build();

        Settlement settlement = aSettlement()
                .withDefenders(2)
                .withNonDefenders(1)
                .build();

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        Raiders raiders = aRaiders()
                .withRaiders(2)
                .build();


        Settlement settlement = aSettlement()
                .withDefenders(1)
                .withNonDefenders(2)
                .build();
        assertThat(settlement.defend(raiders)).isFalse();
    }
}

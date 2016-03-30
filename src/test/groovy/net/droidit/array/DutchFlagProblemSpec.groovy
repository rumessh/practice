package net.droidit.array

import spock.lang.Specification
import java.util.Arrays
import net.droidit.array.DutchFlagProblem

public class DutchFlagProblemSpec extends Specification
{
    def "Testing Dutch Flag problem" () {
        given:
            int[] array = ArrayUtils.generateRandomArray(7)
            def dutchFlagProblem = new DutchFlagProblem(array, 3)
        when:
            dutchFlagProblem.dutchFlagPartition();
        then:
			dutchFlagProblem.validatePartition() == true
    }
}
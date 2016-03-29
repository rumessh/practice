package net.droidit.array

import spock.lang.Specification
import java.util.Arrays
import net.droidit.array.DutchFlagProblem

public class DutchFlagProblemSpec extends Specification
{
    def "Testing Dutch Flag problem" () {
        given:
            int[] array = [1, 22, 3, 4, 12, 4]
            def dutchFlagProblem = new DutchFlagProblem(array, 3)
        when:
            dutchFlagProblem.dutchFlagPartition();
        then:
            array == [1, 3, 4, 4, 12, 22]
    }
}
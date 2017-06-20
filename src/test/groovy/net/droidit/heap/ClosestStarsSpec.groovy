package net.droidit.heap

import spock.lang.Specification

/**
 * Created by rpalaniappan on 6/20/17.
 */
class ClosestStarsSpec extends Specification{

    def random
    def num
    def k
    List<Star> stars

    def setup() {
        random = new Random()
        num = random.nextInt(1000) + 1
        k = random.nextInt(num) + 1
        stars = new ArrayList<>(num)
        for (int i=0; i<num; ++i) {
            stars.add(new Star(random.nextInt(100000), random.nextInt(100000), random.nextInt(100000)))
        }
    }

    def "Get closest stars"() {
        given:
            Collections.sort(stars)
            List<Star> answer = stars.subList(0, k)
            List<Star> closestStars = null

        when:
            closestStars = ClosestStars.findCLosestStars(stars.iterator(), k)
        then:
            answer == closestStars
    }
}
